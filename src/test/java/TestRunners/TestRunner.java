package TestRunners;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
		features = { "src/test/resources/Features/HomePage.feature" },
		glue = { "StepDefinitions","ApplicationHooks" },
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				"rerun:target/failedscenarios.txt",
				}, 
		monochrome = true
		
)

public class TestRunner extends AbstractTestNGCucumberTests 
{
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() 
	{
		return super.scenarios();
	}
}


