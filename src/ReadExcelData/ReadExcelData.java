package ReadExcelData;

import lib.ExcelDataConfig;

public class ReadExcelData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ExcelDataConfig excel = new ExcelDataConfig("d:/TestData.xlsx",1);
		String data = excel.getData( 0, 1);
		System.out.println(data);
	}

}
