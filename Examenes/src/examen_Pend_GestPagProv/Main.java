package examen_Pend_GestPagProv;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	/**
	 * Gestión Pagos Proveedores - Clase Main
	 * 
	 * @author Robert G
	 */
	private static Scanner sc = new Scanner(System.in);
	private static int opcion;
	protected static Ficheros f = new Ficheros();

	public static void main(String[] args) throws IOException {

		do {
			// Mostramos el menu por pantalla
			System.out.println("************************************************************************");
			System.out.println("Elije la opción deseada:");
			System.out.println("1. Leer proveedores.");
			System.out.println("2. Leer pagos.");
			System.out.println("3. Generar IVA de un trimestre.");
			System.out.println("4. Informe de pagos anuales.");
			System.out.println("5. Salir del programa.");
			System.out.println("************************************************************************");

			// Pedimos la opción del menú
			opcion = sc.nextInt();
			switch (opcion) {

			case 1:
				f.LeerProveedores();
				break;
			case 2:
				f.LeerPagos();
				break;
			case 3:
				f.GenerarIva();
				break;
			case 4:
				f.InformePagos();
				break;
			case 5:
				System.out.println("Has salido del programa, hasta pronto!!!");
				break;
			default:
				System.out.println("Opcion incorrecta - Pulse del 1 al 4 o el 5 para salir");
				System.out.println("******************************************************");
				break;
			}
		} while (opcion!=5);
	}
}