package com.selenium.pages;
import com.selenium.utilities.*;
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
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProfilePage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "a[href='http://getbootstrap.com/']")
    @CacheLookup
    private WebElement bootstrap;

    @FindBy(id = "changePassword")
    @CacheLookup
    private WebElement changePassword;

    @FindBy(css = "a[href='http://localhost/fms/MANAGEMENT/index.php']")
    @CacheLookup
    private WebElement dashboardManagementsDashboard;

    @FindBy(css = "a[href='http://www.onlinegurujee.in/nitindeepak/']")
    @CacheLookup
    private WebElement drNitinDeepak;

    @FindBy(css = "a[href='http://localhost/fms/php/edit_profile.php']")
    @CacheLookup
    private WebElement editProfile;

    @FindBy(id = "firstName")
    @CacheLookup
    private WebElement firstName;

    @FindBy(css = "a.nav-link.text-light.lead.pl-1.ml-0.border.border-light.border-left-0.border-bottom-0.border-top-0")
    @CacheLookup
    private WebElement homeFeeManagementSystem;

    @FindBy(id = "lastName")
    @CacheLookup
    private WebElement lastName;

    private final String pageLoadedText = "Last modified: Tuesday, 7 December 2021, 10:26:37 AM";

    private final String pageUrl = "/fms/php/edit_profile.php";

    @FindBy(id = "password")
    @CacheLookup
    private WebElement password;

    @FindBy(css = "button.btn.btn-info.btn-lg.mt-5.ml-2")
    @CacheLookup
    private WebElement reset;

    @FindBy(name = "submitImage")
    @CacheLookup
    private WebElement saveChanges;

    @FindBy(id = "userThumbnail")
    @CacheLookup
    private WebElement selectUsersThumbnail;

    @FindBy(css = "a[href='http://localhost/fms/php/signout.php']")
    @CacheLookup
    private WebElement signOut;

    @FindBy(id = "userid")
    @CacheLookup
    private WebElement userId;
    
    @FindBy(tagName= "title")
    WebElement header;
    
    @FindBy(id = "bd-versions")
    @CacheLookup
    private WebElement dropdown;

    public EditProfilePage() {
    }

    public EditProfilePage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EditProfilePage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public EditProfilePage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }


    /**
     * Click on Change Password Button.
     *
     * @return the EditProfilePage class instance.
     */
    public EditProfilePage clickChangePasswordButton() {
        changePassword.click();
        return this;
    }

    /**
     * Click on Dashboard Managements Dashboard Link.
     *
     * @return the EditProfilePage class instance.
     */
    public EditProfilePage clickDashboardManagementsDashboardLink() {
        dashboardManagementsDashboard.click();
        return this;
    }

    /**
     * Click on Home Fee Management System Link.
     *
     * @return the EditProfilePage class instance.
     */
    public EditProfilePage clickHomeFeeManagementSystemLink() {
        homeFeeManagementSystem.click();
        return this;
    }
    

    /**
     * Click on Reset Button.
     *
     * @return the EditProfilePage class instance.
     */
    public EditProfilePage clickResetButton() {
        reset.click();
        return this;
    }

    /**
     * Click on Save Changes Button.
     *
     * @return the EditProfilePage class instance.
     */
    public EditProfilePage clickSaveChangesButton() {
        saveChanges.click();
        return this;
    }

    /**
     * Click on Sign Out Link.
     *
     * @return the EditProfilePage class instance.
     */
    public EditProfilePage clickSignOutLink() {
        signOut.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the EditProfilePage class instance.
     */
    public EditProfilePage fill() {
        setUserIdTextField();
        setFirstNameTextField();
        setLastNameTextField();
        setPasswordPasswordField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the EditProfilePage class instance.
     */
    public EditProfilePage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to First Name Text field.
     *
     * @return the EditProfilePage class instance.
     */
    public EditProfilePage setFirstNameTextField() {
        return setFirstNameTextField(data.get("FIRST_NAME"));
    }

    /**
     * Set value to First Name Text field.
     *
     * @return the EditProfilePage class instance.
     */
    public EditProfilePage setFirstNameTextField(String firstNameValue) {
    	firstName.clear();
        firstName.sendKeys(firstNameValue);
        return this;
    }

    /**
     * Set default value to Last Name Text field.
     *
     * @return the EditProfilePage class instance.
     */
    public EditProfilePage setLastNameTextField() {
        return setLastNameTextField(data.get("LAST_NAME"));
    }

    /**
     * Set value to Last Name Text field.
     *
     * @return the EditProfilePage class instance.
     */
    public EditProfilePage setLastNameTextField(String lastNameValue) {
    	lastName.clear();
        lastName.sendKeys(lastNameValue);
        return this;
    }

    /**
     * Set default value to Password Password field.
     *
     * @return the EditProfilePage class instance.
     */
    public EditProfilePage setPasswordPasswordField() {
        return setPasswordPasswordField(data.get("PASSWORD"));
    }

    /**
     * Set value to Password Password field.
     *
     * @return the EditProfilePage class instance.
     */
    public EditProfilePage setPasswordPasswordField(String passwordValue) {
        password.sendKeys(passwordValue);
        return this;
    }

    /**
     * Set Select Users Thumbnail File field.
     *
     * @return the EditProfilePage class instance.
     */
    public EditProfilePage setSelectUsersThumbnailFileField(String img) {
    	selectUsersThumbnail.sendKeys(img);
        return this;
    }

    /**
     * Set default value to User Id Text field.
     *
     * @return the EditProfilePage class instance.
     */
    public EditProfilePage setUserIdTextField() {
        return setUserIdTextField(data.get("USER_ID"));
    }

    /**
     * Set value to User Id Text field.
     *
     * @return the EditProfilePage class instance.
     */
    public EditProfilePage setUserIdTextField(String userIdValue) {
        userId.sendKeys(userIdValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the EditProfilePage class instance.
     */
    public EditProfilePage submit() {
        clickSaveChangesButton();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the EditProfilePage class instance.
     */
    @SuppressWarnings("deprecation")
	public EditProfilePage verifyPageLoaded() {
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
     * @return the EditProfilePage class instance.
     */
    @SuppressWarnings("deprecation")
	public EditProfilePage verifyPageUrl() {
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
    	Assert.assertEquals(getPageTitle(),"FMS | Edit Profile");
    }
}
