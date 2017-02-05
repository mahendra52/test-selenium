package com.cleartrip.reusables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestBase {
	
	static WebDriver driver;
	
	public static WebElement getWebElement(String locator) throws Exception
	   {   
		   String locatorType=locator.split("_")[0];
		   String locatorValue=locator.split("_")[1];
		   
		   if(locatorType.toLowerCase().equals("id")){
	    	  return driver.findElement(By.id(locatorValue));}
		   
	       else if(locatorType.toLowerCase().equals("xpath")){
	    	   return driver.findElement(By.xpath(locatorValue));}
	      
	       else if(locatorType.toLowerCase().equals("class")||locatorType.toLowerCase().equals("className")){
	    	   return driver.findElement(By.className(locatorValue));}
	       
	       else if(locatorType.toLowerCase().equals("name")){
	    	   return driver.findElement(By.name(locatorValue));}
	       
	       else if(locatorType.toLowerCase().equals("linktext")){
	    	   return driver.findElement(By.linkText(locatorValue));}
	       
	       else if(locatorType.toLowerCase().equals("partial")){
	    	   return driver.findElement(By.partialLinkText(locatorValue));}
		   
	       else throw new Exception("Unknow locator type" +locator + ";");
	}
	
	
	
	}


