package testngpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DataProviderTest {

    WebDriver driver;

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "dataPro")
    void test_login(Object email,Object pass) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys((CharSequence) email);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys((CharSequence) pass);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(2000);
        boolean status = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).isDisplayed();
        if(status == true){
            driver.findElement(By.xpath("//p[normalize-space()='(1) Timesheet to Approve']")).click();
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }

    @AfterClass
    void tear_down(){
        driver.quit();
    }

    @DataProvider(name = "dataPro", indices = {0,2}) //indices use to sent specific data.
    Object[][] login_data(){
        //Data Provider method always return 2D array.
        Object data [][]={
                {"Admin", "admin1234"},
                {"admin123", "admin123"},
                {"Admin", "admin123"}
        };
        return data;
    }
}
