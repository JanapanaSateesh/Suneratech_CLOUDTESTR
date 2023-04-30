package Steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.PageObjects.CT_DashboardPageObjects;
import com.PageObjects.CT_DesignTestCasesPageObjects;
import com.PageObjects.CT_LoginPageObjects;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CLOUDTESTR_Validations {
	
	public WebDriver driver;
	CT_LoginPageObjects loginpageobjects;
	CT_DashboardPageObjects dashboardpageobjects;
	CT_DesignTestCasesPageObjects designtestcasesobjects;
	
	@Given("Lanuch the URL {string}")
	public void lanuch_the_url(String url) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver(options);	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get(url);
	    loginpageobjects = new CT_LoginPageObjects(driver);
	    dashboardpageobjects = new CT_DashboardPageObjects(driver);
	    designtestcasesobjects = new CT_DesignTestCasesPageObjects(driver);
	}

	@When("Enter the username {string} and password {string}")
	public void enter_the_username_and_password(String username, String password) {
	   loginpageobjects.setUserName(username);
	   loginpageobjects.setPassword(password);
	}

	@When("Click on login button")
	public void click_on_login_button() {
		loginpageobjects.clickOnLoginButton();
	    
	}

	@Then("Successfully logged into CloudTestr and validate the page title")
	public void successfully_logged_into_cloud_testr_and_validate_the_page_title() {
	    loginpageobjects.validatePageTitle();
	}
	
	//// ------------ Scenario 2 -----------------//
	@And("Verify the number of widgets {string}")
	public void verify_the_number_of_widgets(String widgetcount) throws InterruptedException {
		Thread.sleep(5000);
		dashboardpageobjects.validateWidgets(widgetcount);
	}
	
	////-----------Scenario3-------------------//
	
	@And("Click on application dropdown from filter")
	public void click_on_application_dropdown_from_filter() throws InterruptedException {
		dashboardpageobjects.clickOnApplicationDropdown();
		Thread.sleep(5000);
	   
	}

	@And("Select the application as {string}")
	public void select_the_application_as(String application) {
		dashboardpageobjects.clickonApplicationFromDropdown(application);
	    
	}

	@And("Click on product dropdown from filter")
	public void click_on_product_dropdown_from_filter() {
	    dashboardpageobjects.clickOnProductDropdown();
	}

	@And("Select the product as {string}")
	public void select_the_product_as(String product) throws InterruptedException {
	    dashboardpageobjects.clickonProductFromDropdown(product);
	}

	@And("Click on search button")
	public void click_on_search_button() throws InterruptedException {
	   dashboardpageobjects.clickOnSearchButton();
	}

	@Then("validate widget values should contains Accounts {string}")
	public void validate_widget_values_should_contains_accounts(String accountName) throws InterruptedException {
	    dashboardpageobjects.validateWidgetDataAfterSearch(accountName);
	}

	/////--------SCENARIO-4 -------------//
	
	@Then("Validate the menu items should be {string}")
	public void validate_the_menu_items_should_be(String menuItemSize) {
	    dashboardpageobjects.validateMenuItems(menuItemSize);
	}

	
	////--------SCENARIO-5---------------------/////
	
	@And("Mouseover on design and expand design dropdown and click on test cases")
	public void mouseover_on_design_and_expand_design_dropdown_and_click_on_test_cases() throws InterruptedException {
		Thread.sleep(5000);
	    designtestcasesobjects.clickonDesignMenuItem();
	    Thread.sleep(2000);
	    designtestcasesobjects.clickonTestCasesMenuItem();
	    Thread.sleep(6000);
	}

	@Then("Verify the page should have test cases atleast one")
	public void verify_the_page_should_have_test_cases_atleast_one() {
	    designtestcasesobjects.validateTCPage();
	}

}
