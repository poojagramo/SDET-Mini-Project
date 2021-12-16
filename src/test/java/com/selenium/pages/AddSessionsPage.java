package com.selenium.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddSessionsPage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

//    @FindBy(css = "div.container-fluid.px-5:nth-child(2) div.row.pt-5:nth-child(1) div.col-lg-4.ml-sm-auto form.px-3.py-3.form > button.btn.btn-success.btn-block:nth-child(3)")
    @FindBy(xpath = "//button[contains(text(),'Add')]")
    @CacheLookup
    private WebElement add;

    @FindBy(css = "a[href='http://getbootstrap.com/']")
    @CacheLookup
    private WebElement bootstrap;

    @FindBy(css = "a[href='http://localhost/fms/ADMIN/index.php']")
    @CacheLookup
    private WebElement dashboardAdminsDashboard;

    @FindBy(css = "a[href='http://www.onlinegurujee.in/nitindeepak/']")
    @CacheLookup
    private WebElement drNitinDeepak;

    @FindBy(css = "a[href='http://localhost/fms/php/edit_profile.php']")
    @CacheLookup
    private WebElement editProfile;

    @FindBy(css = "a.nav-link.text-light.lead.pl-1.ml-0.border.border-light.border-left-0.border-bottom-0.border-top-0")
    @CacheLookup
    private WebElement homeFeeManagementSystem;

    private final String pageLoadedText = "List of already added sessions";

    private final String pageUrl = "/fms/admin/masters/add_sessions.php";

    @FindBy(css = "button.btn.btn-info.btn-block")
    @CacheLookup
    private WebElement reset;

    @FindBy(id = "sessionStart")
    @CacheLookup
    private WebElement selectSessionStartYear;

    @FindBy(id = "sessionEnd")
    @CacheLookup
    private WebElement sessionEndYear;

    @FindBy(css = "a[href='http://localhost/fms/php/signout.php']")
    @CacheLookup
    private WebElement signOut;
    
    @FindBy(id = "addedModal")
    @CacheLookup
    private WebElement modal;
    
    @FindBy(id = "bd-versions")
    @CacheLookup
    private WebElement dropdown;

    public AddSessionsPage() {
    }

    public AddSessionsPage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AddSessionsPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public AddSessionsPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }

    /**
     * Click on Add Button.
     *
     * @return the AddSessions class instance.
     */
    public AddSessionsPage clickAddButton() {
        add.click();
        return this;
    }

    /**
     * Click on Bootstrap Link.
     *
     * @return the AddSessions class instance.
     */
    public AddSessionsPage clickBootstrapLink() {
        bootstrap.click();
        return this;
    }

    /**
     * Click on Dashboard Admins Dashboard Link.
     *
     * @return the AddSessions class instance.
     */
    public AddSessionsPage clickDashboardAdminsDashboardLink() {
        dashboardAdminsDashboard.click();
        return this;
    }

    /**
     * Click on Dr. Nitin Deepak Link.
     *
     * @return the AddSessions class instance.
     */
    public AddSessionsPage clickDrNitinDeepakLink() {
        drNitinDeepak.click();
        return this;
    }

    /**
     * Click on Edit Profile Link.
     *
     * @return the AddSessions class instance.
     */
    public AddSessionsPage clickEditProfileLink() {
        editProfile.click();
        return this;
    }

    /**
     * Click on Home Fee Management System Link.
     *
     * @return the AddSessions class instance.
     */
    public AddSessionsPage clickHomeFeeManagementSystemLink() {
        homeFeeManagementSystem.click();
        return this;
    }

    /**
     * Click on Reset Button.
     *
     * @return the AddSessions class instance.
     */
    public AddSessionsPage clickResetButton() {
        reset.click();
        return this;
    }

    /**
     * Click on Sign Out Link.
     *
     * @return the AddSessions class instance.
     * @throws InterruptedException 
     */
    public AddSessionsPage clickSignOutLink() throws InterruptedException {
    	Thread.sleep(1000);
    	modal.click();
    	Thread.sleep(1000);
    	dropdown.click();
    	Thread.sleep(1000);
        signOut.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the AddSessions class instance.
     * @throws InterruptedException 
     */
    public AddSessionsPage fill() throws InterruptedException {
    	String s = data.get("SELECT_SESSION_START_YEAR");
        System.out.println(s);
        setSelectSessionStartYearDropDownListField();
//        setSessionEndYearTextField();
        Thread.sleep(2000);
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the AddSessions class instance.
     * @throws InterruptedException 
     */
    public AddSessionsPage fillAndSubmit() throws InterruptedException {
        fill();
        Thread.sleep(2000);
        return submit();
    }

    /**
     * Set default value to Select Session Start Year Drop Down List field.
     *
     * @return the AddSessions class instance.
     */
    public AddSessionsPage setSelectSessionStartYearDropDownListField() {
        return setSelectSessionStartYearDropDownListField(data.get("SELECT_SESSION_START_YEAR"));
    }

    /**
     * Set value to Select Session Start Year Drop Down List field.
     *
     * @return the AddSessions class instance.
     */
    public AddSessionsPage setSelectSessionStartYearDropDownListField(String selectSessionStartYearValue) {
        new Select(selectSessionStartYear).selectByVisibleText(selectSessionStartYearValue);
        return this;
    }

    /**
     * Set default value to Session End Year Text field.
     *
     * @return the AddSessions class instance.
     */
    public AddSessionsPage setSessionEndYearTextField() {
        return setSessionEndYearTextField(data.get("SESSION_END_YEAR"));
    }

    /**
     * Set value to Session End Year Text field.
     *
     * @return the AddSessions class instance.
     */
    public AddSessionsPage setSessionEndYearTextField(String sessionEndYearValue) {
        sessionEndYear.sendKeys(sessionEndYearValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the AddSessions class instance.
     * @throws InterruptedException 
     */
    public AddSessionsPage submit() throws InterruptedException {
    	Thread.sleep(2000);
        clickAddButton();
        return this;
    }

    /**
     * Unset default value from Select Session Start Year Drop Down List field.
     *
     * @return the AddSessions class instance.
     */
    public AddSessionsPage unsetSelectSessionStartYearDropDownListField() {
        return unsetSelectSessionStartYearDropDownListField(data.get("SELECT_SESSION_START_YEAR"));
    }

    /**
     * Unset value from Select Session Start Year Drop Down List field.
     *
     * @return the AddSessions class instance.
     */
    public AddSessionsPage unsetSelectSessionStartYearDropDownListField(String selectSessionStartYearValue) {
        new Select(selectSessionStartYear).deselectByVisibleText(selectSessionStartYearValue);
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the AddSessions class instance.
     */
    public AddSessionsPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the AddSessions class instance.
     */
    public AddSessionsPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
    
    public String getPageTitle() {
    	return driver.getTitle();
    }
    
    public void checkPageTitle() {
    	Assert.assertEquals(getPageTitle(),"FMS | Homepage");
    }
    public void checkAddSessionsTitle() {
    	Assert.assertEquals(getPageTitle(),"FMS | Add Sessions");
    }
    
    public void startYearValidation() {
   	 Boolean isEditable = selectSessionStartYear.isEnabled() && selectSessionStartYear.getAttribute("readonly") == null;
	      assertTrue(isEditable);
	}
    public void endYearValidation() {
      	 Boolean isEditable = sessionEndYear.isEnabled() && sessionEndYear.getAttribute("readonly") == null;
   	      assertFalse(isEditable);
   	}
}
