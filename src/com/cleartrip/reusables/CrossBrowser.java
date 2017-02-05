package com.cleartrip.reusables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cleartrip.constants.Constants;

public class CrossBrowser {
      
	  static WebDriver driver;
	  
	  //Different browsers lunch methods
      @Parameters({"browser","url"})
      @BeforeTest
      public static WebDriver startBrowser(@Optional("chrome")String browser,String url)
      {
        //Open Chrome browser    	
        if(browser.equalsIgnoreCase("chrome")){
    		System.setProperty("webdriver.chrome.driver",Constants.chromDriver);
    		driver=new ChromeDriver();
       } 
        //Open firefox browser 
    	else if(browser.equalsIgnoreCase("firefox")){
  			System.setProperty("webdriver.gecko.driver",Constants.firefoxDriver);
  			driver=new FirefoxDriver();
   		}
    	
        //Open InternetExplorer browser
        else if(browser.equalsIgnoreCase("firefox")){        
      		System.setProperty("webdriver.internetExplore.driver",Constants.internetExplorerDriver);
      		driver=new InternetExplorerDriver();
       	}
        	  
    	driver.manage().window().maximize();
    	driver.get(url);
        return driver;    	
        }
      
        //Close the browser
      
    	@AfterTest
    	public static void closeBrowser()
    	{
    		driver.quit();
    	}
}
