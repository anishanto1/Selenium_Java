package BasicUIElementsAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();

		WebDriver driver = new FirefoxDriver();

		//Select apple from the dropdown

		try {
			// Open the webpage
			driver.navigate().to("https://letcode.in/dropdowns");

			// Locate the dropdown element
			WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"fruits\"]\r\n"
					+ ""));  // Use appropriate locator

			// Initialize Select class and select item
			Select select = new Select(dropdown);
			select.selectByVisibleText("Apple");  // Select the item you want

			// Wait until the popup message appears
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Use Duration for timeout
			WebElement popupMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-dropdowns/section[1]/div/div/div[1]/div/div/div[1]/div/div[2]/div/p\r\n"
					+ ""))); // Replace with the popup message element's locator

			//			Thread.sleep(50);
			// Get the text of the popup message
			String message = popupMessage.getText();

			// Validate the message
			if(message.equals("You have selected Apple")) {
				System.out.println("Validation Passed: Popup message is correct.");
			} else {
				System.out.println("Validation Failed: Popup message is incorrect.");
			}

			//Select multiple items from the dropdown
			WebElement Multiselect = driver.findElement(By.id("superheros"));
			// Initialize Select class
			Select select1 = new Select(Multiselect);

			// Verify if the dropdown allows multiple selections
			if (select1.isMultiple()) {
				// Select multiple items by visible text
				select1.selectByVisibleText("Ant-Man");
				select1.selectByVisibleText("Aquaman");
				select1.selectByVisibleText("The Avengers");
				select1.selectByVisibleText("Batman");
				select1.selectByVisibleText("e=\"xm\"X-Men");

				// Print all selected options
				System.out.println("All selected options:");
				for (WebElement selectedOption : select1.getAllSelectedOptions()) {
					System.out.println(selectedOption.getText());
				}
				// Deselect one item
				select1.deselectByVisibleText("Aquaman");

				// Print the selected options after deselection
				System.out.println("Selected options after deselection:");
				for (WebElement selectedOption : select1.getAllSelectedOptions()) {
					System.out.println(selectedOption.getText());
				}
			} else {
				System.out.println("Dropdown does not support multiple selection.");
			}

			//Select the last Items from the dropdown
			List<WebElement> elements = driver.findElements(By.xpath("//*[@id='lang']/option")); // Adjust the XPath based on your needs

			// Ensure there is at least one element
			if (elements.size() > 0) {
				// Get the last element
				WebElement lastElement = elements.get(elements.size() - 1);

				// Print the text of the last element
				System.out.println("Last element text: " + lastElement.getText());
			} else {
				System.out.println("No elements found.");
			}

			//Select India using value & print the selected value
			WebElement India = driver.findElement(By.xpath("//*[@id=\"country\"]\r\n"
					+ ""));
			// Initialize Select class
			Select select3 = new Select(India);

			// Select the option with value "India"
			select3.selectByValue("India"); // Replace "IN" with the actual value attribute of the option for India

			// Get the currently selected option
			WebElement selectedOption = select3.getFirstSelectedOption();
			String selectedValue = selectedOption.getText();

			// Print the selected value
			System.out.println("Selected value: " + selectedValue);

		} finally {
			// Close the browser
			driver.quit();
		}
	}
}