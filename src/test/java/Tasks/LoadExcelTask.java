package Tasks;

import actors.ClonerActor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class LoadExcelTask implements Task {

	private String oldPath;
	private ClonerActor clonerActor;

	public LoadExcelTask(String oldPath, ClonerActor clonerActor) {
		this.oldPath = oldPath;
		this.clonerActor = clonerActor;
	}

	@Override
    public <T extends Actor> void performAs(T actor) {
		clonerActor.loadExcel(oldPath);
    }
}
