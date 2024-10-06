package AdvancedUIElementsAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrames {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {

			driver.navigate().to("https://letcode.in/frame");

			// Switch to the iframe by its name, ID, or WebElement
			driver.switchTo().frame(0);

			//Spot the webelement
			WebElement inputfield = driver.findElement(By.xpath(" /html/body/app-root/app-frame-content/div/div/form/div[1]/div/input"));

			inputfield.sendKeys("Test");

			// Switch back to the main content
			driver.switchTo().defaultContent();
			System.out.println("Text entered into iframe successfully.");


		} catch (Exception e) {			

		}
		finally {
			// Close the browser
			driver.quit();
		}
	}

}

