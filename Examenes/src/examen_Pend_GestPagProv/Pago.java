package examen_Pend_GestPagProv;

public class Pago {
	/**
	 * Gestión Pagos Proveedores - Clase Pago
	 * 
	 * @author Robert G
	 */
	protected String factura;
	protected int trimestre;
	protected int year;
	protected double importe;

	public Pago(String factura, int trimestre, int year, double importe) {
		super();
		this.factura = factura;
		this.trimestre = trimestre;
		this.year = year;
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "Factura " + factura + " correspondiente al trimestre " + trimestre + " del año " + year
				+ " tuvo un importe de " + importe + " €";
	}
}
