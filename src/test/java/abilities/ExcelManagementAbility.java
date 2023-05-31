package abilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.serenitybdd.screenplay.Ability;

public class ExcelManagementAbility implements Ability {

	private static final Logger logger = Logger.getLogger(ExcelManagementAbility.class.getName());
	private Workbook workbook;
	private String oldExcelPath;
	
	public ExcelManagementAbility(String oldExcelPath) {
		this.oldExcelPath = oldExcelPath;
		try {
			FileInputStream input = new FileInputStream(oldExcelPath);
			workbook = new XSSFWorkbook(input);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Ocurrió un error al cargar el archivo Excel: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Workbook getWorkbook() {
		return workbook;
	}

	public Workbook duplicateExcel(String newExcelFilePath) {

		Workbook newExcel = new XSSFWorkbook();

		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			XSSFSheet oldSheet = (XSSFSheet) workbook.getSheetAt(i);
			XSSFSheet newSheet = (XSSFSheet) newExcel.createSheet(oldSheet.getSheetName());

			for (int r = 0; r <= oldSheet.getLastRowNum(); r++) {
				XSSFRow oldRow = oldSheet.getRow(r);
				XSSFRow newRow = newSheet.createRow(r);

				for (int c = 0; c < oldRow.getLastCellNum(); c++) {
					XSSFCell oldCell = oldRow.getCell(c);
					XSSFCell newCell = newRow.createCell(c);
					cloneCell(oldCell, newCell, newExcel);
				}
			}
		}

		try {
			FileOutputStream output = new FileOutputStream(newExcelFilePath);
			newExcel.write(output);
			output.close();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Ocurrió un error al guardar el archivo Excel duplicado: " + e.getMessage());
			e.printStackTrace();
		}

		return newExcel;
	}

	private void cloneCell(XSSFCell oldCell, XSSFCell newCell, Workbook newExcel) {
		newCell.setCellValue(oldCell.getStringCellValue());

		XSSFCellStyle oldStyle = oldCell.getCellStyle();
		XSSFCellStyle newStyle = (XSSFCellStyle) newExcel.createCellStyle();
		newStyle.cloneStyleFrom(oldStyle);
		newCell.setCellStyle(newStyle);
	}

	public void saveWorkbook(String newExcelFilePath) {
		try {
			FileOutputStream output = new FileOutputStream(newExcelFilePath);
			workbook.write(output);
			output.close();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Ocurrió un error al guardar el archivo Excel: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
