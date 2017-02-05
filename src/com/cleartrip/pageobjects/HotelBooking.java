package com.cleartrip.pageobjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler;

import com.cleartrip.reusables.projectReusables;

public class HotelBooking extends projectReusables{
	
	WebDriver driver;
	
	public HotelBooking(WebDriver driver) {
	    super(driver);
	    this.driver=driver;

	}
	
	public void dateSelect(List<WebElement> element,String date)
	{
		for(WebElement day:element)
		   {   
	       if((day.getText()).equalsIgnoreCase(date))
		   {
	    	   day.click();
		   }
	    }
	}
	
	public void reserveHotel()
	{
		try{
			WebElement hotels=projectReusables.webelementByXpath("//*[@id='Home']/div/aside[1]/nav/ul[1]/li[2]/a[1]");
			hotels.click();
			projectReusables.implicitWait(30);
			WebElement location=projectReusables.webelementByName("from");
			WebElement checkIn=projectReusables.webelementByXpath("//*[@id='CheckInDate']");
			List<WebElement> checkInDate=projectReusables.locatorsByXpath("//*[@class='monthBlock first']/table/tbody/following::td");
			WebElement checkOut=projectReusables.webelementById("CheckOutDate");
			List<WebElement> checkOutDate=projectReusables.locatorsByXpath("//*[@class='monthBlock first']/table/tbody/following::td");
			WebElement travellers=projectReusables.webelementById("travellersOnhome");
			WebElement search=projectReusables.webelementById("SearchHotelsButton");	
			location.click();
			location.sendKeys("Hyderabad");
			projectReusables.sleep(3000);
			Actions action=new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
			checkIn.click();
			dateSelect(checkInDate, "24");
			projectReusables.sleep(3000);
			dateSelect(checkOutDate, "26");
			projectReusables.selectByIndex(travellers, 2);
			search.click();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
