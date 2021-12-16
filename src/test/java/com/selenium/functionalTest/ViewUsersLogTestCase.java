package com.selenium.functionalTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.selenium.pages.*;
import com.selenium.utilities.BrowserSetup;
import com.selenium.utilities.PropertyReader;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

public class ViewUsersLogTestCase extends BrowserSetup {
    LoginPage loginPage;
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
    public void viewUsersLog() {
        try {
            test1 = extent.createTest("View User's Log - Admin Login", "Test to validate view users log card Functinality");
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

            //			  entering data
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
            adminDashboardPage.clickViewUsersLogViewUsersLink();
            test1.pass("Admin Clicked on View Users Log Card");

            //Verify User is on View Logs Page
            adminDashboardPage.verifyTitleOfLogPage();
            test1.pass("View Log Page Title is Correct");
            test1.pass("Logs are visibile");

            driver.close();
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