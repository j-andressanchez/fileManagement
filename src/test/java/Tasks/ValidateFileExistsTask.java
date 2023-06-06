package Tasks;

import actors.ClonerActor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import questions.FileExists;

public class ValidateFileExistsTask implements Task {

	private String filePath;
	private ClonerActor clonerActor;
	

	public ValidateFileExistsTask(String filePath, ClonerActor clonerActor) {
        this.filePath = filePath;
		this.clonerActor = clonerActor;
    }

	public static ValidateFileExistsTask withPath(String filePath, ClonerActor clonerActor) {
		return new ValidateFileExistsTask(filePath, clonerActor);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		Boolean fileExists = clonerActor.asksFor(FileExists.withPath(filePath));
		if (!fileExists) {
			throw new IllegalStateException("El archivo no existe");
		}
	}

}
