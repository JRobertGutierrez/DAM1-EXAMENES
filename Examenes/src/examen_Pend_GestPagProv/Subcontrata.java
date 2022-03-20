package examen_Pend_GestPagProv;

public class Subcontrata extends Proveedor {
	/**
	 * Gestión Pagos Proveedores - Clase Subcontrata
	 * 
	 * @author Robert G
	 */
	private int numPersonas;
	public Subcontrata(String[] inicializa, int n_personas) {
		super(inicializa);
		this.numPersonas=n_personas;
	}
	@Override
	public String toString() {
		return "Tipo Subcontrata:" +"\n"+ "  NºPersonas: " + numPersonas + " - Código: " + codigo + " - CIF: " + cif + " - Nombre: " + nombre + "]" 
				+ "\n" + "  Contacto: " + contacto;
	}
}
