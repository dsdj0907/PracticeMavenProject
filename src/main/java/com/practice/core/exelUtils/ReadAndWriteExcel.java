package com.practice.core.exelUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWriteExcel {
	
	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelWSheet;
	
	private static XSSFRow Row;
	@SuppressWarnings("unused")
	private static XSSFCell Cell;
	
	DataFormatter formatter = new DataFormatter();
	
	public Map<String,String> getDataFromExcel(String fileName, String sheetName) throws IOException{
		
		FileInputStream fis = new FileInputStream("data/" + fileName);
		ExcelWBook = new XSSFWorkbook(fis);
		ExcelWSheet = ExcelWBook.getSheet(sheetName);
		Row = ExcelWSheet.getRow(0);
		int totalRows = ExcelWSheet.getPhysicalNumberOfRows();
		int totalColumns = Row.getLastCellNum();
		
		
		Map<String,String> Data = new LinkedHashMap<String,String>();
		
		for(int i=0; i<totalRows; i++) {
			for(int j=0;j<totalColumns; j++) {
				String column = formatter.formatCellValue(ExcelWSheet.getRow(0).getCell(j));
				String cellValue = formatter.formatCellValue(ExcelWSheet.getRow(i).getCell(j));
				if(!column.equals(cellValue)) {
					Data.put(column, cellValue);
				}
			}
		}
		for(Map.Entry<String, String> cellValues:Data.entrySet()) {
			System.out.print(cellValues.getKey() + ": " + cellValues.getValue());
		}
		
		return Data;
		
	}
	
	

}
