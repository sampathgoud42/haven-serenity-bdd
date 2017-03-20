package com.surify.havenlife.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// This is the only suite I have created, For better Test management we can create multiple suites and configure using Surefire plugin
@RunWith(Suite.class)
@SuiteClasses({ 
	
		Test001_VerifyLandingPageAndWelcomeMessage.class,
		Test002_GetAnInstantQuoteAndVerifySummary.class,
		Test003_VerifyErrorMessagesForInvalidInputs.class,
		Test004_VerifyHavenMessagesForSelectedInputs.class,
		Test005_TestFailureForReports.class
		
})

public class TestSuite {

}
