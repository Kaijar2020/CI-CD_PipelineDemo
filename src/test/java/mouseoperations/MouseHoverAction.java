package mouseoperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseHoverAction {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demo.opencart.com");
        driver.manage().window().maximize();

        WebElement deskTop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        WebElement mac = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));

        //MouseHover. [build() method for create an action and perform() for completed on created action.]
        Actions act = new Actions(driver);
        //act.moveToElement(deskTop).moveToElement(mac).build().perform();
        act.moveToElement(deskTop).moveToElement(mac).click().perform();
    }
}
