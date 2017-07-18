package AdvanceReports;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import utility.ConfigReader;

public class VerifySeleniumTitle {
	private ChromeDriver driver;

	@Test
	public void verfyTitle() throws Throwable{
		ExtentReports logger = ExtentReports.get(VerifySeleniumTitle.class);
		logger.init("d:/log2g1er.html", true);
		logger.startTest("verify Page Title");
		ConfigReader configReader = new ConfigReader();
//		logger.log(LogStatus.INFO, "browser is running");
		String url = configReader.getChromePath();
		driver = new ChromeDriver();
		driver.get(url);
//		logger.log(LogStatus.INFO, "application is running");
		String title = driver.getTitle();
//		logger.log(LogStatus.INFO, "title is captured");
		Assert.assertTrue(title.contains("My"));
		logger.log(LogStatus.PASS, "Title is verified");
//		logger.attachScreenshot("d:\\logger.png");
		logger.endTest();
	}
}
