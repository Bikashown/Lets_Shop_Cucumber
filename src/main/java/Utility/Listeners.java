package Utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Basic implements ITestListener{
	 ExtentTest test;
	 WebDriver Driver;
	ExtentReports report1=ReportEngine.getTestReport();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test=report1.createTest(result.getMethod().getMethodName());
		 
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS,"Test Passed");
	
	}
	
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,"Test Failed");
		try {
			 Driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String filepath=null;
		filepath=CommonAction.screenShot(Driver, result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}
	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report1.flush();
		
	}
}
