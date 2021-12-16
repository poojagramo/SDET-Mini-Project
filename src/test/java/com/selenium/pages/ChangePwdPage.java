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

public class ChangePwdPage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "a[href='http://getbootstrap.com/']")
    @CacheLookup
    private WebElement bootstrap;

    @FindBy(id = "changePassword")
    @CacheLookup
    private WebElement changePassword;

    @FindBy(id = "repeatPassword")
    @CacheLookup
    private WebElement confirmNewPassword;

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

    @FindBy(id = "newPassword")
    @CacheLookup
    private WebElement newPassword;

    @FindBy(id = "currentPassword")
    @CacheLookup
    private WebElement oldPassword;

    private final String pageLoadedText = "Last modified: Tuesday, 7 December 2021, 10:26:37 AM";

    private final String pageUrl = "/fms/php/change_password.php";

    @FindBy(css = "button.btn.btn-info.btn-block")
    @CacheLookup
    private WebElement reset;

    @FindBy(css = "a[href='http://localhost/fms/php/signout.php']")
    @CacheLookup
    private WebElement signOut;

    @FindBy(id = "userid")
    @CacheLookup
    private WebElement userId;

    public ChangePwdPage() {
    }

    public ChangePwdPage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ChangePwdPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public ChangePwdPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }

    /**
     * Click on Bootstrap Link.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage clickBootstrapLink() {
        bootstrap.click();
        return this;
    }

    /**
     * Click on Change Password Button.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage clickChangePasswordButton() {
        changePassword.click();
        return this;
    }

    /**
     * Click on Dashboard Admins Dashboard Link.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage clickDashboardAdminsDashboardLink() {
        dashboardAdminsDashboard.click();
        return this;
    }

    /**
     * Click on Dr. Nitin Deepak Link.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage clickDrNitinDeepakLink() {
        drNitinDeepak.click();
        return this;
    }

    /**
     * Click on Edit Profile Link.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage clickEditProfileLink() {
        editProfile.click();
        return this;
    }

    /**
     * Click on Home Fee Management System Link.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage clickHomeFeeManagementSystemLink() {
        homeFeeManagementSystem.click();
        return this;
    }

    /**
     * Click on Reset Button.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage clickResetButton() {
        reset.click();
        return this;
    }

    /**
     * Click on Sign Out Link.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage clickSignOutLink() {
        signOut.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage fill() {
        setUserIdTextField();
        setOldPasswordPasswordField();
        setNewPasswordPasswordField();
        setConfirmNewPasswordPasswordField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Confirm New Password Password field.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage setConfirmNewPasswordPasswordField() {
        return setConfirmNewPasswordPasswordField(data.get("CONFIRM_NEW_PASSWORD"));
    }

    /**
     * Set value to Confirm New Password Password field.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage setConfirmNewPasswordPasswordField(String confirmNewPasswordValue) {
        confirmNewPassword.sendKeys(confirmNewPasswordValue);
        return this;
    }

    /**
     * Set default value to New Password Password field.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage setNewPasswordPasswordField() {
        return setNewPasswordPasswordField(data.get("NEW_PASSWORD"));
    }

    /**
     * Set value to New Password Password field.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage setNewPasswordPasswordField(String newPasswordValue) {
        newPassword.sendKeys(newPasswordValue);
        return this;
    }

    /**
     * Set default value to Old Password Password field.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage setOldPasswordPasswordField() {
        return setOldPasswordPasswordField(data.get("OLD_PASSWORD"));
    }

    /**
     * Set value to Old Password Password field.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage setOldPasswordPasswordField(String oldPasswordValue) {
        oldPassword.sendKeys(oldPasswordValue);
        return this;
    }

    /**
     * Set default value to User Id Text field.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage setUserIdTextField() {
        return setUserIdTextField(data.get("USER_ID"));
    }

    /**
     * Set value to User Id Text field.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage setUserIdTextField(String userIdValue) {
        userId.sendKeys(userIdValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the ChangePwdPage class instance.
     */
    public ChangePwdPage submit() {
        clickChangePasswordButton();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the ChangePwdPage class instance.
     */
    @SuppressWarnings("deprecation")
	public ChangePwdPage verifyPageLoaded() {
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
     * @return the ChangePwdPage class instance.
     */
    @SuppressWarnings("deprecation")
	public ChangePwdPage verifyPageUrl() {
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
    	Assert.assertEquals(getPageTitle(),"FMS | Change Password");
    }
}
