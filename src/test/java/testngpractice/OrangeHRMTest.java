package testngpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMTest {
    WebDriver driver = new ChromeDriver();


    @Test(priority = 1)
    void openapp(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    void test_logo(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        System.out.println(status);
    }

    @Test(priority = 3)
    void test_login(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }

    @Test(priority = 4)
    void test_logout(){
        driver.quit();
    }
}
