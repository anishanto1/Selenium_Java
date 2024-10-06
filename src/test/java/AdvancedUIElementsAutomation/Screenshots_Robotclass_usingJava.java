package AdvancedUIElementsAutomation;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;


import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshots_Robotclass_usingJava {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {
			// Navigate to your tooltip page
			driver.navigate().to("https://practice.expandtesting.com/tooltips");

			// Wait for the element to be visible
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement tooltipButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='btn1']")));

			// Create Actions class to hover over the element to trigger the tooltip
			Actions action = new Actions(driver);
			action.moveToElement(tooltipButton).perform();

			// Wait for the tooltip to become visible
			WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tooltip-inner")));

			//Screenshot using robot class
			// Create a Robot instance
			Robot robot = new Robot();

			// Define the screen size based on the default toolkit
			Rectangle screenRect  = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

			// Capture the screen as BufferedImage
			BufferedImage screenCapture =   robot.createScreenCapture(screenRect);

			// Save the screenshot to a file
			File destinationFile = new File("C:\\Users\\Anto\\eclipse-workspace\\SeleniumTraining\\screenshots/robot_screenshot.png");
			ImageIO.write(screenCapture, "png", destinationFile);

			System.out.println("Screenshot saved successfully at: " + destinationFile.getAbsolutePath());


			// Print the tooltip text to the console
			String tooltipText = tooltip.getText();
			System.out.println("Tooltip text: " + tooltipText);
		}
		catch (Exception e) {
			// TODO: handle exception
			driver.close();
		}
	}}