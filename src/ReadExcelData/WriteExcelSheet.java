package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelSheet {

	public static void main(String[] args) throws Exception{
		
			File file = new File("TestData\\InputData.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet1 = wb.getSheetAt(0);
//			sheet1.getRow(1).createCell(2).setCellValue("PASS");
//			sheet1.getRow(2).createCell(2).setCellValue("FAIL");
			for (int i = 0; i <2; i++) {
				sheet1.getRow(i).createCell(2).setCellValue("x");
			}
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			wb.write(fileOutputStream);
			wb.close();
			
	}

}
