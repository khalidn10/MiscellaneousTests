package certificates_cookies_screenshots_brokenlinks_tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		// Create Chrome driver 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Khalid\\Documents\\Documents\\Courses\\Selenium\\Apps\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Open Automation Practice website
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		// Create a List of WebElements for the links in the footer
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		// Create variables to be used in 'for' loop
		String url = "";
		HttpURLConnection conn;
		int responseCode = 0;
		SoftAssert sAssert = new SoftAssert();
		
		// For each link
		for (WebElement link : links)
		{
			// Retrieve the URL for the link
			url = link.getAttribute("href");
			
			// Set an instance to a HttpURLConnection for the URL (i.e. the one retrieved in the previous step)
			conn = (HttpURLConnection) new URL(url).openConnection();
			// Set the request method to 'HEAD'
			conn.setRequestMethod("HEAD");
			// Send the request
			conn.connect();
			
			// Retrieve the response code (i.e. the Status code in Dev Tools) for the link
			responseCode = conn.getResponseCode();
			// Soft assert created to check if link is broken
			sAssert.assertTrue(responseCode<=400, "Response code for " + link.getText()  + " failed");
			// Print out the response code for the link
			System.out.println("Response code for " + link.getText()  + " link is: \t" + responseCode);
		}
		
		// Fail test if any soft asserts failed
		sAssert.assertAll();
		
		// Otherwise print a message stating the test passed
		System.out.println("Test passed!");
	}

}
