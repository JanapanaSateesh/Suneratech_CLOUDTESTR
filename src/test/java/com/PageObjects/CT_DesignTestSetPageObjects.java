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

public class CT_DesignTestSetPageObjects {

	public WebDriver rdriver;
	MouseOver mouseover;
	JSExecutor js;
	ExplicitWait explicitwait;
	public CT_DesignTestSetPageObjects(WebDriver ldriver) {
		rdriver=ldriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(xpath="//span[text()='Test Sets']")
	WebElement testsetsmenuitem;
	
	@FindBys(@FindBy(xpath="//table//tbody//tr//td[2]//span"))
	List<WebElement> listoftestsets;

	@FindBy(xpath="//input[@placeholder='Key Word']")
	WebElement testsetsearch;
	
	@FindBy(xpath="//span[text()='Search']/parent::button")
	WebElement searchbutton;
	
	
	
	public void clickonTestSetMenuItem() {
		explicitwait = new ExplicitWait(rdriver, testsetsmenuitem);
		js=new JSExecutor(rdriver, testsetsmenuitem);
	}
	
	public void validateTestSetPage() {
		
		assertTrue(listoftestsets.size()>0);
		for(WebElement ele:listoftestsets) {
			explicitwait= new ExplicitWait(rdriver, ele);
			String TestSetName =ele.getText();
			System.out.println("List of Test Sets are available --"+ ""+TestSetName);
		}
	}
	
	public String TestSetId=null;
	public void searchTestSet(String testsetid) {
		testsetsearch.sendKeys(testsetid);
		TestSetId=testsetid;
		
	}
	
	public void validateTestSetId() {
						
		assertTrue(listoftestsets.size()>0);
		for(WebElement ele:listoftestsets) {
			explicitwait= new ExplicitWait(rdriver, ele);
			String TestSetName =ele.getText();
			System.out.println("Test Set Id from above method"+ TestSetId);
			assertTrue(TestSetName.contains(TestSetId));
			System.out.println("List of Test Sets are available --"+ ""+TestSetName);
		}
		
	}
	
	public void clickOnSearch() {
		searchbutton.click();
	}
}
