package com.PageObjects;

import static org.junit.Assert.assertEquals;
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

public class CT_TestSetPageObjects {

	public WebDriver rdriver;
	MouseOver mouseover;
	JSExecutor js;
	ExplicitWait explicitwait;
	public CT_TestSetPageObjects(WebDriver ldriver) {
		rdriver=ldriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	
	@FindBy(xpath="//table//tbody//tr//td[2]//span/..")
	WebElement testset;
	
	public void clickOnTestSet() {
		explicitwait = new ExplicitWait(rdriver, testset);
		testset.click();
	}
	
	///Test Set Run History--//
	@FindBys(@FindBy(xpath="(//app-test-set-run-history//table/tbody//tr//td[8])[1]"))
	List<WebElement> testsetrunhistory;
	
	public void validateTestSetRunHistory() {
		
		assertTrue(testsetrunhistory.size()>0);
		
		for(WebElement ele:testsetrunhistory) {
			String status = ele.getText();
			System.out.println("Test Set status --"+ status);
		}
	}
	
	
}
