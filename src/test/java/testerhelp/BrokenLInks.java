package testerhelp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLInks {

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();


        //capture all the links.
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        int numberOfBrokenLinks = 0;
        //I have to check href value is appear or not.Only Take request with href value.
        for (WebElement linkElement:links){
            String hrefAttValue = linkElement.getAttribute("href");

            if (hrefAttValue == null || hrefAttValue.isEmpty()){
                System.out.println("Not Possible to check.");
                continue;
            }

            try {
                //Hit url to the server.
                URL linkURL = new URL(hrefAttValue); //converted string to url.
                HttpURLConnection connectionLinkUrl = (HttpURLConnection) linkURL.openConnection(); //connection establish with the server.
                connectionLinkUrl.connect(); //sent the request to the server.
                if(connectionLinkUrl.getResponseCode() >= 400){
                    System.out.println(hrefAttValue+" is a Broken Link");
                    numberOfBrokenLinks++;
                }
                else {
                    System.out.println("Not broken link.");
                }
            }
            catch(Exception e)
            {
                //System.out.println(" Catch block shows error!");
            }


        }
        System.out.println("Total number of Broken links is "+numberOfBrokenLinks);
    }
}
