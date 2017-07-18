package com.wordpress.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.wordpress.Pages.loginPage;

public class VerifyWordPressLogin {
	@Test
	public void verifyValidLogin() throws Exception{
		ChromeDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get("http://localhost:8080/emp_sys/login.jsp");
		Thread.sleep(2222);
		loginPage loginPage = new loginPage(driver);
		Thread.sleep(2222);
		loginPage.typeUserName("tom");
		loginPage.typeUserPassword("123");
		loginPage.clickOnLoginButton();
	}
}
