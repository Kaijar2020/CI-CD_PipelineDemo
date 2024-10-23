package webelementshandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDropDown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com");
        driver.manage().window().maximize();

        //Select the DropDown.
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='country']"));
        Select drpCountry = new Select(dropdown);

        //Select option from the DropDown.
        drpCountry.selectByVisibleText("Germany");
        //drpCountry.selectByValue("japan");

        //Capture the Options from the dropdown
        List<WebElement> options = drpCountry.getOptions();
        System.out.println(options.size());
        //Print all the Options
        for(WebElement op:options){
            System.out.println(op.getText());
        }
    }
}
