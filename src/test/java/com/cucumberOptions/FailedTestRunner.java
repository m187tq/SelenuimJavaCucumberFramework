package com.cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/java/com/features/"},
		glue = {"com/stepDefinitions"},
		tags = "@LoginValidCredentials",
		//tags = "@RegistrationFunctionality",
		//tags = "@NegativeLogin",
		monochrome = true,
		//dryRun = false,
		//Strict = false,
		//name = "Login",
		plugin = {"pretty",
				"html:target/cucumber",
				"json:target/cucumber.json",
				"html:target/cucumber-reports/cucumber-pretty",
				"rerun:target/cucumber-reports/rerun.txt" })

public class FailedTestRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
}
