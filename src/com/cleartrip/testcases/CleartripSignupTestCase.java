package com.cleartrip.testcases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cleartrip.constants.Constants;
import com.cleartrip.pageobjects.CleartripSignup;
import com.cleartrip.reports.Extenetreports;
import com.cleartrip.reusables.CrossBrowser;
import com.cleartrip.utilities.Property;

public class CleartripSignupTestCase {
    
	WebDriver driver;
	Property property;
	Extenetreports report;
	
	@BeforeTest
	public void  beforeSignUp(){
	driver=CrossBrowser.startBrowser("chrome","https://www.cleartrip.com");
	property=new Property(Constants.cleartripSignupProperty);
	report=new Extenetreports(Constants.extentReportForSignUP, "Creating signup for cleartrip",true);
	}
	
	@Test
	public void signup() throws IOException, InterruptedException{
	//CleartripSignup signup=PageFactory.initElements(driver, CleartripSignup.class);
	CleartripSignup signUp=new CleartripSignup(driver,property,report);
	signUp.createNewaccount();

}
}     