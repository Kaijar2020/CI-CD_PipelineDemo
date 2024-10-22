package webdrivermethods;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FluentWaitDemo {

    public static void main(String[] args) {
        //launch the browser (chrome)
        WebDriver driver = new ChromeDriver();

        //Implicit wait.
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Explicit wait
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10)); //declaration

        //Fluent wait declaration
        Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        //Open URL via get() method.
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement txtUserName = myWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//input[@placeholder='Username']"));
            }
        });

        txtUserName.sendKeys("Admin");

        driver.close();
    }
}
