package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.utilities.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageActions {

		
		
	public HomePage(WebDriver driver, ExtentTest logger) {
			
			super(driver,logger);
			PageFactory.initElements(driver, this);
			
			}
		
		//private String uid = "user_name";
		//By uid = By.name("user_name");
		
		
	 @FindBy(linkText = "Logout")
	 WebElement lnk_logout ;
	 
		
	@FindBy(linkText = "Home")
	WebElement lnk_home ;
	
	
	public void click_logout () 

	{
		

		clickElement(lnk_logout,"Linked logout clicked");
		
	}
	
	
	public void validate_logout () 

	{

		elementExits(lnk_logout,"Linked logout is displayed");
		
	}

	
	public void validate_home () 

	{


		elementExits(lnk_home,"Linked home is displayed");
		
	}
	
	
	
	
	
	
	

}
