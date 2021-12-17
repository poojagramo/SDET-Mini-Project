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
import com.selenium.pages.AddStaticHeadsPage;
import com.selenium.pages.EditStaticHeadsPage;
import com.selenium.pages.LoginPage;
import com.selenium.utilities.BrowserSetup;
import com.selenium.utilities.PropertyReader;

public class EditStaticHeadsTestCase extends BrowserSetup{
	LoginPage loginPage;
	AccountsDashboardPage accountDashboardPage;
	AddStaticHeadsPage staticHead;
	EditStaticHeadsPage editStaticHead;
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
  public void editStaticHead() {
	  try {
		  	test1 = extent.createTest("Edit Static Fee Head - Accounts Login", "Test to validate Edit Static Fee Head Functinality");
		  	test1.log(Status.INFO, "Starting test case");
			driver.get(PropertyReader.getProperties("url"));
			vars.put("STATIC_HEAD_ID_EDIT",PropertyReader.getProperties("static_head_id_edit"));
			vars.put("STATIC_HEAD_NAME_EDIT",PropertyReader.getProperties("static_head_name_edit"));
			vars.put("STATIC_HEAD_DESC_EDIT",PropertyReader.getProperties("static_head_desc_edit"));
			
			
			  
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
			accountDashboardPage =new AccountsDashboardPage(driver);
			Thread.sleep(3000);
			accountDashboardPage.checkPageTitle();
			test1.pass("Accounts Dashboard Page Title is Correct");
			accountDashboardPage.clickEditStaticHeadsEditStaticLink();
			test1.pass("Accountant clicked Edit Static Fee Head Card");
			
			//			Add Static head
			staticHead = new AddStaticHeadsPage(driver,vars);
			staticHead.checkPageTitle();
			
			editStaticHead = staticHead.editStaticHead();
			test1.pass("Selected the static head to edit the details");
			test1.pass("Entered new/edited detail");
			test1.pass("Static head edited successfully!");
			
			//	    Sign-out
			editStaticHead=editStaticHead.clickSignOutLink();
			driver.close();
			
			Reporter.log("Driver Closed After Testing");
	        test1.pass("Closed the browser");
	        test1.info("Test completed");
		
		} catch (Throwable e) {
			e.printStackTrace();
		}
  }
}
