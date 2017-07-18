package baogao;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.Utility;

public class VerifyTitle {

	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;

	@Test
	public void verifyBlogTitle() {
		report = new ExtentReports("C:\\Report\\LearnAutomation.html");

		logger = report.startTest("VerifyBlogTitle66666");

		driver = new FirefoxDriver();

		// driver.manage().window().maximize();

		// logger.log(LogStatus.INFO, "Browser started ");

		driver.get("http://www.baidu.com");

		// logger.log(LogStatus.INFO, "Application is up and running");

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("M1y"));

		logger.log(LogStatus.PASS, "Title verified");
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

//		driver.get("file:///C:\\Report\\LearnAutomation.html");
	}
}
