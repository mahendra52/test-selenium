package com.cleartrip.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.cleartrip.pageobjects.Fightbooking;
import com.cleartrip.reusables.CrossBrowser;

public class FightbookingTestCase {

	@Test
	public void initiateBooking()
	{
		WebDriver driver=CrossBrowser.startBrowser("chrome", "https://www.cleartrip.com");
		Fightbooking fight=PageFactory.initElements(driver, Fightbooking.class);
		fight.flightBooking("Hyderabad", "Bangalore");
	}
	
}
