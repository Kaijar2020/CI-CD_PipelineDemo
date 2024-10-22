package webdrivermethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserWindowHandle {

    public static void main(String[] args) {

        //launch the browser (chrome)
        WebDriver driver = new ChromeDriver();

        //Open URL via get() method.
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //maximize window.
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

        Set<String> windowIds = driver.getWindowHandles();

        /*
        //Process -1
        List<String> windowList = new ArrayList<>(windowIds);
        String parentId = windowList.get(0);
        String childId = windowList.get(1);

        //switch to child window
        driver.switchTo().window(childId);
        System.out.println(driver.getTitle());

        //switch to parent window
        driver.switchTo().window(parentId);
        System.out.println(driver.getTitle());
        */

        //Process -2
        for(String winId:windowIds){
           String title = driver.switchTo().window(winId).getTitle();

           if(title.equals("OrangeHRM")){
               System.out.println(driver.getCurrentUrl());
           }
        }
        //Close specific browser
        for(String winId:windowIds){
            String title=driver.switchTo().window(winId).getTitle();
            System.out.println(title);
            if (title.equals("OrangeHRM")){
                driver.close();
                break;
            }
        }
        driver.quit();
    }
}
