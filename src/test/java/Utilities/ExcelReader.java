package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public String data(String row) throws IOException {
		
		String filePath=System.getProperty("user.dir")+"\\testdata\\testDataCucumber.xlsx";
		
		FileInputStream fis=new FileInputStream(filePath);
		int r = Integer.parseInt(row);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("NewBikes");
		XSSFRow currentRow=sheet.getRow(r);
		String cell=currentRow.getCell(0).toString();
		
		workbook.close();
		fis.close();
		
		return cell;
		
	}
	
	

}
