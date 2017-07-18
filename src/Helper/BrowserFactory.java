package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	static WebDriver driver;
	public static WebDriver startBrowser(String browserName,String url){
		if (browserName.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if (browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (browserName.equals("IE")) {
			driver=new InternetExplorerDriver();
		}
		driver.get(url);
		return driver;
	}
	public static WebDriver startBrowser1(String browserName,String url){
		switch (browserName) {
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;

		default:
			driver=new InternetExplorerDriver();
			break;
		}
		driver.get(url);
		return driver;
	}
}
