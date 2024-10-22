package webdrivermethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {

    public static void main(String[] args) {

        //launch the browser (chrome)
        WebDriver driver = new ChromeDriver();

        //Open URL via get() method.
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //maximize window.
        driver.manage().window().maximize();

        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());

        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());

        driver.navigate().refresh();

        driver.close();
    }
}
