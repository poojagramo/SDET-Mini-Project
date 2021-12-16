package com.selenium.functionalTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.pages.AddSessionsPage;
import com.selenium.pages.EditFlexibleHeadsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.selenium.pages.AccountsDashboardPage;
import com.selenium.pages.AddFlexibleHeadsPage;
import com.selenium.pages.LoginPage;
import com.selenium.utilities.BrowserSetup;
import com.selenium.utilities.PropertyReader;

public class EditFlexibleHeadsTestCase extends BrowserSetup{
	LoginPage loginPage;
	AddFlexibleHeadsPage flexibleHead;
	AccountsDashboardPage accountsDashboardPage;
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
  public void editFlexibleHeads() throws InterruptedException {
	  try {
		  	test1 = extent.createTest("Edit Flexible Fee Head - Accounts Login", "Test to validate Edit Flexible Fee Head Functinality");
		  	test1.log(Status.INFO, "Starting test case");
		  	driver.get(PropertyReader.getProperties("url"));
		
			vars.put("FLEXIBLE_HEAD_ID_EDIT",PropertyReader.getProperties("flexible_head_id_edit"));
			vars.put("FLEXIBLE_HEAD_NAME_EDIT",PropertyReader.getProperties("flexible_head_name"));
			vars.put("FLEXIBLE_HEAD_DESC_EDIT",PropertyReader.getProperties("flexible_head_desc"));
		  
			loginPage = new LoginPage(driver);
			
			//		    check page title
			  
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
			
			//   	Accounts Dashboard
			accountsDashboardPage =new AccountsDashboardPage(driver);
			Thread.sleep(3000);
			accountsDashboardPage.checkPageTitle();
			test1.pass("Accounts Dashboard Page Title is Correct");
			accountsDashboardPage.clickEditFlexibleHeadsEditFlexibleLink();
			test1.pass("Accountant clicked Edit Flexible Fee Head Card");
			
			//			Edit Flexible heads
			flexibleHead = new AddFlexibleHeadsPage(driver,vars);
			flexibleHead.checkPageTitle();
			EditFlexibleHeadsPage editFlexibleHead = flexibleHead.editFlexibleHead();
			test1.pass("Selected the flexible head to edit the details");
			test1.pass("Entered new/edited detail");
			test1.pass("Flexible head edited successfully!");

			//    Sign-out
			editFlexibleHead.clickSignOutLink();
			
			Thread.sleep(3000);
			
		    driver.close();
		    Reporter.log("Driver Closed After Testing");
	        test1.pass("Closed the browser");
	        test1.info("Test completed");
			
		  } catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		  }
  }
}
