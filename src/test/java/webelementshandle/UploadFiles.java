package webelementshandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UploadFiles {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
        driver.manage().window().maximize();

        /*
        //Single File Upload.
        driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Users\\kakib\\Desktop\\Dhanvantari\\App\\issue-1.png");
        if (driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("issue-1.png")){
            System.out.println("File Uploaded successfully");
        }
        else {
            System.out.println("File Uploaded Failed");
        }
        **/

        //Multiple file uploaded.
        String file1 = "C:\\Users\\kakib\\Desktop\\Dhanvantari\\App\\issue-1.png";
        String file2 = "C:\\Users\\kakib\\Desktop\\Dhanvantari\\App\\issue-2.png";
        //Upload
        driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
        int noOfTheFileUploaded = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();

        //number files verified.
        if (noOfTheFileUploaded == 2){
            System.out.println("ALl files are uploaded");
        }
        else {
            System.out.println("ALl files are not uploaded incorrect upload occurred.");
        }

        //Validate the uploaded files.
        if (driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("issue-1.png") && driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("issue-2.png")){
            System.out.println("Files names are matching");
        }
        else {
            System.out.println("Files names are not matching");
        }
    }
}
