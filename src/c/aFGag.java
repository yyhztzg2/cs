package c;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class aFGag {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/emp_sys/login.jsp");

		String title1 = driver.getTitle();
		System.out.println(title1);
		Thread.sleep(3333);
		driver.findElement(By.name("userName")).sendKeys("tom");
		driver.findElement(By.name("pwd")).sendKeys("tom");
		driver.findElement(By.name("dl")).click();
		Thread.sleep(3333);

		String title = driver.getTitle();
		System.out.println(title);
		
	}
}
