package com.selenium.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.selenium.utilities.*;
public class UsersPage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "button.btn.btn-success.btn-block")
    @CacheLookup
    private WebElement add;

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
    
    @FindBy(id = "addedModal")
    @CacheLookup
    private WebElement modal;
    
    @FindBy(id = "bd-versions")
    @CacheLookup
    private WebElement dropdown;

    private final String pageLoadedText = "Users will access their accounts using their uesr IDs";

    private final String pageUrl = "/fms/admin/masters/add_users.php";

    @FindBy(css = "button.btn.btn-info.btn-block")
    @CacheLookup
    private WebElement reset;

    @FindBy(css = "a[href='http://localhost/fms/php/signout.php']")
    @CacheLookup
    private WebElement signOut;
    
    @FindBy(tagName="a")
    private List<WebElement> userType;

    @FindBy(id = "userId")
    @CacheLookup
    private WebElement userId;

    public UsersPage() {
    }

    public UsersPage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public UsersPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public UsersPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }

    /**
     * Click on Add Button.
     *
     * @return the UsersPage class instance.
     */
    public UsersPage clickAddButton() {
        add.click();
        return this;
    }

    /**
     * Click on Bootstrap Link.
     *
     * @return the UsersPage class instance.
     */
    public UsersPage clickBootstrapLink() {
        bootstrap.click();
        return this;
    }

    /**
     * Click on Dashboard Admins Dashboard Link.
     *
     * @return the UsersPage class instance.
     */
    public UsersPage clickDashboardAdminsDashboardLink() {
        dashboardAdminsDashboard.click();
        return this;
    }

 
    /**
     * Click on Edit Profile Link.
     *
     * @return the UsersPage class instance.
     */
    public UsersPage clickEditProfileLink() {
        editProfile.click();
        return this;
    }

   
    /**
     * Click on Reset Button.
     *
     * @return the UsersPage class instance.
     */
    public UsersPage clickResetButton() {
        reset.click();
        return this;
    }

    /**
     * Click on Sign Out Link.
     *
     * @return the UsersPage class instance.
     * @throws InterruptedException 
     */
    public UsersPage clickSignOutLink() throws InterruptedException {
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
     * @return the UsersPage class instance.
     */
    public UsersPage fill() {
        setUserIdTextField();
        setFirstNameTextField();
        setLastNameTextField();
//        setAdmin1RadioButtonField();
        String s = data.get("SESSION");
        System.out.println(s);
        if(s.equals("admin"))
        {
        	setAdmin1RadioButtonField();
        }
        else if(s.equals("management"))
        {
        	setAdmin2RadioButtonField();
        }
        else if(s.equals("account"))
        	{setAdmin3RadioButtonField();}
        else
        {
        	System.out.println("Invalid");
        }
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the UsersPage class instance.
     */
    public UsersPage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Admin Radio Button field.
     *
     * @return the UsersPage class instance.
     */
    public UsersPage setAdmin1RadioButtonField() {
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

    /**
     * Set default value to Admin Radio Button field.
     *
     * @return the UsersPage class instance.
     */
    public UsersPage setAdmin2RadioButtonField() {
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

    /**
     * Set default value to Admin Radio Button field.
     *
     * @return the UsersPage class instance.
     */
    public UsersPage setAdmin3RadioButtonField() {
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
     * Set default value to First Name Text field.
     *
     * @return the UsersPage class instance.
     */
    public UsersPage setFirstNameTextField() {
        return setFirstNameTextField(data.get("FIRST_NAME"));
    }

    /**
     * Set value to First Name Text field.
     *
     * @return the UsersPage class instance.
     */
    public UsersPage setFirstNameTextField(String firstNameValue) {
        firstName.sendKeys(firstNameValue);
        return this;
    }

    /**
     * Set default value to Last Name Text field.
     *
     * @return the UsersPage class instance.
     */
    public UsersPage setLastNameTextField() {
        return setLastNameTextField(data.get("LAST_NAME"));
    }

    /**
     * Set value to Last Name Text field.
     *
     * @return the UsersPage class instance.
     */
    public UsersPage setLastNameTextField(String lastNameValue) {
        lastName.sendKeys(lastNameValue);
        return this;
    }

    /**
     * Set default value to User Id Text field.
     *
     * @return the UsersPage class instance.
     */
    public UsersPage setUserIdTextField() {
        return setUserIdTextField(data.get("USER_ID"));
    }

    /**
     * Set value to User Id Text field.
     *
     * @return the UsersPage class instance.
     */
    public UsersPage setUserIdTextField(String userIdValue) {
        userId.sendKeys(userIdValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the UsersPage class instance.
     */
    public UsersPage submit() {
        clickAddButton();
        return this;
    }
    
    public String getPageTitle() {
    	return driver.getTitle();
    }
    
    public void checkPageTitle() {
    	Assert.assertEquals(getPageTitle(),"FMS | Add Users");
    }
    
    public void userIdValidation() {
		 Boolean isEditable = userId.isEnabled() && userId.getAttribute("readonly") == null;
	      assertTrue(isEditable);
	}
    public void lastNameValidation() {
		 Boolean isEditable = lastName.isEnabled() && lastName.getAttribute("readonly") == null;
	      assertTrue(isEditable);
	}
    public void firstNameValidation() {
		 Boolean isEditable = firstName.isEnabled() && firstName.getAttribute("readonly") == null;
	      assertTrue(isEditable);
	}
    /*
     public void enterUserId(String userid) {
    	userId.sendKeys(userid);
    }
    public void enterFirstName(String fname) {
    	firstName.sendKeys(fname);
    }
    public void enterLastName(String lname) {
    	lastName.sendKeys(lname);
    	
    }
    */
    
    public void updateUsersAuthority(String changeAuthorityTo) {
    	UpdateUsersPage up=new UpdateUsersPage(driver);
    	if(changeAuthorityTo.equals("admin")) {
    		up.setAdmin1RadioButtonField();
    		up.clickUpdateButton();
    	}else if(changeAuthorityTo.equals("management")) {
    		up.setAdmin2RadioButtonField();
    		up.clickUpdateButton();
    	} else if(changeAuthorityTo.equals("account")) {
    		up.setAdmin3RadioButtonField();
    		up.clickUpdateButton();
    	}else {
    		System.out.println("Invalid Authority values in Users Authority Update page");
    	}
    }
    
    public void updateUsersAuthority(String userId, String changeAuthorityTo) {
	    for (WebElement option :userType)
	    {
	    	if(option.getAttribute("href").contains("update_users.php")) {
	    		if(option.getAttribute("href").contains("userId="+userId)) {
	    			option.click();
	    			updateUsersAuthority(changeAuthorityTo);
	    			break;
	    		}
	    	}
	    } 
    }
    
    public void deleteUsers(String userId) {
 
	    for (WebElement option :userType)
	    {
	    	if(option.getAttribute("href").contains("delete_users.php")) {
	    		if(option.getAttribute("href").contains("userId="+userId)) {
	    			option.click();
	    			break;
	    		}
	    	}
	    } 
    }
}
