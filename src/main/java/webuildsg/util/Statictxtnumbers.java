package webuildsg.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Statictxtnumbers {

	static XSSFWorkbook myworkBook;
	XSSFSheet ExcelWSheet;
	
	static Map<String,String> dataMap = new HashMap<String,String>();
	public static Map<String,String> Readinputfile(String filepath) throws IOException{
	//Create an object of File class to open xlsx file
	File myFile = new File(filepath);
	FileInputStream fis = new FileInputStream(myFile);
	
	myworkBook = new XSSFWorkbook(fis);
	XSSFSheet mySheet = myworkBook.getSheetAt(0);
	int lastRow = mySheet.getLastRowNum();	
	//ignore first row of the sheet (header)
	for(int i=1;i<=lastRow;i++) {
		 Row row =mySheet.getRow(i);
		 
		 //Get 1st column value  as Value
		 Cell valueCell = row.getCell(1);
		 //Get 0th Column value as key
		 Cell keyCell = row.getCell(0);
		 String value = valueCell.getStringCellValue().trim();
		 String key = keyCell.getStringCellValue().trim();
		 dataMap.put(key,value);

		
	}
		return dataMap;
		
	}
	
}
