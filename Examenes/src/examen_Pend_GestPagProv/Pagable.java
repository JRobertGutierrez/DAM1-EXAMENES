package examen_Pend_GestPagProv;

public interface Pagable {
	/**
	 * Gestión Pagos Proveedores - Interface Pagable
	 * 
	 * @author Robert G
	 */
	void addProveedor(Proveedor pr); 
	
	void addPago(Pago p);

	void listarProveedores();
	
	void listarPagos();
}
