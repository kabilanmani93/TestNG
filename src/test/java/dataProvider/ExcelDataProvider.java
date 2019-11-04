package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
	XSSFWorkbook wb;
	
	public  ExcelDataProvider()
	{
		File src = new File ("./src/test/resources/excel/AppData.xlsx");
		
		try
		{
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}
		catch (Exception e)
		{
			System.out.println("The Exception message is" + e.getMessage());
		}
	}
	
	public  XSSFWorkbook getExcelwb()
	{
		return wb;
		
	} 
	

	
	public String getData(String SheetName, int row,int col)
	{
		String data = wb.getSheet(SheetName).getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	
	
	

}
