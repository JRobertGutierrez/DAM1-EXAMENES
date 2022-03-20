package examen_Pend_GestPagProv;

public class Contacto {
	/**
	 * Gestión Pagos Proveedores - Clase Contacto
	 * 
	 * @author Robert G
	 */
	private String nombre;
	private String direccion;
	private String email;
	private String codigo_postal;
	private String telefono;

	public Contacto(String nombre, String direccion, String email, String codigo_postal, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.email = email;
		this.codigo_postal = codigo_postal;
		this.telefono = telefono;
	}

	public Contacto(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + " - Dirección: " + direccion + " - Email: " + email + " - CP: "
				+ codigo_postal + " - Teléfono: " + telefono;
	}
}
