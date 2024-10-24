package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JsExecutor {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://testautomationpractice.blogspot.com");
        driver.manage().window().maximize();

        WebElement inputBox = driver.findElement(By.xpath("//input[@id='name']"));
        //inputBox.sendKeys("Anne");

        //Perform SendKeys using JavaScript Executor. This is alternative of sendKeys method.
        JavascriptExecutor jsExe = (JavascriptExecutor)driver;
        jsExe.executeScript("arguments[0].setAttribute('value','Anne')",inputBox);

        //Click on element . Just alternative of click() method.
        WebElement radioBtn = driver.findElement(By.xpath("//input[@id='male']"));
        jsExe.executeScript("arguments[0].click()",radioBtn);
    }
}
