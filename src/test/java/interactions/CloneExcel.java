package interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import utilities.ExcelUtil;

public class CloneExcel implements Interaction {

	public CloneExcel() {
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		ExcelUtil.cloneExcel();
	}
	
	public static CloneExcel theFile() {
		return instrumented(CloneExcel.class);
	}
}
