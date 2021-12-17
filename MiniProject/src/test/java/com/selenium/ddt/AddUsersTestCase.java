package com.selenium.ddt;

import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pages.AdminDashboardPage;
import com.selenium.pages.LoginPage;
import com.selenium.pages.UsersPage;
import com.selenium.utilities.BrowserSetup;
import com.selenium.utilities.PropertyReader;
import com.selenium.utilities.ReadExcelFile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AddUsersTestCase extends BrowserSetup {
    LoginPage loginPage;
    UsersPage usersPage;
    AdminDashboardPage adminDashboardPage;
    private Map < String, String > vars;

    @Test(dataProvider = "testdata")
    public void demoClass(String userId, String firstName, String lastName, String accountType) throws InterruptedException {
        try {
            test1 = extent.createTest("Add Users - Admin Login", "Test to validate add users functionality");
            test1.log(Status.INFO, "Starting test case");
            driver.get(PropertyReader.getProperties("url"));
            vars.put("USER_ID", userId);
            vars.put("FIRST_NAME", firstName);
            vars.put("LAST_NAME", lastName);
            vars.put("SESSION", accountType);

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
            adminDashboardPage.clickAddUsersAddNewUsersLink();
            test1.pass("Clicked on Add Users Card");

            //			UsersPages
            usersPage = new UsersPage(driver, vars);
            usersPage.userIdValidation();
            usersPage.firstNameValidation();
            usersPage.lastNameValidation();
            test1.pass("Data from Excel Sheet entered with validation");
            usersPage.fillAndSubmit();
            test1.pass("Clicked Add Button");
            
            //	    Sign-out
            usersPage = usersPage.clickSignOutLink();
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
        ReadExcelFile configuration = new ReadExcelFile("files/newUserDetails.xlsx");
        int rows = configuration.getRowCount(0);
        Object[][] new_user_credentials = new Object[rows][4];

        for (int i = 0; i < rows; i++) {
            new_user_credentials[i][0] = configuration.getData(0, i, 0);
            new_user_credentials[i][1] = configuration.getData(0, i, 1);
            new_user_credentials[i][2] = configuration.getData(0, i, 2);
            new_user_credentials[i][3] = configuration.getData(0, i, 3);
        }
        return new_user_credentials;
    }

}