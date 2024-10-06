package BasicUIElementsAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenGoogle {
	
	 public static void main(String[] args) {
	
    WebDriverManager.chromedriver().setup();
    
    // Create a new instance of ChromeDriver
    WebDriver driver = new ChromeDriver();
    
    // Navigate to Google
    driver.get("https://www.google.com");
    
    // Print the title of the page
    System.out.println("Title of the page: " + driver.getTitle());
	

	 }

}
