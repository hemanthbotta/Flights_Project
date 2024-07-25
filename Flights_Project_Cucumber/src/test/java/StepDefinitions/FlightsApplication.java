package StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightsApplication {
	
	public static WebDriver driver;
	
	@Given("I open browser with url {string}")
	public void i_open_browser_with_url(String url) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get(url);
	    
	}
	@Then("I should see Login Page")
	public void i_should_see_login_page() {
	    if (driver.findElement(By.xpath("//b[normalize-space()='Login']")).isDisplayed()) 
	    {
			System.out.println("System displayed Login Page");
		}
	}
	@When("I click Register link in Login Page")
	public void i_click_register_link_in_login_page() {
		driver.findElement(By.linkText("Register")).click();
	}
	@And("I enter Name as {string}")
	public void i_enter_name_as(String name) {
		driver.findElement(By.id("name")).sendKeys(name);
	}
	@And("I enter Contact as {string}")
	public void i_enter_contact_as(String contact) {
		driver.findElement(By.id("contact")).sendKeys(contact);
	}
	@And("I enter Email ID as {string}")
	public void i_enter_email_id_as(String email) {
		driver.findElement(By.id("email")).sendKeys(email);
	}
	@And("I enter Password as {string}")
	public void i_enter_password_as(String password) {
		driver.findElement(By.id("address")).sendKeys(password);
	}
	@And("I Select Gender")
	public void i_select_gender() {
		WebElement elegender = driver.findElement(By.name("gender"));
		elegender.click();
		Select gender = new Select (elegender);
		gender.selectByValue("M");
	}
	@And("I select Date of Birth as {string}")
	public void i_select_date_of_birth_as(String date) {
		driver.findElement(By.id("popupDatepicker")).sendKeys(date);
	}
	@When("I click Register button")
	public void i_click_register_button() {
		driver.findElement(By.className("form-check-input")).click();
		driver.findElement(By.name("submit")).click();
	}
	
	@When("I enter EmailID as UserID {string}")
	public void i_enter_email_id_as_user_id(String uid) {
		driver.findElement(By.name("email")).sendKeys(uid);
	}
	
	@When("I enter User Password {string}")
	public void i_enter_user_password(String pwd) {
		driver.findElement(By.name("password")).sendKeys(pwd);
	}
	
	@When("I click Sign In")
	public void i_click_sign_in() {
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	}
	@Then("I should see User Dashboard displayed")
	public boolean i_should_see_user_dashboard_displayed() {
		try {
			
			driver.findElement(By.partialLinkText("Hemanth")).isDisplayed();
			System.out.println("System displayed User Dashboard");
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	@When("I click Logout")
	public void i_click_logout() {
		driver.findElement(By.xpath("//i[@class='fa fa-gear']")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	@When("I enter userid as {string}")
	public void i_enter_userid_as(String id) {
		driver.findElement(By.name("email")).sendKeys(id);
	}
	@When("I enter password as {string}")
	public void i_enter_password(String pwd) {
		driver.findElement(By.name("password")).sendKeys(pwd);
	}
	@Then("I should see error message")
	public boolean i_should_see_error_message() {
		try {
			
			WebElement errmsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissable']"));
			errmsg.getText().toLowerCase().contains("invalid Login");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	@When("I select Date of Flight {string}")
	public void i_select_date_of_flight(String dateoffly) {
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
	}
	@When("I select Fly From")
	public void i_select_fly_from() {
		
		WebElement flyfrom = driver.findElement(By.xpath("//select[@class='form-control col-md-3 search_fileds  sf2']"));
		flyfrom.click();
		Select flyfromelement = new Select (flyfrom);
		flyfromelement.selectByValue("1");
	}
	@When("I select Fly To")
	public void i_select_fly_to() {
		WebElement flyto = driver.findElement(By.xpath("//select[@class='form-control col-md-3 search_fileds  sf3']"));
		flyto.click();
		Select flytoelement = new Select (flyto);
		flytoelement.selectByValue("4");
	}
	@When("I select Search Flights")
	public void i_select_search_flights() throws InterruptedException {
		driver.findElement(By.xpath("//button[normalize-space()='Search Flights']")).click();
		Thread.sleep(3000);
	}
	@Then("Flights Search Results popup table display")
	public void flights_search_results_popup_table_display() {
		WebElement flightres = driver.findElement(By.xpath("//span[normalize-space()='Flights Search Results']"));
	    if(flightres.getText().equalsIgnoreCase("Flights Search Results"))
	    {
	    	System.out.println("Flights Search Results table display");
	    }
	}
	@Then("I select by Flight Name {string}")
	public void i_select_by_flight_name(String flname) {
		driver.findElement(By.className("flights_table"));
		List<WebElement> flightsearchrows = driver.findElements(By.tagName("tr"));
		for (int i=1; i<flightsearchrows.size(); i++) 
		{
			List<WebElement> flightsearchcols = flightsearchrows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<flightsearchcols.size();j++)
			{
				System.out.println(flightsearchcols.get(j).getText());
				if(flightsearchcols.get(j).getText().equalsIgnoreCase(flname))
				{
					flightsearchcols.get(8).click();
					break;
				}
			}
					 
		}
	}
	@Then("I enter the Traveller Name {string}")
	public void i_enter_the_traveller_name(String travelername) {
		driver.findElement(By.id("name")).sendKeys(travelername);
	}
	@Then("I enter the number of Tickets {string}")
	public void i_enter_the_number_of_tickets(String fltickets) {
		WebElement tickets = driver.findElement(By.id("tickets"));
		  tickets.clear();
		  tickets.sendKeys(fltickets);
	}
	@Then("I select Insert Order")
	public void i_select_insert_order() {
		driver.findElement(By.xpath("//button[@class='btn disable-order btn-order insert-order active']")).click();
	}
	@Then("I created the order of booking of flight ticket")
	public void i_created_the_order_of_booking_of_flight_ticket() throws InterruptedException {
	    
	    System.out.println("System displays message order has been created");
	    Thread.sleep(2000);
	}

	@When("I click on Flight Bookings")
	public void i_click_on_flight_bookings() {
		driver.findElement(By.linkText("Flight Bookings")).click();
	}
	@When("I should see the Orders Page")
	public boolean i_should_see_the_orders_page() {
	    //driver.findElement(By.tagName("h2")).getText();
		try {
			
			driver.findElement(By.linkText("Orders")).isDisplayed();
			System.out.println("System displays Flight Orders page");
			return true;
			
			
		} catch (Exception e) {
			return false;
		}
	}
	@When("I capture the order ID {string} and delete the ticket")
	public void i_capture_the_order_id_and_delete_the_ticket(String OID) throws InterruptedException {
		
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
	@Then("I cancelled the ticket by deleting the order with Order ID")
	public void i_cancelled_the_ticket_by_deleting_the_order_with_order_id() {
	    System.out.println("System displays message Order has been deleted successfully");
	}

	
	@When("I close browser")
	public void i_close_browser() {
	    driver.close();
	}


}
