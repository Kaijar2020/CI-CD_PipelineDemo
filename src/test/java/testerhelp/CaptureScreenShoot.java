package testerhelp;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class CaptureScreenShoot {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();


        /*
        //Full Page Screen Shoot.
        TakesScreenshot tss = (TakesScreenshot) driver;
        File sourceFile = tss.getScreenshotAs(OutputType.FILE);
        //Dynamically path capture.
        File targetFile = new File(System.getProperty("user.dir")+"\\screenshoot\\fullpage.png");
        //Copy source file to target file.
        sourceFile.renameTo(targetFile);

         **/
        /*
        //Take Specific area of Screen Shoot.
        WebElement specificLoc = driver.findElement(By.xpath("//body/main/div[@id='common-home']/div[@class='row']/div[@id='content']/div[@class='row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-xl-4']/div[1]"));
        File srcFile =  specificLoc.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(System.getProperty("user.dir")+"\\screenshoot\\featureproduct.png");
        srcFile.renameTo(targetFile);

         **/
        //Capture the Screen Shoot of web element.
        WebElement logo = driver.findElement(By.xpath("//img[@title='Your Store']"));
        File srcFile =  logo.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(System.getProperty("user.dir")+"\\screenshoot\\logo.png");
        srcFile.renameTo(targetFile);

        driver.quit();
    }
}
