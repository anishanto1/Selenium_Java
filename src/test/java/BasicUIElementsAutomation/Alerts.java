package BasicUIElementsAutomation;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	public static void main(String[] args) throws TimeoutException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Increased wait time

		try {
			driver.navigate().to("https://letcode.in/alert");

			// Accept the Simple Alert
			WebElement simpleAlertButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='accept']")));
			simpleAlertButton.click();

			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println("Simple Alert Text: " + alertText);
			alert.accept();

			// Validate that the simple alert was accepted
			validateAlertAbsence(driver);

			// Dismiss the Confirm Alert & print the alert text
			WebElement confirmAlertButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='confirm']")));
			confirmAlertButton.click();

			Alert confirmAlert = driver.switchTo().alert();
			String confirmAlertText = confirmAlert.getText();
			System.out.println("Confirm Alert Text: " + confirmAlertText);
			confirmAlert.dismiss();

			// Validate that the confirm alert was dismissed
			validateAlertAbsence(driver);

			// Handle the Prompt Alert
			WebElement promptAlertButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='prompt']")));
			promptAlertButton.click();

			Alert promptAlert = driver.switchTo().alert();
			String promptAlertText = promptAlert.getText();
			System.out.println("Prompt Alert Text: " + promptAlertText);

			promptAlert.sendKeys("Test");
			promptAlert.accept();

			WebElement responseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myName\"]\r\n"
					+ "")));
			String responseText = responseElement.getText();
			System.out.println("Response Text After Prompt Alert: " + responseText);

		} catch (NoAlertPresentException e) {
			System.out.println("No alert present when expected: " + e.getMessage());
		} finally {
			// Close the browser
			driver.quit();
		}
	}

	// Method to check if an alert is present
	private static void validateAlertAbsence(WebDriver driver) {
		boolean isAlertPresent;
		try {
			driver.switchTo().alert(); // Try switching to alert
			isAlertPresent = true;
		} catch (NoAlertPresentException e) {
			isAlertPresent = false; // Alert not present
		}
		if (!isAlertPresent) {
			System.out.println("Alert was successfully handled.");
		} else {
			System.out.println("Alert is still present.");
		}

		
	}
}	