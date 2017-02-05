package com.cleartrip.reusables;

import java.io.File;
import java.sql.Driver;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class projectReusables {
                 
	 static WebDriver driver;	
	 static Select select;
	 static Actions action;
	 
	public projectReusables(WebDriver driver) {
		 
		 this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	 // Method used for opening URL 
	 public static void getURL(String url){
		 driver.get(url);
	 }

	//Method used for setting implicity wait
	 public static void implicitWait(int timeunits){
		 driver.manage().timeouts().implicitlyWait(timeunits, TimeUnit.SECONDS);
		 
	 }
	
	//method for set sleep
	 public static void sleep(int milliseconds) throws InterruptedException{
		 Thread.sleep(milliseconds);
	 }
	 
	 // Method for set  Explicit wait
	 
	 public static void exsplicitWait(int milliseconds,WebElement webelement){
		 WebDriverWait wait=new WebDriverWait(driver, milliseconds);
		 wait.until(ExpectedConditions.elementToBeSelected(webelement));
	 }
	 

	 //Method  for Screen shot
	public static String screenShot(String screenFilePath){
		 try{
		 File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File destFile=new File(screenFilePath);
		 FileUtils.copyFile(srcFile, destFile);
		 }
		 catch(Exception e)
		 {
			 System.out.println("Please enter proper file path" +e);
		 }
		 return screenFilePath;
	 }
	 public static void maxWindow()
     {
    	 driver.manage().window().maximize();
     }
    public static void deleteCookies()
    {
    	driver.manage().deleteAllCookies();
    }
    	
    public static WebElement webelementById(String id)
    {
    	 WebElement elementid=driver.findElement(By.id(id));
    	 return elementid;
    }
    
    public static WebElement webelementByClassName(String className)
    {
    	return driver.findElement(By.className(className));
    }
    
    public static WebElement webelementByName(String name)
    {
    	return driver.findElement(By.name(name));
    }
    
    public static WebElement webelementByXpath(String xPath)
    {
    	return driver.findElement(By.xpath(xPath));
    }
	public static void enterTextById(String id,String testdata)
	{
		driver.findElement(By.id(id)).clear();
		driver.findElement(By.id(id)).sendKeys(testdata);
	}
    
	public static void enterTextByClassname(String classname,String testdata) 
	{
	   driver.findElement(By.className(classname)).clear();
	   driver.findElement(By.className(classname)).sendKeys(testdata);
	}
    
	public static void enterTextByXpath(String xpath,String testdata)
	{
		driver.findElement(By.xpath(xpath)).clear();
		driver.findElement(By.xpath(xpath)).sendKeys(testdata);
		
	}
	public static void enterTextByName(String name,String testdata) 
	{
	   driver.findElement(By.name(name)).clear();
	   driver.findElement(By.name(name)).sendKeys(testdata);
	}
	public static void enterTextByTagname(String tagname,String testdata) 
	{
	   driver.findElement(By.tagName(tagname)).clear();
	   driver.findElement(By.tagName(tagname)).sendKeys(testdata);
	}
	public static void enterTextByCssSelector(String Cssname,String testdata) 
	{
		
	   driver.findElement(By.cssSelector(Cssname)).clear();
	   driver.findElement(By.cssSelector(Cssname)).sendKeys(testdata);
	}
	
	
	public static void clickById(String id)
	{
		driver.findElement(By.id(id)).click();
	}
    
	public static void clickByClassname(String classname) 
	{
	   
	   driver.findElement(By.className(classname)).click();
	}
    
	public static void clickByXpath(String xpath)
	{
		driver.findElement(By.xpath(xpath)).click();
		
	}
	public static void clickByname(String name) 
	{
	   
	   driver.findElement(By.name(name)).click();
	}
	public static void clickByTagname(String tagname) 
	{
	   
	   driver.findElement(By.tagName(tagname)).click();
	}
	
	public static void mouseHover(WebElement element)
	{
		action=new Actions(driver);
		action.moveToElement(element).build().perform();
		
	}
	public static void mouseHoverById(String id)
	{
		action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id(id))).build().perform();
	}
	public static void mouseHoverByClassname(String classname)
	{
		action=new Actions(driver);
		action.moveToElement(driver.findElement(By.className(classname))).build().perform();
	}
	public static void mouseHoverByXpath(String xpath)
	{
		action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(xpath))).build().perform();
	}
	
    public static void selectByvalue(WebElement element,String value)
    {
    	select=new Select(element);
    	select.selectByValue(value);
    	
    }
    
    public static void selectByIndex(WebElement element,int index)
    {
    	select=new Select(element);
    	select.selectByIndex(index);
    }
    
    public static void selectByText(WebElement element,String text)
    {
    	select=new Select(element);
    	select.selectByVisibleText(text);
    }
    
    public static boolean enableverify(WebElement element)
    {
    	if(element.isEnabled())
    	{
    		return true;
    	}
    	else{
    		return false;
    }}
    
    public static boolean selectverify(WebElement element)
    {
    	if(element.isSelected())
    	{
    		return true;
    	}
    	else{
    		return false;
     }}    
    
    public static List<WebElement> tagNames(String tagName)
    {
    	List<WebElement> tages=driver.findElements(By.tagName(tagName));
    	return tages;
    }
    
    public static List<WebElement> locatorsByXpath(String xpathExspersion)
    {
    	List<WebElement> webElements=driver.findElements(By.xpath(xpathExspersion));
    	return webElements;
    }
    
    public static Set<String> getwindows()
    {
        Set<String> windows=driver.getWindowHandles();
        return windows;
    }   
    
    public static String getCurrentWindowName()
    {
    	String window=driver.getWindowHandle();
    	return window;
    }
    
    public static void switchToFrameByID(int id)
    {
    	driver.switchTo().frame(id);
    }
    
    public static void switchToFrameByWebelement(WebElement element)
    {
    	driver.switchTo().frame(element);
    }
    
    public static void switchToFrameByString(String frameName)
    {
    	driver.switchTo().frame(frameName);
    }
    
    public static void defaultFrame()
    {
    	driver.switchTo().defaultContent();
    	
    }
    public static void switchToWindow(String windowName)
    
    {
    	driver.switchTo().window(windowName);
    }
    
    public static void rightClickOperation(WebElement element)
    {
    	action=new Actions(driver);
    	action.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
    }
    
    public static void dragAndDrobByWebElement(WebElement srcElement,WebElement destElement)
    {
    	action=new Actions(driver);
    	action.dragAndDrop(srcElement, destElement);
    }
    
    public static void dragAndDropByOffset(WebElement element,int xOffset,int yOffset)
    {
    	action=new Actions(driver);
    	action.dragAndDropBy(element, xOffset, yOffset);
    }
    
    public static void closerBrowser()
    {
    	driver.close();
    }
    
    public static  void quitBrowser() 
    {
    	driver.quit();
		
	}
}