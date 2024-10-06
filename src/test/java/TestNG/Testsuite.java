package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testsuite {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		// Initialize WebDriver
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void openGoogle() {
		driver.navigate().to("https://www.google.co.in/");
		System.out.println("Opened Google");
	}

	@Test(priority = 2)
	public void openYouTube() {
		driver.navigate().to("https://www.youtube.com/");
		System.out.println("Opened YouTube");
	}

	@AfterMethod
	public void openBing() {
		driver.navigate().to("https://www.bing.com/");
		System.out.println("Opened Bing");
		driver.quit(); // Close the browser after the test completes
	}
}