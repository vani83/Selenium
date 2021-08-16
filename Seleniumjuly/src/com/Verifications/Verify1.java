package com.Verifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify1 {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.in");
	
	String actualtxt1 = driver.findElement(By.linkText("Customer Service")).getText();
	System.out.println("Actual Link :" +actualtxt1);
	
	/*
	 * String actualtxt2 =
	 * driver.findElement(By.linkText("Customer Service")).getAttribute("href");
	 * System.out.println("Actual Test :" + actualtxt2);
	 * 
	 * String actualtxt3 =
	 * driver.findElement(By.linkText("Customer Service")).getAttribute("innerHTML")
	 * ; System.out.println("Actual Test :" + actualtxt3);
	 */
	
	String expectedtxt1 = "Customer Service";
	System.out.println("Expected Test : " + expectedtxt1);
	
	
	 // if(actualtxt1.equals(expectedtxt1))
	  //if(actualtxt1.equalsIgnoreCase(expectedtxt1))
	  if(actualtxt1.contains(expectedtxt1))
		   System.out.println("Both link are equal..... ");
   else
	       System.out.println("Both link are notequal..... ");
	 
	

	}

}
