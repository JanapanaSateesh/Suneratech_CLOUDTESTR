package com.PageObjects;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CT_LoginPageObjects {
	
	public WebDriver rdriver;
	
	public CT_LoginPageObjects(WebDriver ldriver){
		rdriver=ldriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//p[text()='User Name ']/../..//input")
	WebElement username;
	
	@FindBy(xpath="//p[text()='Password ']/../..//input")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement loginButton;
	
	public void setUserName(String uname) {
		username.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void validatePageTitle() {
		String pageTitle = rdriver.getTitle();
		System.out.println("Page Title "+pageTitle);
		assertEquals("CloudTestr - Login", pageTitle);
	}

}
