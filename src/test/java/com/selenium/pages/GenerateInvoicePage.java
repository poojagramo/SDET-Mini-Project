package com.selenium.pages;
import static org.testng.Assert.assertTrue;

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

public class GenerateInvoicePage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "a[href='http://getbootstrap.com/']")
    @CacheLookup
    private WebElement bootstrap;

    @FindBy(css = "a[href='http://localhost/fms/ACCOUNTS/index.php']")
    @CacheLookup
    private WebElement dashboardAccountssDashboard;

    @FindBy(css = "a[href='http://www.onlinegurujee.in/nitindeepak/']")
    @CacheLookup
    private WebElement drNitinDeepak;

    @FindBy(css = "a[href='http://localhost/fms/php/edit_profile.php']")
    @CacheLookup
    private WebElement editProfile;

    @FindBy(css = "a.nav-link.text-light.lead.pl-1.ml-0.border.border-light.border-left-0.border-bottom-0.border-top-0")
    @CacheLookup
    private WebElement homeFeeManagementSystem;

    @FindBy(id = "monthFrom")
    @CacheLookup
    private WebElement monthFrom;

    @FindBy(id = "monthTo")
    @CacheLookup
    private WebElement monthTo;

    private final String pageLoadedText = "Last modified: Monday, 6 December 2021, 01:32:22 PM";

    private final String pageUrl = "/fms/ACCOUNTS/masters/generate_invoices.php";

    @FindBy(id = "classId")
    @CacheLookup
    private WebElement selectClass;

    @FindBy(css = "a[href='http://localhost/fms/php/signout.php']")
    @CacheLookup
    private WebElement signOut;

    @FindBy(id = "yearFrom")
    @CacheLookup
    private WebElement yearFrom;

    @FindBy(id = "yearTo")
    @CacheLookup
    private WebElement yearTo;
    
    @FindBy(id = "generateInvoices")
    @CacheLookup
    private WebElement generateInvoices;
    
    @FindBy(css = "div.container-fluid.px-3:nth-child(2) div.row.mx-1.py-2.bg-white:nth-child(3) div.modal.fade:nth-child(1) div.modal-dialog div.modal-content div.modal-footer > button.btn.btn-danger")
    @CacheLookup
    private WebElement modal;
    
    @FindBy(id = "bd-versions")
    @CacheLookup
    private WebElement dropdown;

    public GenerateInvoicePage() {
    }

    public GenerateInvoicePage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GenerateInvoicePage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public GenerateInvoicePage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }

    /**
     * Click on Bootstrap Link.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage clickBootstrapLink() {
        bootstrap.click();
        return this;
    }

    /**
     * Click on Dashboard Accountss Dashboard Link.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage clickDashboardAccountssDashboardLink() {
        dashboardAccountssDashboard.click();
        return this;
    }

    /**
     * Click on Dr. Nitin Deepak Link.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage clickDrNitinDeepakLink() {
        drNitinDeepak.click();
        return this;
    }

    /**
     * Click on Edit Profile Link.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage clickEditProfileLink() {
        editProfile.click();
        return this;
    }

    /**
     * Click on Home Fee Management System Link.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage clickHomeFeeManagementSystemLink() {
        homeFeeManagementSystem.click();
        return this;
    }

    /**
     * Click on Sign Out Link.
     *
     * @return the GenerateInvoicePage class instance.
     * @throws InterruptedException 
     */
    public GenerateInvoicePage clickSignOutLink() throws InterruptedException {
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
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage fill() {
        setSelectClassDropDownListField();
        setMonthFromDropDownListField();
        setMonthToDropDownListField();
        return this;
    }

    /**
     * Set default value to Month From Drop Down List field.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage setMonthFromDropDownListField() {
        return setMonthFromDropDownListField(data.get("MONTH_FROM"));
    }

    /**
     * Set value to Month From Drop Down List field.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage setMonthFromDropDownListField(String monthFromValue) {
        new Select(monthFrom).selectByVisibleText(monthFromValue);
        return this;
    }

    /**
     * Set default value to Month To Drop Down List field.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage setMonthToDropDownListField() {
        return setMonthToDropDownListField(data.get("MONTH_TO"));
    }

    /**
     * Set value to Month To Drop Down List field.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage setMonthToDropDownListField(String monthToValue) {
        new Select(monthTo).selectByVisibleText(monthToValue);
        return this;
    }

    /**
     * Set default value to Select Class Drop Down List field.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage setSelectClassDropDownListField() {
        return setSelectClassDropDownListField(data.get("SELECT_CLASS"));
    }

    /**
     * Set value to Select Class Drop Down List field.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage setSelectClassDropDownListField(String selectClassValue) {
        new Select(selectClass).selectByVisibleText(selectClassValue);
        return this;
    }

    /**
     * Set default value to Year From Text field.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage setYearFromTextField() {
        return setYearFromTextField(data.get("YEAR_FROM"));
    }

    /**
     * Set value to Year From Text field.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage setYearFromTextField(String yearFromValue) {
        yearFrom.sendKeys(yearFromValue);
        return this;
    }

    /**
     * Set default value to Year To Text field.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage setYearToTextField() {
        return setYearToTextField(data.get("YEAR_TO"));
    }

    /**
     * Set value to Year To Text field.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage setYearToTextField(String yearToValue) {
        yearTo.sendKeys(yearToValue);
        return this;
    }

    /**
     * Unset default value from Month From Drop Down List field.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage unsetMonthFromDropDownListField() {
        return unsetMonthFromDropDownListField(data.get("MONTH_FROM"));
    }

    /**
     * Unset value from Month From Drop Down List field.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage unsetMonthFromDropDownListField(String monthFromValue) {
        new Select(monthFrom).deselectByVisibleText(monthFromValue);
        return this;
    }

    /**
     * Unset default value from Month To Drop Down List field.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage unsetMonthToDropDownListField() {
        return unsetMonthToDropDownListField(data.get("MONTH_TO"));
    }

    /**
     * Unset value from Month To Drop Down List field.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage unsetMonthToDropDownListField(String monthToValue) {
        new Select(monthTo).deselectByVisibleText(monthToValue);
        return this;
    }

    /**
     * Unset default value from Select Class Drop Down List field.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage unsetSelectClassDropDownListField() {
        return unsetSelectClassDropDownListField(data.get("SELECT_CLASS"));
    }

    /**
     * Unset value from Select Class Drop Down List field.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage unsetSelectClassDropDownListField(String selectClassValue) {
        new Select(selectClass).deselectByVisibleText(selectClassValue);
        return this;
    }
    
    public void classValidation() {
		 Boolean isEditable = selectClass.isEnabled() && selectClass.getAttribute("readonly") == null;
	      assertTrue(isEditable);
	}
    
    public void monthFromValidation() {
		 Boolean isEditable = monthFrom.isEnabled() && monthFrom.getAttribute("readonly") == null;
	      assertTrue(isEditable);
	}
    
    public void monthToValidation() {
		 Boolean isEditable = monthTo.isEnabled() && monthTo.getAttribute("readonly") == null;
	      assertTrue(isEditable);
	}
    
    /**
     * Click on Generate Invoices Button.
     *
     * @return the GenerateInvoicePage class instance.
     */
    public GenerateInvoicePage clickGenerateInvoicesButton() {
        generateInvoices.click();
        return this;
    }
}

