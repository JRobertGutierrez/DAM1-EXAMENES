package gesParkAero;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class Persona.
 */
public abstract class Persona implements Valida, Serializable {

	/**
	 * The Constant serialVersionUID.
	 *
	 * @author Robert Gutiérrez
	 */
	private static final long serialVersionUID = 1L;

	/** The dni. */
	protected String DNI;

	/** The nombre. */
	protected String nombre;

	/** The apellidos. */
	protected String apellidos;

	/** The edad. */
	protected int edad;

	/** The direccion. */
	protected String direccion;

	/** The email. */
	protected String email;

	/**
	 * Instantiates a new persona.
	 *
	 * @param dNI       the d NI
	 * @param nombre    the nombre
	 * @param apellidos the apellidos
	 * @param edad      the edad
	 * @param direccion the direccion
	 * @param email     the email
	 */
	public Persona(String dNI, String nombre, String apellidos, int edad, String direccion, String email) {
		DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.direccion = direccion;
		this.email = email;
	}

	/**
	 * Instantiates a new persona.
	 */
	public Persona() {
		this.DNI = "";
		this.nombre = "";
		this.apellidos = "";
		this.edad = 0;
		this.direccion = "";
		this.email = "";
	}

	/**
	 * Gets the dni.
	 *
	 * @return the dni
	 */
	public String getDNI() {
		return DNI;
	}

	/**
	 * Sets the dni.
	 *
	 * @param dNI the new dni
	 */
	public void setDNI(String dNI) {
		DNI = dNI;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the apellidos.
	 *
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Sets the apellidos.
	 *
	 * @param apellidos the new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Gets the edad.
	 *
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Sets the edad.
	 *
	 * @param edad the new edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Gets the direccion.
	 *
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Sets the direccion.
	 *
	 * @param direccion the new direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "persona [DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", direccion=" + direccion + ", email=" + email + "]";
	}

	/**
	 * Valido.
	 *
	 * @param nif the nif
	 * @return true, if successful
	 */
	// Método para validar si un DNI es correcto o no
	public boolean valido(String nif) {

		boolean correcto = false;

		Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
		// Expresiones regulares
		Matcher matcher = pattern.matcher(nif);

		if (matcher.matches()) {

			String letra = matcher.group(2);// letra group 2 es la parte letra

			String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

			int index = Integer.parseInt(matcher.group(1));// index group 1 es la parte numérica

			index = index % 23;// Hallamos el resto de dividir index entre 23

			String reference = letras.substring(index, index + 1);

			if (reference.equalsIgnoreCase(letra)) {// Para admitir tanto mays como minus
				correcto = true;
			} else {
				System.out.println("Letra del dni incorrecta");
				correcto = false;
			}
		} else {
			System.out.println("Formato incorrecto");
			correcto = false;
		}
		return correcto;
	}// Fin método validar dni

	/**
	 * Valido 2.
	 *
	 * @param ed the ed
	 * @return true, if successful
	 */
	// Método para impedir la entrada de datos String en int a traves de interface valida
	public boolean valido2(String ed) {

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
	}// Fin de método valido
}// Fin de clase persona
