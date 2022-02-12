package gesParkAero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Conductor.
 */
public class Conductor extends Persona {

	/**
	 * The Constant serialVersionUID.
	 *
	 * @author Robert Gutiérrez
	 */
	private static final long serialVersionUID = 1L;

	/** The codigo. */
	private int codigo;

	/** The turno. */
	private int turno;

	/** The Constant MAÑANA. */
	public static final int MAÑANA = 1;// Constantes para que el valor que pongo no pueda variar

	/** The Constant TARDE. */
	public static final int TARDE = 2;

	/** The Constant NOCHE. */
	public static final int NOCHE = 3;

	/**
	 * Instantiates a new conductor.
	 *
	 * @param dNI       the dNI
	 * @param nombre    the nombre
	 * @param apellidos the apellidos
	 * @param edad      the edad
	 * @param direccion the direccion
	 * @param email     the email
	 * @param codigo    the codigo
	 * @param turno     the turno
	 */
	public Conductor(String dNI, String nombre, String apellidos, int edad, String direccion, String email, int codigo,
			int turno) {
		super(dNI, nombre, apellidos, edad, direccion, email);
		this.codigo = codigo;
		this.turno = turno;
	}

	/**
	 * Instantiates a new conductor.
	 */
	public Conductor() {
		super();
		this.codigo = 0;
		this.turno = 0;
	}

	/**
	 * Gets the codigo.
	 *
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Sets the codigo.
	 *
	 * @param codigo the new codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Gets the turno.
	 *
	 * @return the turno
	 */
	public int getTurno() {
		return turno;
	}

	/**
	 * Sets the turno.
	 *
	 * @param turno the new turno
	 */
	public void setTurno(int turno) {
		this.turno = turno;
	}

	/**
	 * Gets the mañana.
	 *
	 * @return the mañana
	 */
	public static int getMañana() {
		return MAÑANA;
	}

	/**
	 * Gets the tarde.
	 *
	 * @return the tarde
	 */
	public static int getTarde() {
		return TARDE;
	}

	/**
	 * Gets the noche.
	 *
	 * @return the noche
	 */
	public static int getNoche() {
		return NOCHE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see GesParkAero.persona#toString()
	 */
	@Override
	public String toString() {
		return "conductor [codigo=" + codigo + ", turno=" + turno + ", DNI=" + DNI + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", edad=" + edad + ", direccion=" + direccion + ", email=" + email + "]";
	}

	/**
	 * Conductores.
	 *
	 * @return the array list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// ArrayList de conductores para leer el archivo csv y además llenar el ArrayList
	public static ArrayList<Conductor> conductores() throws IOException {

		ArrayList<Conductor> a = new ArrayList<Conductor>();

		FileReader fr = new FileReader(".\\ficheros\\conductor.csv");
		BufferedReader entrada = new BufferedReader(fr);

		String cadena = entrada.readLine();
		String[] linea;
		// Mostramos los nombres de los campos del archivo csv
		System.out.println("Datos de los conductores del archivo csv" + "\n******************************************");
		System.out.println(cadena + "\n******************************************************");

		while (cadena != null) {
			cadena = entrada.readLine();
			if (cadena != null) {
				linea = cadena.split(";");// Cada linea es una columna de campo

				int c = Integer.parseInt(linea[0]);// Código
				int t = Integer.parseInt(linea[1]);// Turno
				String d = linea[2];// Dni
				String n = linea[3];// Nombre
				String ap = linea[4];// Apellido
				int e = Integer.parseInt(linea[5]);// Edad
				String dir = linea[6];// Dirección
				String em = linea[7];// email
				// llenamos el objeto "co" con los datos de cada conductor desde el archivo csv
				Conductor co = new Conductor(d, n, ap, e, dir, em, c, t);
				a.add(co);
				System.out.println(cadena);// Mostramos los datos del archivo csv
			} // Fin cadena distinto de null
		} // Fin while
		fr.close();
		entrada.close(); // Cierro el BufferedReader
		return a;
	}// Fin ArrayList

	/**
	 * Turno entrega.
	 *
	 * @param conductores          the conductores
	 * @param clientesaparcamiento the clientesaparcamiento
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Método turnos donde cargamos ArrayList conductores y ArrayLis clientesaparcamiento
	public void turnoEntrega(ArrayList<Conductor> conductores, ArrayList<Cliente> clientesaparcamiento)
			throws IOException {
		for (Conductor c : conductores) {
			System.out.println("\n\n********************************\nConductor/a: " + c.getNombre() + " "
					+ "del turno " + c.getTurno() + "\n********************************");

			if (c.getTurno() == MAÑANA) {
				System.out.println("El turno 1 de mañana es de las 8:00 hrs. a las 15:00 hrs."
						+ "\n*********************************************************");
				for (Cliente cl : clientesaparcamiento) {
					if (cl.getHorallegada() >= 8 && cl.getHorallegada() <= 15) {
						System.out.println("El cliente es " + cl.getNombre());
					}
				}
			}

			if (c.getTurno() == TARDE) {
				System.out.println("El turno 2 de tarde es de las 16:00 hrs. a las 24:00 hrs.(0:00)"
						+ "\n***************************************************************");
				for (Cliente cl : clientesaparcamiento) {
					if (cl.getHorallegada() >= 16 && cl.getHorallegada() <= 24) {
						System.out.println("El cliente es " + cl.getNombre());
					}
				}
			}

			if (c.getTurno() == NOCHE) {
				System.out.println("El turno 3 de noche es de la 01:00 hrs. a las 08:00 hrs."
						+ "\n********************************************************");
				for (Cliente cl : clientesaparcamiento) {
					if (cl.getHorallegada() >= 1 && cl.getHorallegada() < 8) {
						System.out.println("El cliente es " + cl.getNombre());
					}
				}
			}
		} // Fin for principal
	}// Fin método turnos
}// Fin clase conductor
