package com.cleartrip.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {
	Properties property;
	String propertyFilePath;
	
	public Property(String propertyFilePath) {
		this.propertyFilePath=propertyFilePath;
		property=new Properties();
		
	}
	
	public String getPropertyValue(String key) throws IOException
	{
	  FileInputStream  inputStream=new FileInputStream(new File(propertyFilePath));
	  property.load(inputStream);
	  String propertyValue=property.getProperty(key);
	  return propertyValue;
	}
	
    public void setPropertyValue(String key,String value) throws IOException
    {
    	FileInputStream inStream=new FileInputStream(new File(propertyFilePath));
    	property.load(inStream);
    	property.setProperty(key, value);
    	property.store(new FileOutputStream(new File(propertyFilePath)),null);
    	
    }
    
    public void removePropertyValue(String key) throws IOException
    {
    	FileInputStream inStream=new FileInputStream(propertyFilePath);
    	property.load(inStream);
    	property.remove(key);
    	property.store(new FileOutputStream(new File(propertyFilePath)),null);
    }

}
