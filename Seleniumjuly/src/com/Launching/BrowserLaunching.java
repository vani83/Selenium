package com.Launching;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunching 
{

	public static void main(String[] args) 
		{
		
		WebDriver driver;
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe" );
	    driver = new ChromeDriver();
	    driver.get("http://www.amazon.in");
	
	
	
	    System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    driver.get("http://www.bestbuy.com");
	
	 }

}
