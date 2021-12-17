package com.selenium.functionalTest;

import java.io.IOException;

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

public class DeleteStaticHeadsTestCase extends BrowserSetup{
	LoginPage loginPage;
	AddStaticHeadsPage staticHead;
	AccountsDashboardPage accountsDashboardPage;
	AddSessionsPage addSessionPage;
	
	 @BeforeMethod
		public void beforeMethod() {
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
  public void deleteFlexibleHeads() throws InterruptedException {
	  try {
		  test1 = extent.createTest("Delete Static Fee Head - Accounts Login", "Test to validate Delete Static Fee Head Functinality");
		  test1.log(Status.INFO, "Starting test case");
		  driver.get(PropertyReader.getProperties("url"));
		  
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
		  accountsDashboardPage.clickDeleteStaticHeadsDeleteALink();
		  test1.pass("Accountant clicked Delete Static Fee Head Card");
			
			//			Delete Flexible Head
		  staticHead = new AddStaticHeadsPage(driver);
		  staticHead.checkPageTitle();
		  staticHead.deleteStaticHead(PropertyReader.getProperties("static_head_id_delete"));
		  test1.pass("Clicked the delete button for a static head");

			//    Sign-out
		  staticHead.clickSignOutLink();
		  
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
