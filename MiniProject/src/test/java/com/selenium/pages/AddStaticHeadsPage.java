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

public class AddStaticHeadsPage {
	private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "button.btn.btn-success.btn-block")
    @CacheLookup
    private WebElement addStaticFeeHead;

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

    private final String pageLoadedText = "Static fee heads (fee heads that are enforced on everyone) can be added class wise whenever needed in every session (as per the requirement)";

    private final String pageUrl = "/fms/ACCOUNTS/masters/add_static_heads.php";

    @FindBy(css = "button.btn.btn-info.btn-block")
    @CacheLookup
    private WebElement reset;

    @FindBy(css = "a[href='http://localhost/fms/php/signout.php']")
    @CacheLookup
    private WebElement signOut;

    @FindBy(id = "staticHeadName")
    @CacheLookup
    private WebElement staticFeeHeadName;
    
    @FindBy(id = "addedModal")
    @CacheLookup
    private WebElement modal;
    
    @FindBy(id = "bd-versions")
    @CacheLookup
    private WebElement dropdown;
    
    @FindBy(tagName="a")
    private List<WebElement> userType;

    public AddStaticHeadsPage() {
    }

    public AddStaticHeadsPage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AddStaticHeadsPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public AddStaticHeadsPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }

    /**
     * Click on Add Static Fee Head Button.
     *
     * @return the AddStaticHeadsPage class instance.
     */
    public AddStaticHeadsPage clickAddStaticFeeHeadButton() {
        addStaticFeeHead.click();
        return this;
    }

    /**
     * Click on Bootstrap Link.
     *
     * @return the AddStaticHeadsPage class instance.
     */
    public AddStaticHeadsPage clickBootstrapLink() {
        bootstrap.click();
        return this;
    }

    /**
     * Click on Dashboard Accountss Dashboard Link.
     *
     * @return the AddStaticHeadsPage class instance.
     */
    public AddStaticHeadsPage clickDashboardAccountssDashboardLink() {
        dashboardAccountssDashboard.click();
        return this;
    }

    /**
     * Click on Dr. Nitin Deepak Link.
     *
     * @return the AddStaticHeadsPage class instance.
     */
    public AddStaticHeadsPage clickDrNitinDeepakLink() {
        drNitinDeepak.click();
        return this;
    }

    /**
     * Click on Edit Profile Link.
     *
     * @return the AddStaticHeadsPage class instance.
     */
    public AddStaticHeadsPage clickEditProfileLink() {
        editProfile.click();
        return this;
    }

    /**
     * Click on Home Fee Management System Link.
     *
     * @return the AddStaticHeadsPage class instance.
     */
    public AddStaticHeadsPage clickHomeFeeManagementSystemLink() {
        homeFeeManagementSystem.click();
        return this;
    }

    /**
     * Click on Reset Button.
     *
     * @return the AddStaticHeadsPage class instance.
     */
    public AddStaticHeadsPage clickResetButton() {
        reset.click();
        return this;
    }
    
    public AddStaticHeadsPage clickModal() throws InterruptedException {
    	Thread.sleep(3000);
    	modal.click();
    	return this;
    }

    /**
     * Click on Sign Out Link.
     *
     * @return the AddStaticHeadsPage class instance.
     * @throws InterruptedException 
     */
    public AddStaticHeadsPage clickSignOutLink() throws InterruptedException {
    	clickModal();
    	Thread.sleep(3000);
    	dropdown.click();
        signOut.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the AddStaticHeadsPage class instance.
     */
    public AddStaticHeadsPage fill() {
        setStaticFeeHeadNameTextField();
        setDescriptionTextareaField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the AddStaticHeadsPage class instance.
     */
    public AddStaticHeadsPage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Description Textarea field.
     *
     * @return the AddStaticHeadsPage class instance.
     */
    public AddStaticHeadsPage setDescriptionTextareaField() {
        return setDescriptionTextareaField(data.get("DESCRIPTION"));
    }

    /**
     * Set value to Description Textarea field.
     *
     * @return the AddStaticHeadsPage class instance.
     */
    public AddStaticHeadsPage setDescriptionTextareaField(String descriptionValue) {
        description.sendKeys(descriptionValue);
        return this;
    }

    /**
     * Set default value to Static Fee Head Name Text field.
     *
     * @return the AddStaticHeadsPage class instance.
     */
    public AddStaticHeadsPage setStaticFeeHeadNameTextField() {
        return setStaticFeeHeadNameTextField(data.get("STATIC_FEE_HEAD_NAME"));
    }

    /**
     * Set value to Static Fee Head Name Text field.
     *
     * @return the AddStaticHeadsPage class instance.
     */
    public AddStaticHeadsPage setStaticFeeHeadNameTextField(String staticFeeHeadNameValue) {
        staticFeeHeadName.sendKeys(staticFeeHeadNameValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the AddStaticHeadsPage class instance.
     */
    public AddStaticHeadsPage submit() {
        clickAddStaticFeeHeadButton();
        return this;
    }
    
    public String getPageTitle() {
    	return driver.getTitle();
    }
    
    public void checkPageTitle() {
    	Assert.assertEquals(getPageTitle(),"FMS | Add Static Fee Heads");
    }
    
    public void staticFeeHeadNameValidation() {
		 Boolean isEditable = staticFeeHeadName.isEnabled() && staticFeeHeadName.getAttribute("readonly") == null;
	     assertTrue(isEditable);
	}
    
    public void descriptionValidation() {
		 Boolean isEditable = description.isEnabled() && description.getAttribute("readonly") == null;
	     assertTrue(isEditable);
	}
    
    public EditStaticHeadsPage editStaticHead(String flexibleId) {
    	EditStaticHeadsPage editStaticPage = new EditStaticHeadsPage(driver);
    	editStaticPage.setStaticFeeHeadNameTextField(data.get("STATIC_HEAD_NAME_EDIT"));
    	editStaticPage.setDescriptionTextareaField(data.get("STATIC_HEAD_DESC_EDIT"));
    	editStaticPage.clickUpdateStaticFeeHeadButton();
    	return editStaticPage;
    }
    
    public EditStaticHeadsPage editStaticHead() {
    	EditStaticHeadsPage editStaticHeadsPage = null;
	    for (WebElement option :userType)
	    {
	    	if(option.getAttribute("href").contains("edit_static_heads.php")) {
	    		if(option.getAttribute("href").contains("staticId="+data.get("STATIC_HEAD_ID_EDIT"))) {
	    			option.click();
	    			editStaticHeadsPage=editStaticHead(data.get("STATIC_HEAD_ID_EDIT"));
	    			break;
	    		}
	    	}
	    }
	    return editStaticHeadsPage;
    }
    
    public void deleteStaticHead(String staticId) {
	    for (WebElement option :userType)
	    {
	    	if(option.getAttribute("href").contains("delete_static_heads.php")) {
	    		if(option.getAttribute("href").contains("staticId="+staticId)) {
	    			option.click();
	    			
	    			break;
	    		}
	    	}
	    } 
    }
   
}
