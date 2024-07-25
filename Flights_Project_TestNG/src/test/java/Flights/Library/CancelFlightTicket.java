package Flights.Library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AppUtils.Utils;

public class CancelFlightTicket extends Utils{
	
	public void flightOrderList(String OID) throws InterruptedException
	{
		  driver.findElement(By.linkText("Flight Bookings")).click();
		  
		  String orderID = OID;
		  driver.findElement(By.className("flights_table"));
		  List<WebElement> flightsorderedrow = driver.findElements(By.tagName("tr"));
		  for (int i=1; i<flightsorderedrow.size(); i++)
		  {
			  List<WebElement> flightsorderedcols = flightsorderedrow.get(i).findElements(By.tagName("td"));
			  if (flightsorderedcols.get(0).getText().equals(orderID))
			  {
				  
				  flightsorderedcols.get(9).findElement(By.linkText("Delete")).click();
				  Thread.sleep(2000);
				  driver.switchTo().alert().accept();
				  break;
			  }
		  }
	}

}
