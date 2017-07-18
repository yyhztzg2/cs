package com.wordpress.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.wordpress.Pages.LoginPageNew;

import Helper.BrowserFactory;
import lib.ExcelDataConfig;

public class VerfyValidLogin {
	@Test
	public void checkValidUser() throws Exception{
		ExcelDataConfig sheet1 = new ExcelDataConfig("TestData\\InputData.xlsx", 0);
		int rowCount = sheet1.getRowCount(0);
		System.out.println(rowCount);
		WebDriver driver = BrowserFactory.startBrowser1("chrome", "http://localhost:8080/emp_sys/login.jsp");
		LoginPageNew pageNew = PageFactory.initElements(driver, LoginPageNew.class);
		pageNew.login_wordpress(sheet1.getData(0, 0), sheet1.getData(0, 1));
		
	}

}
