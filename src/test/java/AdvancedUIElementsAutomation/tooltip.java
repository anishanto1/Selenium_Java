package AdvancedUIElementsAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tooltip {

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

            // Print the tooltip text to the console
            String tooltipText = tooltip.getText();
            System.out.println("Tooltip text: " + tooltipText);

        } catch (Exception e) {
           
        } finally {
            driver.quit();  // Close the browser after test execution
        }
    }
}