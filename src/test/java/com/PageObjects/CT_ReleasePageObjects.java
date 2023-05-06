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

public class CT_ReleasePageObjects {

	public WebDriver rdriver;
	MouseOver mouseover;
	JSExecutor js;
	ExplicitWait explicitwait;
	public CT_ReleasePageObjects(WebDriver ldriver) {
		rdriver=ldriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//span[text()='Plan']")
	WebElement planmenuitem;
	
	@FindBy(xpath="//span[text()='Releases']")
	WebElement release;
	
	@FindBys(@FindBy(xpath="//app-releases//div[@class='row'][1]//app-panel"))
	List<WebElement> releasesdata;
	
	@FindBy(xpath="//input[@placeholder='Key Word']")
	WebElement releasename;
	
	
	public void clickOnPlan() {
		explicitwait = new ExplicitWait(rdriver, planmenuitem);
		planmenuitem.click();
	}
	
	public void clickOnRelease() {
		explicitwait = new ExplicitWait(rdriver, release);
		release.click();
	}
	
	public void ValidateReleaseData() {
	 assertTrue(releasesdata.size()>0);
	}
	
	public void setReleaseName(String relName) {
		releasename.sendKeys(relName);
	}
	
	public void ValidateReleaseAfterSearch() {
		assertTrue(releasesdata.size()==1);
	}
}
