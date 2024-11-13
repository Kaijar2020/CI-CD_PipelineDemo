package testngpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParallelTest {
    WebDriver driver;
    @BeforeClass
    @Parameters({"browser"}) //receive the browser name from parallel_run.xml file.
    void setup(String browsers) throws InterruptedException {
        switch (browsers){
            case "chrome":  driver = new ChromeDriver();
                            break;
            case "edge":    driver = new EdgeDriver();
                            break;
            case "firefox": driver = new FirefoxDriver();
                            break;
            default:  System.out.println("Invalid browser");
                            return;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    void test_logo(){

        boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        Assert.assertEquals(status,true);
    }

    @Test(priority = 2)
    void test_title(){
       Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    }

    @Test(priority = 3)
    void test_url(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    void tear_down(){
        driver.quit();
    }
}
