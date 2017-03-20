package com.surify.havenlife;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public abstract class AbstractTest {

//For Better Test management we can make use of Abstract classes for reusable methods
	//Eg: pre requisites
	//Tear down appraoch
	
	public WebDriver driver;

	@ManagedPages(defaultUrl = "https://havenlife.com")
	
	public Pages pages;
	
	
	@After
	public void tearDown() {		
		driver.close();
		
	}

}
