package webelementshandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestionDropDown {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.google.com");
        driver.manage().window().maximize();

        //Search
        driver.findElement(By.name("q")).sendKeys("selenium");

        //Click on Search key.
        List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
        System.out.println(list.size());
        for (int i =0;i<list.size();i++){
            System.out.println(list.get(i).getText());
            if(list.get(i).getText().equals("selenium")){
                list.get(i).click();
                break;
            }
        }
    }
}
