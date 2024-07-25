package Flights.TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AppUtils.Utils;
import Flights.Library.FlightBookingPage;
import Flights.Library.LoginPage;


public class Test_Booking_Flight_Ticket extends Utils{
	
	@Parameters({"userid","userpwd","dof","flname","tn","ft"})
	@Test
	public void flightReservation(String uid, String upwd, String flightdate, String flightname, String travelername, String ftickets) throws InterruptedException
	{
		LoginPage login = new LoginPage();
		login.loginApp(uid, upwd);
		
		FlightBookingPage flightbook = new FlightBookingPage();
		flightbook.flightBooking(flightdate, flightname, travelername, ftickets);
		Thread.sleep(2000);
		login.logoutApp();
	}

}
