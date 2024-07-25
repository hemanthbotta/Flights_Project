package Flights.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AppUtils.Utils;
import Flights.Library.LoginPage;

public class User_Login_Test_with_Valid_Data extends Utils{
	
	@Parameters({"userid","userpwd"})
	@Test
	public void testAdminLogin(String uid, String upwd)
	{
		LoginPage login = new LoginPage();
		login.loginApp(uid, upwd);
		boolean res = login.isUserModuleDisplayed();
		Assert.assertTrue(res);
		login.logoutApp();
	}
	


}
