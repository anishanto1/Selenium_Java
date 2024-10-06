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

public class Calender {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {
			// Open the webpage with the calendar
			driver.get("https://letcode.in/calendar");

			// Locate and click on the calendar input field to open the calendar
			WebElement calendarInput = driver.findElement(By.xpath("/html/body/app-root/app-calender/section[1]/div/div/div[1]/div/div/div[1]/div[1]/nwb-date-picker/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]\r\n"
					+ ""));
			calendarInput.click() ;      

			// Select Oct from teh popup
			WebElement Oct = driver.findElement(By.xpath("/html/body/app-root/app-calender/section[1]/div/div/div[1]/div/div/div[1]/div[1]/nwb-date-picker/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[10]\r\n"
					+ ""));
			Oct.click();

			// Select the date 15th
			WebElement Date = driver.findElement(By.xpath("/html/body/app-root/app-calender/section[1]/div/div/div[1]/div/div/div[1]/div[1]/nwb-date-picker/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[17]/button"));
			Date.click();


			//Print the text from the popup
			WebElement resposne = driver.findElement(By.xpath("/html/body/app-root/app-calender/section[1]/div/div/div[1]/div/div/div[2]/p\r\n"
					+ ""));
			String The_Date = resposne.getText();
			System.out.println("The Date is :" + The_Date);


		} catch (Exception e) {
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}