package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {

    public static void main(String[] args) {

        //launch the browser (firefox)
        WebDriver driver = new ChromeDriver();

        //Open URL https://demo.opencart.com/
        driver.get("https://demo.opencart.com");

        //maximize window.
        driver.manage().window().maximize();

        //xpath- Syntax -- //tagname[@attribute= 'value']
        //*[@attribute='value']

        //Xpath with single attribute
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("T-Shirt");

        //Xpath With multiple attribute.
        driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search']")).sendKeys("T-shirts");

        //xpath with 'and', 'or' operators.
        driver.findElement(By.xpath("//input[@name='search' and @placeholder='Search']")).sendKeys("T-shirts");
        driver.findElement(By.xpath("//input[@name='search' or @placeholder='Search']")).sendKeys("T-shirts");

        //Xpath with inner text
        //Syntax -- //tagname[text()='The inner text']  --//*[text()='MackBook']
        driver.findElement(By.xpath("//h3[text()='Feature']")).getText();

        //Xpath with contains method/keyword
        //Syntax -- //tagname[contains(@attribute, 'attribute value')]
        driver.findElement(By.xpath("//input[contains(@placeholder,'Sea')]")).sendKeys("T-Shirts");

        //Xpath with start-with method
        driver.findElement(By.xpath("//input[start-with(@placeholder,'Sea')]")).sendKeys("T-Shirts");
    }
}
