package AdvancedUIElementsAutomation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandling {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 
		 try {
	            // Step 1: Navigate to the webpage with multiple windows
	            driver.get("https://letcode.in/windows");
	            
	            // Step 2: Get the current window handle (parent window)
	            String parentWindowHandle = driver.getWindowHandle();
	            System.out.println("Parent window handle: " + parentWindowHandle);
	            
	            // Step 3: Find and click the button that opens a new window
	            WebElement openHomePageButton = driver.findElement(By.id("home"));
	            openHomePageButton.click();
	            
	            // Step 4: Get all window handles
	            Set<String> allWindowHandles = driver.getWindowHandles();
	            System.out.println("All window handles: " + allWindowHandles);
	            
	            // Step 5: Switch to the newly opened window
	            for (String windowHandle : allWindowHandles) {
	                if (!windowHandle.equals(parentWindowHandle)) {
	                    driver.switchTo().window(windowHandle);
	                    System.out.println("Switched to new window: " + driver.getTitle());
	                    
	                    // Perform actions on the new window (e.g., get the page title)
	                    System.out.println("New window title: " + driver.getTitle());
	                    
	                    // Close the new window
	                    driver.close();
	                }
	            }
	            
	            // Step 6: Switch back to the parent window
	            driver.switchTo().window(parentWindowHandle);
	            System.out.println("Switched back to parent window: " + driver.getTitle());
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Step 7: Close the parent window
	            driver.quit();
	        }
	    }
}
