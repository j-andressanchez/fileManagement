package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {

	public Workbook loadExcel(String oldExcelPath) {
		try {
	        File file = new File(oldExcelPath);
			FileInputStream input = new FileInputStream(file);
			Workbook oldWorkbook = WorkbookFactory.create(input);
			input.close();
			return oldWorkbook;
		} catch (Exception e) {
			ProjectExceptions.validateException(e.toString());
	    }
		return null;
	}

	public Workbook cloneExcel(Workbook oldWorkbook) {
		try {
			Workbook newWorkbook = new XSSFWorkbook();
			for (int i = 0; i < oldWorkbook.getNumberOfSheets(); i++) {
				XSSFSheet sourceSheet = (XSSFSheet) oldWorkbook.getSheetAt(i);
				XSSFSheet newSheet = (XSSFSheet) newWorkbook.createSheet(sourceSheet.getSheetName());

				for (int r = 0; r <= sourceSheet.getLastRowNum(); r++) {
					XSSFRow sourceRow = sourceSheet.getRow(r);
					XSSFRow newRow = newSheet.createRow(r);

					for (int c = 0; c < sourceRow.getLastCellNum(); c++) {
						XSSFCell sourceCell = sourceRow.getCell(c);
						XSSFCell newCell = newRow.createCell(c);
						cloneCell(sourceCell, newCell, newWorkbook, sourceSheet, newSheet);
					}
				}
			}
			return newWorkbook;
		} catch (Exception e) {
			ProjectExceptions.validateException(e.toString());
		}
		return null;
	}

	private static void cloneCell(XSSFCell oldCell, XSSFCell newCell, Workbook newWorkbook, XSSFSheet sourceSheet, XSSFSheet newSheet) {
		newCell.setCellValue(oldCell.getStringCellValue());

		XSSFCellStyle oldStyle = oldCell.getCellStyle();
		XSSFCellStyle newStyle = (XSSFCellStyle) newWorkbook.createCellStyle();
		newStyle.cloneStyleFrom(oldStyle);
		newCell.setCellStyle(newStyle);

		int columnIndex = oldCell.getColumnIndex();
		int columnWidth = sourceSheet.getColumnWidth(columnIndex);
		newSheet.setColumnWidth(columnIndex, columnWidth);
	}

	public void saveExcel(Workbook newWorkbook, String newExcelFilePath) {
		try (FileOutputStream output = new FileOutputStream(newExcelFilePath)) {
			newWorkbook.write(output);
		} catch (Exception e) {
			ProjectExceptions.validateException(e.toString());
		}
	}
}
