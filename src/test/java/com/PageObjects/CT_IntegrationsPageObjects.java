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

public class CT_IntegrationsPageObjects {


	public WebDriver rdriver;
	MouseOver mouseover;
	JSExecutor js;
	ExplicitWait explicitwait;
	public CT_IntegrationsPageObjects(WebDriver ldriver) {
		rdriver=ldriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//span[text()='Integrations']/..//span[1]")
	WebElement integrationsmenuitem;
	
	@FindBy(xpath="//span[text()='Integrations']")
	WebElement integrations;
	
	@FindBy(xpath="//app-integration//span[text()='REST']")
	WebElement resttab;
	
	
	@FindBys(@FindBy(xpath="//app-data-table//tbody//tr[1]//td"))
	List<WebElement> restdata;
	
	
	public void mouseOverIntegrationsMenuItem() {
		mouseover = new MouseOver(rdriver, integrationsmenuitem);
	}
	
	public void clickOnintegrations() {
		integrations.click();
	}
	
	public void validateIntegrationsPageTitle() {
		String integrationscurrenttitle=rdriver.getTitle();
		System.out.println("Current Integrations page title "+ integrationscurrenttitle);
		assertEquals("CloudTestr - Integrations", integrationscurrenttitle);
	}
	
	public void clickOnRestTab() {
		resttab.click();
	}
	
	public void ValidateRestTabData() {
		
		System.out.println("size of rest data "+restdata.size());
		assertTrue(restdata.size()>0);
	}
}
