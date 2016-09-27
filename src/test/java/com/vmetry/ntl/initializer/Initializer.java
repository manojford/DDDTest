package com.vmetry.ntl.initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vmetry.ntl.utils.ReportOptimizer;

public class Initializer {

	public static FileInputStream envfis = null; 
	public static Properties envprop = null;
	public static WebDriver wd;
	
	public static FileInputStream locfis = null;
	public static Properties locprop = null;
	
	public static ExtentReports reports;
	public static ExtentTest log;

	public static boolean isArchive=true;
	
	
	@Test
	public static void initialize() throws IOException{
	
		
		
		//FileInputStream envfis = new FileInputStream(new File("C:"+File.separator+"Selenium"+File.separator+"DDDTest1"+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"com"+File.separator+"vmetry"+File.separator+"ntl"+File.separator+"config"+File.separator+"env.properties"));
		
		envfis = new FileInputStream(new File("C:"+File.separator+"Selenium"+File.separator+"DDDTest1"+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"com"+File.separator+"vmetry"+File.separator+"ntl"+File.separator+"config"+File.separator+"env.properties"));
		
//class loader function is used to search the file in any platform - replacement for file.separator
	
	//Properties envprop = new Properties();
		envprop = new Properties();
	envprop.load(envfis);
	System.out.println(envprop.getProperty("BROWSER"));
	
	//locator properties file settings
	
	locfis = new FileInputStream("C:"+File.separator+"Selenium"+File.separator+"DDDTest1"+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"com"+File.separator+"vmetry"+File.separator+"ntl"+File.separator+"config"+File.separator+"locator.properties");
	locprop = new Properties();
	locprop.load(locfis);
	
	
	
	reports = new ExtentReports("C:\\Selenium\\DDDTest1\\Report\\DDD.html");
	
	//if(wd==null) (This will not allow to open differnet browsers
	
	if(envprop.getProperty("BROWSER").equals("IE"))	{
		System.setProperty("webdriver.ie.driver", "C:\\Selenium\\WebDriverTesting\\Browser\\IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
		wd = new InternetExplorerDriver();
	} else if(envprop.getProperty("BROWSER").equals("CHROME")){
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manoj\\AppData\\Local\\Chromium\\Application\\chrome.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\WebDriverTesting\\Browser\\chromedriver.exe");
		wd = new ChromeDriver();
	} else if (envprop.getProperty("BROWSER").equals("FIREFOX")) {
		wd = new FirefoxDriver();
	}
	
	
	
	
	wd.manage().window().maximize();
	wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	
}
	
	public static WebElement getWebelementByXpath(String xpath){
		return wd.findElement(By.xpath(locprop.getProperty(xpath)));
	}
}
