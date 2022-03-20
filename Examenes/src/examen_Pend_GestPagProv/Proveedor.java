package examen_Pend_GestPagProv;

import java.util.ArrayList;

public class Proveedor implements Pagable {
	/**
	 * Gestión Pagos Proveedores - Clase Proveedor
	 * 
	 * @author Robert G
	 */
	protected int codigo;
	protected String cif;
	protected String nombre;
	protected Contacto contacto;

	ArrayList<Proveedor> listarProveedores;
	ArrayList<Pago> listaPagos;

	public Proveedor(String[] inicializa) {
		codigo = Integer.parseInt(inicializa[0]);
		cif = inicializa[1];
		nombre = inicializa[2];
		contacto = new Contacto(inicializa[8], inicializa[4], inicializa[9], inicializa[6], inicializa[5]);
		listarProveedores = new ArrayList<Proveedor>();
		listaPagos = new ArrayList<Pago>();
	}

	@Override
	public String toString() {
		return "Proveedor [codigo=" + codigo + ", cif=" + cif + ", nombre=" + nombre + ", contacto=" + contacto + "]";
	}

	@Override
	public void addPago(Pago p) {
		listaPagos.add(p);
	}

	@Override
	public void listarPagos() {
		for (Pago p : listaPagos)
			System.out.println(nombre + " -> " + p);
	}

	public double totalTrimestre(int trim, int year) {
		double acum = 0.0;
		for (Pago p : listaPagos)
			if (p.trimestre == trim && p.year == year)
				acum += p.importe;
		return acum;
	}

	@Override
	public void addProveedor(Proveedor pr) {
		listarProveedores.add(pr);
	}

	@Override
	public void listarProveedores() {
		for (Proveedor pr : listarProveedores)
			System.out.println(pr);
	}
}
