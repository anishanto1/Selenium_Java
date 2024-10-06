package AdvancedUIElementsAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class autocomplete {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		try {
			driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/auto-complete.php");
			
			WebElement Auto_complete = driver.findElement(By.xpath("//*[@id=\"tags\"]\r\n"
					+ ""));
			Auto_complete.sendKeys("Asp");
			
			// Wait for the auto-complete suggestions to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-autocomplete-input"))); // Update with actual class
            
            // Get all suggestions
            List<WebElement> suggestions = driver.findElements(By.className("auto-complete-suggestion-class"));

            // Select a suggestion (for example, the first one)
            for (WebElement suggestion : suggestions) {
                if (suggestion.getText().equals("Asp")) { // Replace with expected text
                    suggestion.click();
                    break;
                }
            }

            System.out.println("Auto-complete option selected successfully.");
            
            // After selecting, retrieve the selected value from the search field
            
            String selectedText = Auto_complete.getAttribute("value");
            
            System.out.println("Selected auto-complete suggestion: " + selectedText);
            
        } catch (Exception e) {
           
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}