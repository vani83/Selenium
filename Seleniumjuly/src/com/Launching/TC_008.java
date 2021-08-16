package com.Launching;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TC_008
{
	//ExtentHtmlReporter
	
   static ExtentHtmlReporter htmlReporter;
    //ExtentReports
	static ExtentReports report;
    
	//ExtentTest
    static ExtentTest test;
	 

	public static void main(String[] args)
	{
		
	    htmlReporter = new ExtentHtmlReporter("C://Users//user//eclipse-workspace//Seleniumjuly//HtmlReports//index.html");
		htmlReporter.config().setDocumentTitle("Automation Repord");
		htmlReporter.config().setReportName("Functional Testing Repot");
		htmlReporter.config().setTheme(Theme.STANDARD);
	 
		
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS","Windows10");
		report.setSystemInfo("Tester Name","Vani");
		report.setSystemInfo("Browser","chrome");
		 
		test = report.createTest("TC_008");
		
		test.log(Status.PASS, "step1");
		test.log(Status.FAIL, "step2");
		test.log(Status.PASS, "step3");
		test.log(Status.ERROR, "step4");
		test.log(Status.PASS, "step5");
		test.log(Status.INFO, "step6");
		
		report.flush();

		
		
		
	}
	
	

}
