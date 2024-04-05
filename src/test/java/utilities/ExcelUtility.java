package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import testBase.BaseClass;

public class ExcelUtility {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;   
	String path;
	public static int rowIndex = 0;
    public static int cellIndex = 0;
	
	//Constructor
	public ExcelUtility(String path)
	{
		this.path=path;
	}
	
	public static void setCellCount() {
		cellIndex = 0;
	}
	
	public int getRowCount(String sheetName) throws IOException 
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;		
	}
	
	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
	}
	
	public static void writeSubHeadersData(List<WebElement> list) throws IOException {
		File file = new File("src\\test\\resources\\Output.xlsx");
		FileInputStream fis = new FileInputStream(file);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    
	    XSSFSheet sheet = wb.getSheet(BaseClass.browser + " Header Info");
	    XSSFRow row;
	    int rowIndex = 1;
	    for (WebElement item : list) {
	    	row = sheet.getRow(rowIndex);
	    	if (row == null) {row = sheet.createRow(rowIndex);}
	        row.createCell(cellIndex).setCellValue(item.getText().split("\n")[0]);
	        rowIndex++;
	    }
	    cellIndex++;
	    FileOutputStream fos = new FileOutputStream(file);
	    wb.write(fos);
	    wb.close();
	}
	
	public static void writeHeadersData(List<WebElement> list) throws IOException {
		File file = new File("src\\test\\resources\\Output.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet(BaseClass.browser + " Header Info");
		XSSFRow row;
		
		int cellIndex = 0;
		for (int i = 1; i < list.size(); i++) {
			row = sheet.getRow(0);
	    	if (row == null) {row = sheet.createRow(0);}
			row.createCell(cellIndex++).setCellValue(list.get(i).getText());
		}
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		wb.close();
	}
	
	public static void writeEthicsPageInfo(WebElement info) throws IOException {
		File file = new File("src\\test\\resources\\Output.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheet("Ethics Page Info");
		XSSFRow row;
		String[] arr = info.getText().split("\n");
		for (String s : arr) {
			row = sheet.createRow(rowIndex);
			if (row == null) {row = sheet.createRow(rowIndex);}
			row.createCell(0).setCellValue(s);
			rowIndex++;
		}
		
		
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		wb.close();
	}
}
