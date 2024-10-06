package BasicUIElementsAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Buttons {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://letcode.in/buttons");

		//Click the button

		WebElement HomeButton = driver.findElement(By.xpath("//*[@id='home']"));

		try {
			// Attempt to click the button
			HomeButton.click();

			// If no exception occurs, the button was clicked
			System.out.println("Home button was clicked.");
		} catch (Exception e) {
			// If an exception occurs, the button was not clicked
			System.out.println("Failed to click the Home button.");
		}

		driver.navigate().back();

		//Get the X & Y co-ordinates
		WebElement getpostition = driver.findElement(By.xpath("//*[@id=\"position\"]\r\n"
				+ ""));
		Point XYpoint = getpostition.getLocation();
		int Xvalue = XYpoint.getX();
		int Yvalue = XYpoint.getY();
		System.out.println("The X Value is : " + Xvalue);
		System.out.println("The Y Value is : " + Yvalue);

		//Find the button color


		WebElement FindColor = driver.findElement(By.xpath("//*[@id=\"color\"]\r\n"
				+ ""));
		String color = FindColor.getCssValue("background-color");
		System.out.println("The button color is : " + color);

		//Find Height & Width
		WebElement Buttonsize = driver.findElement(By.xpath("//*[@id=\"property\"]\r\n"
				+ ""));
		int height = Buttonsize.getSize().getHeight();
		int Width = Buttonsize.getSize().getWidth();
		System.out.println("The Heigh is : " + height  + " The Width is : " + Width);

		//Is Enabled
		WebElement button = driver.findElement(By.xpath("(//*[@id=\"isDisabled\"])[1]"));

		if (button.isEnabled()) {
			System.out.println("Enabled");
		}
		else
		{
			System.out.println("Not enabled");
		}

		//Click & Hold the Button

		WebElement ButtonHold =  driver.findElement(By.xpath("/html/body/app-root/app-buttons/section[1]/div/div/div[1]/div/div/div[6]/div/button/div/h2\r\n"
				+ ""));

		Actions action = new Actions(driver); 
		action.clickAndHold(ButtonHold).click().perform();

		//		WebElement afterclickandHold = driver.findElement(By.xpath("/html/body/app-root/app-buttons/section[1]/div/div/div[1]/div/div/div[6]/label"));
		//
		//		String text = afterclickandHold.getText();
		//		System.out.println(text);


		// Wait for changes to appear (if any)
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-buttons/section[1]/div/div/div[1]/div/div/div[6]/div/button/div/h2\r\n"
				+ ""
				+ ""))); // Adjust locator as needed
		Thread.sleep(500);
		// Retrieve and display the changed text
		String displayedText = resultElement.getText();
		System.out.println("Text after long press: " + displayedText);

		// Optionally, close the driver
		driver.close();
	}





}

