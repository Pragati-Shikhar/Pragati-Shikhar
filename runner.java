package TestRunner;

import cucumber.api.CucumberOptions;


import org.junit.runner.RunWith;	
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;		

@RunWith(Cucumber.class)				
@CucumberOptions(features="Features",glue={"StepDefinition"},tags ={"@MoneyControlAutomation"},dryRun = false


)

	



public class runner  {

	

}
