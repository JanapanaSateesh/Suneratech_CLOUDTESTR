package com.PageObjects;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExplicitWait;
import Utilities.JSExecutor;
import Utilities.MouseOver;

public class CT_TestCasePageObjects {

	public WebDriver rdriver;
	MouseOver mouseover;
	JSExecutor js;
	ExplicitWait explicitwait;
	public CT_TestCasePageObjects(WebDriver ldriver) {
		rdriver=ldriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	
	@FindBy(xpath="//table//tbody//tr//td[2]//span")
	WebElement testcase;
	
	public void clickOnTestCase() {
		explicitwait = new ExplicitWait(rdriver, testcase);
		testcase.click();
	}
	
	///-AUDIT LOG---//
	
	@FindBy(xpath="//app-tabs//span[contains(text(),'Audit Log')]")
	WebElement auditlog;
	
    @FindBys(@FindBy(xpath="//span[text()=' Time']/ancestor::table//tbody//tr//td"))
	List<WebElement> auditlogdata;
	
	
	public void clickONAuditLog() throws InterruptedException 
	{
		Thread.sleep(5000);
		explicitwait = new ExplicitWait(rdriver, auditlog);
		auditlog.click();
	}
	
	public void validateAuditLog() {
		assertTrue(auditlogdata.size()>0);
	}
	
	///-- Documentation -- //
	@FindBy(xpath="//app-documentation//img")
	WebElement documentationimage;
	
	public void validateDocImages() {
		explicitwait = new ExplicitWait(rdriver, documentationimage);
		assertTrue(documentationimage.isDisplayed());
	}
	
	//---Configuration--//
	
	@FindBy(xpath="//app-tabs//span[contains(text(),'Configuration')]")
	WebElement configurationtab;
	
	@FindBys(@FindBy(xpath="//app-configuration//tbody//tr//td[1]"))
	List<WebElement> configurationlines;
	
	public void clickOnConfigurationTab() {
		explicitwait = new ExplicitWait(rdriver, configurationtab);
		configurationtab.click();
	}
	
	public void validateConfigurationLines() {
		assertTrue(configurationlines.size()>0);
	}
	
	
	//---Run History--//
	
		@FindBy(xpath="//app-tabs//span[contains(text(),'Run History')]")
		WebElement runhistorytab;
		
		@FindBys(@FindBy(xpath="//app-run-history//tbody//tr"))
		List<WebElement> resultfiles;
		
		public void clickOnRunHistoryTab() {
			explicitwait = new ExplicitWait(rdriver, runhistorytab);
			runhistorytab.click();
		}
		
		public void validateResultFiles() {
			assertTrue(resultfiles.size()>0);
		}
	
}
