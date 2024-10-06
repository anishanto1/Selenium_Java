package AdvancedUIElementsAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {

			driver.navigate().to("https://letcode.in/dropable");

			WebElement Source = driver.findElement(By.xpath("//*[@id=\"draggable\"]\r\n"
					+ ""));

			WebElement Target = driver.findElement(By.xpath("//*[@id=\"droppable\"]"
					+ ""));

			// Create an Actions object
			Actions action = new Actions(driver);

			// Perform the drag-and-drop action
			action.dragAndDrop(Source, Target).build().perform();

			// Validate if the drag-and-drop was successful by checking the text
			String textAfterDrop = Target.getText();
			if (textAfterDrop.equals("Dropped!")) {
				System.out.println("Drag and drop successful!");
			} else {
				System.out.println("Drag and drop failed!");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		driver.quit();
	}

}
