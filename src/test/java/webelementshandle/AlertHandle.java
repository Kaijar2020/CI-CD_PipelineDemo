package webelementshandle;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandle {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        //Normal alert with ok button
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
        //This statement will close the alert window.
        Alert myAlert = driver.switchTo().alert();
        System.out.println(myAlert.getText());
        myAlert.accept();
        Thread.sleep(1000);
        //Confirmation Alert-- OK or Cancel
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        //Close alert using OK button.
        driver.switchTo().alert().accept();
        //Close alert using Cancel button.
        //driver.switchTo().alert().dismiss();

        //Prompt Alert - Input box
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        Alert myalert = driver.switchTo().alert();
        myalert.sendKeys("Welcome");
        myalert.accept();
    }
}
