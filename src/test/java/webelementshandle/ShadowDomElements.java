package webelementshandle;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShadowDomElements {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://books-pwakit.appspot.com/");
        driver.manage().window().maximize();

        //Xpath can not handle Shadow dom element.Only CSS can handle.
        //Handle shadow DOM
        SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        shadow.findElement(By.cssSelector("#input")).sendKeys("Welcome");
    }
}
