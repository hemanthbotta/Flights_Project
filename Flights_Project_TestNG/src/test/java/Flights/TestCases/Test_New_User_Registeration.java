package Flights.TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AppUtils.Utils;
import Flights.Library.RegisterPage;

public class Test_New_User_Registeration extends Utils{
	
	@Parameters({"name","contact","mailid","pwd","dob"})
	@Test
	public void newUserRegisteration(String name, String contact, String mail, String pwd, String date) 
	{
		RegisterPage register = new RegisterPage();
		register.newRegister(name, contact, mail, pwd, date);
		
	}
	
}
