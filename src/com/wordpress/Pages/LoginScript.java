package com.wordpress.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.ConfigReader;

public class LoginScript {
	private ChromeDriver driver;
	@BeforeMethod
	public void setUp() throws Exception{
		
		ConfigReader configReader = new ConfigReader();
		String url = configReader.getChromePath();
		driver = new ChromeDriver();
		driver.get(url);
		Reporter.log("====Application Started =====",true);
	}
	@Test
	public void loginToApplication() throws Exception{
		driver.findElement(By.name("userName")).sendKeys("tom");
		driver.findElement(By.name("pwd")).sendKeys("tom");
		driver.findElement(By.name("dl")).click();
		Reporter.log("====Click on login Session End =====",true);
	}
	@AfterMethod
	public void closeApplication(){
		driver.quit();
		Reporter.log("========Browser Session End=======",true);
	}
	
}
