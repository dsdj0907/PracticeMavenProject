package com.practice.core.exelUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperationsDataProvider {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;

	@SuppressWarnings("unused")
	private static XSSFCell cell;
	private static XSSFRow Row;

	public Object[][] fnGetDataFromxlFile(String vFileName, String vSheetName) throws IOException {
		FileInputStream ExcelFile = null;

		String vXlsxFilePath = "data/" + vFileName;
		ExcelFile = new FileInputStream(vXlsxFilePath);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(vSheetName);
		Row = ExcelWSheet.getRow(0);
		int vCols = Row.getLastCellNum();

		int vRowCount = ExcelWSheet.getPhysicalNumberOfRows();

		@SuppressWarnings("unused")
		Object vDataObject[][] = null;
		int x = 0;
		int vCount = 0;
		DataFormatter formatter = new DataFormatter();

		for (int i = 1; i < vRowCount; i++) {
			@SuppressWarnings("unused")
			XSSFRow row = ExcelWSheet.getRow(i);
			for (int j = 0; j < vCols; j++) {

				Cell cell1 = ExcelWSheet.getRow(i).getCell(j);
				String sColumn = formatter.formatCellValue(cell1);
				if (sColumn.equalsIgnoreCase("Yes")) {
					vCount++;
					break;
				}
			}
		}

		Object Data[][] = new Object[vCount][vCols];

		for (int k = 1; k < vRowCount; k++) {
			XSSFRow row = ExcelWSheet.getRow(k);
			Cell cell2 = ExcelWSheet.getRow(k).getCell(0);
			String sColumn1 = formatter.formatCellValue(cell2);
			if (!sColumn1.equalsIgnoreCase("Yes"))
				continue;
			if (x == vCount)
				break;
			for (int n = 0; n < vCols; n++) {
				if (row == null)
					Data[x][n] = "";
				else {
					XSSFCell cell = row.getCell(n);
					if (cell == null) {
						Data[x][n] = "";
					} else {
						Cell cell3 = ExcelWSheet.getRow(k).getCell(n);
						String vData = formatter.formatCellValue(cell3);
						Data[x][n] = vData;
						System.out.println("Data[" + x + "][" + n + "]-" + Data[x][n]);
					}
				}
			}
			x++;

		}

		return null;

	}
}
