package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static void main(String[] args) throws Exception {
		File file = new File("d:/TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
//		String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();
//		System.out.println(data0);
		int lastRowNum = sheet1.getLastRowNum();
		System.out.println(lastRowNum);
		for (int i = 0; i < lastRowNum+1; i++) {
			String data0 = sheet1.getRow(i).getCell(1).getStringCellValue();
			System.out.println("µÚÒ»ÁÐ"+data0);
		}
		wb.close();
	}
}
