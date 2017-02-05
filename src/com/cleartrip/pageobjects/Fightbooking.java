package com.cleartrip.pageobjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.cleartrip.reusables.projectReusables;

public class Fightbooking {
	
    WebDriver driver;
    Actions action;
    
	public Fightbooking(WebDriver driver) {
		this.driver=driver;
	}

	projectReusables reusables=new projectReusables(driver);
	
	//Locator for From station 
	@FindBy(how=How.ID,using="FromTag")
	WebElement fromStation;
	
	//Locator for To station
	@FindBy(how=How.ID,using="ToTag")
	WebElement toStation;
	
	//Locator for depart Data identification
	@FindBy(how=How.ID,using="DepartDate")
	WebElement departDate;
	
	//locator for month identifcaton
	@FindBy(how=How.CLASS_NAME,using="ui-datepicker-month")
	List<WebElement> departMonths;
	
	//locator for date identification
	@FindBy(how=How.XPATH,using="//*[@class='monthBlock first']/table/tbody/following::td")
	List<WebElement> departDay;
	
	//locator for adults identification
	@FindBy(how=How.ID,using="Adults")
	WebElement adultNo;
	
	//locator for childrens identification
	@FindBy(how=How.ID,using="Childrens")
	WebElement childrens;
	
	//Locator for more options
	@FindBy(how=How.XPATH,using="//*[@title='More search options']")
	WebElement moreOptions;
	
	//locator for selecting class of Service
	@FindBy(how=How.ID,using="Class")
	WebElement classOfTravel;
	
	//locator for submit button
	@FindBy(how=How.XPATH,using="//*[@id='SearchBtn']")
	WebElement submit;

   public void flightBooking(String sourceStation,String destinationStation)
   {
	   try{
		   Thread.sleep(3000);
		   action=new Actions(driver);   
	       fromStation.sendKeys(sourceStation);
	       Thread.sleep(3000);
	       action.sendKeys(Keys.ENTER).build().perform();
	       toStation.sendKeys(destinationStation);
	       Thread.sleep(3000);
	       action.sendKeys(Keys.ENTER).build().perform();
	       Thread.sleep(2000);
	       departDate.click();
       for(WebElement day:departDay)
	   {   
       if((day.getText()).equalsIgnoreCase("25"))
	   {day.click();
	   }
       }
       reusables.selectByIndex(adultNo, 2);
       reusables.selectByIndex(childrens, 1);
       moreOptions.click();
       reusables.selectByIndex(classOfTravel, 1);
       submit.click();
	   
	   
	   
   }
   catch(Exception e)
   {
	   System.out.println(e);
   }
}}




