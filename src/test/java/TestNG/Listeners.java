package TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	 public void onTestStart(ITestResult result) {
	        System.out.println("Test Started: " + result.getName());
	    }

	    public void onTestSuccess(ITestResult result) {
	        System.out.println("Test Passed: " + result.getName());
	    }

	    public void onTestFailure(ITestResult result) {
	        System.out.println("Test Failed: " + result.getName());
	    }

	    public void onTestSkipped(ITestResult result) {
	        System.out.println("Test Skipped: " + result.getName());
	    }

	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Not often used
	    }

	    public void onStart(ITestContext context) {
	        System.out.println("Test Suite Started: " + context.getName());
	    }

	    public void onFinish(ITestContext context) {
	        System.out.println("Test Suite Finished: " + context.getName());
	    }
	}
	

