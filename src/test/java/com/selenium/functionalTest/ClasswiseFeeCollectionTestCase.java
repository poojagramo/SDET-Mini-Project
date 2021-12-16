package com.selenium.functionalTest;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.selenium.pages.LoginPage;
import com.selenium.pages.ManagementDashboardPage;
import com.selenium.utilities.BrowserSetup;
import com.selenium.utilities.PropertyReader;

public class ClasswiseFeeCollectionTestCase extends BrowserSetup {

    LoginPage loginPage;
    ManagementDashboardPage managementDashboard;
    @BeforeTest
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
    public void ViewClasswiseFeeCollection() {
        try {
            test1 = extent.createTest(" Classwise Fee Heads - Management Login", "Test to validate Classwise Fee Heads Card Functinality");
            test1.log(Status.INFO, "Starting test case");
            driver.get(PropertyReader.getProperties("url"));
            loginPage = new LoginPage(driver);

            //    check page title

            loginPage.checkPageTitle();
            test1.pass("Login Page Title is correct");

            //    validation of fields
            loginPage.usernameValidation();
            loginPage.passwordValidation();
            loginPage.sessionValidation();
            test1.pass("Username is Editable");
            test1.pass("Password is Editable");
            test1.pass("Session is Editable");

            //		  entering data
            loginPage.enterUserName(PropertyReader.getProperties("management_username"));
            loginPage.enterPassword(PropertyReader.getProperties("management_password"));
            loginPage.setSelectSessionDropDownListField(PropertyReader.getProperties("admin_session"));
            test1.pass("Username is Entered");
            test1.pass("Password is Entered");
            test1.pass("Session is Selected");
            Thread.sleep(3000);

            //   click Sign In button
            loginPage.clickSignIn();

            //		ManagementDashboard
            managementDashboard = new ManagementDashboardPage(driver);
            Thread.sleep(3000);
            //	assert title
            managementDashboard.checkPageTitle();
            test1.pass("Management Dashboard Page Title is Correct");
            //verify card present
            managementDashboard.ClasswiseFeeCardPresent();
            test1.pass("Classwise Fee Heads Card is Present ");
            //open view static heads card
            managementDashboard.clickClasswiseFeeCollectionViewTheLink();
            Thread.sleep(3000);
            test1.pass("Classwise Fee Heads Card is Clicked ");
            //verify title of view flexible heads
            managementDashboard.verifyTitleOfClasswiseFeeCollection();
            test1.pass("Classwise Fee Heads Card Title is Correct ");
            //verify the table is present
            managementDashboard.verifyTableViewClasswiseFee();
            test1.pass(" Classwise Fee Heads Table is Present ");

            //signout
            managementDashboard.clickSignOutLink();

            Reporter.log("Driver Closed After Testing");
            test1.pass("Closed the browser");
            test1.info("Test completed");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}