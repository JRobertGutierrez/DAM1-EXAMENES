package gesParkAero;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class LeeClientes.
 */
public class LeeClientes {

	/**
	 * The fichero.
	 *
	 * @author Robert Gutiérrez
	 */
	private File fichero;

	/** The file. */
	private FileInputStream file;

	/** The input. */
	private ObjectInputStream input;

	/**
	 * Abrir.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void abrir() throws IOException {
		fichero = new File(".\\ficheros\\clientes.par");
		file = new FileInputStream(fichero);
		input = new ObjectInputStream(file);
	}

	/**
	 * Cerrar.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void cerrar() throws IOException {
		if (input != null)
			input.close();
	}

	/**
	 * Leer.
	 *
	 * @return the array list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Método ArrayList para leer clientes
	public ArrayList<Cliente> leer() throws IOException {

		ArrayList<Cliente> leer_cli = new ArrayList<Cliente>();

		Cliente c = new Cliente();// Creamos objeto "c" de la clase cliente

		while (input != null) {
			try {
				c = (Cliente) input.readObject();
				leer_cli.add(c);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.err.println("No se encuentra la clase cliente");
			} catch (EOFException e) {
				input.close();
				input = null;
			}
		}

		return leer_cli;
	}// Fin ArrayList para leer clientes
}// Fin clase leeclientes
