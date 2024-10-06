package AdvancedUIElementsAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Forms {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {

			driver.navigate().to("https://letcode.in/forms");

			//First Name using Send keys
			WebElement First_Name = driver.findElement(By.xpath("//*[@id=\"firstname\"]\r\n"
					+ ""));
			First_Name.sendKeys("Tester");

			//Last Name using Send keys
			WebElement Last_Name = driver.findElement(By.xpath("//*[@id=\"lasttname\"]\r\n"
					+ ""));
			Last_Name.sendKeys("Test");

			//Add Email 
			// clear existing data 
			//Send keys
			WebElement Email = driver.findElement(By.xpath("//*[@id=\"email\"]\r\n"
					+ ""));
			Email.clear();
			Email.sendKeys("test@yopmail.com");

			//Choose Country code
			WebElement country_code = driver.findElement(By.xpath("/html/body/app-root/app-forms/section[1]/div/div/div[1]/div/div/form/div[2]/div[2]/div/div/div/select\r\n"
					+ ""));

			//Use select class
			Select select = new Select(country_code);
			select.selectByVisibleText("Austria (+43)");

			//Phone Number
			WebElement phonenumber = driver.findElement(By.xpath("//*[@id=\"Phno\"]\r\n"
					+ ""));
			phonenumber.sendKeys("1234567890");

			//Address Line-1
			WebElement Address1 = driver.findElement(By.xpath("//*[@id=\"Addl1\"]\r\n"
					+ ""));
			Address1.sendKeys("Test");

			//Address Line-2
			WebElement Address2 = driver.findElement(By.xpath("//*[@id=\"Addl2\"]\r\n"
					+ ""));
			Address2.sendKeys("Test");

			//State
			WebElement State = driver.findElement(By.xpath("//*[@id=\"state\"]\r\n"
					+ ""));
			State.sendKeys("Test");

			//Postalcode
			WebElement Postalcode = driver.findElement(By.xpath("//*[@id=\"postalcode\"]\r\n"
					+ ""));
			Postalcode.sendKeys("Test");

			//Country
			WebElement Country = driver.findElement(By.xpath("/html/body/app-root/app-forms/section[1]/div/div/div[1]/div/div/form/div[5]/div[2]/div/div/div/select\r\n"
					+ ""));

			//User select class
			Select select1 = new Select(Country);			
			select1.selectByVisibleText("Australia");

			//DOB
			WebElement DOB = driver.findElement(By.xpath("//*[@id=\"Date\"]\r\n"
					+ ""));

			//DOB click
			DOB.sendKeys("10/02/2024");

			//Gender
			WebElement Male = driver.findElement(By.xpath("/html/body/app-root/app-forms/section[1]/div/div/div[1]/div/div/form/div[6]/div[2]/div/div/label[1]\r\n"
					+ ""));
			Male.click();

			//Accept the check box
			WebElement Agree = driver.findElement(By.xpath("/html/body/app-root/app-forms/section[1]/div/div/div[1]/div/div/form/div[7]/div/label/input\r\n"
					+ ""));
			Agree.click();	

			//Click submit
			WebElement submit = driver.findElement(By.xpath("/html/body/app-root/app-forms/section[1]/div/div/div[1]/div/div/form/div[8]/div/input\r\n"
					+ ""));
			submit.click();



		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
