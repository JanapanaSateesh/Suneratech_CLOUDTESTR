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

public class CT_DesignTestCasesPageObjects {

	public WebDriver rdriver;
	MouseOver mouseover;
	JSExecutor js;
	ExplicitWait explicitwait;
	public CT_DesignTestCasesPageObjects(WebDriver ldriver) {
		rdriver=ldriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//span[text()='Design']/..//span[1]")
	WebElement designmenuitem;
	
	@FindBy(xpath="//span[text()='Test Cases']")
	WebElement testcasesmenuitem;
	
	@FindBys(@FindBy(xpath="//table//tbody//tr//td[2]//span"))
	List<WebElement> listoftestcases;
	
	@FindBy(xpath="//input[@placeholder='Key Word']")
	WebElement testcasesearchinput;
	
	@FindBy(xpath="//span[text()='Search']/parent::button")
	WebElement searchbutton;
	
	
	
	public void clickonDesignMenuItem() throws InterruptedException {
		explicitwait = new ExplicitWait(rdriver, designmenuitem);
		mouseover= new MouseOver(rdriver, designmenuitem);
		Thread.sleep(5000);
		js=new JSExecutor(rdriver, designmenuitem);
	}
	
	public void clickonTestCasesMenuItem() {
		explicitwait = new ExplicitWait(rdriver, testcasesmenuitem);
		js=new JSExecutor(rdriver, testcasesmenuitem);
	}
	
	public void validateTCPage() {
		
		assertTrue(listoftestcases.size()>0);
		for(WebElement ele:listoftestcases) {
			explicitwait= new ExplicitWait(rdriver, ele);
			String TCName =ele.getText();
			System.out.println("List of TCs are available --"+ ""+TCName);
		}
	}
	
	public String TestCaseId=null;
	public void searchTestCase(String testcaseid) {
		TestCaseId=testcaseid;
		testcasesearchinput.sendKeys(testcaseid);
	}
	
	public void clickOnSearchButton() {
		searchbutton.click();
	}
	
	public void validateTestCaseAfterSearch() {
		assertTrue(listoftestcases.size()==1);
		for(WebElement ele:listoftestcases) {
			explicitwait= new ExplicitWait(rdriver, ele);	
			String TCName =ele.getText();
			System.out.println("Test Case Id from above method"+ TestCaseId);
			assertTrue(TCName.contains(TestCaseId));
			System.out.println("List of TCs are available --"+ ""+TCName);
		}
	}
}
