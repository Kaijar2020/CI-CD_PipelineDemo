package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com");
        driver.manage().window().maximize();

        JavascriptExecutor jsExe = (JavascriptExecutor)driver;
        /*
        //scroll down page by pixel number.
        jsExe.executeScript("window.scrollBy(0,1500)"," ");
        System.out.println(jsExe.executeScript("return window.pageYOffset;"));
        **/

        /*
        //scroll the page till element is visible.
        WebElement ele = driver.findElement(By.xpath("//h4[normalize-space()='Mobile Labels']"));
        jsExe.executeScript("arguments[0].scrollIntoView();", ele);
        System.out.println(jsExe.executeScript("return window.pageYOffset;")); //2387
         **/

        //Scroll till the end of the page.
        jsExe.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        System.out.println(jsExe.executeScript("return window.pageYOffset;"));

        Thread.sleep(1000);

        //Scroll from bottom to top.
        jsExe.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
        System.out.println(jsExe.executeScript("return window.pageYOffset;"));

        //Scroll with Horizontal or X-axis.
        jsExe.executeScript("window.scrollBy(0,document.body.scrollWidth)");
        System.out.println(jsExe.executeScript("return window.pageXOffset;"));
    }
}
