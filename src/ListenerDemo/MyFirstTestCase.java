package ListenerDemo;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(ListenerDemo.TestNGListener.class)
public class MyFirstTestCase {
	@Test
	public void GoogleTitleVerify(){
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}
	@Test
	public void TitleMatch(){
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
