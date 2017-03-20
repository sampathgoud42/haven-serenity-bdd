package com.surify.havenlife.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.surify.havenlife.HavenLifeLandingAndQuoteSteps;
import com.surify.havenlife.Surify;

@Story(Surify.LandingPage.class)
@RunWith(SerenityRunner.class)
public class Test001_VerifyLandingPageAndWelcomeMessage{
	
	@Managed
	WebDriver driver;
	
	
	@Steps 
	HavenLifeLandingAndQuoteSteps havenLifeLandingAndQuoteSteps;
	
	
	@Test
	@Title("Test001 - Verify Landing Page And Welcome Message ")
	public void test001_VerifyLandingPageAndWelcomeMessage(){
		havenLifeLandingAndQuoteSteps.launchHavenLife();
		havenLifeLandingAndQuoteSteps.verifyWelcomeMessage("Online life insurance in 20 minutes.");// \n"+"in 20 minutes");
		havenLifeLandingAndQuoteSteps.verifyButtonIsPresent("GET YOUR FREE QUOTE");
	}
}
