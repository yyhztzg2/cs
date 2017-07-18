package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings(value = { "unused" })
public class ExcelDataConfig {
	public XSSFWorkbook wb;
	public XSSFSheet sheet1;

	public ExcelDataConfig(String excelPath,int sheetNumber) throws Exception{
		File file = new File(excelPath);
		FileInputStream fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet1 = wb.getSheetAt(sheetNumber);
//		wb.close();
	}
	
	public String getData(int row ,int column){
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	public String getData2(int row ,int column){
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	public String getData1(String sheetNumber,int row ,int column){
		sheet1 = wb.getSheet(sheetNumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	
	public int getRowCount(int sheetIndex){
		int lastRowNum = wb.getSheetAt(sheetIndex).getLastRowNum();
		lastRowNum=lastRowNum+1;
		return lastRowNum;
	}
	public void xie(String excelPath) throws Exception{
		File file = new File(excelPath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
	}
}
