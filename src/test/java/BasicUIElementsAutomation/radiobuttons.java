package BasicUIElementsAutomation;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class radiobuttons {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//Cofirm you can select only one radio button

		try {
			driver.navigate().to("https://letcode.in/radio"); 

			// Locate the radio button
			WebElement radioButton = driver.findElement(By.xpath("//*[@id=\"no\"]\r\n"
					+ ""));

			// Click the radio button
			radioButton.click();

			// Validate if the radio button is selected
			boolean isSelected1 = radioButton.isSelected();

			if (isSelected1) {
				System.out.println("Radio button is selected.");
			} else {
				System.out.println("Radio button is not selected.");
			}

			WebElement Yes = driver.findElement(By.xpath("/html/body/app-root/app-radio-check/section[1]/div/div/div[1]/div/div/div[3]/div/label[1]\r\n"
					+ ""));
			Yes.click();
			WebElement No = driver.findElement(By.xpath("/html/body/app-root/app-radio-check/section[1]/div/div/div[1]/div/div/div[3]/div/label[2]\r\n"
					+ ""));
			No.click();

			// Check if only one is selected
			boolean isYesSelected = Yes.isSelected();
			boolean isNoSelected = No.isSelected();

			// Validation logic
			if (isYesSelected && isNoSelected) {
				System.out.println("Test Failed: Both radio buttons are selected.");
			} else if (!isYesSelected && !isNoSelected) {
				System.out.println("Test Failed: Neither radio button is selected.");
			} else if (isYesSelected) {
				System.out.println("Test Passed: 'Yes' is selected and 'No' is not selected.");
			} else {
				System.out.println("Test Passed: 'No' is selected and 'Yes' is not selected.");
			}

			// Confirm last field is disabled
			WebElement going = driver.findElement(By.xpath("/html/body/app-root/app-radio-check/section[1]/div/div/div[1]/div/div/div[5]/div/label[1]\r\n"
					+ ""));
			WebElement notgoing = driver.findElement(By.xpath("/html/body/app-root/app-radio-check/section[1]/div/div/div[1]/div/div/div[5]/div/label[2]\r\n"
					+ ""));

			WebElement Maybe = driver.findElement(By.xpath("/html/body/app-root/app-radio-check/section[1]/div/div/div[1]/div/div/div[5]/div/label[3]\r\n"
					+ ""));

			// Check if the "Maybe" radio button is disabled
			if (Maybe.isEnabled()) {
				System.out.println("Test Passed: 'Maybe' option is disabled.");
			} else {
				System.out.println("Test Failed: 'Maybe' option is enabled, but it should be disabled.");
			}

			//Find if the checkbox is selected?
			WebElement Remember_me = driver.findElement(By.xpath("/html/body/app-root/app-radio-check/section[1]/div/div/div[1]/div/div/div[6]/label[2]/input\r\n"
					+ ""));
			// Check if the checkbox is selected
			if (Remember_me.isSelected()) {
				System.out.println("The 'Remember me' checkbox is selected.");
			} else {
				System.out.println("The 'Remember me' checkbox is NOT selected.");
			}

			//Accept the T&C
			WebElement I_Agree = driver.findElement(By.xpath("/html/body/app-root/app-radio-check/section[1]/div/div/div[1]/div/div/div[7]/label[2]\r\n"
					+ ""));
			// Click the "I Agree" checkbox to accept the Terms and Conditions
			I_Agree.click();

			// Re-fetch the checkbox element to confirm selection state
	        WebElement refreshedCheckbox = driver.findElement(By.xpath("/html/body/app-root/app-radio-check/section[1]/div/div/div[1]/div/div/div[7]/label[2]/input"));

	        // Validate that the checkbox is selected
	        if (refreshedCheckbox.isSelected()) {
	            System.out.println("Test Passed: 'I Agree' checkbox is selected.");
	        } else {
	            System.out.println("Test Failed: 'I Agree' checkbox is NOT selected.");
	        }
			
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}