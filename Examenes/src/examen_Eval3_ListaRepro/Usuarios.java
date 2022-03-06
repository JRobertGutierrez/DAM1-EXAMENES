package examen_Eval3_ListaRepro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Usuarios {
	/**
	 * Lista de reproducción - Clase Usuarios
	 * 
	 * @author Robert G
	 */
	protected String DNI;
	protected String nombre;
	protected String apellidos;
	protected String usuario;
	protected String clave;

	public Usuarios(String dNI, String nombre, String apellidos, String usuario, String clave) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.clave = clave;
	}

	public Usuarios() {
		this.DNI = "";
		this.nombre = "";
		this.apellidos = "";
		this.usuario = "";
		this.clave = "";
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Usuarios [DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", usuario=" + usuario
				+ ", clave=" + clave + "]";
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
}// Fin de clase Usuarios