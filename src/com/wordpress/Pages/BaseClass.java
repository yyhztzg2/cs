package com.wordpress.Pages;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.Utility;
import utility.ConfigReader;

public class BaseClass {
	public  WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger; 
//	protected ExtentReports report;
//	protected ExtentTest logger;
	@BeforeMethod
	public void setUp() throws Exception{
		report=new ExtentReports("C:\\Report\\LearnAutomation.html");
		logger=report.startTest("VerifyBlogTitle123");
		ConfigReader configReader = new ConfigReader();
		String url = configReader.getChromePath();
		driver = new FirefoxDriver();
//		logger.log(LogStatus.INFO, "browser started");
		driver.get(url);
//		logger.log(LogStatus.INFO, "app started");
//		Reporter.log("====Application Started =====",true);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			String screenshot_path = Utility.captureScreenshot(driver, result.getName());
			// System.out.println("--------------------------------------------------------------------------------------------------------------------");
			// System.out.println(result.getName());//verifyBlogTitle
			// System.out.println(screenshot_path);//TestData\verifyBlogTitle.png
			String image = logger.addScreenCapture(screenshot_path);// ÎªÊ²Ã´·µ»Øimage,
			// System.out.println(image);//¡¢¡¢<img class='report-img
			// materialboxed' src='TestData\verifyBlogTitle.png' />
			logger.log(LogStatus.FAIL, "Title verification", image);

		}

		report.endTest(logger);
		report.flush();

		driver.get("file:///C:\\Report\\LearnAutomation.html");
	}
}
