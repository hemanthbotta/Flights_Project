package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions
(
	features = "FeatureFiles/UserBooksFlight.feature",
	glue = "StepDefinitions",
	dryRun = false,
	plugin = {"pretty","html:Test Reports/UserBookFlightTestResult.html"}
	//tags = "@tag2"
)


public class UserBookingFlightTicketTest extends AbstractTestNGCucumberTests{

}
