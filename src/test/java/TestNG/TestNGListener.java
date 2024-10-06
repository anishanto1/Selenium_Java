package TestNG;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

    WebDriver driver;

    
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());

        // Retrieve WebDriver instance from the test class
        Object testClass = result.getInstance();
        driver = ((TestNGScreenshotExample) testClass).driver;

        // Capture screenshot if driver is available
        if (driver != null) {
            String screenshotPath = captureScreenshot(driver, result.getName());
            System.out.println("Screenshot saved at: " + screenshotPath);
            // Add screenshot path to the report
            result.setAttribute("screenshotPath", screenshotPath);
        }
    }

    // Method to capture screenshot
    public String captureScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Set destination file path
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + "_" + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileHandler.copy(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    
    public void onTestStart(ITestResult result) { }
    
    public void onTestSuccess(ITestResult result) { }
    
    public void onTestSkipped(ITestResult result) { }
    
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }
    
    public void onStart(ITestContext context) { }
    
    public void onFinish(ITestContext context) { }
}