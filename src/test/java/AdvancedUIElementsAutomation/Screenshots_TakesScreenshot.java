package AdvancedUIElementsAutomation;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshots_TakesScreenshot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {
            // Navigate to the URL
            driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/auto-complete.php");

            // Take screenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Destination for saving the screenshot
            File destinationFile = new File("C:\\Users\\Anto\\eclipse-workspace\\SeleniumTraining\\screenshots\\screenshot.png");

            // Copy file to the destination (ensure directory exists)
            FileHandler.copy(sourceFile, destinationFile); 

            // Locate auto-complete element and interact
            WebElement autoComplete = driver.findElement(By.id("tags")); // Adjust this locator if necessary
            autoComplete.sendKeys("Asp");

            // Wait for suggestions to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-autocomplete")));

            // Find all auto-complete suggestions
            List<WebElement> suggestions = driver.findElements(By.className("ui-menu-item")); // Adjust if necessary

            // Select a suggestion (e.g., the first one)
            for (WebElement suggestion : suggestions) {
                if (suggestion.getText().equals("Asp")) { // Replace with actual expected text
                    suggestion.click();
                    break;
                }
            }

            System.out.println("Auto-complete option selected successfully.");

            // Retrieve the selected value from the field
            String selectedText = autoComplete.getAttribute("value");
            System.out.println("Selected auto-complete suggestion: " + selectedText);

        } catch (Exception e) {
            // Print the exception for debugging
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}