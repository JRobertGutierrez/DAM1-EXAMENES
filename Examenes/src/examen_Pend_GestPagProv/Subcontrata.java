package examen_Pend_GestPagProv;

public class Subcontrata extends Proveedor {
	/**
	 * Gesti�n Pagos Proveedores - Clase Subcontrata
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
		return "Tipo Subcontrata:" +"\n"+ "  N�Personas: " + numPersonas + " - C�digo: " + codigo + " - CIF: " + cif + " - Nombre: " + nombre + "]" 
				+ "\n" + "  Contacto: " + contacto;
	}
}
