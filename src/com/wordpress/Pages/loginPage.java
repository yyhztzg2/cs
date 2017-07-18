package com.wordpress.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	WebDriver driver;
	By username=By.name("userName");
	By pwd=By.name("pwd");
	By dl=By.name("dl");
	public loginPage(WebDriver driver){
		this.driver=driver;
	}
	public void loginToWordpress(String userid,String password){
		driver.findElement(username).sendKeys(userid);
		driver.findElement(pwd).sendKeys(password);
	}
	public void typeUserName(String uid){
		driver.findElement(username).sendKeys(uid);
	}
	
	public void typeUserPassword(String password){
		driver.findElement(pwd).sendKeys(password);
	}
	public void clickOnLoginButton(){
		driver.findElement(dl).click();
	}
	
}
