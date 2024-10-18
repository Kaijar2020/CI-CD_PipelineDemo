package locators;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//Locators - CSS Selector
public class CssSelectorLocators {

    public static void main(String[] args) {

        //launch the browser (firefox)
        WebDriver driver = new ChromeDriver();

        //Open URL https://demo.opencart.com/
        driver.get("https://demo.nopcommerce.com");

        //maximize window.
        driver.manage().window().maximize();

        //tag#id as locator
        driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");

        //tag.class
        driver.findElement(By.cssSelector("input.search-box-test")).sendKeys("T_shirts");

        //tag[attribute='value']
        driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("T-shirts");

        //tag.class[attribute='value']
        driver.findElement(By.cssSelector("input.search-box-test[name='q']"));

    }
}
