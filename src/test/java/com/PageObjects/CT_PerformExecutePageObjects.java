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

public class CT_PerformExecutePageObjects {

	public WebDriver rdriver;
	MouseOver mouseover;
	JSExecutor js;
	ExplicitWait explicitwait;
	public CT_PerformExecutePageObjects(WebDriver ldriver) {
		rdriver=ldriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//span[text()='Perform']")
	WebElement performmenuitem;
	
	@FindBy(xpath="//span[text()='Execute']")
	WebElement execute;
	
	@FindBys(@FindBy(xpath="//app-execute//div[@class='row'][1]//app-panel"))
	List<WebElement> executiondata;
	
	@FindBy(xpath="//input[@placeholder='Key Word']")
	WebElement releasename;
	
	
	public void clickOnPerform() {
		explicitwait = new ExplicitWait(rdriver, performmenuitem);
		performmenuitem.click();
	}
	
	public void clickOnExecute() {
		explicitwait = new ExplicitWait(rdriver, execute);
		execute.click();
	}
	
	public void ValidateExecutionData() {
	 assertTrue(executiondata.size()>0);
	}
	
	public void setReleaseName(String relName) {
		releasename.sendKeys(relName);
	}
	
	public void ValidateExecutionPageAfterSearch() {
		assertTrue(executiondata.size()==1);
	}
}
