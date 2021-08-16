package com.ScreenShortselfies;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SS_3 
{
	
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bbc.com");
		 
		driver.findElement(By.linkText("Sport"));
		
		List<WebElement> links1 = driver.findElements(By.tagName("a"));
	     System.out.println(links1.size());
		
		
		List<WebElement> links2 = driver.findElements(By.xpath("//div[@id='orb-nav-links']/ul/li"));
        System.out.println(links2.size());
		
	}

}
