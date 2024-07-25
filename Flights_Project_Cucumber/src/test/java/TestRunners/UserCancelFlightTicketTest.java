package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions
(
	features = "FeatureFiles/CancelFlightTicket.feature",
	glue = "StepDefinitions",
	dryRun = false,
	plugin = {"pretty","html:Test Reports/UserCancelFlightTicketTestResult.html"}
	//tags = "@tag2"
)

public class UserCancelFlightTicketTest extends AbstractTestNGCucumberTests{

}
