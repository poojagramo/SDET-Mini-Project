package com.selenium.pages;


import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassesPage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "button.btn.btn-success.btn-block")
    @CacheLookup
    private WebElement add;

    @FindBy(css = "a[href='http://getbootstrap.com/']")
    @CacheLookup
    private WebElement bootstrap;

    @FindBy(id = "className")
    @CacheLookup
    private WebElement className;

    @FindBy(css = "a[href='http://localhost/fms/ADMIN/index.php']")
    @CacheLookup
    private WebElement dashboardAdminsDashboard;


    @FindBy(css = "a[href='http://localhost/fms/php/edit_profile.php']")
    @CacheLookup
    private WebElement editProfile;

    @FindBy(css = "a.nav-link.text-light.lead.pl-1.ml-0.border.border-light.border-left-0.border-bottom-0.border-top-0")
    @CacheLookup
    private WebElement homeFeeManagementSystem;
    
    //............................
    @FindBy(className = "close")
    @CacheLookup
    private WebElement closeMain;
    
    
    @FindBy(css = "tr:nth-child(1) .fa-minus-circle")
    @CacheLookup
    private WebElement delete;
    
    @FindBy(css = "body > div > div.row.pt-5 > div.col-lg-8.d-none.d-sm-block.ml-sm-auto.mt-2 > table > tbody > tr:nth-child(1) > td:nth-child(3) > a > i")
    @CacheLookup
    private WebElement edit;
    
    @FindBy(tagName="a")
    private List<WebElement> dlt;
    
    @FindBy(id = "classId")
    @CacheLookup
    private WebElement classId;

    
    private final String pageLoadedText = "Add a class to the school";

    private final String pageUrl = "/fms/admin/masters/add_classes.php";

    @FindBy(css = "button.btn.btn-info.btn-block")
    @CacheLookup
    private WebElement reset;

    @FindBy(css = "a[href='http://localhost/fms/php/signout.php']")
    @CacheLookup
    private WebElement signOut;
    
    @FindBy(id="bd-versions")
    @CacheLookup
    private  WebElement logoutDropdown;
	
	@FindBy(id="addedModal")
    @CacheLookup
    private  WebElement modal;


    public ClassesPage() {
    }

    public ClassesPage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ClassesPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public ClassesPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }

//    Click on Add Button.
    public ClassesPage clickAddButton() {
        add.click();
        return this;
    }

//    Click on Bootstrap Link.
    public ClassesPage clickBootstrapLink() {
        bootstrap.click();
        return this;
    }

//    Click on Dashboard Admins Dashboard Link.
    public ClassesPage clickDashboardAdminsDashboardLink() {
        dashboardAdminsDashboard.click();
        return this;
    }

   

//    Click on Edit Profile Link.
    public ClassesPage clickEditProfileLink() {
        editProfile.click();
        return this;
    }

//    Click on Home Fee Management System Link.
    public ClassesPage clickHomeFeeManagementSystemLink() {
        homeFeeManagementSystem.click();
        return this;
    }

//    Click on Reset Button.
    public ClassesPage clickResetButton() {
        reset.click();
        return this;
    }

//    Click on Sign Out Link.
    public ClassesPage clickSignOutLink() {
        signOut.click();
        return this;
    }

//    Fill every fields in the page
    
    public ClassesPage fill() {
        setClassNameTextField();
        return this;
    }

//    Fill every fields in the page and submit it to target page.
        public ClassesPage fillAndSubmit() {
        fill();
        return submit();
    }

   
//      Set default value to Class Name Text field.
         public ClassesPage setClassNameTextField() {
        return setClassNameTextField(data.get("CLASS_NAME"));
   }

//    Set value to Class Name Text field.
    public ClassesPage setClassNameTextField(String classNameValue) {
        className.sendKeys(classNameValue);
        return this;
    }

//    Submit the form to target page.
    public ClassesPage submit() {
        clickAddButton();
        return this;
    }
    
    //logout dropdown
    public ClassesPage clickLogoutDropDown() {
//    	modal.click();
    	logoutDropdown.click();
    	return this;
    }
    public ClassesPage clickLogoutDropDownNew() {
    	modal.click();
    	logoutDropdown.click();
    	return this;
    }
    
    //Page title
    public String getPageTitle() {
    	return driver.getTitle();
    }
    
    public void checkPageTitle() {
    	Assert.assertEquals(getPageTitle(),"FMS | Add Classes");
    }
    
    //Validation
    public void classNameValidation() {
		 Boolean isEditable = className.isEnabled() && className.getAttribute("readonly") == null;
	      assertTrue(isEditable);
	}
    
    //To check reset
    public void checkEmpty() {
    	if(className.getAttribute("value")=="")
    		System.out.println("Reset not working");
    	else
    		System.out.println("Reset working");
    		
	}
    
    //delete classes
    public ClassesPage deleteButton() {
        delete.click();
        return this;
    }
    
  //edit classes
    public ClassesPage editButton() {
        edit.click();
        return this;
    }
    
  
    
    //Click on close main after delete
    public ClassesPage clickCloseButton() {
        closeMain.click();
        return this;
    }
    
    public ClassesPage clearText() {
        className.clear();
        return this;
    }
    
    public void deleteClass(String classId) {
	    for (WebElement option :dlt)
	    {
	    	if(option.getAttribute("href").contains("delete_classes.php")) {
	    		if(option.getAttribute("href").contains("classId="+classId)) {
	    			option.click();
	    			break;
	    		}
	    	}
	    } 
    }
    public void editClass(String classId) {
	    for (WebElement option :dlt)
	    {
	    	
	    	if(option.getAttribute("href").contains("edit_classes.php")) {
	    		if(option.getAttribute("href").contains("classId="+classId)) {
	    			option.click();
	    			
	    			break;
	    		}
	    	}
	    } 
    }
    
}
