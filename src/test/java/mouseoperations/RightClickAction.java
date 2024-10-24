package mouseoperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RightClickAction {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().window().maximize();

        WebElement button = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions act = new Actions(driver);

        //Right Click Action.
        act.contextClick(button).perform();

        //Click on Copy
        driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();

        //Close alert.
        driver.switchTo().alert().accept();

        /*
        //Double Click Action on the button.
        Actions act = new Actions(driver);
        act.doubleClick(element/locator).perform();
         **/
    }
}
