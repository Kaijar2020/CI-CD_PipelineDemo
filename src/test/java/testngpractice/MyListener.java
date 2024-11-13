package testngpractice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    public void onStart(ITestContext context){
        System.out.println("this execution is Start");
    }

    public void onTestStart(ITestResult result){
        System.out.println("Test start");
    }

    public void onTestSuccess(ITestResult result){
        System.out.println("Test Passed.....");
    }

    public void onTestFailure(ITestResult result){
        System.out.println("Test Failure...");
    }

    public void onTestSkipped(ITestResult result){
        System.out.println("Test Skipped");
    }

    public void onFinish(ITestContext context){
        System.out.println("Test execution is completed.");
    }
}
