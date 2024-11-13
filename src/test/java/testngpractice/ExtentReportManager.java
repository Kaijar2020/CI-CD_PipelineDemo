package testngpractice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter; //UI of the reports.
    public ExtentReports extent; //common info on the project.
    public ExtentTest test; //creating test case entire on the report and update status on test methods.

    public void onStart(ITestContext context){
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/MyReport.html"); //specific test report folder.

        sparkReporter.config().setDocumentTitle("Automation Test Report"); //Title of the Report.
        sparkReporter.config().setReportName("Test Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter); //Attach the repo

        extent.setSystemInfo("Computer Name","localhost");
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("Tester Name","Ayon");
        extent.setSystemInfo("OS","Windows 10");
        extent.setSystemInfo("Browser name","Chrome");
    }

    public void onTestSuccess(ITestResult result){
        test = extent.createTest(result.getName()); //create new entry in the report.
        test.log(Status.PASS,"Test case PASSED is: "+result.getName()); //update status.
    }

    public void onTestFailure(ITestResult result){
        test = extent.createTest(result.getName()); //create new entry in the report.
        test.log(Status.FAIL,"Test case FAILED is: "+result.getName()); //update status.
        test.log(Status.FAIL,"Test case FAILED is: "+result.getThrowable()); //update status.
    }

    public void onTestSkipped(ITestResult result){
        test = extent.createTest(result.getName()); //create new entry in the report.
        test.log(Status.SKIP,"Test case SKIPPED is: "+result.getName());
    }

    public void onFinish(ITestContext context){
        extent.flush(); //will update the all things and close the report.
    }
}
