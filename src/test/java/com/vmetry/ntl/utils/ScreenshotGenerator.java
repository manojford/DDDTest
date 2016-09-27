package com.vmetry.ntl.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.vmetry.ntl.initializer.Initializer;

public class ScreenshotGenerator extends Initializer {
	
	
public static void generateScreenshot(ITestResult it) throws IOException{
	
	Object[] data = it.getParameters();
	if(it.isSuccess()){
		//String path = takeScreenshot(it.getName());
		String path = takeScreenshot(data[0].toString());
		log.addScreenCapture(path);
		log.log(LogStatus.PASS, "Test Case Pass", path);
	}
	else {
		String path = takeScreenshot(data[0].toString());
		log.addScreenCapture(path);
		log.log(LogStatus.FAIL, "Test Case fAIL", path);
	}
	reports.endTest(log);
	reports.flush();
}

public static String takeScreenshot(String path) throws IOException{
	File src = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
	File dest = new File("C:\\Selenium\\DDDTest1\\Screenshot\\"+path+".jpg");
	FileUtils.copyFile(src, dest);
	
	return dest.toString();
}

}
