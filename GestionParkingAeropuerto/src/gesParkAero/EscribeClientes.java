package gesParkAero;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class EscribeClientes.
 */
public class EscribeClientes {

	/**
	 * The file.
	 *
	 * @author Robert Gutiérrez
	 */
	private FileOutputStream file;

	/** The output. */
	private ObjectOutputStream output;

	/**
	 * Abrir.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void abrir() throws IOException {
		file = new FileOutputStream(".\\ficheros\\clientes.par");
		output = new ObjectOutputStream(file);
	}

	/**
	 * Cerrar.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void cerrar() throws IOException {
		if (output != null)
			output.flush();
		output.close();
	}

	/**
	 * Escribir.
	 *
	 * @param i the i
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void escribir(Cliente i) throws IOException {
		if (output != null)
			output.writeObject(i);
	}
}// Fin clase escribeclientes
