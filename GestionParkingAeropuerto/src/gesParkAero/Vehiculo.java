package gesParkAero;

import java.io.Serializable;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class vehiculo.
 */
public abstract class Vehiculo implements Valida, Serializable {

	/**
	 * The Constant serialVersionUID.
	 *
	 * @author Robert Gutiérrez
	 */
	private static final long serialVersionUID = 1L;

	/** The matricula. */
	protected String matricula;

	/** The color. */
	protected String color;

	/** The marca. */
	protected String marca;

	/** The modelo. */
	protected String modelo;

	/**
	 * Instantiates a new vehiculo.
	 *
	 * @param matricula the matricula
	 * @param color     the color
	 * @param marca     the marca
	 * @param modelo    the modelo
	 */
	public Vehiculo(String matricula, String color, String marca, String modelo) {
		super();
		this.matricula = matricula;
		this.color = color;
		this.marca = marca;
		this.modelo = modelo;
	}

	/**
	 * Instantiates a new vehiculo.
	 */
	public Vehiculo() {
		super();
		this.matricula = "";
		this.color = "";
		this.marca = "";
		this.modelo = "";
	}

	/**
	 * Gets the matricula.
	 *
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Sets the matricula.
	 *
	 * @param matricula the new matricula
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Gets the marca.
	 *
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Sets the marca.
	 *
	 * @param marca the new marca
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Gets the modelo.
	 *
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Sets the modelo.
	 *
	 * @param modelo the new modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "vehiculo [matricula=" + matricula + ", color=" + color + ", marca=" + marca + "," + " modelo=" + modelo
				+ "]";
	}

	/**
	 * Dar alta.
	 *
	 * @param opcion the opcion
	 * @return the vehiculo
	 */
	// Método para dar de alta los vehículos
	public static Vehiculo darAlta(int opcion) {
		Vehiculo v = null;

		@SuppressWarnings("resource") // Para que sc no me de aviso de que no lo he cerrado
		Scanner sc = new Scanner(System.in);

		String m = "";
		do {
			System.out.println("Introduce matricula (Formato 1111-AAA)");
			m = sc.next();
		} while (!valido(m));

		System.out.println("Introduce color");
		String c = sc.next();
		System.out.println("Introduce marca");
		String ma = sc.next();
		System.out.println("Introduce modelo");
		String mo = sc.next();

		if (opcion == 1) {

			String np = "";
			do {
				System.out.println("Introduce número de puertas");
				np = sc.next();

			} while (!valido2(np));
			int puertascorrectas = Integer.parseInt(np);// Convertimos a entero

			v = new Coche(m, c, ma, mo, puertascorrectas);// Cargamos en el objeto v los datos de coche

		} else if (opcion == 2) {
			System.out.println("Introduce tipo de moto (SCOOTER, MOTOCROSS, ENDURO, SUPERMOTARD, TRIAL, NAKED)");
			String ti = sc.next();

			String ci = "";
			do {
				System.out.println("Introduce cilindrada");
				ci = sc.next();

			} while (!valido2(ci));
			int cilcorrecta = Integer.parseInt(ci);// Convertimos a entero

			System.out.println("Introduce tipo de carnet (AM-A1-A2-A)");
			String ca = sc.next();

			v = new Moto(m, c, ma, mo, ti, cilcorrecta, ca);// Cargamos en el objeto v los datos de moto

		} else {

			String ca = "";
			do {
				System.out.println("Introduce capacidad de cubicaje en litros");
				ca = sc.next();
			} while (!valido2(ca));
			int capcorrecta = Integer.parseInt(ca);// Convertimos a entero

			v = new Furgoneta(m, c, ma, mo, capcorrecta);// Cargamos en el objeto v los datos de furgoneta
		}
		return v;
	}// Fin método darAlta vehiculos

	/**
	 * Valido 2.
	 *
	 * @param ed the ed
	 * @return true, if successful
	 */
	// Método para impedir la entrada de datos String en int a traves de interface valida
	public static boolean valido2(String ed) {
		@SuppressWarnings("unused") // Para que entero no me de aviso de que no lo he usado todavía
		int entero = 0;
		boolean error = true;
		try {
			entero = Integer.parseInt(ed);
		} catch (NumberFormatException e1) {
			error = false;
			System.out.println("Error en el formato del número, intentelo de nuevo");
		} catch (Exception e1) {
			error = false;
			System.out.println("Error en el formato del número, intentelo de nuevo");
		}
		return error;
	}

	/**
	 * Valido.
	 *
	 * @param matricula the matricula
	 * @return true, if successful
	 */
	// Método para comprobar matricula a traves de interface valida
	public static boolean valido(String matricula) {

		if (matricula.matches("^[0-9]{4}-[A-Z]{3}$")) {// Expresiones regulares
			System.out.println("La matrícula es válida");
			return true;

		} else {

			System.out.println("La matrícula no es válida");
			return false;
		}
	}// Fin de método valido
}// Fin de clase vehículo