package Utilities;
 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
 
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelWriter {
	public static String path;
	public static FileOutputStream file;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static void openExcel(String fileName) throws FileNotFoundException {
		path=System.getProperty("user.dir")+"\\ExcelOutput\\"+fileName+".xlsx";
		file=new FileOutputStream(path);
		workbook = new XSSFWorkbook();
	}
	public static void enterBikeDetails(List<String> bikeName,List<String> price,List<String> date,String f) throws IOException {
		openExcel(f);
		CellStyle style=workbook.createCellStyle();
	     style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
		 style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
		sheet=workbook.createSheet("Upcoming Bikes");
		XSSFRow row=sheet.createRow(0);
		
		XSSFCell c1=row.createCell(0);
		c1.setCellValue("Bike Name");
		 c1.setCellStyle(style);
		 
		//row.createCell(1).setCellValue("Price of the bike");
			XSSFCell c2=row.createCell(1);
			c2.setCellValue("Price of the bike");
			 c2.setCellStyle(style);
		 
		//row.createCell(2).setCellValue("Expected date of release");
			 XSSFCell c3=row.createCell(2);
				c3.setCellValue("Expected date of release");
				 c3.setCellStyle(style);
			 
		for(int i=1;i<bikeName.size();i++) {
			XSSFRow currentRow=sheet.createRow(i);
			currentRow.createCell(0).setCellValue(bikeName.get(i-1));
			currentRow.createCell(1).setCellValue(price.get(i-1));
			currentRow.createCell(2).setCellValue(date.get(i-1).split(":")[1]);
		}
		closeExcel();
	}
	public static void enterCarDetails(List<String> popularCars,String f) throws IOException {
		openExcel(f);
		sheet=workbook.createSheet("PopularCars");
		XSSFRow row=sheet.createRow(0);
		CellStyle style=workbook.createCellStyle();
	     style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
		 style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		//row.createCell(0).setCellValue("Car Name");
		XSSFCell c4=row.createCell(0);
		c4.setCellValue("Car name");
		 c4.setCellStyle(style);
		
		for(int i=1;i<popularCars.size();i++) {
			XSSFRow currentRow=sheet.createRow(i);
			currentRow.createCell(0).setCellValue(popularCars.get(i-1));
		}
		closeExcel();
	}
 
	public static void closeExcel() throws IOException {
		workbook.write(file);
		workbook.close();
		file.close();
	}
 
}