package Flights.Library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import AppUtils.Utils;

public class RegisterPage extends Utils{
	
	public void newRegister(String name, String contact, String email, String password, String date)
	{
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("contact")).sendKeys(contact);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("address")).sendKeys(password);
		WebElement elegender = driver.findElement(By.name("gender"));
		elegender.click();
		Select gender = new Select (elegender);
		gender.selectByValue("M");
		driver.findElement(By.id("popupDatepicker")).sendKeys(date);
		driver.findElement(By.className("form-check-input")).click();
		driver.findElement(By.name("submit")).click();
												
	}

}
