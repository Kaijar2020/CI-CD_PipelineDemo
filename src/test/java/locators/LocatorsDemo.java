package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//ID,Name,LinkText,PartialLinkText,Class&Tag

public class LocatorsDemo {

    public static void main(String[] args) {

        //launch the browser (firefox)
        WebDriver driver = new ChromeDriver();

        //Open URL https://demo.opencart.com/
        driver.get("https://demo.opencart.com");

        //maximize window.
        driver.manage().window().maximize();

        //name attribute as locator.
         driver.findElement(By.name("search")).sendKeys("Laptop");

        //id as locator
        boolean logoDisplay = driver.findElement(By.id("log")).isDisplayed();
        System.out.println(logoDisplay);

        //linked test as locator.
        driver.findElement(By.linkText("Tablets")).click();

        //Partial linked text as locator. **It is not good practice**
        driver.findElement(By.partialLinkText("Tab")).click();

        //Multiple WebElements by className as locator.
        List< WebElement > headerLinks = driver.findElements(By.className("list-inline-item"));
        //Find total Header Links.
        System.out.println("Total number of Links"+headerLinks.size());

        //Find Total Links by using Tag name.
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total Number of Links : "+links.size());

    }
}
