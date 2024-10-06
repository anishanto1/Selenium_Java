package AdvancedUIElementsAutomation;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Download {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {

			driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/upload-download.php");

			//Locate the download Button
			WebElement downloadButton = driver.findElement(By.xpath("//*[@id='downloadButton']"));

			//click the downloadButton
			downloadButton.click();

			//Create File Class
			//Provide file path
			File filelocation = new File("D:\\Downloads");

			//List all the files from the downloads section
			File[] allfiles = filelocation.listFiles();

			//Use foreach statement
			for (File file : allfiles) {

				if (file.getName().equals("sampleFile.jpeg"));
				System.out.println("The file is downloaded");

				break;

			}


		} catch (Exception e) {
		    
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}