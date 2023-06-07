package questions;

import java.io.File;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class FileExists implements Question<Boolean> {

	private String filePath;

	public FileExists(String filePath) {
        this.filePath = filePath;
    }

	public static FileExists inPath(String filePath) {
		return new FileExists(filePath);
	}

	@Override
	public Boolean answeredBy(Actor robot) {
		File file = new File(filePath);
		return file.exists();
	}
}
