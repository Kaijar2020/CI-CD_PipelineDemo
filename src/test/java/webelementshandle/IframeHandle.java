package webelementshandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeHandle {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ui.vision/demo/webtest/frames ");
        driver.manage().window().maximize();

        //Switch to Frame -1
        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frame1); //parse frame 1 as webElement.
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("welcome");

        //Switch to default Page/root page
        driver.switchTo().defaultContent();

        //Switch to the Frame -2
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frame2);

        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Selenium");

        //Switch to default Page/root page
        driver.switchTo().defaultContent();

        //Switch to Frame -3
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frame3);

        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Java");

        //Switch to the inner iFrame inside Frame -3
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']")).click();

        //Switch to default Page/root page
        driver.switchTo().defaultContent();

    }
}
