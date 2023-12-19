package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fis;
	public FileOutputStream fos;
	public String path;
	public XSSFWorkbook wb;
	public XSSFSheet ws;
	public XSSFCell cell;
	public XSSFRow row;

	
	public ExcelUtility(String filePath) {
		// TODO Auto-generated constructor stub
		this.path = filePath;
	}
	
	public int getRowCount(String sheetName) throws IOException {
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetName);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
	}
	
	public int getCellCount(String sheetName,int rowCount) throws IOException {
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowCount);
		int cellCount = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;
	}
	
	public String getCellData(String sheetName,int rowCount,int colCount) throws IOException {
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rowCount);
		cell = row.getCell(colCount);
		return cell.toString();	
	}
	
	
	
}
