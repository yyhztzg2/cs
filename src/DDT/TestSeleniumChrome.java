package DDT;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utility.ConfigReader;

public class TestSeleniumChrome {
	@Test
	public void testChrome() throws Exception{
		ConfigReader configReader = new ConfigReader();
		String url = configReader.getChromePath();
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);
	}
}
