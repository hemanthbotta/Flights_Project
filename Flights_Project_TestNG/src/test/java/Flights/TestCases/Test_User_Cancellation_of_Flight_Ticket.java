package Flights.TestCases;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AppUtils.Utils;
import Flights.Library.CancelFlightTicket;

import Flights.Library.LoginPage;

public class Test_User_Cancellation_of_Flight_Ticket extends Utils {
	
	@Parameters({"userid","userpwd","orderid"})
	@Test
	public void flightBookingCancel(String uid, String upwd, String oid) throws InterruptedException
	{
		LoginPage login = new LoginPage();
		login.loginApp(uid, upwd);
		
		CancelFlightTicket flightticketcancel = new CancelFlightTicket();
		flightticketcancel.flightOrderList(oid);
		Thread.sleep(2000);
		login.logoutApp();
	}

}
