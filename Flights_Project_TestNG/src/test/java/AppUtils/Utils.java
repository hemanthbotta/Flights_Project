package AppUtils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Utils {
	
	public static String url = "http://flights.qedgetech.com/";
	public static WebDriver driver;
	
	@BeforeSuite
	public static void openApp()
	{
//		System.setProperty("webdriver.chrome.driver", "chromdriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
	}
	
	@AfterSuite
	public static void closeApp()
	{
		driver.close();
	}

}
