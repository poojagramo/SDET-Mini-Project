package com.selenium.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddFlexibleHeadsPage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "button.btn.btn-success.btn-block")
    @CacheLookup
    private WebElement addFlexibleFeeHead;

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

    @FindBy(id = "flexibleHeadName")
    @CacheLookup
    private WebElement flexibleFeeHeadName;

    @FindBy(css = "a.nav-link.text-light.lead.pl-1.ml-0.border.border-light.border-left-0.border-bottom-0.border-top-0")
    @CacheLookup
    private WebElement homeFeeManagementSystem;

    private final String pageLoadedText = "Flexible fee heads (applicable on individual students according to the facilities they avail, like bus, canteen, etcetera) can be added student wise in every session (as per the requirement)";

    private final String pageUrl = "/fms/ACCOUNTS/masters/add_flexible_heads.php";

    @FindBy(css = "button.btn.btn-info.btn-block")
    @CacheLookup
    private WebElement reset;

    @FindBy(css = "a[href='http://localhost/fms/php/signout.php']")
    @CacheLookup
    private WebElement signOut;
    
    @FindBy(id = "addedModal")
    @CacheLookup
    private WebElement modal;
    
    @FindBy(id = "bd-versions")
    @CacheLookup
    private WebElement dropdown;
    
    @FindBy(tagName="a")
    private List<WebElement> userType;

    public AddFlexibleHeadsPage() {
    }

    public AddFlexibleHeadsPage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AddFlexibleHeadsPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public AddFlexibleHeadsPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }

    /**
     * Click on Add Flexible Fee Head Button.
     *
     * @return the AddFlexibleHeadsPage class instance.
     */
    public AddFlexibleHeadsPage clickAddFlexibleFeeHeadButton() {
        addFlexibleFeeHead.click();
        return this;
    }

    /**
     * Click on Bootstrap Link.
     *
     * @return the AddFlexibleHeadsPage class instance.
     */
    public AddFlexibleHeadsPage clickBootstrapLink() {
        bootstrap.click();
        return this;
    }

    /**
     * Click on Dashboard Accountss Dashboard Link.
     *
     * @return the AddFlexibleHeadsPage class instance.
     */
    public AddFlexibleHeadsPage clickDashboardAccountssDashboardLink() {
        dashboardAccountssDashboard.click();
        return this;
    }

    /**
     * Click on Edit Profile Link.
     *
     * @return the AddFlexibleHeadsPage class instance.
     */
    public AddFlexibleHeadsPage clickEditProfileLink() {
        editProfile.click();
        return this;
    }

    /**
     * Click on Home Fee Management System Link.
     *
     * @return the AddFlexibleHeadsPage class instance.
     */
    public AddFlexibleHeadsPage clickHomeFeeManagementSystemLink() {
        homeFeeManagementSystem.click();
        return this;
    }

    /**
     * Click on Reset Button.
     *
     * @return the AddFlexibleHeadsPage class instance.
     */
    public AddFlexibleHeadsPage clickResetButton() {
        reset.click();
        return this;
    }

    /**
     * Click on Sign Out Link.
     *
     * @return the AddFlexibleHeadsPage class instance.
     * @throws InterruptedException 
     */
    public AddFlexibleHeadsPage clickSignOutLink() throws InterruptedException {
    	Thread.sleep(3000);
    	modal.click();
    	Thread.sleep(3000);
    	dropdown.click();
        signOut.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the AddFlexibleHeadsPage class instance.
     */
    public AddFlexibleHeadsPage fill() {
        setFlexibleFeeHeadNameTextField();
        setDescriptionTextareaField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the AddFlexibleHeadsPage class instance.
     */
    public AddFlexibleHeadsPage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Description Textarea field.
     *
     * @return the AddFlexibleHeadsPage class instance.
     */
    public AddFlexibleHeadsPage setDescriptionTextareaField() {
        return setDescriptionTextareaField(data.get("DESCRIPTION"));
    }

    /**
     * Set value to Description Textarea field.
     *
     * @return the AddFlexibleHeadsPage class instance.
     */
    public AddFlexibleHeadsPage setDescriptionTextareaField(String descriptionValue) {
        description.sendKeys(descriptionValue);
        return this;
    }

    /**
     * Set default value to Flexible Fee Head Name Text field.
     *
     * @return the AddFlexibleHeadsPage class instance.
     */
    public AddFlexibleHeadsPage setFlexibleFeeHeadNameTextField() {
        return setFlexibleFeeHeadNameTextField(data.get("FLEXIBLE_FEE_HEAD_NAME"));
    }

    /**
     * Set value to Flexible Fee Head Name Text field.
     *
     * @return the AddFlexibleHeadsPage class instance.
     */
    public AddFlexibleHeadsPage setFlexibleFeeHeadNameTextField(String flexibleFeeHeadNameValue) {
        flexibleFeeHeadName.sendKeys(flexibleFeeHeadNameValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the AddFlexibleHeadsPage class instance.
     */
    public AddFlexibleHeadsPage submit() {
        clickAddFlexibleFeeHeadButton();
        return this;
    }
    
    public String getPageTitle() {
    	return driver.getTitle();
    }
    
    public void checkPageTitle() {
    	Assert.assertEquals(getPageTitle(),"FMS | Add Flexible Fee Heads");
    }
    
    public void flexibleFeeHeadNameValidation() {
		 Boolean isEditable = flexibleFeeHeadName.isEnabled() && flexibleFeeHeadName.getAttribute("readonly") == null;
	     assertTrue(isEditable);
	}
    
    public void descriptionValidation() {
		 Boolean isEditable = description.isEnabled() && description.getAttribute("readonly") == null;
	     assertTrue(isEditable);
	}
    
    public EditFlexibleHeadsPage editFlexibleHead(String flexibleId) {
    	EditFlexibleHeadsPage editflexiblepage = new EditFlexibleHeadsPage(driver);
    	editflexiblepage.setFlexibleFeeHeadNameTextField(data.get("FLEXIBLE_HEAD_NAME_EDIT"));
    	editflexiblepage.setDescriptionTextareaField(data.get("FLEXIBLE_HEAD_DESC_EDIT"));
    	editflexiblepage.clickUpdateFlexibleFeeHeadButton();
    	return editflexiblepage;
    }
    
    public EditFlexibleHeadsPage editFlexibleHead() {
    	EditFlexibleHeadsPage editFlexibleHeadsPage = null;
	    for (WebElement option :userType)
	    {
	    	if(option.getAttribute("href").contains("edit_flexible_heads.php")) {
	    		if(option.getAttribute("href").contains("flexibleId="+data.get("FLEXIBLE_HEAD_ID_EDIT"))) {
	    			option.click();
	    			editFlexibleHeadsPage=editFlexibleHead(data.get("FLEXIBLE_HEAD_ID_EDIT"));
	    			break;
	    		}
	    	}
	    } 
	    return editFlexibleHeadsPage;
    }
    
    public void deleteFlexibleHead(String flexibleId) {
	    for (WebElement option :userType)
	    {
	    	if(option.getAttribute("href").contains("delete_flexible_heads.php")) {
	    		if(option.getAttribute("href").contains("flexibleId="+flexibleId)) {
	    			option.click();
	    			break;
	    		}
	    	}
	    } 
    }
}
