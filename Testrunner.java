package com.vtiger.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		
	features = "src/test/resources/features/" ,
	glue = "com.vtiger.stepdefinations" ,
	dryRun = false,
	plugin = {"pretty","html:target/cucumber-reports.html"} ,
	tags = "@Only"
	
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		)




public class Testrunner {

}
