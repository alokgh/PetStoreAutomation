package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Data")
	public String[][] getAlldata() throws IOException{
		
		String path = System.getProperty("./testdata/UserData.xlsx");
		ExcelUtility xl = new ExcelUtility(path);		
		int rowCount = xl.getRowCount("Sheet1");
		int colCount = xl.getCellCount(path, rowCount);
		String userData[][] = new String[rowCount][colCount];	
		
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				userData[i][j] = xl.getCellData("Sheet1", i, j);
			}
		}
		return userData;
	}
	
	
	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException{
		
		String path = System.getProperty("./testdata/UserData.xlsx");
		ExcelUtility xl = new ExcelUtility(path);		
		int rowCount = xl.getRowCount("Sheet1");
		String userData[] = new String[rowCount];	
		
		for(int i=1;i<=rowCount;i++) {
				userData[i]= xl.getCellData("Sheet1", i,1);
		}
		return userData;
	}
	
	
	 
}
