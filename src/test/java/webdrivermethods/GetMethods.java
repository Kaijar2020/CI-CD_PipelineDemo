package webdrivermethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class GetMethods {
    public static void main(String[] args) throws InterruptedException {

        //launch the browser (chrome)
        WebDriver driver = new ChromeDriver();

        //Open URL via get() method.
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
        //maximize window.
        driver.manage().window().maximize();

        //getTitle() return title of the page.
        System.out.println(driver.getTitle());

        //getCurrentURL() return current url.
        System.out.println(driver.getCurrentUrl());

        //getPageSource() return whole page source code.
        //System.out.println(driver.getPageSource());

        //getWindowHandle() return the ID of single browser window.
        String windowId = driver.getWindowHandle();
        System.out.println(windowId);

        //getWindowHandles() return the ID of Multiple browser window.
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Set<String> windowIds = driver.getWindowHandles(); //use Set because id will be unique and set does not allow duplicate ID.
        System.out.println(windowIds);
    }
}
