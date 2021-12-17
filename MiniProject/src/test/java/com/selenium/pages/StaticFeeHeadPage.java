package com.selenium.pages;
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

public class StaticFeeHeadPage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(id="bd-versions")
    @CacheLookup
    private  WebElement logoutDropdown;
    
    @FindBy(css = "button.btn.btn-danger")
    @CacheLookup
    private WebElement close;

    @FindBy(css = "button.btn.btn-success.btn-block")
    @CacheLookup
    private WebElement associate;

    @FindBy(css = "a[href='http://getbootstrap.com/']")
    @CacheLookup
    private WebElement bootstrap;

    @FindBy(css = "a[href='http://localhost/fms/ACCOUNTS/index.php']")
    @CacheLookup
    private WebElement dashboardAccountssDashboard;

    @FindBy(css = "a[href='http://www.onlinegurujee.in/nitindeepak/']")
    @CacheLookup
    private WebElement drNitinDeepak;

    @FindBy(css = "a[href='http://localhost/fms/php/edit_profile.php']")
    @CacheLookup
    private WebElement editProfile;

    @FindBy(css = "a.nav-link.text-light.lead.pl-1.ml-0.border.border-light.border-left-0.border-bottom-0.border-top-0")
    @CacheLookup
    private WebElement homeFeeManagementSystem;

    private final String pageLoadedText = "Last modified: Monday, 13 December 2021, 12:41:07 PM";

    private final String pageUrl = "/fms/accounts/masters/associate_static_heads.php";

    @FindBy(css = "button.btn.btn-info.btn-block")
    @CacheLookup
    private WebElement reset;

    @FindBy(id = "classId")
    @CacheLookup
    private WebElement selectClass;

    @FindBy(id = "staticHeadId")
    @CacheLookup
    private WebElement selectStaticFeeHead;

    @FindBy(id = "sessionId")
    @CacheLookup
    private WebElement session;

    @FindBy(css = "a[href='http://localhost/fms/php/signout.php']")
    @CacheLookup
    private WebElement signOut;

    @FindBy(id = "staticHeadAmount")
    @CacheLookup
    private WebElement staticFeeHeadAmount;

    public StaticFeeHeadPage() {
    }

    public StaticFeeHeadPage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public StaticFeeHeadPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public StaticFeeHeadPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }

    /**
     * Click on Associate Button.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage clickAssociateButton() {
        associate.click();
        return this;
    }

    /**
     * Click on Bootstrap Link.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage clickBootstrapLink() {
        bootstrap.click();
        return this;
    }

    /**
     * Click on Dashboard Accountss Dashboard Link.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage clickDashboardAccountssDashboardLink() {
        dashboardAccountssDashboard.click();
        return this;
    }

    /**
     * Click on Dr. Nitin Deepak Link.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage clickDrNitinDeepakLink() {
        drNitinDeepak.click();
        return this;
    }

    /**
     * Click on Edit Profile Link.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage clickEditProfileLink() {
        editProfile.click();
        return this;
    }

    /**
     * Click on Home Fee Management System Link.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage clickHomeFeeManagementSystemLink() {
        homeFeeManagementSystem.click();
        return this;
    }

    /**
     * Click on Reset Button.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage clickResetButton() {
        reset.click();
        return this;
    }

    /**
     * Click on Sign Out Link.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage clickSignOutLink() {
        signOut.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage fill() {
        setSessionTextField();
        setSelectClassDropDownListField();
        setSelectStaticFeeHeadDropDownListField();
        setStaticFeeHeadAmountTextField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Select Class Drop Down List field.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage setSelectClassDropDownListField() {
        return setSelectClassDropDownListField(data.get("SELECT_CLASS"));
    }

    /**
     * Set value to Select Class Drop Down List field.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage setSelectClassDropDownListField(String selectClassValue) {
        new Select(selectClass).selectByVisibleText(selectClassValue);
        return this;
    }

    /**
     * Set default value to Select Static Fee Head Drop Down List field.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage setSelectStaticFeeHeadDropDownListField() {
        return setSelectStaticFeeHeadDropDownListField(data.get("SELECT_STATIC_FEE_HEAD"));
    }

    /**
     * Set value to Select Static Fee Head Drop Down List field.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage setSelectStaticFeeHeadDropDownListField(String selectStaticFeeHeadValue) {
        new Select(selectStaticFeeHead).selectByVisibleText(selectStaticFeeHeadValue);
        return this;
    }

    /**
     * Set default value to Session Text field.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage setSessionTextField() {
        return setSessionTextField(data.get("SESSION"));
    }

    /**
     * Set value to Session Text field.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage setSessionTextField(String sessionValue) {
        session.sendKeys(sessionValue);
        return this;
    }

    /**
     * Set default value to Static Fee Head Amount Text field.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage setStaticFeeHeadAmountTextField() {
        return setStaticFeeHeadAmountTextField(data.get("STATIC_FEE_HEAD_AMOUNT"));
    }

    /**
     * Set value to Static Fee Head Amount Text field.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage setStaticFeeHeadAmountTextField(String staticFeeHeadAmountValue) {
        staticFeeHeadAmount.sendKeys(staticFeeHeadAmountValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage submit() {
        clickAssociateButton();
        return this;
    }

    /**
     * Unset default value from Select Class Drop Down List field.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage unsetSelectClassDropDownListField() {
        return unsetSelectClassDropDownListField(data.get("SELECT_CLASS"));
    }

    /**
     * Unset value from Select Class Drop Down List field.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage unsetSelectClassDropDownListField(String selectClassValue) {
        new Select(selectClass).deselectByVisibleText(selectClassValue);
        return this;
    }

    /**
     * Unset default value from Select Static Fee Head Drop Down List field.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage unsetSelectStaticFeeHeadDropDownListField() {
        return unsetSelectStaticFeeHeadDropDownListField(data.get("SELECT_STATIC_FEE_HEAD"));
    }

    /**
     * Unset value from Select Static Fee Head Drop Down List field.
     *
     * @return the staticFeeHead class instance.
     */
    public StaticFeeHeadPage unsetSelectStaticFeeHeadDropDownListField(String selectStaticFeeHeadValue) {
        new Select(selectStaticFeeHead).deselectByVisibleText(selectStaticFeeHeadValue);
        return this;
    }


//    public void amountValidation() {
//		 Boolean isEditable = staticFeeHeadAmount.isEnabled() && staticFeeHeadAmount.getAttribute("readonly") == null;
//	      assertTrue(isEditable);
//	}
//    
//    //Page title
//    public String getPageTitle() {
//    	return driver.getTitle();
//    }
//    
//    public void checkPageTitle() {
//    	Assert.assertEquals(getPageTitle(),"FMS | Associate Static Fee Heads");
//    }
//
    public StaticFeeHeadPage close() {
    	close.click();
    	return this;
    }
//    
//    
//    //logout dropdown
    public StaticFeeHeadPage clickLogoutDropDown() {
    	logoutDropdown.click();
    	return this;
    }
    
}
