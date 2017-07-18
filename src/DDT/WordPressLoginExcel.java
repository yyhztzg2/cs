package DDT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wordpress.Pages.BaseClass;

import lib.ExcelDataConfig;

public class WordPressLoginExcel {
	private ChromeDriver driver;

	@Test(dataProvider="wordpressData")
	public void loginToWordpress(String u,String p) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/emp_sys/login.jsp");
		driver.findElement(By.name("userName")).sendKeys(u);
		driver.findElement(By.name("pwd")).sendKeys(p);
		Thread.sleep(5333);
		driver.findElement(By.name("dl")).click();
		Thread.sleep(5333);
		System.out.println(driver.getTitle());
		System.out.println(u+"="+p);
		
	
	}
	@AfterMethod
	public void tearDown(){
//		driver.quit();
		
	}

	@DataProvider(name="wordpressData")
	public Object[][] passData() throws Exception {
		
		
		ExcelDataConfig sheet1 = new ExcelDataConfig("TestData\\InputData.xlsx", 0);
		int rowCount = sheet1.getRowCount(0);
		System.out.println(rowCount);
		Object[][] data = new Object[rowCount][2];
//		data[0][0] = "a";
//		data[0][1] = "a1";
//
//		data[1][0] = "b";
//		data[1][1] = "b1";
//
//		data[2][0] = "tom";
//		data[2][1] = "123";
		ArrayList<String> list = new ArrayList<>();
		for (int i = 1; i <rowCount; i++) {
			data[i][0]=sheet1.getData(i, 0);
			data[i][1]=sheet1.getData(i, 1);
			System.out.println(data[i][0]+"==="+data[i][1]);
			list.add("i");
			File file = new File("TestData\\InputData2.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet2 = wb.getSheetAt(0);
//			sheet1.getRow(1).createCell(2).setCellValue("PASS");
//			sheet1.getRow(2).createCell(2).setCellValue("FAIL");
			for (int j = 0; j <2;j++) {
				sheet2.getRow(j).createCell(2).setCellValue("x");
			}
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			wb.write(fileOutputStream);
			wb.close();
		}

		return data;
	}

}
