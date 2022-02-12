package gesParkAero;

import java.io.Serializable;
import java.util.Scanner;

//TODO: Auto-generated Javadoc
/**
* The Class Cliente.
*/
public class Cliente extends Persona implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 *
	 * @author Robert Gutiérrez
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private int horallegada;
	/**
	 * 
	 */
	private int diasestancia;
	/**
	 * 
	 */
	private Vehiculo v;
	/**
	 * 
	 */
	private static Scanner sc = new Scanner(System.in);

	/**
	 * @param dNI
	 * @param nombre
	 * @param apellidos
	 * @param edad
	 * @param direccion
	 * @param email
	 * @param v
	 * @param horallegada
	 * @param diasestancia
	 */
	public Cliente(String dNI, String nombre, String apellidos, int edad, String direccion, String email, Vehiculo v,
			int horallegada, int diasestancia) {
		super(dNI, nombre, apellidos, edad, direccion, email);
		this.horallegada = horallegada;
		this.diasestancia = diasestancia;
		this.v = v;
	}

	/**
	 * 
	 */
	public Cliente() {
		super();
		this.horallegada = 0;
		this.diasestancia = 0;
		this.v = null;
	}

	/**
	 * @return
	 */
	public int getHorallegada() {
		return horallegada;
	}

	/**
	 * @param horallegada
	 */
	public void setHorallegada(int horallegada) {
		this.horallegada = horallegada;
	}

	/**
	 * @return
	 */
	public int getDiasestancia() {
		return diasestancia;
	}

	/**
	 * @param diasestancia
	 */
	public void setDiasestancia(int diasestancia) {
		this.diasestancia = diasestancia;
	}

	/**
	 * @return
	 */
	public Vehiculo getV() {
		return v;
	}

	/**
	 * @param v
	 */
	public void setV(Vehiculo v) {
		this.v = v;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "cliente [horallegada=" + horallegada + ", diasestancia=" + diasestancia + ", vehiculo=" + v + ", DNI="
				+ DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", direccion="
				+ direccion + ", email=" + email + "]";
	}

	// Método dar de alta cliente
	/**
	 * @return
	 */
	public Cliente darAlta() {

		String d = "";
		String ed = "";
		String h = "";
		String de = "";

		do {
			System.out.println("Introduce DNI (8 números y una letra)");
			d = sc.next();
		} while (!valido(d));

		System.out.println("Introduce Nombre");
		sc.nextLine();
		String n = sc.nextLine();

		System.out.println("Introduce Apellidos");
		sc.nextLine();
		String ap = sc.nextLine();

		do {
			System.out.println("Introduce Edad");
			ed = sc.next();
		} while (!valido2(ed));
		int edadcorrecta = Integer.parseInt(ed);

		System.out.println("Introduce Dirección");
		sc.nextLine();
		String di = sc.nextLine();

		System.out.println("Introduce email");
		String em = sc.next();

		do {
			System.out.println("Introduce Hora de llegada");
			h = sc.next();
		} while (!valido2(h));
		int horacorrecta = Integer.parseInt(h);

		do {
			System.out.println("Introduce Dias de estancia");
			de = sc.next();
		} while (!valido2(de));
		int diascorrectos = Integer.parseInt(de);

		// Bucle para dar de alta un tipo de vehiculo
		boolean salir = false;
		Vehiculo v = null;

		while (!salir) {

			// Menu para elegir que tipo de vehiculo voy a dar de alta
			System.out.println("Elija una opción");
			System.out.println("1. Coche");
			System.out.println("2. Moto");
			System.out.println("3. Furgoneta");
			int opcion = sc.nextInt();

			if (opcion == 1) {
				// coche
				v = Vehiculo.darAlta(opcion);
				salir = true;
			} else if (opcion == 2) {
				// moto
				v = Vehiculo.darAlta(opcion);
				salir = true;
			} else if (opcion == 3) {
				// furgoneta
				v = Vehiculo.darAlta(opcion);
				salir = true;
			}
		} // Fin while
		Cliente cl = new Cliente(d, n, ap, edadcorrecta, di, em, v, horacorrecta, diascorrectos);
		return cl;
	}// Fin método darAlta
}// Fin clase cliente
