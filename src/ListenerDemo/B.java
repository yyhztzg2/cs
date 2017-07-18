package ListenerDemo;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class B {
	@Test
	public void test2(){
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
