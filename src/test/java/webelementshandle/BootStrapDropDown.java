package webelementshandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BootStrapDropDown {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().window().maximize();

        //opens the dropdown
        driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();

        //Capture all the options and find out the size
        List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
        //Select multiple options
        for(WebElement opt:options){
            String option = opt.getText();
            if (option.equals("Java") || option.equals("Python") || option.equals("MySQL")){
                opt.click();
            }
        }
    }
}
