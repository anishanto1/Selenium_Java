package AdvancedUIElementsAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {

			driver.navigate().to("https://letcode.in/elements");

			//Find the Text box where we need to provide inputs
			WebElement textbox = driver.findElement(By.xpath("/html/body/app-root/app-githome/section[1]/div/div/div[1]/div/div/form/div/p[1]/input\r\n"
					+ ""));
			String searchTerm = "Test";
			textbox.sendKeys(searchTerm);

			//Find the searchbox
			WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"search\"]\r\n"
					+ ""));
			searchbox.click();

			// Use WebDriverWait to wait for the image to appear after search
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement image = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-githome/section[1]/div/div/div[1]/div/div/div/app-usercard/div/div/div[1]/div[1]/figure/img")));

			// Validate if the image is displayed
			boolean isImageDisplayed = image.isDisplayed();

			// Assert to check if the image is displayed
			Assert.assertTrue(isImageDisplayed, "The image is not displayed!");

			System.out.println("Image is displayed as expected.");


			List<WebElement> searchResults  =  driver.findElements(By.xpath("/html/body/app-root/app-githome/section[1]/div/div/div[1]/div/div/div/app-gitrepos/div/div/ol"));

			for (WebElement result : searchResults) {
				String resultText = result.getText();  // Get the visible text from the result
				System.out.println(resultText);  // Print each search result

				// Optional: Validate if the result contains the search term
				Assert.assertTrue(resultText.toLowerCase().contains(searchTerm.toLowerCase()), "Irrelevant result found: " + resultText);
			}

			System.out.println("All results are relevant to the search term.");

		} catch (Exception e) {

		} finally {
			// Close the browser
			driver.quit();
		}
	}
}