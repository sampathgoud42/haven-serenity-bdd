package com.surify.havenlife.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.surify.havenlife.HavenLifeLandingAndQuoteSteps;
import com.surify.havenlife.Surify;

@Story(Surify.Nagative.class)
@RunWith(SerenityRunner.class)
public class Test005_TestFailureForReports{
	
	@Managed
	WebDriver driver;

	
	
	@Steps 
	HavenLifeLandingAndQuoteSteps havenLifeLandingAndQuoteSteps;
	
	// I have combined the steps in single method, verify my code for details
	@Test
	@Title("Test005_Test Failure For Reports")
	public void test005_TestFailureForReports(){

		havenLifeLandingAndQuoteSteps.launchHavenLife();
		havenLifeLandingAndQuoteSteps.clickonGetFreeQuote();
		havenLifeLandingAndQuoteSteps.failThis();
		/// Combined all steps into one :p, go through the code
		
	
	}
}
