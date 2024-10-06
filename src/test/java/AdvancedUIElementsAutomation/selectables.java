package AdvancedUIElementsAutomation;

import java.security.Key;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selectables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {
			driver.navigate().to("https://letcode.in/selectable");

			List<WebElement> Selectable = driver.findElements(By.xpath("//*[@id=\"clour\"]\r\n"
					+ ""));
			int count =	Selectable.size();
			System.out.println(count);


			Actions action = new Actions(driver);
			// Hold down the Control key and click on multiple elements
			action.keyDown(Keys.CONTROL)
			.click(Selectable.get(0)) // Click first element
			.click(Selectable.get(1)) // Click second element
			.click(Selectable.get(2)) // Click third element
			.keyUp(Keys.CONTROL)      // Release Control key
			.perform();                // Perform the action

			System.out.println("Multiple elements selected successfully.");
		} catch (Exception e) {
			// TODO: handle exception
		}
		driver.quit();
	}

}
