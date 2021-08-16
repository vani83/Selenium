package com.Launching;

import com.relevantcodes.extentreports.LogStatus;

public class TC_006 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		
		  init();
		  
		  test = report.startTest("TC_006"); 
		  test.log(LogStatus.PASS, "Initiating the Property Files.....");
		  
		  launch("chromebrowser");
		  test.log(LogStatus.INFO,"Opened the ChromeDriver :- "+ p.getProperty("chromebrowser"));
		  
		  
		  navigate("amazonurl");
		  test.log(LogStatus.FAIL, "Navigated to app :-" + childProp.getProperty("amazonurl"));
		  
		  selectOption("amazondropdown_id","Books");
		  test.log(LogStatus.PASS, "Selected the option Books By using locator :-"+ orprop.getProperty("amazondropdown_id"));
		  
		  type("amazonsearchtext_name","Harry Potter");
		  test.log(LogStatus.PASS, "Entered the text HarryPotter By using locator :- "+ orprop.getProperty("amazonsearchtext_name"));
		  
		  clickElement("amazonsearchbutton_css"); 
		  test.log(LogStatus.PASS,"Clicked on Button By using locator :- "+ orprop.getProperty("amazonsearchbutton_css"));
		  
		  report.flush(); 
		  report.endTest(test);
		 

	}

}
