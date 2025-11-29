package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "./Cucumber/Senarios",glue = "stepDefination",
plugin = "html:./CucumberReport/report1.html",
tags="@positive",dryRun = false)

public class RunCucumbercode extends AbstractTestNGCucumberTests{
	
}