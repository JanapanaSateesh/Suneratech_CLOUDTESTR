package com.PageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExplicitWait;
import Utilities.JSExecutor;


public class CT_DashboardPageObjects {

	public ExplicitWait explicitwait;
	public JSExecutor js;
	public WebDriver rdriver;
	public CT_DashboardPageObjects(WebDriver ldriver) {
		rdriver=ldriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBys(@FindBy(xpath="//div[@id='groupsAccordian']"))
	List<WebElement> widgets;
	
	@FindBy(xpath="//div[@class='dropdown drop-ht']//button[@name='Application']")
	WebElement applicationdropdown;
	
	@FindBy(xpath="//div[@class='dropdown drop-ht']//button[@name='Product']")
	WebElement productdropdown;
	
	@FindBy(xpath="//button//span[text()='Search']")
	WebElement searchbutton;
	
	@FindBys(@FindBy(xpath="//app-sidebar//ul//li[@class='nav-list m-0']"))
	List<WebElement> menuItemsList;
	
	
	
		
	public void validateWidgets(String widgetCount) {
		int actualWidgetSize = widgets.size();
		System.out.println("Actual Widets "+actualWidgetSize);
		
		int expectedWidgetSize = Integer.parseInt(widgetCount);
		
		System.out.println("Expected Widets "+expectedWidgetSize);
		assertEquals(expectedWidgetSize, actualWidgetSize);
	}
	
	
	public void clickOnApplicationDropdown() {
		
		explicitwait= new ExplicitWait(rdriver, applicationdropdown);
		js=new JSExecutor(rdriver, applicationdropdown);
		//applicationdropdown.click();
	}
	
	public void clickonApplicationFromDropdown(String Application) {
		rdriver.findElement(By.xpath("//label[contains(text(),'"+Application+"')]")).click();
	}
	
	public void clickOnProductDropdown() {
		
		explicitwait= new ExplicitWait(rdriver, productdropdown);
		js=new JSExecutor(rdriver, productdropdown);
		
	}
	
	public void clickonProductFromDropdown(String Product) throws InterruptedException {
		Thread.sleep(5000);
		rdriver.findElement(By.xpath("//label[contains(text(),'"+Product+"')]")).click();
	}
	
	public void clickOnSearchButton() throws InterruptedException {
		searchbutton.click();
		Thread.sleep(5000);
	}
	
	public void validateWidgetDataAfterSearch(String widgetData) throws InterruptedException {
		//String validateAccount = rdriver.findElement(By.xpath("//span[@class='graphLabel']")).getText();
		List<WebElement> WidgeDataAccounts = rdriver.findElements(By.xpath("//span[@class='graphLabel']"));
		
		for(WebElement ele:WidgeDataAccounts) {
			explicitwait= new ExplicitWait(rdriver, ele);
			String validateAccount = ele.getText();	
			Thread.sleep(2000);
			System.out.println("Account Names after search---"+validateAccount);
			
			assertTrue(validateAccount.toLowerCase().contains(widgetData.toLowerCase()));
		}
	}
	
	public void validateMenuItems(String menuSize) {
		
		int menuItemActualSize = menuItemsList.size();
		int menuItemExpectedSize=Integer.parseInt(menuSize);
		System.out.println("Actual Menu Items Size from Application "+""+menuItemActualSize);
		System.out.println("Expected Menu Items Size "+menuSize);
		
		assertEquals(menuItemActualSize,menuItemExpectedSize);
	}
	
	
}
