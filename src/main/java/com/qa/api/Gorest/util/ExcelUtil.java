package com.qa.api.Gorest.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static Workbook book;
	public static Sheet sheet;

	public static String TestDataSheetPath = "/Users/yogeshdhekale/eclipse-workspace/APIRestAssuredFramework/"
			+ "src/main/java/com/qa/api/Gorest/TestData/GoRestTestData.xlsx";

	public static Object[][] getTestDataExcel(String sheetName) {

		try {
			FileInputStream input = new FileInputStream(TestDataSheetPath);
			try {
				try {
					book = WorkbookFactory.create(input);
					sheet = book.getSheet(sheetName);
				} catch (InvalidFormatException e) {
					e.printStackTrace();
				}

			} catch (EncryptedDocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object data[][] = new Object[rowCount][colCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();

			}
		}
		return data;
	}

}
