package javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInZoomOut {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com");
        driver.manage().window().maximize();

        JavascriptExecutor jsExe = (JavascriptExecutor)driver;
        jsExe.executeScript("document.body.style.zoom='50%'"); //set zoom level on corresponding percentage.
    }
}
