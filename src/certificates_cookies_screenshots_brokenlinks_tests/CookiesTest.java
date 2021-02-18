package certificates_cookies_screenshots_brokenlinks_tests;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create Chrome driver 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Khalid\\Documents\\Documents\\Courses\\Selenium\\Apps\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Maximise the window
		driver.manage().window().maximize();
		
		Cookie testCookie = new Cookie("testCookieName", "testCookieValue");
		System.out.println("Cookie created: " + testCookie.toString());
		
		// Add a cookie
		//driver.manage().addCookie(testCookie); // doesn't work - fails due to "invalid cookie domain"
		//System.out.println("Cookie added: " + driver.manage().getCookieNamed("testCookieName"));
		
		//Delete single cookie - To find Chrome cookies, go to Dev tools --> Application tab --> Storage --> Cookies (expand and select)
		//driver.manage().deleteCookieNamed("testCookieName");
		
		// Delete all cookies
		//driver.manage().deleteAllCookies();
		
		// Get google.com
		//driver.get("https://www.google.com");
	}

}
