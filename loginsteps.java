package com.vtiger.stepdefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginsteps extends basesteps 


{
	@Before
	public void getSenarioName(Scenario Scenario)

	{ if(extent==null) {

		createExtentReport();

	}
                 ScenarioName = Scenario.getName();
		logger= extent.createTest(ScenarioName);

	}

	@After
	public void tierdown()

	{
		extent.flush();
		driver.quit();

	}
	
	
	@Given("User should be on login page")
	public void user_should_be_on_login_page() throws Exception {
		
		LaunchApp();

		logger.info("Application Launched");

		
		lp = new LoginPage(driver , logger);
		
		hp = new HomePage(driver,logger);
		
		Ldp = new LeadPage(driver,logger);
				
	    
	}
	@When("User enter the valid credentials")
	public void user_enter_the_valid_credentials() {
		
		lp.login(dt.get(ScenarioName).get("Userid"), dt.get(ScenarioName).get("Password"));
		
	    
	}
	@Then("User shoud be navigated to home page")
	public void user_shoud_be_navigated_to_home_page() {
		
		hp.validate_home();
	    
	}
	@Then("User can see the logout link")
	public void user_can_see_the_logout_link() {
		
		hp.validate_logout();
	   
	}
	
	@When("User enter the Invalid credentials")
	public void user_enter_the_Invalid_credentials() {
		lp.login(dt.get(ScenarioName).get("Userid"), dt.get(ScenarioName).get("Password"));
	    
	}
	@Then("User can see error message")
	public void user_can_see_error_message() {
		
		lp.validate_error_message();
	    
	}
	
	@When("User enter the Invalid userid as {string} and password as {string}")
	public void user_enter_the_invalid_userid_as_and_password_as(String uid, String pwd) {
		
		
		lp.login(uid, pwd);
		
		
	   
	}

	}

	    
	
	
	




	


