package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parameters {

	@Test
	@Parameters("url")	
	public void openURL(String url) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Open the provided URL
		driver.get(url);
		System.out.println("Opened URL: " + url);
	}

}
