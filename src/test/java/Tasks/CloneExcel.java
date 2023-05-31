package Tasks;

import abilities.ExcelManagementAbility;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class CloneExcel implements Task {

	private String newExcelFilePath;

	public CloneExcel(String newExcelFilePath) {
		this.newExcelFilePath = newExcelFilePath;
	}

	public static CloneExcel inPath(String newExcelFilePath) {
		return new CloneExcel(newExcelFilePath);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		ExcelManagementAbility excelAbility = actor.abilityTo(ExcelManagementAbility.class);
		excelAbility.duplicateExcel(newExcelFilePath);
		excelAbility.saveWorkbook(newExcelFilePath);
	}
}
