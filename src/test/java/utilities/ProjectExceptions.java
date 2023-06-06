package utilities;

import static org.junit.Assert.fail;

public class ProjectExceptions {

	private ProjectExceptions() {
	}

	// Exceptions
	private static final String STR_IO_EXCEPTION = "IOException";
	private static final String STR_ILLEGAL_STATE_EXCEPTION = "IllegalStateException";

	// Messages
	private static final String MSG_IO_EXCEPTION = "Ocurrió un error al acceder al archivo: ";
	private static final String MSG_ILLEGAL_STATE_EXCEPTION = "Se presentó un error encontrando el archivo en la memoria del actor: ";

	/**
	 * Método que valida que mensaje mostrar a partir de una excepcion
	 * 
	 * @params strExcepcion String con exception de sistema
	 */
	public static void validateException(String strException) {
		switch (strException) {
		case STR_IO_EXCEPTION:
			throwException(MSG_IO_EXCEPTION, strException);
		case STR_ILLEGAL_STATE_EXCEPTION:
			throwException(MSG_ILLEGAL_STATE_EXCEPTION, strException);
		}
	}

	/**
	 * Método trigger que lanza excepciones
	 * 
	 * @params strMensaje String con mensaje a mostrar
	 */
	public static void throwException(String strMensaje, String strException) {
		fail(strMensaje + strException);
	}
}
