package Tasks;

import actors.ClonerActor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class CloneExcelFileTask implements Task {

	private ClonerActor clonerActor;

	public CloneExcelFileTask(ClonerActor clonerActor) {
		this.clonerActor = clonerActor;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		clonerActor.cloneExcel();
	}
}