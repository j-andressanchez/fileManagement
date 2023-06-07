package tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import questions.FileExists;
import utilities.ProjectExceptions;

public class ValidateFileExistsTask implements Task {

	private String filePath;
	

	public ValidateFileExistsTask(String filePath) {
        this.filePath = filePath;
    }

	public static ValidateFileExistsTask onPath(String filePath) {
		return instrumented(ValidateFileExistsTask.class, filePath);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		if (actor.asksFor(FileExists.inPath(filePath)).equals(false)) {
			ProjectExceptions.validateException("NotExistsException");
		}
	}
}
