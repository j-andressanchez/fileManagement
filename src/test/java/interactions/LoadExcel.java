package interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import utilities.ExcelUtil;

public class LoadExcel implements Interaction {

	private String oldPath;

	public LoadExcel(String oldPath) {
		this.oldPath = oldPath;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		ExcelUtil.loadExcel(oldPath);
	}

	public static LoadExcel from(String oldPath) {
		return instrumented(LoadExcel.class, oldPath);
	}
}
