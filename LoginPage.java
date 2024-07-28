package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.utilities.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageActions {
	
	

	
	
public LoginPage (WebDriver driver , ExtentTest logger) {
		
		super(driver,logger);
		PageFactory.initElements(driver, this);
		
		}
	
	//private String uid = "user_name";
	//By uid = By.name("user_name");
	
	
 @FindBy(name = "user_name")
 WebElement tb_uid ;
 
	
@FindBy(name = "user_password")
WebElement tb_password ;
		


@FindBy(xpath = "//select[@name='login_theme']")
WebElement dp_theme ;
	


@FindBy(name = "Login" )
WebElement btn_login ;


@FindBy(xpath = "//*[contains(text(),'You must specify a valid username and password')]")
WebElement err_msg ;


	
		
public void validate_error_message () 

{
	
	err_msg.isDisplayed();
	
}




		
	public void login(String userid , String pwd)
	
	{
		

		setInput(tb_uid,userid,userid+"has been enterted into user name field");

		setInput(tb_password,pwd,pwd+"has been enterted into password field");

		clickElement(btn_login, "login button clicked");
		
		
	}




	public void login(String userid , String pwd , String theme)
{


	setInput(tb_uid,userid,userid+"has been enterted into user name field");

	setInput(tb_password,pwd,pwd+"has been enterted into password field");

	selectVisibleText(dp_theme,theme,theme+"has been selected from theme dropdown");

	clickElement(btn_login, "login button clicked");






}
	
	
	

}
