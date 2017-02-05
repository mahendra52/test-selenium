package com.cleartrip.reports;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {

	public static Logger log=Logger.getLogger(Log.class);
    public static void infoLog(String text){
    	DOMConfigurator.configure("I:\\selinum\\POM\\src\\Log4j.xml");
    	log.info(text);
	}
    
}
