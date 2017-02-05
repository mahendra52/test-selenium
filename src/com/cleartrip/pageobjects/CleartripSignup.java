package com.cleartrip.pageobjects;

import java.io.IOException;

import net.sourceforge.htmlunit.corejs.javascript.ast.CatchClause;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.xalan.trace.PrintTraceListener;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.cleartrip.constants.Constants;
import com.cleartrip.reports.Extenetreports;
import com.cleartrip.reports.Log;
import com.cleartrip.reusables.projectReusables;
import com.cleartrip.utilities.Property;

public class CleartripSignup extends projectReusables{
	
	WebDriver driver;
   	Property property;
   	Extenetreports report;
	public Logger  log;
   	
    public CleartripSignup(WebDriver driver,Property property,Extenetreports report){
		super(driver);
		this.property=property;
		this.report=report;
	    log=Logger.getLogger(CleartripSignup.class);
		DOMConfigurator.configure("I:\\selinum\\POM\\src\\Log4j.xml");
	}
	
		
	public void createNewaccount() throws IOException, InterruptedException{		
	
	try{	
		
		//Get the locatores  from property file
		report.infoLogWithDescription("Get the all webelements");
		log.info("get the all webelemtns");
		String yourTripsId=property.getPropertyValue("cleartrip_your_trips_id");
		log.info("created logs");
		String registerClass=property.getPropertyValue("cleartrip_register_class");
		log.info("created register class");
		String promotionCheckboxID=property.getPropertyValue("cleartrip_promotion_checkbox_id");
		String userEmailId=property.getPropertyValue("cleartrip_useremail_id");
		String createAccountId=property.getPropertyValue("cleartrip_createaccount_id");
		String passwordId=property.getPropertyValue("cleartrip_password_id");
		String titleId=property.getPropertyValue("cleartrip_title_id");
		String firstNameNAME=property.getPropertyValue("cleartrip_firstName_name");
		String lastNameNAME=property.getPropertyValue("cleartrip_lastName_name");
		String mobileNumberName=property.getPropertyValue("cleartrip_mobile_number_name");
		String newsCheckboxXpath=property.getPropertyValue("cleartrip_promotion_xpath");
		String signupID=property.getPropertyValue("cleartrip_signup_id");
		
		//Set the implicit wait
		projectReusables.implicitWait(30);
 	   
		//click the yourTrip icon
		projectReusables.clickById(yourTripsId);
		report.infoLogWithDescription("click on new account button");
        log.info("Click the yourTrip Id");		
		//performing click option on Register icon for new account creation
		projectReusables.clickByClassname(registerClass);
		log.info("lick the class name");
		//switch to frame
		projectReusables.switchToFrameByID(3);
		log.info("switch the frame");
		//Uncheck the promotion checkbox in signup form
		projectReusables.clickById(promotionCheckboxID);
		
		//Enter useremail id in username box 
		projectReusables.enterTextById(userEmailId, "endra.panterrra@gmail.com");
		
	    //Click on create accountbutton
		projectReusables.clickById(createAccountId);
		
		projectReusables.sleep(3000);
		//Enter password in password field
		projectReusables.clickById(passwordId);
		projectReusables.enterTextById(passwordId, "9876543219");
		
		//select name title in title list
		WebElement title=projectReusables.webelementById(titleId);
        projectReusables.selectByText(title, "Mr");
        
        //Enter first name in first name field
        projectReusables.enterTextByName(firstNameNAME, "mahendra");
        
        //Enter lastname in last name field
        projectReusables.enterTextByName(lastNameNAME, "k");
        
		//Enter mobile number n mobile number field using CSS selector
        projectReusables.enterTextByName(mobileNumberName, "9999888877");
        
        //Click on submit button
        projectReusables.clickById(signupID);
        report.passLogWithName("signup form is created");
        
	}catch(Exception e)
	{
		System.out.println(e);
		log.error("getting exception",e);
        report.errorLogWithNameandDescription("Exception", "exception happend during script running");	
	}
	
	}}
