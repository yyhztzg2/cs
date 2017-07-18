package com.wordpress.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPageNew {
	WebDriver driver;
	
	public LoginPageNew(WebDriver driver) {
		super();
		this.driver = driver;
	}
	@FindBy(name="userName")
	WebElement username;
	@FindBy(name="pwd")
	WebElement pwd;
	@FindBy(name="dl")
	//@CacheLookup
	WebElement dl;
	public void login_wordpress(String uid,String pas){
		username.sendKeys(uid);
		pwd.sendKeys(pas);
		dl.click();
	}

}
