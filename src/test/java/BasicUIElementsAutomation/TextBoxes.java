package BasicUIElementsAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextBoxes {

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();

		WebDriver driver = new FirefoxDriver();

		driver.navigate().to("https://letcode.in/edit");

		//Add text into the Text box 
		WebElement EnterName = driver.findElement(By.xpath("//*[@id=\"fullName\"]\r\n"
				+ ""));
		EnterName.sendKeys("Tester");

		//Append Text
		WebElement Append = driver.findElement(By.xpath("//*[@id=\"join\"]"));
		Append.sendKeys(" Test ");

		//Get Default Text
		String	DefaultText = driver.findElement(By.id("clearMe")).getAttribute("value");
		System.out.println(DefaultText);

		//Clear Values
		driver.findElement(By.id("clearMe")).clear();

		//Is enabled

		WebElement UI = driver.findElement(By.xpath("//*[@id='noEdit']"));
		boolean  	i=  UI.isEnabled();
		System.out.println(i);

	}

}
