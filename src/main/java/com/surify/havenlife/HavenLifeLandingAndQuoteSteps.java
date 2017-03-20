package com.surify.havenlife;


import org.junit.Assert;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class HavenLifeLandingAndQuoteSteps extends ScenarioSteps {

	
	private static final long serialVersionUID = 1L;
	
	HavenLifeLandingAndQuotePages havenLifeLandingAndQuotePages;
	

	@Step("Launch HavenLife")
	public void launchHavenLife() {
		havenLifeLandingAndQuotePages.launchHavenLife();
	}
	
	@Step("Verify welcome message: {0}")
	public void verifyWelcomeMessage(String message) {
		havenLifeLandingAndQuotePages.verifyWelcomeMessage(message);
	}
	
	@Step("Verify welcome message: {0}")
	public void verifyButtonIsPresent(String buttonName) {
		havenLifeLandingAndQuotePages.verifyGetQuoteButton(buttonName);
	}
	
	@Step("Click on {0} button")
	public void clickonGetFreeQuote(){
		havenLifeLandingAndQuotePages.clickonGetFreeQuote();
	}
	
	@Step("Enter valid age {0}")
	public void enterValidAge(String s){
		havenLifeLandingAndQuotePages.enterValidAge(s);
	}
	
	@Step("Enter Invalid age {0} - verify error message")
	public void enterInvalidAgeAndVerifyMesages(String s){
		havenLifeLandingAndQuotePages.enterInvalidAge(s);
	}
	
	@Step("Select gender {0}")
	public void selectGender(String s){
		havenLifeLandingAndQuotePages.selectGender(s);
	}
	
	@Step("Enter valid zip code {0}")
	public void enterValidZipCode(String s){
		havenLifeLandingAndQuotePages.enterValidZipCode(s);
	}
	
	@Step("Enter Invalid zip code {0} - verify error message")
	public void enterInvalidZipCode(String s){
		havenLifeLandingAndQuotePages.enterInvalidZipCode(s);
	}
	
	@Step("Select Health class {0}")
	public void selectHealthClass(String s){
		havenLifeLandingAndQuotePages.selectHealthClass(s);
	}
	
	@Step("Select Smoke Habit as {0}")
	public void selectSmokeHabit(String s){
		havenLifeLandingAndQuotePages.selectSmokeHabit(s);
	}
	
	@Step("Enter valid Premium {0}")
	public void enterValidPremium(String s){
		havenLifeLandingAndQuotePages.enterValidPremium(s);
	}
	
	@Step("Enter Invalid Premium {0} and verify message")
	public void enterInvalidPremium(String s){
		havenLifeLandingAndQuotePages.enterInvalidPremium(s);
	}
	
	@Step("Select Policy Term {0}")
	public void selectTerm(String s){
		havenLifeLandingAndQuotePages.selectTerm(s);
	}
	
	@Step("Click On Apply Button")
	public void clickApplyButton(){
		havenLifeLandingAndQuotePages.clickApply();
	}
	
	@Step("Verify Apply Now Title")
	public void verifyApplyNowTitle(){
		havenLifeLandingAndQuotePages.verifyApplyNowTitle();
	}
	
	@Step("Verify Apply Now Title")
	public void verifySummaryOfQuote(String premium, String term){
		havenLifeLandingAndQuotePages.verifySummaryOfQuote(premium, term);
	}
	
	@Step("Verify Apply Button Is Disappeared or Not Visible")
	public void verifyApplyButtonIsDisappeared(){
		havenLifeLandingAndQuotePages.verifyApplyButtonIsDisappeared();
	}
	//I have combined all messages in this method
	@Step("Verify Haven Specific messages for user inputs")
	public void verifyHavenMessages(String age, String gender, String zip, String health, String smoke, String premium, String term){
		havenLifeLandingAndQuotePages.verifyHavenMessages(age, gender, zip, health, smoke, premium, term);
	}
	
	@Pending
	@Step("Verify for other options message on specific condition for user inputs")
	public void verifyOtherOptionsOnSpecificCondition(String age, String gender, String zip, String health, String smoke, String premium, String term){
		havenLifeLandingAndQuotePages.forOtherOptions(age, gender, zip, health, smoke, premium, term);
	}
	
	@Pending
	@Step("Click on Calculate your needs")
	public void clickCalculateUrNeeds(){
		havenLifeLandingAndQuotePages.clickCalculateUrNeeds();
	}
	
	@Step("Intentioanl failuer for reports")
	public void failThis(){
		
		Assert.assertTrue(false);
	}
	
}

