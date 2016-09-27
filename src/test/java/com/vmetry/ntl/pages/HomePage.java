package com.vmetry.ntl.pages;

import com.vmetry.ntl.initializer.Initializer;
import com.vmetry.ntl.initializer.WebDriverFunctions;

public class HomePage extends Initializer{
public static void enterUserName(String username){
	
	//getWebelementByXpath("")
	getWebelementByXpath("HOMEPAGE_USERNAME_TYPE_XPATH").sendKeys(username);;
	System.out.println(username);
}

public static void enterMobileno(String mobileno){
	System.out.println(mobileno);
	getWebelementByXpath("HOMEPAGE_MOBILENO_TYPE_XPATH").sendKeys(mobileno);;
}

public static void enterPickupAdd(String picad){
	System.out.println(picad);
	getWebelementByXpath("HOMEPAGE_PICADD_TYPE_XPATH").sendKeys(picad);;
}

public static void enterDropAdd(String dropad){
	getWebelementByXpath("HOMEPAGE_DROPADD_TYPE_XPATH").sendKeys(dropad);
	System.out.println(dropad);
}

public static void enterBasic(String basic){

//WebDriverFunctions.selectDropdownByVisibleText(basic, option);
	//WebDriverFunctions.selectDropdownByVisibleText("").se;
	WebDriverFunctions.selectDropdownByVisibleText("HOMEPAGE_BASIC_SELECT_XPATH",basic);
}

public static void clickBookLater(){
	getWebelementByXpath("HOMEPAGE_BOOKLATER_SELECT_XPATH").click();
}
}
