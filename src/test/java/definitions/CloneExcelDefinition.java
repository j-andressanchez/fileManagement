package definitions;

import Tasks.CloneExcelFileTask;
import Tasks.LoadExcelTask;
import Tasks.SaveExcelTask;
import Tasks.ValidateFileExistsTask;
import actors.ClonerActor;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelUtil;

public class CloneExcelDefinition {

	private ClonerActor robot;

	@Before
	public void setUp() {
		ExcelUtil excelUtil = new ExcelUtil();
		robot = ClonerActor.named("robot", excelUtil);
	}

	@Given("Se carga el archivo de excel {string}")
	public void loadExcelFile(String oldFilePath) {
		LoadExcelTask loadTask = new LoadExcelTask(oldFilePath, robot);
		robot.attemptsTo(loadTask);
	}

	@When("Se clona el archivo de excel cargado")
	public void cloneExcelFile() {
		CloneExcelFileTask cloneTask = new CloneExcelFileTask(robot);
		robot.attemptsTo(cloneTask);
	}

	@When("Se guarda el nuevo archivo en {string}")
	public void saveNewExcelFile(String newFilePath) {
		SaveExcelTask saveTask = new SaveExcelTask(newFilePath, robot);
		robot.attemptsTo(saveTask);
	}

	@Then("El archivo de Excel debe existir en {string}")
	public void verifyExcelFileExists(String newFilePath) {
		ValidateFileExistsTask validateExists = ValidateFileExistsTask.withPath(newFilePath, robot);
		robot.attemptsTo(validateExists);
	}

}
