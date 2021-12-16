package com.selenium.pages;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EditStaticHeadsPage {
	private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "a[href='http://getbootstrap.com/']")
    @CacheLookup
    private WebElement bootstrap;

    @FindBy(css = "a[href='http://localhost/fms/ACCOUNTS/index.php']")
    @CacheLookup
    private WebElement dashboardAccountssDashboard;

    @FindBy(id = "description")
    @CacheLookup
    private WebElement description;

    @FindBy(css = "a[href='http://www.onlinegurujee.in/nitindeepak/']")
    @CacheLookup
    private WebElement drNitinDeepak;

    @FindBy(css = "a[href='http://localhost/fms/php/edit_profile.php']")
    @CacheLookup
    private WebElement editProfile;

    @FindBy(css = "a.nav-link.text-light.lead.pl-1.ml-0.border.border-light.border-left-0.border-bottom-0.border-top-0")
    @CacheLookup
    private WebElement homeFeeManagementSystem;

    private final String pageLoadedText = "The fee to be paid for full body check up";

    private final String pageUrl = "/fms/ACCOUNTS/php/edit_static_heads.php?staticId=6";

    @FindBy(css = "a[href='http://localhost/fms/php/signout.php']")
    @CacheLookup
    private WebElement signOut;

    @FindBy(id = "staticHeadName")
    @CacheLookup
    private WebElement staticFeeHeadName;

    @FindBy(css = "button.btn.btn-success.btn-block")
    @CacheLookup
    private WebElement updateStaticFeeHead;
    
    @FindBy(id = "addedModal")
    @CacheLookup
    private WebElement modal;
    
    @FindBy(id = "bd-versions")
    @CacheLookup
    private WebElement dropdown;


    public EditStaticHeadsPage() {
    }

    public EditStaticHeadsPage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EditStaticHeadsPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public EditStaticHeadsPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }

    /**
     * Click on Bootstrap Link.
     *
     * @return the EditStaticHeadsPage class instance.
     */
    public EditStaticHeadsPage clickBootstrapLink() {
        bootstrap.click();
        return this;
    }

    /**
     * Click on Dashboard Accountss Dashboard Link.
     *
     * @return the EditStaticHeadsPage class instance.
     */
    public EditStaticHeadsPage clickDashboardAccountssDashboardLink() {
        dashboardAccountssDashboard.click();
        return this;
    }

    /**
     * Click on Dr. Nitin Deepak Link.
     *
     * @return the EditStaticHeadsPage class instance.
     */
    public EditStaticHeadsPage clickDrNitinDeepakLink() {
        drNitinDeepak.click();
        return this;
    }

    /**
     * Click on Edit Profile Link.
     *
     * @return the EditStaticHeadsPage class instance.
     */
    public EditStaticHeadsPage clickEditProfileLink() {
        editProfile.click();
        return this;
    }

    /**
     * Click on Home Fee Management System Link.
     *
     * @return the EditStaticHeadsPage class instance.
     */
    public EditStaticHeadsPage clickHomeFeeManagementSystemLink() {
        homeFeeManagementSystem.click();
        return this;
    }

    /**
     * Click on Sign Out Link.
     *
     * @return the EditStaticHeadsPage class instance.
     * @throws InterruptedException 
     */
    public EditStaticHeadsPage clickSignOutLink() throws InterruptedException {
    	Thread.sleep(3000);
    	modal.click();
    	Thread.sleep(3000);
    	dropdown.click();
        signOut.click();
        return this;
    }

    /**
     * Click on Update Static Fee Head Button.
     *
     * @return the EditStaticHeadsPage class instance.
     */
    public EditStaticHeadsPage clickUpdateStaticFeeHeadButton() {
        updateStaticFeeHead.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the EditStaticHeadsPage class instance.
     */
    public EditStaticHeadsPage fill() {
        setStaticFeeHeadNameTextField();
        setDescriptionTextareaField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the EditStaticHeadsPage class instance.
     */
    public EditStaticHeadsPage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Description Textarea field.
     *
     * @return the EditStaticHeadsPage class instance.
     */
    public EditStaticHeadsPage setDescriptionTextareaField() {
        return setDescriptionTextareaField(data.get("DESCRIPTION"));
    }

    /**
     * Set value to Description Textarea field.
     *
     * @return the EditStaticHeadsPage class instance.
     */
    public EditStaticHeadsPage setDescriptionTextareaField(String descriptionValue) {
    	description.clear();
        description.sendKeys(descriptionValue);
        return this;
    }

    /**
     * Set default value to Static Fee Head Name Text field.
     *
     * @return the EditStaticHeadsPage class instance.
     */
    public EditStaticHeadsPage setStaticFeeHeadNameTextField() {
        return setStaticFeeHeadNameTextField(data.get("STATIC_FEE_HEAD_NAME"));
    }

    /**
     * Set value to Static Fee Head Name Text field.
     *
     * @return the EditStaticHeadsPage class instance.
     */
    public EditStaticHeadsPage setStaticFeeHeadNameTextField(String staticFeeHeadNameValue) {
    	staticFeeHeadName.clear();
        staticFeeHeadName.sendKeys(staticFeeHeadNameValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the EditStaticHeadsPage class instance.
     */
    public EditStaticHeadsPage submit() {
        clickUpdateStaticFeeHeadButton();
        return this;
    }
    
    public String getPageTitle() {
    	return driver.getTitle();
    }
    
    public void checkPageTitle() {
    	Assert.assertEquals(getPageTitle(),"FMS | Edit Static Fee Heads");
    }
    
    public void staticFeeHeadNameValidation() {
		 Boolean isEditable = staticFeeHeadName.isEnabled() && staticFeeHeadName.getAttribute("readonly") == null;
	     assertTrue(isEditable);
	}
   
   public void descriptionValidation() {
		 Boolean isEditable = description.isEnabled() && description.getAttribute("readonly") == null;
	     assertTrue(isEditable);
	}

}
