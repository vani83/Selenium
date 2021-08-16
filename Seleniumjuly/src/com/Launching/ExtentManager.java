package com.Launching;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager extends BaseTest
{
	public static ExtentReports report;
	
	public static ExtentReports getInstance()
	{
		if(report==null) 
		{
			report = new ExtentReports(projectPath+"//HtmlReports//htmlreports.html");
			report.loadConfig(new File(projectPath+"//extendReportconfig.xml"));
			report.addSystemInfo("Languaging Binging", "3.141.59").addSystemInfo("Instance Environment", mainProp.getProperty("env"));
			
		}
		
		return report;
		
	}
	
	
	
		
		
	

}
