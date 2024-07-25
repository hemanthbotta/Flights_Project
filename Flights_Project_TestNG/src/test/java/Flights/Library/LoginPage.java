package Flights.Library;

import AppUtils.Utils;

import org.openqa.selenium.*;

public class LoginPage extends Utils{
	
	public void loginApp(String uid, String pwd)
	{
		driver.findElement(By.name("email")).sendKeys(uid);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	}
	
	public boolean isUserModuleDisplayed() 
	{
		try {
			
			driver.findElement(By.partialLinkText("Hemanth")).isDisplayed();
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isErrorMessageDisplayed()
	{
		try {
			
			WebElement errmsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissable']"));
			errmsg.getText().toLowerCase().contains("invalid Login");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void logoutApp()
	{
		driver.findElement(By.xpath("//i[@class='fa fa-gear']")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

}
