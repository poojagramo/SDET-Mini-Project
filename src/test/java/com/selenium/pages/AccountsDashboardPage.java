package com.selenium.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountsDashboardPage {
	private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(1) div.card-deck-wrapper div.card-deck div:nth-of-type(1) a")
    @CacheLookup
    private WebElement addFlexibleHeadsFlexibleFee;

    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(3) div.card-deck-wrapper div.card-deck div:nth-of-type(1) a")
    @CacheLookup
    private WebElement addStaticHeadsStaticFee;

    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(7) div.card-deck-wrapper div.card-deck div:nth-of-type(1) a")
    @CacheLookup
    private WebElement associateFlexibleHeadsAssociateFlexible;

    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(5) div.card-deck-wrapper div.card-deck div:nth-of-type(1) a")
    @CacheLookup
    private WebElement associateStaticFeeHeadsAssociate;

    @FindBy(css = "a[href='http://getbootstrap.com/']")
    @CacheLookup
    private WebElement bootstrap;

    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(7) div.card-deck-wrapper div.card-deck div:nth-of-type(3) a")
    @CacheLookup
    private WebElement deleteAssociatedHeadsDeleteFlexible;

    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(5) div.card-deck-wrapper div.card-deck div:nth-of-type(3) a")
    @CacheLookup
    private WebElement deleteAssociatedHeadsDeleteStatic;

    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(1) div.card-deck-wrapper div.card-deck div:nth-of-type(3) a")
    @CacheLookup
    private WebElement deleteFlexibleHeadsDeleteA;

    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(3) div.card-deck-wrapper div.card-deck div:nth-of-type(3) a")
    @CacheLookup
    private WebElement deleteStaticHeadsDeleteA;

    @FindBy(css = "a[href='http://www.onlinegurujee.in/nitindeepak/']")
    @CacheLookup
    private WebElement drNitinDeepak;

    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(7) div.card-deck-wrapper div.card-deck div:nth-of-type(2) a")
    @CacheLookup
    private WebElement editAssociatedHeadsEditFlexible;

    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(5) div.card-deck-wrapper div.card-deck div:nth-of-type(2) a")
    @CacheLookup
    private WebElement editAssociatedHeadsEditStatic;

    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(1) div.card-deck-wrapper div.card-deck div:nth-of-type(2) a")
    @CacheLookup
    private WebElement editFlexibleHeadsEditFlexible;

    @FindBy(css = "a[href='http://localhost/fms/php/edit_profile.php']")
    @CacheLookup
    private WebElement editProfile;

    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(3) div.card-deck-wrapper div.card-deck div:nth-of-type(2) a")
    @CacheLookup
    private WebElement editStaticHeadsEditStatic;

    @FindBy(css = "a[href='masters/generate_invoices.php']")
    @CacheLookup
    private WebElement generateInvoicesGenerateInvoicesFor;

    @FindBy(css = "a.nav-link.text-light.lead.pl-1.ml-0")
    @CacheLookup
    private WebElement homeFeeManagementSystem;

    @FindBy(css = "div.container-fluid.mt-5 div:nth-of-type(11) div.card-deck-wrapper div.card-deck div:nth-of-type(2) a")
    @CacheLookup
    private WebElement loremIpsumDolorSitAmet;

    private final String pageLoadedText = "Flexible fee heads (applicable on individual students according to the facilities they avail, like bus, canteen, etcetera) can be added student wise in every session (as per the requirement)";

    private final String pageUrl = "/fms/ACCOUNTS/index.php";

    @FindBy(css = "a[href='masters/pay_fee.php']")
    @CacheLookup
    private WebElement payFeePayFeeAccording;

    @FindBy(css = "a[href='masters/print_invoices.php']")
    @CacheLookup
    private WebElement printInvoicePrintTheLatest;

    @FindBy(css = "a[href='masters/reprint_receipts.php']")
    @CacheLookup
    private WebElement reprintReceiptsReprintReceiptsUsing;

    @FindBy(css = "a[href='http://localhost/fms/php/signout.php']")
    @CacheLookup
    private WebElement signOut;

    public AccountsDashboardPage() {
    }

    public AccountsDashboardPage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AccountsDashboardPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public AccountsDashboardPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }

    /**
     * Click on Add Flexible Heads Flexible Fee Heads Applicable On Individual Students According To The Facilities They Avail Like Bus Canteen Etcetera Can Be Added Student Wise In Every Session As Per The Requirement. Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickAddFlexibleHeadsFlexibleFeeLink() {
        addFlexibleHeadsFlexibleFee.click();
        return this;
    }

    /**
     * Click on Add Static Heads Static Fee Heads Fee Heads That Are Enforced On Everyone Can Be Added Class Wise Whenever Needed In Every Session As Per The Requirement. Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickAddStaticHeadsStaticFeeLink() {
        addStaticHeadsStaticFee.click();
        return this;
    }

    /**
     * Click on Associate Flexible Heads Associate Flexible Fee Heads To Students. Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickAssociateFlexibleHeadsAssociateFlexibleLink() {
        associateFlexibleHeadsAssociateFlexible.click();
        return this;
    }

    /**
     * Click on Associate Static Fee Heads Associate Static Fee Heads To Classes. Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickAssociateStaticFeeHeadsAssociateLink() {
        associateStaticFeeHeadsAssociate.click();
        return this;
    }

    /**
     * Click on Bootstrap Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickBootstrapLink() {
        bootstrap.click();
        return this;
    }

    /**
     * Click on Delete Associated Heads Delete Flexible Fee Heads That Have Been Associated With Students. Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickDeleteAssociatedHeadsDeleteFlexibleLink() {
        deleteAssociatedHeadsDeleteFlexible.click();
        return this;
    }

    /**
     * Click on Delete Associated Heads Delete Static Fee Heads That Have Been Associated With Classes. Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickDeleteAssociatedHeadsDeleteStaticLink() {
        deleteAssociatedHeadsDeleteStatic.click();
        return this;
    }

    /**
     * Click on Delete Flexible Heads Delete A Flexible Head. Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickDeleteFlexibleHeadsDeleteALink() {
        deleteFlexibleHeadsDeleteA.click();
        return this;
    }

    /**
     * Click on Delete Static Heads Delete A Static Head. Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickDeleteStaticHeadsDeleteALink() {
        deleteStaticHeadsDeleteA.click();
        return this;
    }

    /**
     * Click on Dr. Nitin Deepak Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickDrNitinDeepakLink() {
        drNitinDeepak.click();
        return this;
    }

    /**
     * Click on Edit Associated Heads Edit Flexible Fee Heads That Have Been Associated With Students. Amount Of Flexible Heads Associated To Students Can Be Updated. Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickEditAssociatedHeadsEditFlexibleLink() {
        editAssociatedHeadsEditFlexible.click();
        return this;
    }

    /**
     * Click on Edit Associated Heads Edit Static Fee Heads That Have Been Associated With Classes. Amount Of Static Heads Associated To Classes Can Be Updated. Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickEditAssociatedHeadsEditStaticLink() {
        editAssociatedHeadsEditStatic.click();
        return this;
    }

    /**
     * Click on Edit Flexible Heads Edit Flexible Heads. Their Name Or Description Can Be Changed. Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickEditFlexibleHeadsEditFlexibleLink() {
        editFlexibleHeadsEditFlexible.click();
        return this;
    }

    /**
     * Click on Edit Profile Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickEditProfileLink() {
        editProfile.click();
        return this;
    }

    /**
     * Click on Edit Static Heads Edit Static Heads. Their Name Or Description Can Be Changed. Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickEditStaticHeadsEditStaticLink() {
        editStaticHeadsEditStatic.click();
        return this;
    }

    /**
     * Click on Generate Invoices Generate Invoices For Different Classes In The Session. Invoices Must Be Generated In Oreder To Pay Fee. Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickGenerateInvoicesGenerateInvoicesForLink() {
        generateInvoicesGenerateInvoicesFor.click();
        return this;
    }

    /**
     * Click on Home Fee Management System Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickHomeFeeManagementSystemLink() {
        homeFeeManagementSystem.click();
        return this;
    }

    /**
     * Click on Lorem Ipsum Dolor Sit Amet Consectetur Adipisicing Elit. Porro Perferendis Voluptas Magnam Voluptatem Ex Temporibus Blanditiis Quasi Debitis Eaque Dolorem Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickLoremIpsumDolorSitAmetLink() {
        loremIpsumDolorSitAmet.click();
        return this;
    }

    /**
     * Click on Pay Fee Pay Fee According To The Latest Invoice Studentwise. Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickPayFeePayFeeAccordingLink() {
        payFeePayFeeAccording.click();
        return this;
    }

    /**
     * Click on Print Invoice Print The Latest Generated Invoice Studentwise. Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickPrintInvoicePrintTheLatestLink() {
        printInvoicePrintTheLatest.click();
        return this;
    }

    /**
     * Click on Reprint Receipts Reprint Receipts Using Their Id. Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickReprintReceiptsReprintReceiptsUsingLink() {
        reprintReceiptsReprintReceiptsUsing.click();
        return this;
    }

    /**
     * Click on Sign Out Link.
     *
     * @return the AccountsDashboardPage class instance.
     */
    public AccountsDashboardPage clickSignOutLink() {
        signOut.click();
        return this;
    }
    
    public String getPageTitle() {
    	return driver.getTitle();
    }
    
    public void checkPageTitle() {
    	Assert.assertEquals(getPageTitle(),"FMS | Accounts Department's Dashboard");
    }
}
