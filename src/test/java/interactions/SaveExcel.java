package interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import utilities.ExcelUtil;

public class SaveExcel implements Interaction {

	private String newPath;

	public SaveExcel(String newPath) {
		this.newPath = newPath;
	}

	public static SaveExcel inPath(String newPath) {
		return instrumented(SaveExcel.class, newPath);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		ExcelUtil.saveExcel(newPath);
	}

}
