package com.selenium.functionalTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.selenium.pages.AccountsDashboardPage;
import com.selenium.pages.LoginPage;
import com.selenium.pages.UsersPage;
import com.selenium.utilities.BrowserSetup;
import com.selenium.utilities.PropertyReader;
import com.selenium.pages.StaticFeeHeadPage;

public class AssociateStaticFee extends BrowserSetup{
	 LoginPage loginPage;
	 JavascriptExecutor js;
	 UsersPage usersPage;
	 AccountsDashboardPage accountDashboardPage;
	 StaticFeeHeadPage staticFeeHeadPage;
	 
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
	  public void addClasses() throws InterruptedException {
		  try {
			  	test1 = extent.createTest("Associate Static Fee Head - Accounts Login", "Test to validate Associate Static Fee Head Card Functinality");
			  	test1.log(Status.INFO, "Starting test case");
				driver.get(PropertyReader.getProperties("url"));
				loginPage = new LoginPage(driver);
				staticFeeHeadPage = new StaticFeeHeadPage(driver);
				
				//			    check page title
				  
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
				accountDashboardPage.clickAssociateStaticFeeHeadsAssociateLink();
				test1.pass("Accountant clicked Associate Static Fee Head Card");
			
				Thread.sleep(3000);
				staticFeeHeadPage.setSelectClassDropDownListField(PropertyReader.getProperties("associate_static_head_class"));
				//Thread.sleep(3000);
				staticFeeHeadPage.setSelectStaticFeeHeadDropDownListField(PropertyReader.getProperties("associate_static_head"));
				staticFeeHeadPage.setStaticFeeHeadAmountTextField(PropertyReader.getProperties("associate_static_head_amount"));
				test1.pass("Selected the class and static fee head from he dropdown");
				test1.pass("Entered static fee head amount from properties file");
				staticFeeHeadPage.clickAssociateButton();
				test1.pass("Clicked Associate button");
				Thread.sleep(3000);
				
				//close dialog box
				staticFeeHeadPage.close();
				Thread.sleep(3000);
	
				//logout
				staticFeeHeadPage.clickLogoutDropDown();
				staticFeeHeadPage.clickSignOutLink();
			    Thread.sleep(3000);
	
			    driver.close();
			    Reporter.log("Driver Closed After Testing");
		        test1.pass("Closed the browser");
		        test1.info("Test completed");
			
	} catch (Throwable e) {
		e.printStackTrace();
	}
	  }
}
