package webelementshandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesHandle {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com");
        driver.manage().window().maximize();

        //Select specific checkbox
        //driver.findElement(By.xpath("//input[@id='sunday']")).click();

        //Select All/Multiple checkboxes
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

        //Normal For Loop.
        /*
        for(int i =0; i<checkboxes.size(); i++){
            checkboxes.get(i).click();
        }
        */
        //Enhance for loop.
        /*
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }
         */
       //Select last 3 check boxes.
        for(int i=0; i<3;i++){
            checkboxes.get(i).click();
        }
        Thread.sleep(2000);
        //Unselect the Selected checkboxes
        for (WebElement checkbox : checkboxes)
            if (checkbox.isSelected()) {
                checkbox.click();
            }
    }
}
