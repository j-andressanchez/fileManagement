package tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import interactions.LoadExcel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class LoadExcelTask implements Task {

	private String oldPath;

	public static LoadExcelTask from(String oldPath) {
		return instrumented(LoadExcelTask.class, oldPath);
	}

	public LoadExcelTask(String oldPath) {
		this.oldPath = oldPath;
	}

	@Override
    public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(LoadExcel.from(oldPath));
    }
}
