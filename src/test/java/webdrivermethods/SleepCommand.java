package webdrivermethods;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Difference between all kinds of wait.
// --If the element is find between wait period the time still continuing until it finished. [Thread.sleep]
// --If the element is not find in between wait the exception will throw. [Implicit wait].
// --There is also the chance of , if the element not found.It has written multiple time for multiple elements. [Explicit wait]

public class SleepCommand {

    public static void main(String[] args) {

        //launch the browser (chrome)
        WebDriver driver = new ChromeDriver();

        //Implicit wait.
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Explicit wait
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10)); //declaration

        //Open URL via get() method.
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //maximize window.
        driver.manage().window().maximize();

        //use of Explicit wait.
        WebElement txtUserName = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        txtUserName.sendKeys("Admin");

        WebElement txtPassword = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
        txtPassword.sendKeys("Admin");

        WebElement loginBtn = myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']")));
        loginBtn.click();

        //driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Amin"); //This statement will use for implicit wait only.
        driver.close();

    }
}



