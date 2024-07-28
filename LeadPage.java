package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.utilities.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage extends PageActions {
	

	
	
public LeadPage (WebDriver driver, ExtentTest logger) {
		
		super(driver,logger);
		PageFactory.initElements(driver, this);
		
		}
	
	//private String uid = "user_name";
	//By uid = By.name("user_name");
	
	

@FindBy(linkText = "New Lead")
WebElement lnk_NewLead ;

	
@FindBy(name = "lastname")
WebElement lnk_lastname ;

@FindBy(name = "company")
WebElement tb_company ;

@FindBy(name = "button123")
WebElement tb_save ;


public void clickNewlead () 

{

	clickElement(lnk_NewLead,"Linked new lead clicked");

	
}



public void createlead (String lname , String comp) 

{
	


	setInput(lnk_lastname,lname,lname+"has been enterted into last name field");
	setInput(tb_company,comp,comp+"has been enterted into company field");
	clickElement(tb_save, "saved button clicked");
	
}
	
	
	
	
	
	
	
	
	

}
