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

@Story(Surify.Messages.class)
@RunWith(SerenityRunner.class)
public class Test003_VerifyErrorMessagesForInvalidInputs{
	
	@Managed
	WebDriver driver;
	//Below data can be converted to datadriven framework, for multile iterations with invalid data
	String button1="GET YOUR FREE QUOTE", age="26", gender="man", zip="35801", health="excellent health", 
			smokeHabit="do not",premium="500000", term="20 years", noVoteAge="15", grandPaAge="75", xZip="11111",
			xPremD="5000", xPremH="6000001";
	
	
	@Steps 
	HavenLifeLandingAndQuoteSteps havenLifeLandingAndQuoteSteps;
	
	//I have combined the verifications to single test
	@Test
	@Title("Test003 - Verify Error Messages For Invalid Inputs - can be implemented multiple iterations for diffrent set of options")
	public void test003_VerifyErrorMessagesForInvalidInputs(){
		havenLifeLandingAndQuoteSteps.launchHavenLife();
		havenLifeLandingAndQuoteSteps.clickonGetFreeQuote();
		havenLifeLandingAndQuoteSteps.enterInvalidAgeAndVerifyMesages(noVoteAge);
		havenLifeLandingAndQuoteSteps.enterInvalidAgeAndVerifyMesages(grandPaAge);
		havenLifeLandingAndQuoteSteps.enterInvalidZipCode(xZip);
		havenLifeLandingAndQuoteSteps.enterInvalidPremium(xPremD);
		havenLifeLandingAndQuoteSteps.enterValidAge(age);
		havenLifeLandingAndQuoteSteps.selectGender(gender);
		havenLifeLandingAndQuoteSteps.enterValidZipCode(zip);
		havenLifeLandingAndQuoteSteps.selectHealthClass(health);
		havenLifeLandingAndQuoteSteps.selectSmokeHabit(smokeHabit);
		havenLifeLandingAndQuoteSteps.enterInvalidPremium(xPremH);	
	
	}
}
