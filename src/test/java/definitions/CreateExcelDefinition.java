package definitions;

import Tasks.CloneExcel;
import abilities.ExcelManagementAbility;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;

public class CreateExcelDefinition {

	Actor robot = Actor.named("robot");
	String newFilePath = "src\\test\\resources\\docs\\newFile.xlsx";
	String oldFilePath = "src\\test\\resources\\docs\\DatosAleatorios.xlsx";
	
	@Given("Se crea nuevo excel")
	public void cloneExcel() {
		ExcelManagementAbility excelAbility = new ExcelManagementAbility(oldFilePath);
		robot.whoCan(excelAbility).attemptsTo(CloneExcel.inPath(newFilePath));
	}
	
}
