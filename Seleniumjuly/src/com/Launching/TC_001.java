package com.Launching;

import java.util.concurrent.TimeUnit;

public class TC_001 extends BaseTest
{

	public static void main(String[] args) throws Exception
	{
		init();
		
		  //launch("chrome"); 
		  launch("chromebrowser");
		  
		  driver.manage().timeouts().pageLoadTimeout(30 ,TimeUnit.SECONDS);
		  
		 // navigate("https://www.amazon.in"); 
		  navigate("amazonurl");
		
		 driver.manage().window().maximize();
		  
		  String title = driver.getTitle(); System.out.println(title);
		  
		  String url = driver.getCurrentUrl(); System.out.println(url);
		  
		  driver.manage().deleteAllCookies();
		  
		  driver.navigate().back();
		  
		  Thread.sleep(5000);
		  
		  driver.navigate().forward();
		  
		  Thread.sleep(5000);
		  
		  driver.navigate().refresh();
		  
		 // driver.close();
		  
		  driver.quit();
	
		}



}
