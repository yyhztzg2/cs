package Helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;

public class Utility {
	public static String captureScreenshot(WebDriver driver,String screenshotName) throws IOException{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		String dest="E:\\workspace2\\Assss\\TestData"+screenshotName+".png";
		File file = new File(dest);
		FileUtils.copyFile(screenshotAs, file);
		return dest;
	}
	public static void main(String[] args) throws IOException {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.google.com");
//		String captureScreenshot = captureScreenshot(driver, "yyyyyyyyyyyy");
//		System.out.println(captureScreenshot);
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
//		Date date = new Date();
		String localeString = new Date().toLocaleString();
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd-HH.mm.ss");
	    String format = simpleDateFormat.format(new Date());
	    
		System.out.println(format);
		FileUtils.copyFile(screenshotAs, new File("TestData/"+format+".png"));
	}
}
