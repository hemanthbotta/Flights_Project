package Flights.TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AppUtils.Utils;
import Flights.Library.LoginPage;

public class User_Login_Test_with_InValid_Data extends Utils{
	
	@Parameters({"id","pwd"})
	@Test
	public void testAdminLogin(String id, String pwd)
	{
		LoginPage lp = new LoginPage();
		lp.loginApp(id, pwd);
		boolean res = lp.isErrorMessageDisplayed();
		Assert.assertTrue(res);
		
	}

}
