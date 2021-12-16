package com.selenium.functionalTest;

import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.selenium.pages.*;
import com.selenium.utilities.BrowserSetup;
import com.selenium.utilities.PropertyReader;

public class DeleteUsersTestCase extends BrowserSetup {
    LoginPage loginPage;
    UsersPage usersPage;
    AdminDashboardPage adminDashboardPage;

    @AfterMethod
    void ProgramTermination() throws InterruptedException {

        driver.quit();
        extent.flush();
    }

    @BeforeMethod
    public void beforeMethod() {
        BrowserSetup.setup("Chrome");
        htmlReporter = new ExtentSparkReporter("files\\ExtentReports\\" + this.getClass().getSimpleName() + "Report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

    }
    @Test
    public void deleteUser() throws InterruptedException, IOException {
        test1 = extent.createTest("Delete User - Admin Login", "Test to validate Delet Users Card Functinality");
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


        //	  entering data
        loginPage.enterUserName(PropertyReader.getProperties("admin_username"));
        loginPage.enterPassword(PropertyReader.getProperties("admin_password"));
        loginPage.setSelectSessionDropDownListField("2015-16");
        test1.pass("Username is Entered");
        test1.pass("Password is Entered");
        test1.pass("Session is Selected");
        Thread.sleep(3000);

        //   click Sign In button
        loginPage.clickSignIn();

        //   		AdminDashboard
        adminDashboardPage = new AdminDashboardPage(driver);
        adminDashboardPage.checkPageTitle();
        test1.pass("Admin Dashboard Page Title is Correct");
        adminDashboardPage.clickDeleteUsersDeleteAnExistingLink();
        test1.pass("Admin Clicked on Delet Users Card");

        //         Users Page 
        usersPage = new UsersPage(driver);
        usersPage.checkPageTitle();
        test1.pass("Users Page Title is Correct");
        usersPage.deleteUsers(PropertyReader.getProperties("entryToBeDeleted"));
        test1.pass("User to be deleted is sent through properties file");
        test1.pass("User Deleted successfully");
        driver.close();
        Reporter.log("Driver Closed After Testing");
        test1.pass("Closed the browser");
        test1.info("Test completed");


    }
}