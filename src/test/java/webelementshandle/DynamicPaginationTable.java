package webelementshandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicPaginationTable {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/index.php?route=common/login");
        driver.manage().window().maximize();

//        WebElement usernmae = driver.findElement(By.xpath("//input[@id='input-username']"));
//        usernmae.clear();
//        usernmae.sendKeys("demo");
//
//        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
//        password.clear();
//        password.sendKeys("demo");
         for(int i=0;i<3;i++) {
             driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
             Thread.sleep(1000);
         }

        //Close window if it is available
//        if (driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed()){
//            driver.findElement(By.xpath("//button[@class='btn-close']")).click();
//        }
    }
}
//Skiping this class .Because the test website not response well.