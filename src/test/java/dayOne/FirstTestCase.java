package dayOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

    public static void main(String[] args) {
        //launch the browser (chrome)
        WebDriver driver = new ChromeDriver();

        //Open URL https://demo.opencart.com/
        driver.get("https://demo.opencart.com");

        //Assertion the Title.
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("Your Store")){
            System.out.println("Test Passed");
        }
        else{
            System.out.println("Test Failed");
        }

        //Close browser
        driver.close();
    }
}
