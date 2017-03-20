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

@Story(Surify.Quotes.class)
@RunWith(SerenityRunner.class)
public class Test002_GetAnInstantQuoteAndVerifySummary{
	
	@Managed
	WebDriver driver;
	//Below data can be converted to datadriven framework, for multile iterations with valid data
	String button1="GET YOUR FREE QUOTE", age="26", gender="man", zip="35801", health="excellent health", 
			smokeHabit="do not",premium="500000", term="20 year";
	
	
	@Steps 
	HavenLifeLandingAndQuoteSteps havenLifeLandingAndQuoteSteps;
	
	
	@Test
	@Title("Test002 - Get An Instant Quote and Verify Summary - can be implemented multiple iterations for diffrent set of options")
	public void test002_GetAnInstantQuote(){
		havenLifeLandingAndQuoteSteps.launchHavenLife();
		havenLifeLandingAndQuoteSteps.clickonGetFreeQuote();
		havenLifeLandingAndQuoteSteps.enterValidAge(age);
		havenLifeLandingAndQuoteSteps.selectGender(gender);
		havenLifeLandingAndQuoteSteps.enterValidZipCode(zip);
		havenLifeLandingAndQuoteSteps.selectHealthClass(health);
		havenLifeLandingAndQuoteSteps.selectSmokeHabit(smokeHabit);
		havenLifeLandingAndQuoteSteps.enterValidPremium(premium);
		havenLifeLandingAndQuoteSteps.selectTerm(term);
		havenLifeLandingAndQuoteSteps.clickApplyButton();
		havenLifeLandingAndQuoteSteps.verifySummaryOfQuote(premium, term);
	
	}
}
