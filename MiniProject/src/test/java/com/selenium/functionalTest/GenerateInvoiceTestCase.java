package com.selenium.functionalTest;

import java.io.IOException;
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
import com.selenium.pages.GenerateInvoicePage;
import com.selenium.pages.LoginPage;
import com.selenium.utilities.BrowserSetup;
import com.selenium.utilities.PropertyReader;

public class GenerateInvoiceTestCase extends BrowserSetup{
	LoginPage loginPage;
	AccountsDashboardPage accountsDashboardPage;
	AddSessionsPage addSessionPage;
	GenerateInvoicePage generateInvoice;
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
  public void genrateInvoice() throws InterruptedException {
	  try {
		  	test1 = extent.createTest("Generate Invoice - Accounts Login", "Test to validate Generate Invoice Functinality");
		  	test1.log(Status.INFO, "Starting test case");
			driver.get(PropertyReader.getProperties("url"));
			loginPage = new LoginPage(driver);
			vars.put("SELECT_CLASS",PropertyReader.getProperties("select_class"));
			vars.put("MONTH_FROM",PropertyReader.getProperties("month_from"));
			vars.put("MONTH_TO",PropertyReader.getProperties("month_to"));
			
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
			accountsDashboardPage.clickGenerateInvoicesGenerateInvoicesForLink();
			test1.pass("Accountant clicked on Generate Invoice Card");
			
			//          Generate Invoice 
			generateInvoice = new GenerateInvoicePage(driver,vars);
			generateInvoice.classValidation();
			test1.pass("Class is Editable");
			generateInvoice.monthFromValidation();
			test1.pass("Month From is Editable");
			generateInvoice.monthToValidation();
			test1.pass("Month To is Editable");
			generateInvoice.fill();
			test1.pass("Entered the details to generate the invoice");
			Thread.sleep(3000);
			generateInvoice.clickGenerateInvoicesButton();
			test1.pass("Generate Invoice button is clicked");
			
			Thread.sleep(3000);
			generateInvoice.clickSignOutLink();
			
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
