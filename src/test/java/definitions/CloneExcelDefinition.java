package definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;

import interactions.SaveExcel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import tasks.CloneExcelFileTask;
import tasks.LoadExcelTask;
import tasks.ValidateFileExistsTask;

public class CloneExcelDefinition {

	private Actor actor = Actor.named("automation");

	@Given("Se carga el archivo de excel {string}")
	public void loadExcelFile(String oldFilePath) {
		givenThat(actor).attemptsTo(LoadExcelTask.from(oldFilePath));
	}

	@When("Se clona el archivo de excel cargado")
	public void cloneExcelFile() {
		givenThat(actor).attemptsTo(CloneExcelFileTask.theFile());
	}

	@When("Se guarda el nuevo archivo en {string}")
	public void saveNewExcelFile(String newFilePath) {
		givenThat(actor).attemptsTo(SaveExcel.inPath(newFilePath));
	}

	@Then("El archivo de Excel debe existir en {string}")
	public void verifyExcelFileExists(String newFilePath) {
		givenThat(actor).attemptsTo(ValidateFileExistsTask.onPath(newFilePath));
	}

}
