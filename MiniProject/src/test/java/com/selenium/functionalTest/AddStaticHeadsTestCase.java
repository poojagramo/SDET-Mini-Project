package com.selenium.functionalTest;

import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.selenium.pages.AccountsDashboardPage;
import com.selenium.pages.AddSessionsPage;
import com.selenium.pages.AddStaticHeadsPage;
import com.selenium.pages.LoginPage;
import com.selenium.utilities.BrowserSetup;
import com.selenium.utilities.PropertyReader;

public class AddStaticHeadsTestCase extends BrowserSetup{
	LoginPage loginPage;
	AccountsDashboardPage accountDashboardPage;
	AddStaticHeadsPage staticHead;
	AddSessionsPage addSessionPage;
	private Map<String, String> vars;
	
	@BeforeMethod
	public void beforeMethod() {
		vars = new HashMap<String, String>();
		BrowserSetup.setup("chrome");
		htmlReporter = new ExtentSparkReporter("files\\ExtentReports\\" + this.getClass().getSimpleName() + "Report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
		}
	
	@AfterTest
	  public void tearDown() {
	    driver.quit();
	    extent.flush();
	  }
  @Test
  public void addStaticHead() {
	  try {
		  	test1 = extent.createTest("Add Static Fee Head - Accounts Login", "Test to validate Add Static Fee Head Card Functinality");
		  	test1.log(Status.INFO, "Starting test case");
			driver.get(PropertyReader.getProperties("url"));
			vars.put("STATIC_FEE_HEAD_NAME",PropertyReader.getProperties("static_fee_head_name"));
			vars.put("DESCRIPTION",PropertyReader.getProperties("static_fee_head_desc"));
			
			  
			loginPage = new LoginPage(driver);
			
			//    check page title
			  
			loginPage.checkPageTitle();
			test1.pass("Login Page Title is correct");
				
			//    validation of fields
			loginPage.usernameValidation();
			test1.pass("Username is Editable");
			loginPage.passwordValidation();
			test1.pass("Password is Editable");
			loginPage.sessionValidation();
			test1.pass("Session is Editable");
				
			// 		entering data
			loginPage.enterUserName(PropertyReader.getProperties("accounts_username"));
			test1.pass("Username is Entered");
			loginPage.enterPassword(PropertyReader.getProperties("accounts_password"));
			test1.pass("Password is Entered");
			loginPage.setSelectSessionDropDownListField(PropertyReader.getProperties("accounts_session"));
			test1.pass("Session is Selected");
			Thread.sleep(3000);
				
			//   click Sign In button
			loginPage.clickSignIn();
			
			//   		Accounts Dashboard
			accountDashboardPage =new AccountsDashboardPage(driver);
			Thread.sleep(3000);
			accountDashboardPage.checkPageTitle();
			test1.pass("Accounts Dashboard Page Title is Correct");
			accountDashboardPage.clickAddStaticHeadsStaticFeeLink();
			test1.pass("Accountant clicked Add Static Fee Head Card");
			
			//			Add Static head
			staticHead = new AddStaticHeadsPage(driver,vars);
			staticHead.checkPageTitle();
			staticHead.staticFeeHeadNameValidation();
			staticHead.descriptionValidation();
			staticHead.fillAndSubmit();
			test1.pass("Entered static fee head title and its description from properties file");
			test1.pass("Clicked Add button");
	
			//	    Sign-out
			staticHead=staticHead.clickSignOutLink();
			driver.close();
			
			Reporter.log("Driver Closed After Testing");
            test1.pass("Closed the browser");
            test1.info("Test completed");
		
		} catch (Throwable e) {
			e.printStackTrace();
		}
  }
}
