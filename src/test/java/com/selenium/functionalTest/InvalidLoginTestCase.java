package com.selenium.functionalTest;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class InvalidLoginTestCase extends BrowserSetup {
    LoginPage loginPage;
    AdminDashboardPage admin;

    @BeforeClass
    public void beforeMethod() {
        htmlReporter = new ExtentSparkReporter("files\\ExtentReports\\" + this.getClass().getSimpleName() + "Report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test
    public void invalidLoginTestCase() throws IOException, InterruptedException {
//        try {
            BrowserSetup.setup("chrome");
            test1 = extent.createTest("Invalid Login", "Test to validate Login Functionality Using Incorrect Username & Password");
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

            loginPage.enterUserName(PropertyReader.getProperties("wrong_username"));
            loginPage.enterPassword(PropertyReader.getProperties("admin_password"));
            loginPage.setSelectSessionDropDownListField(PropertyReader.getProperties("admin_session"));
            test1.pass("Incorrect Username is Entered");
            test1.pass("Password is Entered");
            test1.pass("Session is Selected");
            Thread.sleep(3000);

            //   click Sign In button
            loginPage.clickSignIn();

            //			loginPage.checkAdminPageTitle();
            @SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dashboard")));

//        } catch (TimeoutException e) {
//            e.printStackTrace();
            driver.close();
            test1.fail("aaa");
//            driver.close();
//            extent.flush();
            Reporter.log("Driver Closed After Testing");
            test1.pass("Closed the browser");
            test1.info("Test completed");
            driver.quit();
//        }

    }
    @AfterClass
    public void tearDown() {
        extent.flush();

    }
}