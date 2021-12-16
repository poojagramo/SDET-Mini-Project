package com.selenium.functionalTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.selenium.pages.AdminDashboardPage;
import com.selenium.pages.LoginPage;
import com.selenium.utilities.BrowserSetup;
import com.selenium.utilities.PropertyReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.selenium.pages.AddSessionsPage;

public class AddSessionsTestCase extends BrowserSetup {
    LoginPage loginPage;
    AdminDashboardPage adminDashboardPage;
    AddSessionsPage addSessionPage;
    private Map < String, String > vars;

    @BeforeMethod
    public void beforeMethod() {
        vars = new HashMap < String, String > ();
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
    public void addNewSession() {
        try {
            test1 = extent.createTest("Add Session - Admin Login", "Test to valid Add Session Card Functinality");
            test1.log(Status.INFO, "Starting test case");
            driver.get(PropertyReader.getProperties("url"));
            vars.put("SELECT_SESSION_START_YEAR", PropertyReader.getProperties("addSessionFrom"));

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
            loginPage.setSelectSessionDropDownListField(PropertyReader.getProperties("admin_session"));
            test1.pass("Username is Entered");
            test1.pass("Password is Entered");
            test1.pass("Session is Selected");
            Thread.sleep(3000);


            //   click Sign In button
            loginPage.clickSignIn();


            //AdminDashboard Page
            adminDashboardPage = new AdminDashboardPage(driver);
            Thread.sleep(3000);
            adminDashboardPage.checkPageTitle();
            test1.pass("Admin Dashboard Page Title is Correct");
            adminDashboardPage.clickAddSessionsAddNewSessionsLink();
            test1.pass("Admin clicked on Add Session Card");
            Thread.sleep(2000);

            addSessionPage = new AddSessionsPage(driver, vars);
            //Assert Title
            addSessionPage.checkAddSessionsTitle();
            test1.pass("Add Session Page Title is Correct");
            Thread.sleep(3000);
            //Verify Dropdown fields are Editable
            addSessionPage.startYearValidation();
            test1.pass("Year of new session selected from dropdown");
            addSessionPage.endYearValidation();
            //			
            //Fill the session year
            //			addSessionPage.setSelectSessionStartYearDropDownListField();
            addSessionPage.fill();

            //Sign-out
            addSessionPage.submit();
            test1.pass("Clicked on Add button");
            driver.close();
            Reporter.log("Driver Closed After Testing");
            test1.pass("Closed the browser");
            test1.info("Test completed");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}