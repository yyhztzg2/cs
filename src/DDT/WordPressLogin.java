package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WordPressLogin {
	private ChromeDriver driver;

	@Test(dataProvider="wordpressData")
	public void loginToWordpress(String u,String p) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/emp_sys/login.jsp");
		driver.findElement(By.name("userName")).sendKeys(u);
		driver.findElement(By.name("pwd")).sendKeys(p);
		Thread.sleep(5333);
		driver.findElement(By.name("dl")).click();
		System.out.println(driver.getTitle());
//		Assert.assertTrue(dr);
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
		
	}

	@DataProvider(name="wordpressData")
	public Object[][] passData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "a";
		data[0][1] = "a1";

		data[1][0] = "b";
		data[1][1] = "b1";

		data[2][0] = "tom";
		data[2][1] = "123";

		return data;
	}

}
