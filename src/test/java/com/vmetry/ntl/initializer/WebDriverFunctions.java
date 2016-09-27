package com.vmetry.ntl.initializer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverFunctions extends Initializer {
public static void selectDropdownByVisibleText(String xpath,String basic){
	Select s = new Select(getWebelementByXpath(xpath));
	s.selectByVisibleText(basic);
	
	
}

}
