package com.selenium.pages;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManagementDashboardPage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "a[href='http://getbootstrap.com/']")
    @CacheLookup
    private WebElement bootstrap;

    @FindBy(css = "a[href='masters/classwise_collection.php']")
    @CacheLookup
    private WebElement classwiseFeeCollectionViewThe;

    @FindBy(css = "a[href='http://www.onlinegurujee.in/nitindeepak/']")
    @CacheLookup
    private WebElement drNitinDeepak;

    @FindBy(css = "a[href='http://localhost/fms/php/edit_profile.php']")
    @CacheLookup
    private WebElement editProfile;

    @FindBy(css = "a.nav-link.text-light.lead.pl-1.ml-0")
    @CacheLookup
    private WebElement homeFeeManagementSystem;

    @FindBy(css = "a[href='masters/monthly_collection.php']")
    @CacheLookup
    private WebElement monthlyFeeCollectionViewThe;

    private final String pageLoadedText = "View different flexible fee heads that can be associated with the students of the school";

    private final String pageUrl = "/fms/management/index.php";

    @FindBy(css = "a[href='http://localhost/fms/php/signout.php']")
    @CacheLookup
    private WebElement signOut;

    @FindBy(css = "a[href='masters/defaulters.php']")
    @CacheLookup
    private WebElement viewDefaultersViewTheList;

    @FindBy(css = "a[href='masters/view_flexible.php']")
    @CacheLookup
    private WebElement viewFlexibleHeadsViewDifferent;

    @FindBy(css = "a[href='masters/view_static.php']")
    @CacheLookup
    private WebElement viewStaticHeadsViewDifferent;

    @FindBy(css = "a[href='masters/view_log.php']")
    @CacheLookup
    private WebElement viewUsersLogViewUsers;
    
    @FindBy(id = "bd-versions")
    @CacheLookup
    private WebElement dropdown;
    
    @FindBy(css = ".row:nth-child(1) .card:nth-child(1) .card-banner")
    @CacheLookup
    private WebElement viewStaticHeadsCard;
    
    @FindBy(css = ".row:nth-child(1) .card:nth-child(2) .card-banner")
    @CacheLookup
    private WebElement viewFlexibleHeadsCard; 
    
    @FindBy(css = ".row:nth-child(1) .card:nth-child(3) .card-banner")
    @CacheLookup
    private WebElement MonthlyCollectionCard; 
    
    @FindBy(css = "div.container-fluid.mt-5:nth-child(2) div.row.px-sm-3.mx-md-1:nth-child(3) div.card-deck-wrapper div.card-deck div.card.text-center.card-box:nth-child(1) a:nth-child(1) > h3.card-banner")
    @CacheLookup
    private WebElement ClasswiseFeeCollectionCard; 
    
    @FindBy(css = "div.container-fluid.mt-5:nth-child(2) div.row.px-sm-3.mx-md-1:nth-child(3) div.card-deck-wrapper div.card-deck div.card.text-center.card-box:nth-child(2) a:nth-child(1) > h3.card-banner")
    @CacheLookup
    private WebElement ViewDefaultersCard; 
    
    @FindBy(css = ".thead-dark th:nth-child(1)")
    @CacheLookup
    private WebElement tableCol1;
    
    @FindBy(css = ".thead-dark th:nth-child(2)")
    @CacheLookup
    private WebElement tableCol2;
    
    @FindBy(css = ".thead-dark th:nth-child(3)")
    @CacheLookup
    private WebElement tableCol3;
    
    @FindBy(css = ".thead-dark th:nth-child(4)")
    @CacheLookup
    private WebElement tableCol4;
    
    @FindBy(css = ".thead-dark th:nth-child(5)")
    @CacheLookup
    private WebElement tableCol5;

    public ManagementDashboardPage() {
    }

    public ManagementDashboardPage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ManagementDashboardPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public ManagementDashboardPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
        PageFactory.initElements(driver, this);
    }

    /**
     * Click on Bootstrap Link.
     *
     * @return the ManagementDashboard class instance.
     */
    public ManagementDashboardPage clickBootstrapLink() {
        bootstrap.click();
        return this;
    }

    /**
     * Click on Classwise Fee Collection View The Classwise Fee Collection. Link.
     *
     * @return the ManagementDashboard class instance.
     */
    public ManagementDashboardPage clickClasswiseFeeCollectionViewTheLink() {
        classwiseFeeCollectionViewThe.click();
        return this;
    }

    /**
     * Click on Dr. Nitin Deepak Link.
     *
     * @return the ManagementDashboard class instance.
     */
    public ManagementDashboardPage clickDrNitinDeepakLink() {
        drNitinDeepak.click();
        return this;
    }

    /**
     * Click on Edit Profile Link.
     *
     * @return the ManagementDashboard class instance.
     */
    public ManagementDashboardPage clickEditProfileLink() {
        editProfile.click();
        return this;
    }

    /**
     * Click on Home Fee Management System Link.
     *
     * @return the ManagementDashboard class instance.
     */
    public ManagementDashboardPage clickHomeFeeManagementSystemLink() {
        homeFeeManagementSystem.click();
        return this;
    }

    /**
     * Click on Monthly Fee Collection View The Monthly Fee Collection. Link.
     *
     * @return the ManagementDashboard class instance.
     */
    public ManagementDashboardPage clickMonthlyFeeCollectionViewTheLink() {
        monthlyFeeCollectionViewThe.click();
        return this;
    }

    /**
     * Click on Sign Out Link.
     *
     * @return the ManagementDashboard class instance.
     * @throws InterruptedException 
     */
    public ManagementDashboardPage clickSignOutLink() throws InterruptedException {
    	Thread.sleep(1000);
    	dropdown.click();
        signOut.click();
        return this;
    }

    /**
     * Click on View Defaulters View The List Of Students Who Have Not Cleared Their Dues. The Students With Remaining Dues Are Defaulters. Link.
     *
     * @return the ManagementDashboard class instance.
     */
    public ManagementDashboardPage clickViewDefaultersViewTheListLink() {
        viewDefaultersViewTheList.click();
        return this;
    }

    /**
     * Click on View Flexible Heads View Different Flexible Fee Heads That Can Be Associated With The Students Of The School. Link.
     *
     * @return the ManagementDashboard class instance.
     */
    public ManagementDashboardPage clickViewFlexibleHeadsViewDifferentLink() {
        viewFlexibleHeadsViewDifferent.click();
        return this;
    }

    /**
     * Click on View Static Heads View Different Staic Fee Heads That Can Be Associated With The Classes Of The School. Link.
     *
     * @return the ManagementDashboard class instance.
     */
    public ManagementDashboardPage clickViewStaticHeadsViewDifferentLink() {
        viewStaticHeadsViewDifferent.click();
        return this;
    }

    /**
     * Click on View Users Log View Users Log With Log In And Log Out Time. Link.
     *
     * @return the ManagementDashboard class instance.
     */
    public ManagementDashboardPage clickViewUsersLogViewUsersLink() {
        viewUsersLogViewUsers.click();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the ManagementDashboard class instance.
     */
    public ManagementDashboardPage verifyPageLoaded() {
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
     * @return the ManagementDashboard class instance.
     */
    public ManagementDashboardPage verifyPageUrl() {
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
    	Assert.assertEquals(getPageTitle(),"FMS | Management's Dashboard");
    }

	public void verifyTitleOfViewStaticHeads() {
		Assert.assertEquals(getPageTitle(),"FMS | View Static Heads");
	}
	
	public void verifyTitleOfViewFlexibleHeads() {
		Assert.assertEquals(getPageTitle(),"FMS | View Flexible Heads");
	}
	
	public void verifyTitleOfMonthlyFeeCollection() {
		Assert.assertEquals(getPageTitle(),"FMS | Monthly Fee Collection");
	}
	public void verifyTitleOfClasswiseFeeCollection() {
		Assert.assertEquals(getPageTitle(),"FMS | Classwise Fee Collection");
	}
	public void verifyTitleOfViewDefaulters() {
		Assert.assertEquals(getPageTitle(),"FMS | View Defaulters");
	}
	
	public void viewStaticHeadsCardPresent() {
		Assert.assertEquals(viewStaticHeadsCard.getText(),"View Static Heads");
	}
	
	public void verifyAllTablesColumn() {
		Assert.assertEquals(tableCol1.getText(),"#");
		Assert.assertEquals(tableCol2.getText(),"Static Fee Head Name");
		Assert.assertEquals(tableCol3.getText(),"Description");
	}
	
	public void viewFlexibleHeadsCardPresent() {
		Assert.assertEquals(viewFlexibleHeadsCard.getText(),"View Flexible Heads");
	}
	
	public void verifyTableViewFlexibleHeads() {
		Assert.assertEquals(tableCol1.getText(),"#");
		Assert.assertEquals(tableCol2.getText(),"Flexible Fee Head Name");
		Assert.assertEquals(tableCol3.getText(),"Description");
	}
	
	public void MonthlyFeeCardPresent() {
		Assert.assertEquals(MonthlyCollectionCard.getText(),"Monthly Fee Collection");
	}
	
	public void verifyTableViewMonthlyFee() {
		Assert.assertEquals(tableCol1.getText(),"#");
		Assert.assertEquals(tableCol2.getText(),"Month");
		Assert.assertEquals(tableCol3.getText(),"Fee Collection (in )");
		Assert.assertEquals(tableCol4.getText(),"Fee Collection (in words)");
	}
	
	public void ClasswiseFeeCardPresent() {
		Assert.assertEquals(ClasswiseFeeCollectionCard.getText(),"Classwise Fee Collection");
	}
	
	public void verifyTableViewClasswiseFee() {
		Assert.assertEquals(tableCol1.getText(),"#");
		Assert.assertEquals(tableCol2.getText(),"Class");
		Assert.assertEquals(tableCol3.getText(),"Fee Collection (in )");
		Assert.assertEquals(tableCol4.getText(),"Fee Collection (in words)");
	}
	
	public void ViewDefaultersCardCardPresent() {
		Assert.assertEquals(ViewDefaultersCard.getText(),"View Defaulters");
	}
	
	public void verifyTableViewDefaultersCard() {
		Assert.assertEquals(tableCol1.getText(),"#");
		Assert.assertEquals(tableCol2.getText(),"Student ID");
		Assert.assertEquals(tableCol3.getText(),"Student Name");
		Assert.assertEquals(tableCol4.getText(),"Class");
		Assert.assertEquals(tableCol5.getText(),"Remaining Dues (in )");
	}
	
	
}
