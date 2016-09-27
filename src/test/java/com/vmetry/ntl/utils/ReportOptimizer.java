package com.vmetry.ntl.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import com.vmetry.ntl.initializer.Initializer;

public class ReportOptimizer extends Initializer {
	

public static void archiveFiles() throws IOException{
	
	
	if(isArchive){
	SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD HH-MM-SS-mm");
	String path =df.format(new Date());
	System.out.println(path);
	File src = new File("C:\\Selenium\\DDDTest1\\Screenshot\\");
	File dest = new File("C:\\Selenium\\DDDTest1\\Archive\\"+path);
	

	FileUtils.copyDirectory(src, dest);
	FileUtils.cleanDirectory(src);
isArchive=false;
	}

	
}
}
