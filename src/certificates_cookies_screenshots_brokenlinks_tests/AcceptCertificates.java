package certificates_cookies_screenshots_brokenlinks_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AcceptCertificates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create a new customised Chrome profile
		DesiredCapabilities profile = DesiredCapabilities.chrome();
		
		// There are 2 ways to accept insecure certificates in the new Chrome profile
		// 1.
		//profile.acceptInsecureCerts();
		// 2.
		profile.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		// Accept SSL certificates also 
		profile.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		// Create an instance of Chrome options
		ChromeOptions options = new ChromeOptions();
		
		// In Chrome options, merge new Chrome profile with existing local Chrome profile
		options.merge(profile);
		
		// Create Chrome driver with options having the merged profile
		// So that the driver knows to automatically accept insecure and SSL certificates 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Khalid\\Documents\\Documents\\Courses\\Selenium\\Apps\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		// Get google.com
		driver.get("https://www.google.com");
		
	}

}
