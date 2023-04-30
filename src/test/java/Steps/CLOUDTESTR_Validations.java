package Steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.PageObjects.CT_DashboardPageObjects;
import com.PageObjects.CT_LoginPageObjects;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CLOUDTESTR_Validations {
	
	public WebDriver driver;
	CT_LoginPageObjects loginpageobjects;
	CT_DashboardPageObjects dashboardpageobjects;
	
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
	public void click_on_application_dropdown_from_filter() {
		dashboardpageobjects.clickOnApplicationDropdown();
	   
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



}
