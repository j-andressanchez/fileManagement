package actors;

import org.apache.poi.ss.usermodel.Workbook;

import net.serenitybdd.screenplay.Actor;
import questions.FileExists;
import utilities.ExcelUtil;

public class ClonerActor extends Actor {

	private ExcelUtil excelUtil;
	@SuppressWarnings("unused")
	private String name;
	private Workbook oldWorkbook;
	private Workbook newWorkbook;

	public ClonerActor(String name, ExcelUtil excelUtil) {
		super(name);
		this.excelUtil = excelUtil;
	}

	public static ClonerActor named(String name, ExcelUtil excelUtil) {
		return new ClonerActor(name, excelUtil);
	}

	public Workbook getOldWorkbook() {
		return oldWorkbook;
	}

	public Workbook getNewWorkbook() {
		return newWorkbook;
	}

	public void loadExcel(String oldPath) {
		oldWorkbook = excelUtil.loadExcel(oldPath);
	}

	public void cloneExcel() {
		newWorkbook = excelUtil.cloneExcel(oldWorkbook);
	}

	public void saveWorkbook(String newPath) {
		excelUtil.saveExcel(newWorkbook, newPath);
	}

	public void validateExist(String newPath) {
		FileExists.withPath(newPath);
	}

}
