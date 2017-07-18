package com.wordpress.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class fdahfdh {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get("http://localhost:8080/emp_sys/login.jsp");
		Thread.sleep(3333);
		driver.findElement(By.name("userName")).sendKeys("tom");
		driver.findElement(By.name("pwd")).sendKeys("123");
		Thread.sleep(3333);
		driver.findElement(By.name("dl")).click();
	}
}
