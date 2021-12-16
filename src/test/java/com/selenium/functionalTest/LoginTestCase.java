package com.selenium.functionalTest;

import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.selenium.pages.AdminDashboardPage;
import com.selenium.pages.LoginPage;
import com.selenium.utilities.BrowserSetup;
import com.selenium.utilities.PropertyReader;

public class LoginTestCase extends BrowserSetup {
    LoginPage loginPage;
    AdminDashboardPage admin;

    @BeforeClass
    public void beforeMethod() {
        htmlReporter = new ExtentSparkReporter("files\\ExtentReports\\" + this.getClass().getSimpleName() + "Report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test
    public void loginTestCase() {
        try {
            BrowserSetup.setup("chrome");
            test1 = extent.createTest("Valid Login", "Test to validate Login Functionality Using Correct Username & Password");
            test1.log(Status.INFO, "Starting test case");
            driver.get(PropertyReader.getProperties("url"));

            loginPage = new LoginPage(driver);
            admin = new AdminDashboardPage(driver);

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

            //	  entering data
            loginPage.enterUserName(PropertyReader.getProperties("admin_username"));
            loginPage.enterPassword(PropertyReader.getProperties("admin_password"));
            loginPage.setSelectSessionDropDownListField(PropertyReader.getProperties("admin_session"));
            test1.pass("Username is Entered");
            test1.pass("Password is Entered");
            test1.pass("Session is Selected");
            Thread.sleep(3000);

            //   click Sign In button
            loginPage.clickSignIn();
            admin.clickSignOutLink();
            
            driver.close();
            Reporter.log("Driver Closed After Testing");
            test1.pass("Closed the browser");
            test1.info("Test completed");
            driver.quit();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
    	driver.quit();
        extent.flush();

    }
}