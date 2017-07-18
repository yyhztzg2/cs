package ListenerDemo;

import org.openqa.selenium.chrome.ChromeDriver;

public class riutri {
public static void main(String[] args) {
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.google.com");
	System.out.println(driver.getTitle());
	
}
}
