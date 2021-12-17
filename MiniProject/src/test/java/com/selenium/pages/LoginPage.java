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

public class LoginPage {
	private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "a[href='http://getbootstrap.com/']")
    @CacheLookup
    private WebElement bootstrap;

    @FindBy(css = "a[href='http://www.onlinegurujee.in/nitindeepak/']")
    @CacheLookup
    private WebElement drNitinDeepak;

    private final String pageLoadedText = "It is designed to facilitate the users (at more ease) with customized fee records related to every student in every session and overall fee history on a single click";

    private final String pageUrl = "/fms/";

    @FindBy(id = "password")
    @CacheLookup
    private WebElement password;

    @FindBy(id = "session")
    @CacheLookup
    private WebElement selectSession;

    @FindBy(css = "button.btn.btn-success.btn-block.mb-4")
    @CacheLookup
    private WebElement signIn;

    @FindBy(id = "username")
    @CacheLookup
    private WebElement username;
    
    @FindBy(tagName= "title")
    WebElement header;
    
    public LoginPage() {
    }

    public LoginPage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public LoginPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }
    public void enterUserName(String userName) {
    	username.sendKeys(userName);
    }
    public void enterPassword(String pwd) {
    	password.sendKeys(pwd);
    }
    
   
    public LoginPage setSelectSessionDropDownListField() {
        return setSelectSessionDropDownListField(data.get("SELECT_SESSION"));
    }

   
    public LoginPage setSelectSessionDropDownListField(String selectSessionValue) {
        new Select(selectSession).selectByVisibleText(selectSessionValue);
        return this;
    }
    
    public LoginPage clickSignIn() {
        signIn.click();
         return this;
     }
     
    public String getPageTitle() {
    	return driver.getTitle();
    }
    
    public void checkPageTitle() {
    	Assert.assertEquals(getPageTitle(),"FMS | Homepage");
    }
    public void checkAdminPageTitle() {
    	Assert.assertEquals(getPageTitle(),"FMS | Admin's Dashboard");
    }
    
    public void usernameValidation() {
		 Boolean isEditable = username.isEnabled() && username.getAttribute("readonly") == null;
	      assertTrue(isEditable);
	}

    public void passwordValidation() {
		 Boolean isEditable = password.isEnabled() && password.getAttribute("readonly") == null;
	      assertTrue(isEditable);
	}
    
    public void sessionValidation() {
    	 Boolean isEditable = selectSession.isEnabled() && selectSession.getAttribute("readonly") == null;
	      assertTrue(isEditable);
	}
}
