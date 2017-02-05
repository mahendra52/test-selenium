package com.cleartrip.reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extenetreports {
        ExtentReports extent;
        ExtentTest logger;
        
        public Extenetreports(String testReportPath,String testReportDescription,boolean reportCreationType)
        {
        	extent=new ExtentReports(testReportPath,reportCreationType);
        	logger=extent.startTest(testReportDescription);
        }
        public Extenetreports(String testReportPath,String testReportName,String testReportDescription,boolean reportCreation)
        {
        	extent=new ExtentReports(testReportPath,reportCreation);
        	logger=extent.startTest(testReportName, testReportDescription);
        }
        
        public void infoLogWithDescription(String infoDescription)
        {
        	logger.log(LogStatus.INFO, infoDescription);
        }
        
        public void infoLogWithNameandDescription(String infoName,String infoDescription)
        {
        	logger.log(LogStatus.INFO, infoName, infoDescription);
        }
        
        public void errorLogWithName(String errorDescription)
        {
        	logger.log(LogStatus.ERROR, errorDescription);
        	
        }

        public void errorLogWithNameandDescription(String errorName,String errorDescription)
        {
        	logger.log(LogStatus.ERROR, errorName, errorDescription);
        }
        public void warningLogWithName(String warningDescription)
        {
        	logger.log(LogStatus.WARNING, warningDescription);
        	
        }

        public void warningLogWithNameandDescription(String warningName,String warningDescription)
        {
        	logger.log(LogStatus.WARNING, warningName, warningDescription);
        }
        public void passLogWithName(String passCaseDescription)
        {
        	logger.log(LogStatus.PASS, passCaseDescription);
        	
        }

        public void passLogWithNameandDescription(String passCaseName,String passCaseDescription)
        {
        	logger.log(LogStatus.PASS, passCaseName, passCaseDescription);
        }

        public void failureLogWithName(String failCaseDescription)
        {
        	logger.log(LogStatus.FAIL, failCaseDescription);
        	
        }

        public void FailureLogWithNameandDescription(String failCaseName,String failCaseDescription)
        {
        	logger.log(LogStatus.PASS, failCaseName, failCaseDescription);
        }

        public void attchScreeToReports(String screenFilePath,String logDescription)
        {
        	logger.log(LogStatus.INFO,logDescription);
        	logger.addScreenCapture(screenFilePath);
        }

        public void closeBroser()
        {
        	extent.endTest(logger);
        	extent.flush();
        }
}

