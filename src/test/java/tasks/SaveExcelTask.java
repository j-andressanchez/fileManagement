package tasks;

import interactions.SaveExcel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class SaveExcelTask implements Task {

	private String newPath;

	public SaveExcelTask(String newPath) {
		this.newPath = newPath;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(SaveExcel.inPath(newPath));
	}
}
