package Steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.PageObjects.CT_DashboardPageObjects;
import com.PageObjects.CT_DesignTestCasesPageObjects;
import com.PageObjects.CT_DesignTestSetPageObjects;
import com.PageObjects.CT_IntegrationsPageObjects;
import com.PageObjects.CT_LoginPageObjects;
import com.PageObjects.CT_PerformExecutePageObjects;
import com.PageObjects.CT_ReleasePageObjects;
import com.PageObjects.CT_TestCasePageObjects;
import com.PageObjects.CT_TestSetPageObjects;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.codec.base64.Base64;

public class CLOUDTESTR_Validations {
	
	//public WebDriver driver;
	
	WebDriver driver=BaseClass.getDriver();
	
	CT_LoginPageObjects loginpageobjects;
	CT_DashboardPageObjects dashboardpageobjects;
	CT_DesignTestCasesPageObjects designtestcasesobjects;
	CT_DesignTestSetPageObjects designtestsetobjects;
	CT_TestCasePageObjects testcasespageobjects;
	CT_TestSetPageObjects testSetPageObjects;
	CT_IntegrationsPageObjects integrationspageobjects;
	CT_ReleasePageObjects releasepageobjects;
	CT_PerformExecutePageObjects performexecutepageobjects;
	
	@Given("Lanuch the URL {string}")
	public void lanuch_the_url(String url) {
		
	    driver.get(url);
	    loginpageobjects = new CT_LoginPageObjects(driver);
	    dashboardpageobjects = new CT_DashboardPageObjects(driver);
	    designtestcasesobjects = new CT_DesignTestCasesPageObjects(driver);
	    designtestsetobjects = new CT_DesignTestSetPageObjects(driver);
	    testcasespageobjects = new CT_TestCasePageObjects(driver);
	    testSetPageObjects = new CT_TestSetPageObjects(driver);
	    integrationspageobjects = new CT_IntegrationsPageObjects(driver);
	    releasepageobjects = new CT_ReleasePageObjects(driver);
	    performexecutepageobjects = new CT_PerformExecutePageObjects(driver);
	}

	@When("Enter the username  and password")
	public void enter_the_username_and_password(io.cucumber.datatable.DataTable dataTable) {
	   List<Map<String,String>> credentialsList = dataTable.asMaps();
	   String username = credentialsList.get(0).get("username");
	   String password = credentialsList.get(0).get("password");
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
		Thread.sleep(6000);
	   dashboardpageobjects.clickOnSearchButton();
	   Thread.sleep(6000);
	   
	   //driver.findElement(By.xpath("//p[contains(text(),'Search')]")).click();
	   Thread.sleep(6000);
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
	
	
	
	////---------SCENARIO-7------------///
	
	@When("Search with the test case id {string}")
	public void search_with_the_test_case_id(String TCID) {
	    designtestcasesobjects.searchTestCase(TCID);
	}

	@Then("Validate the test case should contain the test case id in the above step")
	public void validate_the_test_case_should_contain_the_test_case_id_in_the_above_step() {
	    designtestcasesobjects.validateTestCaseAfterSearch();
	}
	
	
	/////-----------SCENARIO-8-------------------///
	
	@When("Click on test case")
	public void click_on_test_case() throws InterruptedException {
		Thread.sleep(3000);
	    testcasespageobjects.clickOnTestCase();
	}

	@When("Click on audit log tab")
	public void click_on_audit_log_tab() throws InterruptedException {
		testcasespageobjects.clickONAuditLog();
	   
	}

	@Then("Validate audit log has data")
	public void validate_audit_log_has_data() {
	    testcasespageobjects.validateAuditLog();
	}
	
	//--------------SCENARIO - 9 ---------------//
	
	@Then("Vefify documentation tab should have images")
	public void vefify_documentation_tab_should_have_images() throws InterruptedException {
		Thread.sleep(4000);
	    testcasespageobjects.validateDocImages();
	}
	
	//--------SCENARIO-10---------//
	
	@When("Click on configuration tab")
	public void click_on_configuration_tab() throws InterruptedException {
		
	   testcasespageobjects.clickOnConfigurationTab();
	   Thread.sleep(3000);
	}

	@And("Vefify configuration tab should have config lines")
	public void vefify_configuration_tab_should_have_config_lines() {
		
	    testcasespageobjects.validateConfigurationLines();
	}

	//-----SCENARIO 11------------//
	
	@And("Click on runhistory tab")
	public void click_on_runhistory_tab() throws InterruptedException {
	    testcasespageobjects.clickOnRunHistoryTab();
	    Thread.sleep(3000);
	}

	@Then("Vefify runhistory tab should have result files")
	public void vefify_runhistory_tab_should_have_result_files() {
	    testcasespageobjects.validateResultFiles();
	}
	
	
	///////////////---------SCENARIO-12-------------------///

	@And("Mouseover on design and expand design dropdown and click on test set")
	public void mouseover_on_design_and_expand_design_dropdown_and_click_on_test_set() throws InterruptedException {

		Thread.sleep(5000);
		designtestcasesobjects.clickonDesignMenuItem();
		Thread.sleep(2000);
		designtestsetobjects.clickonTestSetMenuItem();
		Thread.sleep(4000);
	}

	@Then("Verify the page should have test set atleast one")
	public void verify_the_page_should_have_test_set_atleast_one() {
		designtestsetobjects.validateTestSetPage();
	}

	////-----------SCENARIO -13---------------/////


	@And("Search with the test set id {string}")
	public void search_with_the_test_set_id(String testsetid) {
		designtestsetobjects.searchTestSet(testsetid);
	}

	@Then("Validate the test set should contain the test set id in the above step")
	public void validate_the_test_set_should_contain_the_test_set_id_in_the_above_step() {
		designtestsetobjects.validateTestSetId();
	}
	
	
	///--------SCENARIO-14----------------------//
	

	@And("Click on test set")
	public void click_on_test_set() {
	    testSetPageObjects.clickOnTestSet();
	}
	
	//-----SCENARIO-15-//
	
	@Then("Vefify test set runhistory tab should have result files")
	public void vefify_test_set_runhistory_tab_should_have_result_files() {
	    testSetPageObjects.validateTestSetRunHistory();
	}
	
	//---SCENARIO-16--//
	
	@And("Mouseover on integrations")
	public void mouseover_on_integrations() {
	    integrationspageobjects.mouseOverIntegrationsMenuItem();
	}

	@And("Click on Integrations")
	public void click_on_integrations() {
		integrationspageobjects.clickOnintegrations();
	   
	}

	@And("Validate integrations page title")
	public void validate_integrations_page_title() {
	    integrationspageobjects.validateIntegrationsPageTitle();
	}

	@Then("Click on Rest tab and rest tab should have the data")
	public void click_on_rest_tab_and_rest_tab_should_have_the_data() {
	    integrationspageobjects.clickOnRestTab();
	    integrationspageobjects.ValidateRestTabData();
	}
	
	//----SCENARIO-17--//

	@And("Click on plan")
	public void click_on_plan() {
		releasepageobjects.clickOnPlan();
	}

	@And("Click on Releases")
	public void click_on_releases() throws InterruptedException {
		releasepageobjects.clickOnRelease();
		Thread.sleep(5000);
	}

	@Then("Validate the releases have the releases data")
	public void validate_the_releases_have_the_releases_data() {
		releasepageobjects.ValidateReleaseData();
	}

	////-----SCENARIO-18--////

	@And("Search for the release name {string}")
	public void search_for_the_release_name(String ReleaseName) {
		releasepageobjects.setReleaseName(ReleaseName);
	}

	@Then("Validate only one release should display")
	public void validate_only_one_release_should_display() {
		releasepageobjects.ValidateReleaseAfterSearch();
	}
	
	//--SCENARIO-19--//
	
	@And("Click on perform")
	public void click_on_perform() {
	    performexecutepageobjects.clickOnPerform();
	}

	@And("Click on Execute")
	public void click_on_execute() {
	    performexecutepageobjects.clickOnExecute();
	}

	@Then("Validate the execution page have the releases data")
	public void validate_the_execution_page_have_the_releases_data() {
	  performexecutepageobjects.ValidateExecutionData();
	}
	
	//--SCENARIO-20--//
	@Then("Validate only one release should display in execution page")
	public void validate_only_one_release_should_display_in_execution_page() {
	    performexecutepageobjects.ValidateExecutionPageAfterSearch();
	}

}
