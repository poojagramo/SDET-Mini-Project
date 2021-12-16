package com.selenium.ddt;

import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pages.AccountsDashboardPage;
import com.selenium.pages.AddFlexibleHeadsPage;
import com.selenium.pages.LoginPage;
import com.selenium.utilities.BrowserSetup;
import com.selenium.utilities.PropertyReader;
import com.selenium.utilities.ReadExcelFile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AddFlexibleHeadsTestCase extends BrowserSetup{
	LoginPage loginPage;
	AddFlexibleHeadsPage flexibleHead;
	AccountsDashboardPage accountDashboardPage;
	private Map<String, String> vars;

	@Test(dataProvider = "testdata")
	public void demoClass(String flexibleFeeHead, String desc) throws InterruptedException {
		try {
			test1 = extent.createTest("Add Flexible Fee Head - Accounts Login", "Test to validate add flexible fee head functionality");
            test1.log(Status.INFO, "Starting test case");
			driver.get(PropertyReader.getProperties("url"));
			vars.put("FLEXIBLE_FEE_HEAD_NAME",flexibleFeeHead);
			vars.put("DESCRIPTION",desc);
			
			  
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
			accountDashboardPage.clickAddFlexibleHeadsFlexibleFeeLink();
			test1.pass("Clicked on Add Flexible Fee Head Card");
			
			//			Add Flexible head
			flexibleHead = new AddFlexibleHeadsPage(driver,vars);
			flexibleHead.checkPageTitle();
			flexibleHead.flexibleFeeHeadNameValidation();;
			flexibleHead.descriptionValidation();
			flexibleHead.fillAndSubmit();
			test1.pass("Data from Excel Sheet entered with validation");
			test1.pass("Clicked Add Button");
	
			//	    Sign-out
			flexibleHead=flexibleHead.clickSignOutLink();
			driver.close();
			
			Reporter.log("Driver Closed After Testing");
            test1.pass("Closed the browser");
            test1.info("Test completed");

		
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}


	@AfterMethod
    void ProgramTermination() throws InterruptedException {

        driver.quit();
        extent.flush();
    }

	@BeforeMethod
    public void beforeMethod() {
        vars = new HashMap < String, String > ();
        BrowserSetup.setup("Chrome");
        htmlReporter = new ExtentSparkReporter("files\\ExtentReports\\" + this.getClass().getSimpleName() + "Report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

    }

	@DataProvider(name = "testdata")
	public Object[][] testDataExample() {
		ReadExcelFile configuration = new ReadExcelFile("files/flexibleheads.xlsx");
		int rows =configuration.getRowCount(0);
		Object[][] flexibleFeeHeads = new Object[rows][2];

		for (int i = 0; i < rows; i++) {
			flexibleFeeHeads[i][0] = configuration.getData(0, i, 0);
			flexibleFeeHeads[i][1] = configuration.getData(0, i, 1);
		}
		return flexibleFeeHeads;
	}
}
