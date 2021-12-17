package com.selenium.functionalTest;


import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.selenium.pages.AdminDashboardPage;
import com.selenium.pages.ClassesPage;
import com.selenium.pages.LoginPage;
import com.selenium.pages.UsersPage;
import com.selenium.utilities.BrowserSetup;
import com.selenium.utilities.PropertyReader;


public class DeleteClassTestCase extends BrowserSetup{
	ClassesPage classesTab;
	 LoginPage loginPage;
	 JavascriptExecutor js;
	 UsersPage usersPage;
	 AdminDashboardPage adminDashboardPage;
	 
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
			  	test1 = extent.createTest("Delete Class - Admin Login", "Test to validate Delete Class Functinality");
			  	test1.log(Status.INFO, "Starting test case");
			  	driver.get(PropertyReader.getProperties("url"));
				loginPage = new LoginPage(driver);
				classesTab = new ClassesPage(driver);
				
				//       check page title
	            loginPage.checkPageTitle();
	            test1.pass("Login Page Title is correct");

	            //    validation of fields
	            loginPage.usernameValidation();
	            loginPage.passwordValidation();
	            loginPage.sessionValidation();
	            test1.pass("Username is Editable");
	            test1.pass("Password is Editable");
	            test1.pass("Session is Editable");

	            // 		entering data
	            loginPage.enterUserName(PropertyReader.getProperties("admin_username"));
	            loginPage.enterPassword(PropertyReader.getProperties("admin_password"));
	            loginPage.setSelectSessionDropDownListField(PropertyReader.getProperties("admin_session"));
	            test1.pass("Username is Entered");
	            test1.pass("Password is Entered");
	            test1.pass("Session is Selected");
	            Thread.sleep(3000);

	            //   click Sign In button
	            loginPage.clickSignIn();

	            //   		AdminDashboard
	            adminDashboardPage = new AdminDashboardPage(driver);
	            Thread.sleep(3000);
	            adminDashboardPage.checkPageTitle();
	            test1.pass("Admin Dashboard Page Title is Correct");
	            adminDashboardPage.clickAddClassesAddNewClassesLink();
	            test1.pass("Admin clicked Add Classes Card");
				
				//check title
				classesTab.checkPageTitle();
				Thread.sleep(3000);
				
				//classesTab.deleteButton();
				classesTab.deleteClass(PropertyReader.getProperties("delete_class_id"));
				Thread.sleep(3000);
				test1.pass("Clicked Delete button for a class");
				
				//close dialog box
				classesTab.clickCloseButton();
				Thread.sleep(3000);
				
				//logout
				classesTab.clickLogoutDropDown();
				classesTab.clickSignOutLink();
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
