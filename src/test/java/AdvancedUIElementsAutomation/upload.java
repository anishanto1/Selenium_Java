package AdvancedUIElementsAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class upload {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {
			// Navigate to the page with the upload option
			driver.get("https://the-internet.herokuapp.com/upload");

			// Wait for the file input element to be present
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"file-upload\"]"))); // Use ID for the file input

			// Provide the path of the file you want to upload
			String filePath = "D:\\Downloads\\sampleFile.jpeg"; // Update with the actual file path
			fileInput.sendKeys(filePath); // Directly send the file path to the input

			// Click the upload button
			WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("file-submit"))); // Use ID for the submit button
			uploadButton.click(); // Submit the upload

			// Print success message
			System.out.println("File uploaded successfully.");

			// Optionally, verify if the file upload was successful
			WebElement uploadedFileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));
			System.out.println("Uploaded File: " + uploadedFileName.getText());

		} catch (Exception e) {
			e.printStackTrace(); // Print any exceptions that occur
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}