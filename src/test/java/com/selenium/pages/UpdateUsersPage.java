package com.selenium.pages;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateUsersPage {
	private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(name = "userType")
    @CacheLookup
    private List<WebElement> admin1;

    @FindBy(name = "userType")
    @CacheLookup
    private List<WebElement> admin2;

    @FindBy(name = "userType")
    @CacheLookup
    private List<WebElement> admin3;

    private final String admin1Value = "1";

    private final String admin2Value = "2";

    private final String admin3Value = "3";

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

    @FindBy(id = "firstName")
    @CacheLookup
    private WebElement firstName;

    @FindBy(css = "a.nav-link.text-light.lead.pl-1.ml-0.border.border-light.border-left-0.border-bottom-0.border-top-0")
    @CacheLookup
    private WebElement homeFeeManagementSystem;

    @FindBy(id = "lastName")
    @CacheLookup
    private WebElement lastName;

    private final String pageLoadedText = "List of already added users";

    private final String pageUrl = "/fms/ADMIN/php/update_users.php?userId=hemant";

    @FindBy(css = "button.btn.btn-info.btn-block")
    @CacheLookup
    private WebElement reset;

    @FindBy(css = "a[href='http://localhost/fms/php/signout.php']")
    @CacheLookup
    private WebElement signOut;

    @FindBy(css = "button.btn.btn-success.btn-block")
    @CacheLookup
    private WebElement update;

    @FindBy(id = "userId")
    @CacheLookup
    private WebElement userId;

    public UpdateUsersPage() {
    }

    public UpdateUsersPage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public UpdateUsersPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public UpdateUsersPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }
    
    public UpdateUsersPage clickDashboardAdminsDashboardLink() {
        dashboardAdminsDashboard.click();
        return this;
    }
    
    public UpdateUsersPage clickEditProfileLink() {
        editProfile.click();
        return this;
    }
    
    public UpdateUsersPage clickResetButton() {
        reset.click();
        return this;
    }
    
    public UpdateUsersPage clickUpdateButton() {
        update.click();
        return this;
    }
    
    public UpdateUsersPage setAdmin1RadioButtonField() {
        for (WebElement el : admin1) {
            if (el.getAttribute("value").equals(admin1Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    
    public UpdateUsersPage setAdmin2RadioButtonField() {
        for (WebElement el : admin2) {
            if (el.getAttribute("value").equals(admin2Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }

    
    public UpdateUsersPage setAdmin3RadioButtonField() {
        for (WebElement el : admin3) {
            if (el.getAttribute("value").equals(admin3Value)) {
                if (!el.isSelected()) {
                    el.click();
                }
                break;
            }
        }
        return this;
    }
    
    /**
     * Set default value to User Id Text field.
     *
     * @return the UpdateUsersPage class instance.
     */
    public UpdateUsersPage setUserIdTextField() {
        return setUserIdTextField(data.get("USER_ID"));
    }

    /**
     * Set value to User Id Text field.
     *
     * @return the UpdateUsersPage class instance.
     */
    public UpdateUsersPage setUserIdTextField(String userIdValue) {
        userId.sendKeys(userIdValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the UpdateUsersPage class instance.
     */
    public UpdateUsersPage submit() {
        clickUpdateButton();
        return this;
    }

    
}
