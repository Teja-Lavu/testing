package com.mrp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public Workbook wb;
	public Sheet sh;
	FileInputStream fis;

	public ExcelRead(String WorkBookName) {
		// GenericMethods.logInfo(System.getProperty("user.dir"));
		File file = new File(
				System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
						+ "resources" + File.separator + "testData" + File.separator + WorkBookName + ".xlsx");
		try {
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getRowCount() {
		sh = wb.getSheetAt(0);
		return sh.getLastRowNum() + 1;
	}

	public int getColCount() {
		return sh.getRow(0).getLastCellNum();
	}

	public String getCellData(int row, int col) {
		Cell cell;
		try {
			cell = sh.getRow(row).getCell(col);
			return cell.getStringCellValue();
		} catch (Exception e) {
			return null;
		}
	}

	public HashMap<String, String> getData() {
		HashMap<String, String> testData = new HashMap<String, String>();
		int rowCount = getRowCount();
		for (int i = 0; i < rowCount; i++) {
			String key;
			try {
				key = sh.getRow(i).getCell(0).getStringCellValue();
			} catch (Exception e) {
				continue;
			}
			String value;
			try {
				value = sh.getRow(i).getCell(1).getStringCellValue();
			} catch (Exception e) {
				value = "";
			}
			testData.put(key, value);
		}
		return testData;
	}

	public HashMap<String, String> getTestData(String testCaseName) throws IOException {
		HashMap<String, String> testData = new HashMap<String, String>();
		int rowNo = obtainRowNo(testCaseName);
		for (int j = 0; j < getColCount(); j++) {
			String key;
			key = sh.getRow(0).getCell(j).getStringCellValue();

			String value;
			value = sh.getRow(rowNo).getCell(j).getStringCellValue();
			testData.put(key, value);

		}

		return testData;

	}

	public int obtainRowNo(String testName) throws IOException {
		int rowNo = -1;
		int rownum = getRowCount();
		for (int j = 0; j < rownum; j++) {
			Cell cell = sh.getRow(j).getCell(0);
			String cellContent = getContentValue(cell);

			if (cellContent.equals(testName)) {
				rowNo = j;
				break;
			}
		}

		return rowNo;

	}

	public static String getContentValue(Cell cell) {
		DataFormatter formatter = new DataFormatter();
		String value = formatter.formatCellValue(cell);
		if (value.equalsIgnoreCase(null)) {
			value = "";
		}

		return value;
	}

}
