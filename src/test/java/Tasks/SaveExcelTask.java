package Tasks;

import actors.ClonerActor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class SaveExcelTask implements Task {

	private String newPath;
	private ClonerActor clonerActor;

	public SaveExcelTask(String newPath, ClonerActor clonerActor) {
		this.newPath = newPath;
		this.clonerActor = clonerActor;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		clonerActor.saveWorkbook(newPath);
	}
}
