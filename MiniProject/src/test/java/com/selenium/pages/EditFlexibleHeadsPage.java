package com.selenium.pages;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditFlexibleHeadsPage {
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

    @FindBy(id = "flexibleHeadName")
    @CacheLookup
    private WebElement flexibleFeeHeadName;

    @FindBy(css = "a.nav-link.text-light.lead.pl-1.ml-0.border.border-light.border-left-0.border-bottom-0.border-top-0")
    @CacheLookup
    private WebElement homeFeeManagementSystem;

    private final String pageLoadedText = "Flexible fee heads (applicable on individual students according to the facilities they avail, like bus, canteen, etcetera) can be added student wise in every session (as per the requirement)";

    private final String pageUrl = "/fms/ACCOUNTS/php/edit_flexible_heads.php?flexibleId=8";

    @FindBy(css = "a[href='http://localhost/fms/php/signout.php']")
    @CacheLookup
    private WebElement signOut;

    @FindBy(css = "button.btn.btn-success.btn-block")
    @CacheLookup
    private WebElement updateFlexibleFeeHead;
    
    @FindBy(id = "addedModal")
    @CacheLookup
    private WebElement modal;
    
    @FindBy(id = "bd-versions")
    @CacheLookup
    private WebElement dropdown;

    public EditFlexibleHeadsPage() {
    }

    public EditFlexibleHeadsPage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EditFlexibleHeadsPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public EditFlexibleHeadsPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }

    /**
     * Click on Bootstrap Link.
     *
     * @return the EditFlexibleHeadsPage class instance.
     */
    public EditFlexibleHeadsPage clickBootstrapLink() {
        bootstrap.click();
        return this;
    }

    /**
     * Click on Dashboard Accountss Dashboard Link.
     *
     * @return the EditFlexibleHeadsPage class instance.
     */
    public EditFlexibleHeadsPage clickDashboardAccountssDashboardLink() {
        dashboardAccountssDashboard.click();
        return this;
    }

    /**
     * Click on Dr. Nitin Deepak Link.
     *
     * @return the EditFlexibleHeadsPage class instance.
     */
    public EditFlexibleHeadsPage clickDrNitinDeepakLink() {
        drNitinDeepak.click();
        return this;
    }

    /**
     * Click on Edit Profile Link.
     *
     * @return the EditFlexibleHeadsPage class instance.
     */
    public EditFlexibleHeadsPage clickEditProfileLink() {
        editProfile.click();
        return this;
    }

    /**
     * Click on Home Fee Management System Link.
     *
     * @return the EditFlexibleHeadsPage class instance.
     */
    public EditFlexibleHeadsPage clickHomeFeeManagementSystemLink() {
        homeFeeManagementSystem.click();
        return this;
    }

    /**
     * Click on Sign Out Link.
     *
     * @return the EditFlexibleHeadsPage class instance.
     * @throws InterruptedException 
     */
    public EditFlexibleHeadsPage clickSignOutLink() throws InterruptedException {
    	Thread.sleep(3000);
    	modal.click();
    	Thread.sleep(3000);
    	dropdown.click();
        signOut.click();
        return this;
    }

    /**
     * Click on Update Flexible Fee Head Button.
     *
     * @return the EditFlexibleHeadsPage class instance.
     */
    public EditFlexibleHeadsPage clickUpdateFlexibleFeeHeadButton() {
        updateFlexibleFeeHead.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the EditFlexibleHeadsPage class instance.
     */
    public EditFlexibleHeadsPage fill() {
        setFlexibleFeeHeadNameTextField();
        setDescriptionTextareaField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the EditFlexibleHeadsPage class instance.
     */
    public EditFlexibleHeadsPage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Description Textarea field.
     *
     * @return the EditFlexibleHeadsPage class instance.
     */
    public EditFlexibleHeadsPage setDescriptionTextareaField() {
        return setDescriptionTextareaField(data.get("DESCRIPTION"));
    }

    /**
     * Set value to Description Textarea field.
     *
     * @return the EditFlexibleHeadsPage class instance.
     */
    public EditFlexibleHeadsPage setDescriptionTextareaField(String descriptionValue) {
    	description.clear();
        description.sendKeys(descriptionValue);
        return this;
    }

    /**
     * Set default value to Flexible Fee Head Name Text field.
     *
     * @return the EditFlexibleHeadsPage class instance.
     */
    public EditFlexibleHeadsPage setFlexibleFeeHeadNameTextField() {
        return setFlexibleFeeHeadNameTextField(data.get("FLEXIBLE_FEE_HEAD_NAME"));
    }

    /**
     * Set value to Flexible Fee Head Name Text field.
     *
     * @return the EditFlexibleHeadsPage class instance.
     */
    public EditFlexibleHeadsPage setFlexibleFeeHeadNameTextField(String flexibleFeeHeadNameValue) {
    	flexibleFeeHeadName.clear();
        flexibleFeeHeadName.sendKeys(flexibleFeeHeadNameValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the EditFlexibleHeadsPage class instance.
     */
    public EditFlexibleHeadsPage submit() {
        clickUpdateFlexibleFeeHeadButton();
        return this;
    }


}

