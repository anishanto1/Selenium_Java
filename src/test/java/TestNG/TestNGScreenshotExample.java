package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGScreenshotExample {
	
	 public WebDriver driver;

	    @BeforeMethod
	    public void setup() {
	        driver = new ChromeDriver();
	        driver.get("https://example.com");
	    }

	    @Test
	    public void sampleTest() {
	        // Some test that might fail
	        // Example of failing assertion:
	        assert driver.getTitle().equals("Wrong Title");
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    } }