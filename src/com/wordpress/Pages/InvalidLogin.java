package com.wordpress.Pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


public class InvalidLogin  extends BaseClass{
	@Test(description="this TC will perform valid login")
	public void loginToApplication() throws InterruptedException{
		driver.findElement(By.name("userName")).sendKeys("tom");
		driver.findElement(By.name("pwd")).sendKeys("tom");
		driver.findElement(By.name("dl")).click();
		Thread.sleep(6333);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("M1y"));

		logger.log(LogStatus.PASS, "Title verified");
//		Reporter.log("====Click on login Session End =====",true);
	}
//	@Test(description="this TC will perform invalid login")
//	public void loginToApplication1() throws InterruptedException{
//		driver.findElement(By.name("userName")).sendKeys("tom111111111");
//		driver.findElement(By.name("pwd")).sendKeys("tom1");
//		driver.findElement(By.name("dl")).click();
////		Reporter.log("====Click on login Session End =====",true);
//		Thread.sleep(3333);
//	}
}
