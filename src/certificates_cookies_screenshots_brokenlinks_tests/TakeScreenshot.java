package certificates_cookies_screenshots_brokenlinks_tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Create Chrome driver 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Khalid\\Documents\\Documents\\Courses\\Selenium\\Apps\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Open Facebook page
		driver.get("https://www.facebook.com/");
		
		// Create a File object (i.e. a screenshot)
		// by casting the driver to a TakesScreenshot class object
		// and calling its getScreenshotAs() method
		// by passing the parameter as an OutputType of FILE
		// (so that the driver creates the screenshot as a file)
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		// Need to now save the "screenshot" file object created in previous step to local machine
		// This can be done using the copyFile() method in the FileUtils class from apache
		// By passing the screenshot file object and target file location/name as parameters
		FileUtils.copyFile(screenshot, new File("C:\\Users\\Khalid\\screenshot.png"));
		
	}

}
