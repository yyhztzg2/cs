package SmokeTest;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import com.relevantcodes.extentreports.LogStatus;
import com.wordpress.Pages.BaseClass;

public class VerifyTitle  extends BaseClass{
	
	@Test
	public void verifyBlogTitle(){
		String title = driver.getTitle();

		Assert.assertTrue(title.contains("ssssM"));

		logger.log(LogStatus.PASS, "Title verified");
	}
}
