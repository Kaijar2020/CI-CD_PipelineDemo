package webdrivermethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

    public static void main(String[] args) {

        //launch the browser (chrome)
        WebDriver driver = new ChromeDriver();

        //Open URL via get() method.
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        //Thread.sleep(5000);

        //maximize window.
        driver.manage().window().maximize();

        //isDisplay()-- method.
        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        System.out.println(logo.isDisplayed());

        //isEnable --method
        WebElement status = driver.findElement(By.xpath("//input[@id='Firstname']"));
        System.out.println(status.isEnabled());

        //isSelected() --method
        WebElement selectedStatus = driver.findElement(By.xpath("//input[@id='gender-female']"));
        System.out.println(selectedStatus.isSelected());
        selectedStatus.click();
        System.out.println(selectedStatus.isSelected());

    }
}
