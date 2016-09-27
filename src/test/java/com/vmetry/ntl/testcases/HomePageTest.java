package com.vmetry.ntl.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vmetry.ntl.initializer.Initializer;
import com.vmetry.ntl.pages.HomePage;
import com.vmetry.ntl.utils.ScreenshotGenerator;
import com.vmetry.ntltaxi.inputreader.inputReader;


public class HomePageTest extends Initializer{
	@BeforeMethod
	public void setUp() throws IOException{
		initialize();
	}
	
	@Test(dataProvider="HomePageTest")
	public void validDataHomePage(String testdata,String username,String mobileno,String pickadd,String dropadd, String basic) throws IOException{
		//initialize(); (each and every time, browser will open & close)
		wd.manage().window().maximize();
		wd.get(envprop.getProperty("URL"));
		
	//wd.findElement(By.xpath(locprop.getProperty("HOMEPAGE_USERNAME_TYPE_XPATH"))).sendKeys("Test UN");
	//XPath to be find for other webelements too
/*WebElement username = wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[2]"));

WebElement mobileno = wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[3]"));
WebElement pickup = wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[5]"));
WebElement drop = wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[6]"));
WebElement basic = wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/select"));
WebElement booklater = wd.findElement(By.xpath("html/body/section/div/div[2]/div/form/input[7]"));
*/		
		
		log = reports.startTest(testdata);
		
		HomePage.enterUserName(username);
		HomePage.enterMobileno(mobileno);
		HomePage.enterPickupAdd(pickadd);
		HomePage.enterDropAdd(dropadd);
		HomePage.enterBasic(basic);
		HomePage.clickBookLater();
	}
	
	@DataProvider(name="HomePageTest")
	public static Object[][] getHomePageData() throws Exception{
		
		Object[][] data = new Object[3][6];

		if(inputReader.RunModeVerification("HomePageTest")){
			Object[][] data1 = inputReader.selectSingleDataOrMulitiData("HomePageTest");
			return data1;
		}
		return null;
		
		/*		data[0][0] = "HomePageTest_Dataset1";
				data[0][1] = "Test A";
				data[0][2] = "97978955";
				data[0][3] = "Adyar";
				data[0][4] = "Medavakkam";
				data[0][5] = "Sedan";
				
				data[1][0] = "HomePageTest_Dataset2";
				data[1][1] = "Test B";
				data[1][2] = "97978956";
				data[1][3] = "Guindy";
				data[1][4] = "Tambaram";
				data[1][5] = "Sedan";
						
				data[2][0] = "HomePageTest_Dataset3";
				data[2][1] = "Test C";
				data[2][2] = "97978455";
				data[2][3] = "Saidapet";
				data[2][4] = "Madipakkam";
				data[2][5] = "Sedan";*/
		//return data;
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult it) throws IOException
	{
		ScreenshotGenerator.generateScreenshot(it);
	}
	
	}
