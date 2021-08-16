package com.Launching;

import org.apache.log4j.Logger;

public class TC_007 extends BaseTest
{
	private static final Logger log = Logger.getLogger(TC_007.class);

	public static void main(String[] args) throws Exception 
	{
		init();
		log.info("Initiating the Property Files.....");
		
		 launch("chromebrowser");
		 log.info("Opened the ChromeDriver :- "+ p.getProperty("chromebrowser"));
		 		
		 navigate("amazonurl");
		 log.info("Navigated to app :-" + childProp.getProperty("amazonurl"));
		 
		
		 selectOption("amazondropdown_id","Books");
		 log.info("Selected the option Books By using locator :-"+ orprop.getProperty("amazondropdown_id"));
		 
		  type("amazonsearchtext_name","Harry Potter");
		  log.info("Entered the text HarryPotter By using locator :- "+  orprop.getProperty("amazonsearchtext_name"));
		  
		 clickElement("amazonsearchbutton_css");
		 log.info("Clicked on Button By using locator :- "+ orprop.getProperty("amazonsearchbutton_css"));
		 

	}

}
