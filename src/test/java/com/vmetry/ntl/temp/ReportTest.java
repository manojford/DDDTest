package com.vmetry.ntl.temp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportTest {
public static WebDriver wd = null;
ExtentReports reports;
ExtentTest log;

@Test(priority=1)
public void googleTest(){
//wd = new FirefoxDriver();
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\WebDriverTesting\\Browser\\chromedriver.exe");
	WebDriver wd = new ChromeDriver();
reports = new ExtentReports("C:\\Selenium\\DDDTest1\\Report\\sample.html");
reports.startTest("googleTest");

wd.get("http://www.google.com");
}

@Test(priority=2)
public void yahooTest(){
	//wd = new FirefoxDriver();
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\WebDriverTesting\\Browser\\chromedriver.exe");
	WebDriver wd = new ChromeDriver();
	wd.get("http://www.yahoo.com");
	reports.startTest("yahooTest");
}

@Test(priority=3)
public void bingTest(){
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\WebDriverTesting\\Browser\\chromedriver.exe");
	WebDriver wd = new ChromeDriver();
	wd.get("http://www.bing.com");
	reports.startTest("bingtest");
}

@AfterMethod
public void tearDown(ITestResult it) throws IOException{
if(it.isSuccess()){
	String path = takeScreenshot(it.getName());
	log.addScreenCapture(path);
	log.log(LogStatus.PASS, "Test Case Pass", path);
}
else {
	String path = takeScreenshot(it.getName());
	log.addScreenCapture(path);
	log.log(LogStatus.FAIL, "Test Case fAIL", path);
}
reports.endTest(log);
reports.flush();
}

public static String takeScreenshot(String name) throws IOException{
	File src = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
	File dest = new File("C:\\Selenium\\DDDTest1\\Screenshot\\");
	FileUtils.copyFile(src, dest);
	
	return dest.toString();
}  
}