package com.selenium.pages;
import java.util.Map;
import com.selenium.utilities.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AdminDashboardPage {
	 private Map<String, String> data;
	    private WebDriver driver;
	    private int timeout = 15;

	    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(3) div.card-deck-wrapper div.card-deck div:nth-of-type(1) a")
	    @CacheLookup
	    private WebElement addClassesAddNewClasses;

	    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(3) div.card-deck-wrapper div.card-deck div:nth-of-type(2) a")
	    @CacheLookup
	    private WebElement addClassesSessionWiseAdd;

	    @FindBy(css = "a[href='masters/add_sessions.php']")
	    @CacheLookup
	    private WebElement addSessionsAddNewSessions;

	    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(1) div.card-deck-wrapper div.card-deck div:nth-of-type(1) a")
	    @CacheLookup
	    private WebElement addUsersAddNewUsers;

	    @FindBy(css = "a[href='http://getbootstrap.com/']")
	    @CacheLookup
	    private WebElement bootstrap;

	    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(1) div.card-deck-wrapper div.card-deck div:nth-of-type(2) a")
	    @CacheLookup
	    private WebElement changeUsersAuthorityChangeA;

	    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(3) div.card-deck-wrapper div.card-deck div:nth-of-type(3) a")
	    @CacheLookup
	    private WebElement deleteClassesDeleteClassesFrom;

	    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(5) div.card-deck-wrapper div.card-deck div:nth-of-type(1) a")
	    @CacheLookup
	    private WebElement deleteClassesSessionWiseDelete;

	    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(1) div.card-deck-wrapper div.card-deck div:nth-of-type(3) a")
	    @CacheLookup
	    private WebElement deleteUsersDeleteAnExisting;

	    @FindBy(css = "a[href='http://localhost/fms/php/edit_profile.php']")
	    @CacheLookup
	    private WebElement editProfile;

	    @FindBy(css = "a.nav-link.text-light.lead.pl-1.ml-0")
	    @CacheLookup
	    private WebElement homeFeeManagementSystem;

	    private final String pageLoadedText = "A new user can be an admin or from the accounts department or even someone from the management";

	    private final String pageUrl = "/fms/ADMIN/index.php";

	    @FindBy(css = "a[href='http://localhost/fms/php/signout.php']")
	    @CacheLookup
	    private WebElement signOut;

	    @FindBy(css = "a[href='masters/view_log.php']")
	    @CacheLookup
	    private WebElement viewUsersLogViewUsers;
	    @FindBy(id = "bd-versions")
	    @CacheLookup
	    private WebElement dropdown;

	    public AdminDashboardPage() {
	    }

	    public AdminDashboardPage(WebDriver driver) {
	        this();
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public AdminDashboardPage(WebDriver driver, Map<String, String> data) {
	        this(driver);
	        this.data = data;
	        PageFactory.initElements(driver, this);
	    }

	    public AdminDashboardPage(WebDriver driver, Map<String, String> data, int timeout) {
	        this(driver, data);
	        this.timeout = timeout;
	        PageFactory.initElements(driver, this);
	    }
	    
	    public AdminDashboardPage clickAddClassesAddNewClassesLink() {
	        addClassesAddNewClasses.click();
	        return this;
	    }
	    
	   
	    public AdminDashboardPage clickAddClassesSessionWiseAddLink() {
	        addClassesSessionWiseAdd.click();
	        return this;
	    }

	   
	    public AdminDashboardPage clickAddSessionsAddNewSessionsLink() {
	        addSessionsAddNewSessions.click();
	        return this;
	    }

	    
	    public AdminDashboardPage clickAddUsersAddNewUsersLink() {
	        addUsersAddNewUsers.click();
	        return this;
	    }

	  
	    public AdminDashboardPage clickBootstrapLink() {
	        bootstrap.click();
	        return this;
	    }

	    
	    public AdminDashboardPage clickChangeUsersAuthorityChangeALink() {
	        changeUsersAuthorityChangeA.click();
	        return this;
	    }

	    public AdminDashboardPage clickDeleteClassesDeleteClassesFromLink() {
	        deleteClassesDeleteClassesFrom.click();
	        return this;
	    }

	  
	    public AdminDashboardPage clickDeleteClassesSessionWiseDeleteLink() {
	        deleteClassesSessionWiseDelete.click();
	        return this;
	    }

	    
	    public AdminDashboardPage clickDeleteUsersDeleteAnExistingLink() {
	        deleteUsersDeleteAnExisting.click();
	        return this;
	    }

	    
	    public AdminDashboardPage clickEditProfileLink() {
	        editProfile.click();
	        return this;
	    }

	  
	    public AdminDashboardPage clickSignOutLink() {
	    	dropdown.click();
	        signOut.click();
	        return this;
	    }

	    public AdminDashboardPage clickViewUsersLogViewUsersLink() {
	        viewUsersLogViewUsers.click();
	        return this;
	    }
	    
	    public String getPageTitle() {
	    	return driver.getTitle();
	    }
	    
	    public void checkPageTitle() {
	    	Assert.assertEquals(getPageTitle(),"FMS | Admin's Dashboard");
	    }
	    
	    public AdminDashboardPage clickDropdownList() {
	    	dropdown.click();
	    	return this;
	    }
	    
	    public void verifyTitleOfLogPage() {
			Assert.assertEquals(getPageTitle(),"FMS | View Users' Log");
			
		}
}
