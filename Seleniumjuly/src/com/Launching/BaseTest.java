package com.Launching;



import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

    public class BaseTest 
{
	public static WebDriver driver;
	public static String projectPath = System.getProperty("user.dir");
	public static Properties p;
	public static FileInputStream fis;
	public static Properties mainProp;
	public static Properties childProp;
	public static Properties orprop;
	public static  ExtentReports report;
	public static ExtentTest test;
	
	
	public static void init() throws Exception
	{
	    fis = new FileInputStream(projectPath+"/data.properties");
		p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectPath+"/environment.properties");
		mainProp = new Properties();
		mainProp.load(fis);
		String e = mainProp.getProperty("env");
		
		System.out.println(e);
		
		fis = new FileInputStream(projectPath+"/"+e+".properties");
		childProp = new Properties();
		childProp.load(fis);
		String url = childProp.getProperty("amazonurl");
       System.out.println(url);
       
       fis = new FileInputStream(projectPath+"//or.properties");
       orprop = new Properties();
       orprop.load(fis);
       
       
       fis = new FileInputStream(projectPath+"//log4jconfig.properties");
       PropertyConfigurator.configure(fis);
       
      report = ExtentManager.getInstance();
		
	}
	
    public static void  launch(String browser)
   {
    	if(p.getProperty(browser).equals("chrome"))
    	{
    		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
    		//System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe" );
    		
    		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "logs//chromelog.log");
    		
    		ChromeOptions option = new ChromeOptions();
    		option.addArguments("user-data-dir=C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 4");
    		option.addArguments("--disable-notifications");
    		option.addArguments("--start-maximized");
    		option.addArguments("--ignore-certificate-errors");
    		//option.addArguments("--proxy-server=http://192.168.10.1:9090");
    				
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver(option);
    		
			/*
			 * //System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,
			 * "logs//chromelog.log"); ChromeOptions option = new ChromeOptions(); //
			 * option.
			 * addArguments("user-data-dir=C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 3\\Default\"3"
			 * ); option.addArguments("--disable-notifications");
			 * option.addArguments("--start-maximized");
			 * option.addArguments("--ignore-certificate-errors");
			 * //option.addArguments("--proxy-server=http://192.168.10.1:9090");
			 */			     	
    		
		}
    	
    	else if (p.getProperty(browser).equals("firefox")) 
    		
    	{
    	
    		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
    		// System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
   
    		 		
    		WebDriverManager.firefoxdriver().setup();
    		
		    ProfilesIni p = new ProfilesIni(); 
			FirefoxProfile profile = p.getProfile("julyffprofile");
			  
			  
	        FirefoxOptions option = new FirefoxOptions(); 
			option.setProfile(profile);
			
			//Binaries
			//option.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			
			//Logs
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "logs\\firefoxlogs.log");
			
			//Notifications
			profile.setPreference("dom.webnotifications.enabled", false);
			
			//Certificaton errors
			 profile.setAcceptUntrustedCertificates(true);
		     profile.setAssumeUntrustedCertificateIssuer(false);
			
			//Work with proxy setting
		    // profile.setPreference("network.proxy.type", 1);
		    // profile.setPreference("network.proxy.socks", "192.156.10.1");
			//profile.setPreference("network.proxy.socks_port;0", 1765);
			
			
		    driver = new FirefoxDriver(option);
		    
    	    
    	}
   }

  public static void navigate(String url) 
  {
	  //driver.get(childProp.getProperty(url));
	  driver.navigate().to(childProp.getProperty(url));
	
	  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  
}


  public static void clickElement(String locatorkey)
  {
	
	//driver.findElement(By.cssSelector(orprop.getProperty(locatorkey))).click();
	  getElement(locatorkey).click();;
	
	}


public static void type(String locatorkey, String text) 
  {
	
	//driver.findElement(By.name(orprop.getProperty(locatorkey))).sendKeys(text);
	  getElement(locatorkey).sendKeys(text);;
	}


  public static void selectOption(String locatorkey, String option)
  {
		//driver.findElement(By.id(orprop.getProperty(locatorkey))).sendKeys(option);
		getElement(locatorkey).sendKeys(option);
	}

  public static WebElement getElement(String locatorkey)
  {
	  //check for Present of Element
	   if (!isElementPresent(locatorkey))
	   {
		//report failure
		  System.out.println("Elements is not  present :" + locatorkey);
	}
	  
	 //check for the visibility of Element
	   else if(!isElementVisible(locatorkey)) {
		//report failure
		  System.out.println("Elements is not visible :" + locatorkey);
	  }

	WebElement element = null;
	element = driver.findElement(getLocator(locatorkey));
	
	/*
	 * if(locatorkey.endsWith("_id")) { element =
	 * driver.findElement(By.id(orprop.getProperty(locatorkey))); }else if
	 * (locatorkey.endsWith("_name")) { element =
	 * driver.findElement(By.name(orprop.getProperty(locatorkey))); }else if
	 * (locatorkey.endsWith("_classname")) { element =
	 * driver.findElement(By.className(orprop.getProperty(locatorkey))); }else if
	 * (locatorkey.endsWith("_css")) { element =
	 * driver.findElement(By.cssSelector(orprop.getProperty(locatorkey))); }else if
	 * (locatorkey.endsWith("_xpath")) { element =
	 * driver.findElement(By.xpath(orprop.getProperty(locatorkey))); }else if
	 * (locatorkey.endsWith("_linktext")) { element =
	 * driver.findElement(By.linkText(orprop.getProperty(locatorkey))); }else if
	 * (locatorkey.endsWith("_partiallinktext")) { element =
	 * driver.findElement(By.partialLinkText(orprop.getProperty(locatorkey))); }
	 */
	return element;
		
	
}

	//true - visible
     //false - not-visible
        public static boolean isElementVisible(String locatorkey) {
        	System.out.println("checking the visibility : " + locatorkey); 
        	 
			WebDriverWait wait = new WebDriverWait(driver, 10);
			
			try 
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorkey)));
				
				/*
				 * if(locatorkey.endsWith("_id")) {
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(orprop.
				 * getProperty(locatorkey)))); }else if(locatorkey.endsWith("_name")) {
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(orprop.
				 * getProperty(locatorkey)))); }else if(locatorkey.endsWith("_classname")) {
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(orprop.
				 * getProperty(locatorkey)))); }else if(locatorkey.endsWith("_xpath")) {
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(orprop.
				 * getProperty(locatorkey)))); }else if(locatorkey.endsWith("_css")) {
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				 * orprop.getProperty(locatorkey)))); }else if(locatorkey.endsWith("_linktext"))
				 * {
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(orprop.
				 * getProperty(locatorkey)))); }else if(locatorkey.endsWith("_partiallinktext"))
				 * {
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(
				 * orprop.getProperty(locatorkey)))); }
				 */
		} 
    	catch (Exception e) 
    	{
			return true;
		} 
		
    return false;
    }
        	

      
      //true - present
        //false - not-present
        
         static boolean isElementPresent(String locatorkey) {
        	 
        
				System.out.println("checking present : " + locatorkey);
				
				WebDriverWait wait = new WebDriverWait(driver, 30);
				
				try 
				{
					wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorkey)));
					/*
					 * if(locatorkey.endsWith("_id")) {
					 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orprop.
					 * getProperty(locatorkey)))); }else if(locatorkey.endsWith("_name")) {
					 * wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orprop.
					 * getProperty(locatorkey)))); }else if(locatorkey.endsWith("_classname")) {
					 * wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orprop.
					 * getProperty(locatorkey)))); }else if(locatorkey.endsWith("_xpath")) {
					 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orprop.
					 * getProperty(locatorkey)))); }else if(locatorkey.endsWith("_css")) {
					 * wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orprop.
					 * getProperty(locatorkey)))); }else if(locatorkey.endsWith("_linktext")) {
					 * wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orprop.
					 * getProperty(locatorkey)))); }else if(locatorkey.endsWith("_partiallinktext"))
					 * { wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(
					 * orprop.getProperty(locatorkey)))); }
					 */
			} 
        	catch (Exception e) {
				return true;
		  } 
			 return false;
          }
         
         
    public static By getLocator(String locatorKey)
    { 
    	By by = null;
    	
    	if(locatorKey.endsWith("_id")) {
    	by = By.id(orprop.getProperty(locatorKey));
    	} else if(locatorKey.endsWith("_name")) {
        by = By.name(orprop.getProperty(locatorKey));
        } else if(locatorKey.endsWith("_classname")) {
         by = By.className(orprop.getProperty(locatorKey));
       } else if(locatorKey.endsWith("_xpath")) {
         by = By.xpath(orprop.getProperty(locatorKey));
       } else if(locatorKey.endsWith("_css")) {
         by = By.cssSelector(orprop.getProperty(locatorKey));
       } else if(locatorKey.endsWith("_linktext")) {
         by = By.linkText(orprop.getProperty(locatorKey));
       } else if(locatorKey.endsWith("_partiallinktext")) {
          by = By.partialLinkText(orprop.getProperty(locatorKey));
        } 
    	
    	return by;
	}
    
    //************** Verifications ************************
    public static boolean isLinkEqual(String expectedtxt1)
    {	
		String actualtxt1 = driver.findElement(By.linkText("Customer Service")).getText();
		if(actualtxt1.equals(expectedtxt1))
		return true;
	
		else
			return false;
    }
    
    //*************** Reporting **********************************************
    public static void  testPass(String passMessage)
    {
		test.log(LogStatus.PASS,passMessage);
	}

	public static void testFail(String failMessage) throws Exception 
	{
		test.log(LogStatus.FAIL, failMessage);
		TakesScreenshot();
	}

	public static void TakesScreenshot() throws Exception
	{
		Date dt=new Date();
		String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".png";		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile, new File(projectPath+"\\failurescreenshots\\"+dateFormat));
		
		test.log(LogStatus.INFO, "Screenshot --->" +test.addScreenCapture(projectPath+"\\failurescreenshots\\"+dateFormat));
		
	}

    
    
    
}


