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

@Story(Surify.Messages.class)
@RunWith(SerenityRunner.class)
public class Test004_VerifyHavenMessagesForSelectedInputs{
	
	@Managed
	WebDriver driver;

	//Below data can be converted to datadriven framework for better test management
	String button1="GET YOUR FREE QUOTE", age="46", genderM="man", zipNA="10001", health="excellent health", 
			smoke="do not",premium="50000", term="20 years", noVoteAge="15", grandPaAge="75", xZip="11111",
			xPremD="5000", xPremH="6000001";
	
	
	@Steps 
	HavenLifeLandingAndQuoteSteps havenLifeLandingAndQuoteSteps;
	
	// I have combined the steps in single method, verify my code for details
	@Test
	@Pending
	@Title("Test004 - Verify Haven Messages For Selected Inputs")
	public void test004_VerifyHavenMessagesForSelectedInputs(){

		havenLifeLandingAndQuoteSteps.launchHavenLife();
		havenLifeLandingAndQuoteSteps.clickonGetFreeQuote();
		havenLifeLandingAndQuoteSteps.verifyHavenMessages(age, genderM, zipNA, health, smoke, premium, term);
		/// Combined all steps into one :p, go through the code
		
	
	}
}
