package com.selenium.functionalTest;

import java.io.IOException;
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
import com.selenium.utilities.BrowserSetup;
import com.selenium.utilities.PropertyReader;

public class AddClassesTestCase extends BrowserSetup {
    ClassesPage classesTab;
    LoginPage loginPage;
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
            test1 = extent.createTest("Add Classes - Admin Login", "Test to validate Add Classes Card Functinality");
            test1.log(Status.INFO, "Starting test case");
            driver.get(PropertyReader.getProperties("url"));
            classesTab = new ClassesPage(driver);
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

            classesTab.classNameValidation();
            classesTab.setClassNameTextField(PropertyReader.getProperties("add_class"));
            test1.pass("Entered a class value from properties file");
            classesTab.clickAddButton();
            test1.pass("Clicked add button");
            Thread.sleep(3000);

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
            e.printStackTrace();
        }
    }
}