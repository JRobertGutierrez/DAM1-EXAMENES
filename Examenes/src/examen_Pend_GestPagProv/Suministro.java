package examen_Pend_GestPagProv;

public class Suministro extends Proveedor {
	/**
	 * Gestión Pagos Proveedores - Clase Suministro
	 * 
	 * @author Robert G
	 */
	public int retencion;

	public Suministro(String[] inicializa, int retencion) {
		super(inicializa);
		this.retencion = retencion;
	}

	@Override
	public String toString() {
		return "Tipo Suministro:" +"\n"+ "  Retencion: " + retencion + " - Código: " + codigo + " - CIF: " + cif + " - Nombre: " + nombre 
				+ "\n" + "  Contacto: " + contacto;
	}
}