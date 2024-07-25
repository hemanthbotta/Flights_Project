package Flights.Library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import AppUtils.Utils;

public class FlightBookingPage extends Utils{
	
	public void flightBooking(String dateoffly, String flightname, String travelername, String flighttickets) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@placeholder='Select Date']")).click();
		
		String dof = dateoffly;
		String[] temp = dof.split("-");
		String date = temp[0];
		String month = temp[1];
		String year = temp[2];
		
		String calmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		while(!calmonth.equals(month))
		{
			driver.findElement(By.linkText("Next")).click();
			calmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		}
		
		String calyear = driver.findElement(By.className("ui-datepicker-year")).getText();
		while(!calyear.equals(year))
		{
			driver.findElement(By.linkText("Next")).click();
			calyear = driver.findElement(By.className("ui-datepicker-year")).getText();
		}
		
		driver.findElement(By.className("ui-datepicker-calendar"));
		List<WebElement> calrows = driver.findElements(By.tagName("tr"));
		for(int i=1; i<calrows.size(); i++)
		{
			List<WebElement> calcols = calrows.get(i).findElements(By.tagName("td"));
			for(WebElement element : calcols)
			{
				if(element.getText().equals(date))
				{
					element.click();
					break;
				}
			}
		}
		
		  WebElement flyfrom = driver.findElement(By.xpath("//select[@class='form-control col-md-3 search_fileds  sf2']"));
		  flyfrom.click();
		  Select flyfromelement = new Select (flyfrom);
		  flyfromelement.selectByValue("1");
		  
		  WebElement flyto = driver.findElement(By.xpath("//select[@class='form-control col-md-3 search_fileds  sf3']"));
		  flyto.click();
		  Select flytoelement = new Select (flyto);
		  flytoelement.selectByValue("4");
		  
		  driver.findElement(By.xpath("//button[normalize-space()='Search Flights']")).click();
	        Thread.sleep(3000);
			driver.findElement(By.className("flights_table"));
			List<WebElement> flightsearchrows = driver.findElements(By.tagName("tr"));
			for (int i=1; i<flightsearchrows.size(); i++) 
			{
				List<WebElement> flightsearchcols = flightsearchrows.get(i).findElements(By.tagName("td"));
				for(int j=0;j<flightsearchcols.size();j++)
				{
					System.out.println(flightsearchcols.get(j).getText());
					if(flightsearchcols.get(j).getText().equalsIgnoreCase(flightname))
					{
						flightsearchcols.get(8).click();
						break;
					}
				}
						 
			}
			
			  driver.findElement(By.id("name")).sendKeys(travelername);
			  WebElement tickets = driver.findElement(By.id("tickets"));
			  tickets.clear();
			  tickets.sendKeys(flighttickets);
			  
			  driver.findElement(By.xpath("//button[@class='btn disable-order btn-order insert-order active']")).click();
			  
	}
	
	

}
