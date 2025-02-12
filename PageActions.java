package com.vtiger.utilities;

import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class PageActions {

    public WebDriver driver;
    private WebDriverWait wait;

    private ExtentTest logger;

    public PageActions(WebDriver driver , ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));

    }

    public void setInput(WebElement elm, String val ,String msg) {

        try {

            wait.until(ExpectedConditions.visibilityOf(elm));

            elm.clear();

            elm.sendKeys(val);
            logger.pass(msg);

        } catch (Exception e) {
            System.out.println(e.getMessage());
           logger.fail("unable to enter text into textbox due to error "+ e.getMessage()+"  "+"<a href ='"+getScreenshot()+"'><span class='label start-time'>Screenshot</span></a>");

        }
    }

    public void setInput(String str, String val,String msg)
    {
        try
        {
            WebElement elm = driver.findElement(By.xpath(str));
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(val);
            logger.pass(msg);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable to enter text into Textbox due to error "+e.getMessage()+"  "+"<a href ='"+getScreenshot()+"'><span class='label start-time'>Screenshot</span></a>");
        }
    }

    public void setInput(By elmtxt, String val, String msg)
    {
        try
        {
            WebElement elm = driver.findElement(elmtxt);
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(val);
            logger.pass(msg);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable to enter text into Textbox due to error "+e.getMessage()+"  "+"<a href ='"+getScreenshot()+"'><span class='label start-time'>Screenshot</span></a>");
        }
    }

    public void selectVisibleText(WebElement elm, String val,String msg)
        {

            try {

                wait.until(ExpectedConditions.visibilityOf(elm));
                Select sel = new Select(elm);
                sel.selectByVisibleText(val);
                logger.pass(msg);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                logger.fail("unable to enter text into textbox due to error "+ e.getMessage()+"  "+"<a href ='"+getScreenshot()+"'><span class='label start-time'>Screenshot</span></a>");

            }


        }

        public void clickElement(WebElement elm,String msg)
        {

            try {

                wait.until(ExpectedConditions.elementToBeClickable(elm));
                elm.click();
                logger.pass(msg);


            } catch (Exception e) {
                System.out.println(e.getMessage());
                logger.fail("unable to enter text into textbox due to error "+ e.getMessage()+"  "+"<a href ='"+getScreenshot()+"'><span class='label start-time'>Screenshot</span></a>");

            }


        }


        public void elementExits(WebElement elm,String msg)
        {

            try {

                wait.until(ExpectedConditions.visibilityOf(elm));
                elm.isDisplayed();
                logger.pass(msg);


            } catch (Exception e) {
                System.out.println(e.getMessage());
                logger.fail("unable to find the element due to error "+ e.getMessage()+"  "+"<a href ='"+getScreenshot()+"'><span class='label start-time'>Screenshot</span></a>");

            }


        }

    public String getScreenshot()
    {
        Date d = new Date();
        DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
        String fileName = ft.format(d);
        String path = System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/screenshot/"+fileName+".png";
        TakesScreenshot ts = ((TakesScreenshot)driver);
        File SrcFile=ts.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(path);
        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return path;
    }


    }


