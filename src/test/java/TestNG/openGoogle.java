package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class openGoogle {

	 WebDriver driver;

	    @BeforeTest
	    public void setUp() {
	        // Set up ChromeDriver
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	    }

	    @Test
	    public void openGoogle() {
	        // Open Google
	        driver.get("https://www.google.com");
	        System.out.println("Google is opened!");
	    }

	    @AfterTest
	    public void tearDown() {
	        // Close the browser
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}