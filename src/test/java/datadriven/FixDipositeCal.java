package datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.time.Duration;

public class FixDipositeCal {

    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
        driver.manage().window().maximize();

        String filePath = System.getProperty("user.dir")+"\\testdata\\Book2.xlsx";

        int rows = ExcellUtils.getRowCount(filePath, "Data2");

        for (int i=1;i<=rows;i++){
            //read data from excel
            String price = ExcellUtils.getCellData(filePath, "Data2",i, 0);
            String rateOfInterest = ExcellUtils.getCellData(filePath, "Data2",i, 1);
            String per1 = ExcellUtils.getCellData(filePath, "Data2",i, 2);
            String per2 = ExcellUtils.getCellData(filePath, "Data2",i, 3);
            String frequency = ExcellUtils.getCellData(filePath, "Data2",i, 4);
            String exp_maturityValue = ExcellUtils.getCellData(filePath, "Data2",i, 5);

            //pass above data into application
            driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(price);
            driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
            driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
            Select periodDropDown = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
            periodDropDown.selectByVisibleText(per2);
            Select frcDrpdwn = new Select(driver.findElement(By.xpath("//select[@id='frequency']"))) ;
            frcDrpdwn.selectByVisibleText(frequency);
            //Clicked on Calculate button.
            driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();
            //validation.
            String actualMtrVal = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
            if(Double.parseDouble(exp_maturityValue)==Double.parseDouble(actualMtrVal)){
                System.out.println("Test Passed");
                ExcellUtils.setCellData(filePath,"Data2",i,7,"Passed");
                ExcellUtils.fileGreenColor(filePath,"Data2",i,7);
            }
            else{
                System.out.println("Test Failed");
                ExcellUtils.setCellData(filePath,"Data2",i,7,"Failed");
                ExcellUtils.fileRedColor(filePath,"Data2",i,7);
            }
            Thread.sleep(4000);
            driver.findElement(By.xpath("//img[@class='PL5']")).click();
        }

        driver.quit();
    }
}
