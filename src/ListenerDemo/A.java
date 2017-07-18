package ListenerDemo;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class A {
	@Test
	public void test1(){
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
