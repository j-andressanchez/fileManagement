package tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import interactions.CloneExcel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class CloneExcelFileTask implements Task {

	public static CloneExcelFileTask theFile() {
		return instrumented(CloneExcelFileTask.class);
	}

	public CloneExcelFileTask() {
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(CloneExcel.theFile());
	}
}