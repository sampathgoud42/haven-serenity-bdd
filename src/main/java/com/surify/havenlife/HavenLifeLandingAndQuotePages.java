package com.surify.havenlife;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.awt.event.KeyEvent.*;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;

@DefaultUrl("https://havenlife.com/")
public class HavenLifeLandingAndQuotePages extends PageObject{
	private static final Logger LOG = LoggerFactory.getLogger(HavenLifeLandingAndQuotePages.class);
	 private Robot robot;
	 
	@Managed
	WebDriver driver;

	public HavenLifeLandingAndQuotePages(final WebDriver driver) {
		super(driver);
		this.driver=driver;

	}

	//Landing Page Elements

	@FindBy(css="div.container h1") //div.container h1 "Online life insurance" //div.container h1 br "in 20 minutes."
	WebElement welcomeMessage;

	@FindBy(css="button.btn") //div.container h1 "Online life insurance" //div.container h1 br "in 20 minutes."
	List<WebElement> buttonsList;

	@FindBy(css="form[b\\:onsubmit*='quickquote'] button")
	WebElement quickQuoteButtton;
	
	@FindBy(css="button.btn:nth-child(1)") //div.container h1 "Online life insurance" //div.container h1 br "in 20 minutes."
	WebElement getFreeQuoteButton;

	@FindBy(css="nav[class*='navsteps'] ol li a") //Calculate needs //Select a quote //Apply online
	List<WebElement> navSteps;

	@FindBy(css="div[class*='needs-form'] h1") //Get an instant quote.
	WebElement quickQuoteTitle;

	@FindBy(css="div[class*='margin-bottom'] div a") //Calculate your needs. //proposed options //Calculate needs //Select a quote //Apply online
	List<WebElement> allLinks;

	@FindBy(css="input[id*='primaryAge']") 
	WebElement primaryAge;

	@FindBy(id="genderPO")
	WebElement genderPO;

	@FindBy(css="div.popover-content div[class*='list-pop-item']")
	List<WebElement> populatedItems;

	@FindBy(css="#primaryZIP input#primaryZIP") 
	WebElement primaryZIP;

	@FindBy(id="healthClassNumberPO") //average health// good health //very good health //excellent health
	WebElement healthClassNumberPO;

	@FindBy(id="smokerPO") 
	WebElement smokerPO;

	@FindBy(css="#face input#face") 
	WebElement face;
	//<span b:binderrordata="{field:'__errorfieldname__'}" b:binderror="customer.primaryCustomer.overrideAmount">Please enter a number less than or equal to 6000000</span>
	//<span b:binderrordata="{field:'__errorfieldname__'}" b:binderror="customer.primaryCustomer.overrideAmount">Please enter a number greater than or equal to 50000</span>

	@FindBy(id="termPO")
	WebElement termPO;

	@FindBy(css="div[class*='applicationTopBleed']>h1")
	WebElement applyNowMessage;

	@FindBy(css="span.selectedQuoteFaceTerm")
	WebElement premiumAndTerm;

	@FindBy(css="span.selectedQuoteMonthlyCost")
	WebElement estimatedPerMonth;

	@FindBy(id="applynow")
	WebElement applynowButton;
	
	@FindBy(css="div>a[b\\:onclick*='public.needs']")
	WebElement calculateNeeds;
	
	@FindBy(css="h2>a[b\\:onclick*='quick_quote_confirm']")
	WebElement quickQuoteConfirm;
	
	@FindBy(css="button[id*='viewmyquotes']")
	WebElement okayIwill;

	String bindErrorAge="span[b\\:binderror='customer.primaryCustomer.person.age']"; //span[b\:binderror='customer.primaryCustomer.person.age']
	//2 errors
	String bindErrorZip="span[b\\:binderror='needsController.zip']"; //span[b\:binderror='needsController.zip']
	//1 error
	String bindErrorPrem="span[b\\:binderror='customer.primaryCustomer.overrideAmount']"; 
	//2 errors
	String havenMessageAge = "table[id$='quotesList'] div[b\\:showif*='person.age']";
	String havenMessageCapitalBelow1M = "table[id$='quotesList'] div[b\\:showif*='< 100000']";
	String havenMessageCapitalAbove1M = "table[id$='quotesList'] div[b\\:showif*='> 100000']";
	String havenMessageNAState = "table[id$='quotesList'] div[b\\:showif*='address.state']:nth-child(2)";
	//4 messages and apply button should not visible.
	
	public void launchHavenLife(){
		driver.get("https://havenlife.com/");
		driver.manage().window().maximize();
	}

	public void verifyWelcomeMessage(String message){
		waitForAngularRequestsToFinish();
		element(welcomeMessage).waitUntilVisible();
		String actualTextWO=welcomeMessage.getText();
		String[] st= actualTextWO.split("\\r?\\n");
		String actualText=st[0]+" "+st[1];
		LOG.info(actualText);
		Assert.assertTrue("The welcome message "+actualText+" is inncorrect", actualText.equals(message));
	}


	public void verifyGetQuoteButton(String buttonName){

		boolean isFound= false;
		for(WebElement quote: buttonsList){

			if(quote.getText().toLowerCase().equals(buttonName.toLowerCase()))
				isFound=true;
			Assert.assertTrue(buttonName+" is not Found", isFound);
		}	
	}	

	
	public void clickonGetFreeQuote(){

		boolean isFound= false;
		quickQuoteButtton.sendKeys("");
		quickQuoteButtton.click();
	}

	public void clickOnQuoteNavigteStep(String navStep){

		boolean isFound= false;
		for(WebElement step: navSteps){
			if(step.getText().toLowerCase().contains(navStep.toLowerCase())){
				step.click();
				isFound=true;
				break;
		}
			Assert.assertTrue(navStep+" is not Found", isFound);
		}
	}

	//Here I am not using Happy paths since JSF on webpage not allowing to enter values using sendKeys for the firsttime so I am navigating back and sending keys again.
	public void enterValidAge(String age){

		jsRequestsToFinish();
		element(primaryAge).waitUntilVisible();
		findAndWaitForElementToBePresent(primaryAge,60);
		primaryAge.clear();
		//Below Steps added to make sure Random Clicks should allow user to enter Inputs.
		genderPO.click();
		genderPO.click();
		Actions builder = new Actions(driver);
		builder.moveToElement(primaryAge).click().sendKeys("").build().perform();
		builder.moveToElement(primaryAge).click().sendKeys(age).build().perform();

	}

	//**** here I have hard coded ALL ERROR messages using Asserts, for future maintenance we can drive it through CSV or final Constants.
	public void enterInvalidAge(String age) {
		int i = Integer.parseInt(age);		
		//unit test purpose
		if(i<=70 && i>=18){
			i=15;
		}
		
		age =Integer.toString(i);
		System.out.println("age is " +age);
		findAndWaitForElementToBePresent(primaryAge,60);
		primaryAge.clear();
		genderPO.click();
		genderPO.click();
		Actions builder = new Actions(driver);
		builder.moveToElement(primaryAge).click().sendKeys("").build().perform();
		builder.moveToElement(primaryAge).click().sendKeys(age).build().perform();
		genderPO.click();
		genderPO.click();
		System.out.println(driver.findElement(By.cssSelector(bindErrorAge)).getText());
		findAndWaitForElementToBePresent(driver.findElement(By.cssSelector(bindErrorAge)),60);
		if(i>70){
			Assert.assertTrue("Allowing the age greater than 70", driver.findElement(By.cssSelector(bindErrorAge)).getText().contains("Please enter a number less than or equal to 70"));
		}
		else if(i<18){
			System.out.println(driver.findElement(By.cssSelector(bindErrorAge)).getText());
			Assert.assertTrue("Allowing the age less than 18", driver.findElement(By.cssSelector(bindErrorAge)).getText().contains("Please enter a number greater than or equal to 18"));
		}

		else{
			Assert.assertTrue("The entered age is not invalid", false);
		}
	}

	// man // woman
	public void selectGender(String gender){
		boolean isFound=false;
		findAndWaitForElementToBePresent(genderPO,60);
		genderPO.click();
		waitForListToLoad(populatedItems, 30, true);
		for(WebElement gdr: populatedItems){
			if(gdr.getText().toLowerCase().trim().contentEquals(gender.toLowerCase())){
				
				gdr.click();
				isFound = true;
				break;
			}
		}

		Assert.assertTrue(gender+" is not found in populated gender list", isFound);
	}

	public void enterValidZipCode(String zip){
		findAndWaitForElementToBePresent(primaryZIP,60);
		primaryZIP.clear();
		Actions builder = new Actions(driver);
		builder.moveToElement(primaryZIP).click().sendKeys(zip).build().perform();
		
	}

	public void enterInvalidZipCode(String zip){

		findAndWaitForElementToBePresent(primaryZIP,60);
		primaryZIP.clear();
		Actions builder = new Actions(driver);
		builder.moveToElement(primaryZIP).click().sendKeys(zip).build().perform();
		genderPO.click();
		genderPO.click();
		findAndWaitForElementToBePresent(driver.findElement(By.cssSelector(bindErrorZip)),60);
		Assert.assertTrue("The error message is not displayed", driver.findElement(By.cssSelector(bindErrorZip)).getText().contains("Not a valid ZIP code"));

	}

	//average health// good health //very good health //excellent health
	public void selectHealthClass(String healthStatus){

		boolean isFound=false;
		findAndWaitForElementToBePresent(healthClassNumberPO,60);
		healthClassNumberPO.click();
		waitForListToLoad(populatedItems, 30, true);
		for(WebElement hlt: populatedItems){
			if(hlt.getText().trim().toLowerCase().contains(healthStatus.toLowerCase())){
				hlt.click();
				isFound = true;
				break;
			}
		}
		Assert.assertTrue(healthStatus+" is not found in populated health status list", isFound);
	}

	//do //do not
	public void selectSmokeHabit(String smokeHabit){

		boolean isFound=false;
		findAndWaitForElementToBePresent(smokerPO,60);
		smokerPO.click();
		waitForListToLoad(populatedItems, 30, true);
		for(WebElement hlt: populatedItems){
			if(hlt.getText().toLowerCase().trim().contentEquals(smokeHabit.toLowerCase())){
				
				hlt.click();
				isFound = true;
				break;
			}
		}
		Assert.assertTrue(smokeHabit+" is not found in populated Smoke habit list", isFound);
	}

	public void enterValidPremium(String premium){
		findAndWaitForElementToBePresent(face,60);
		face.clear();
		Actions builder = new Actions(driver);
		builder.moveToElement(face).click().sendKeys(premium).build().perform();
	}

	//**** here I have hard coded ALL ERROR messages using Asserts, for future maintenance we can drive it through CSV or final Constants.
	public void enterInvalidPremium(String premium){
		
		int prem = Integer.parseInt(premium);
		findAndWaitForElementToBePresent(face,60);
		face.clear();
		Actions builder = new Actions(driver);
		builder.moveToElement(face).click().sendKeys(premium).build().perform();
		genderPO.click();
		genderPO.click();
		findAndWaitForElementToBePresent(driver.findElement(By.cssSelector(bindErrorPrem)),60);
		if(prem<50000){
			Assert.assertTrue("Allowing the age greater than 70", driver.findElement(By.cssSelector(bindErrorPrem)).getText().contains("Please enter a number greater than or equal to 50000"));
		}
		else if(prem>6000000){
			System.out.println(driver.findElement(By.cssSelector(bindErrorAge)).getText());
			Assert.assertTrue("Allowing the age less than 18", driver.findElement(By.cssSelector(bindErrorPrem)).getText().contains("Please enter a number less than or equal to 6000000"));
		}
		
		else{
			Assert.assertTrue("The entered premium is not invalid, modify test data", false);
		}
		
		System.out.println("Here it comes, Awesome");
	}


	//10 years // 15 years //20 years // 30 years
	public void selectTerm(String term){

		boolean isFound=false;
		findAndWaitForElementToBePresent(termPO,60);
		termPO.click();
		waitForListToLoad(populatedItems, 30, true);
		for(WebElement trm: populatedItems){
			if(trm.getText().trim().toLowerCase().contains(term.toLowerCase())){
				trm.click();
				isFound = true;
				break;
			}
		}
		waitABit(1000);
		Assert.assertTrue(term+" is not found in populated the list", isFound);
	}

	public void clickApply(){
		jsRequestsToFinish();
		boolean isButtonPresent= isElementVisible(By.id("applynow"));
		findAndWaitForElementToBePresent(applynowButton, 60);
		if(isButtonPresent==true)		
			applynowButton.click();

		Assert.assertTrue("The apply button is not visible", isButtonPresent);

	}
	
	//pending
	public void verifyApplyButtonIsDisappeared(){
		
		jsRequestsToFinish();
		boolean isButtonPresent= isElementVisible(By.id("applynow"));
		Assert.assertFalse("The apply button IS VISIBLE", isButtonPresent);
		
	}
	
	
	public void verifyHavenMessages(String age, String gender, String zip, String health, String smoke, String premium, String term){

		enterValidAge(age);
		selectGender(gender);
		enterValidZipCode(zip); //pass validZip but available for Haven
		selectHealthClass(health);
		selectSmokeHabit(smoke);
		enterValidPremium(premium);
		selectTerm(term);
		
		int iAge = Integer.parseInt(age);		

		if(iAge<18 || iAge>44 ){
			Assert.assertTrue("Haven message is Not correct/ or not displaying", driver.findElement(By.cssSelector(havenMessageAge)).getText().contains("Haven Term is available for people of ages 18-44, only"));
		}
		
		Assert.assertTrue("Haven message is Not correct/ or not displaying", driver.findElement(By.cssSelector(havenMessageNAState)).getText().contains("Haven Term is not available in your state"));
		//verify the haven message for premium below 100000
		Assert.assertTrue("Haven message is Not correct/ or not displaying for premium less than $100,000", driver.findElement(By.cssSelector(havenMessageCapitalBelow1M)).getText().contains("Haven Term is not available under $100,000"));
		selectSmokeHabit(smoke);
		//verify the haven message for premium above 1M
		enterValidPremium(premium+"00");
		selectTerm(term);
		Assert.assertTrue("Haven message is Not correct/ or not displaying for premium less than $100,000", driver.findElement(By.cssSelector(havenMessageCapitalAbove1M)).getText().contains("Haven Term is not available above $1 million"));

	}
	
	
	
	
	//customer.capitalNeeds.getFace(false) >= 100000 && (customer.primaryCustomer.person.age >= 45 || !isProductSoldIn(customer.primaryCustomer.address.state) || customer.capitalNeeds.getFace(false) > 1200000)

	//pending
	public void forOtherOptions(String age, String gender, String zip, String health, String smoke, String premium, String term){

		enterValidAge(age);
		selectGender(gender);
		enterValidZipCode(zip); //pass validZip but available for Haven
		selectHealthClass(health);
		selectSmokeHabit(smoke);
		enterValidPremium(premium);
		selectTerm(term);
		
		int iAge = Integer.parseInt(age);		
	
	}

	//pending
		public void clickCalculateUrNeeds(){

			calculateNeeds.click();
			//Here we have another module with extra options to select with assumptions
			
			quickQuoteConfirm.click();
			okayIwill.click();
			//Already know insuranceclick here
			//Made few assuptions web popup
			// click Okay I will
			//navigateBackto getAnInstantQuote Page
		
		}
	public void getAnInstantQuote(String age, String gender, String zip, String health, String smoke, String premium, String term){

		enterValidAge(age);
		selectGender(gender);
		enterValidZipCode(zip);
		selectHealthClass(health);
		selectSmokeHabit(smoke);
		enterValidPremium(premium);
		selectTerm(term);
		clickApply();

	}	

	public void verifyApplyNowTitle(){

		jsRequestsToFinish();
		findAndWaitForElementToBePresent(applyNowMessage,60);
		Assert.assertTrue("Apply now message is incoorect", applyNowMessage.getText().equals("Apply now for immediate approval. No obligation."));

	}

	public void verifySummaryOfQuote(String premium, String term){

		findAndWaitForElementToBePresent(premiumAndTerm, 60);
		int actPremium=Integer.parseInt(premium);

		//Need a logic//math claculation to calculate monthly premium.

			/*		double estCostPerMonth=actPremium/(actTermYears*12);
			NumberFormat nf = NumberFormat.getInstance();
			nf.setMaximumFractionDigits(2);
			nf.format(estCostPerMonth);
			System.out.println(estCostPerMonth);
			 */		
		DecimalFormat dFormat = new DecimalFormat();
		String formattedString = dFormat.format(actPremium); 
		String expectedPolicy="Haven Term $"+formattedString+" / "+term;
		Assert.assertTrue("The Policy Term is not correct", premiumAndTerm.getText().equals(expectedPolicy));
		//	Assert.assertTrue("The Estimated cost per month is incorrect", estimatedPerMonth.getText())


	}



	private static boolean isElementPresentAndDisplay(WebDriver driver, By by) {

		try {               
			return driver.findElement(by).isDisplayed();
		} catch (StaleElementReferenceException e) {
			return false;
		}

	}


	public WebElement findAndWaitForElementToBePresent(
			final WebElement element, int timeoutSeconds) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
				.withTimeout(timeoutSeconds, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class,StaleElementReferenceException.class);

		WebElement searchedElement = wait
				.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return element;
					}
				});
		return searchedElement;
	}
	
	
	public void sendKeysCustom(final WebElement element, String s){
		
		Actions builder = new Actions(driver);
		builder.moveToElement(element).click().sendKeys(s).build().perform();
		

	}
	
	   public void jsRequestsToFinish() {
	        if ((boolean) getJavascriptExecutorFacade().executeScript(
	                "return (typeof angular !== 'undefined')? true : false;")) {
	            getJavascriptExecutorFacade()
	                    .executeAsyncScript(
	                            "var callback = arguments[arguments.length - 1];"
	                                    + "angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);");
	        }
	    }

	   
	   public void waitForListToLoad(List<WebElement> list, int timeoutSeconds,
				boolean assertListNotEmpty) {
			int counter = 0;
			while ((list.size() == 0) && (counter < timeoutSeconds)) {
				waitABit(1000L);
				++counter;
			}
			if (assertListNotEmpty)
				Assert.assertTrue("List is empty", list.size() > 0);
		}


}






