package examen_Pend_GestPagProv;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class Ficheros {
	/**
	 * Gestión Pagos Proveedores - Clase Ficheros
	 * 
	 * @author Robert G
	 */
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Proveedor> listaProveedores;
	private static int year;
	private static Scanner entrada;
	private static File fr;
	protected static String cadena;
	protected static String[] linea;
	protected static Boolean pagosGenerados = false;

	// Método leer proveedores
	public ArrayList<Proveedor> LeerProveedores() throws FileNotFoundException {
		fr = new File("src/examen_Pend_GestPagProv/ficheros/proveedores.csv");
		entrada = new Scanner(fr);
		listaProveedores = new ArrayList<Proveedor>();
		cadena = entrada.nextLine();// salta 1A

		while (entrada.hasNext()) {
			cadena = entrada.nextLine();
			linea = cadena.split(";");

			if (linea[3].equals("suministro")) {
				int retencion = Integer.parseInt(linea[7]);
				Suministro sumin = new Suministro(linea, retencion);
				listaProveedores.add(sumin); // proveedor de suministro
			} else {
				int n_personas = Integer.parseInt(linea[10]);
				Subcontrata subcon = new Subcontrata(linea, n_personas);
				listaProveedores.add(subcon); // proveedor de subcontrata
			}
		}
		if (!listaProveedores.isEmpty()) {
			for (Proveedor pr : listaProveedores) {
				pr.addProveedor(pr);
			}
			System.out.println("Se han leído los proveedores");
			System.out.println("****************************" + "\n");
			for (Proveedor pr : listaProveedores)
				pr.listarProveedores();
			System.out.println("\n");
		} else {
			System.out.println("No existen proveedores en el archivo!!!\n" + "El archivo csv está vacío!!!");
			System.out.println("El programa ha terminado, vuelve cuando quieras.");
			System.exit(0);
		}
		return listaProveedores;
	}// Fin método LeerProvedores

	public void LeerPagos() throws FileNotFoundException {
		fr = new File("src/examen_Pend_GestPagProv/ficheros/pagos.csv");
		entrada = new Scanner(fr);
		cadena = entrada.nextLine();// salta 1A
		if (listaProveedores != null) {
			while (entrada.hasNext()) {
				cadena = entrada.nextLine();
				linea = cadena.split(";");
				int proveedor = Integer.parseInt(linea[0]);
				for (Proveedor p : listaProveedores) {
					linea[4] = linea[4].replace(',', '.');
					if (p.codigo == proveedor)
						p.addPago(new Pago(linea[1], Integer.parseInt(linea[2]), Integer.parseInt(linea[3]),
								Double.parseDouble(linea[4])));
				}
			}
			System.out.println("Se han leído los pagos");
			System.out.println("**********************" + "\n");
			for (Proveedor p : listaProveedores)
				p.listarPagos();
			System.out.println("\n");
			pagosGenerados = true;
		} else {
			System.out.println("Primero debes leer los proveedores!!!");
		}
	}// Fin método LeerPagos

	public void GenerarIva() {
		if (pagosGenerados) {
			System.out.println("Introduzca el año");
			year = sc.nextInt();
			System.out.println("Introduzca el trimestre");
			int trimestre = sc.nextInt();

			System.out.println("Informe de IVA del trimestre " + trimestre + " del año " + year);
			System.out.println("*************************************************************");
			double acum = 0.0;
			double total_trimestre = 0.0;
			for (Proveedor p : listaProveedores) {
				total_trimestre = p.totalTrimestre(trimestre, year);
				acum += total_trimestre;
				System.out.println(p.nombre + " -> " + p.totalTrimestre(trimestre, year) + " €");
			}
			System.out.println("Total -> " + acum + " €");
			System.out.println("*************************************************************");
			System.out.println("  ");
		} else {
			System.out.println("Primero debes generar pagos!!!");
		}
	}// Fin método GenerarIva

	public void InformePagos() {
		if (pagosGenerados) {
			System.out.println("Introduzca el año");
			year = sc.nextInt();
			System.out.println("Informe anual del año " + year);
			System.out.println("*************************************************************");

			double totalTemp = 0.0;
			for (Proveedor p : listaProveedores) {
				double acum = 0.0, total_trimestre = 0.0;

				for (int i = 1; i <= 4; i++) {
					total_trimestre = p.totalTrimestre(i, year);
					acum += total_trimestre;
					System.out.println(p.nombre + " - Trimestre " + i + ": " + total_trimestre + " €");
				}
				System.out.println("Total de " + p.nombre + " -> " + acum + " €");
				System.out.println("*************************************************************");
				System.out.println("  ");
				totalTemp += acum;
			}

			// Redondeo a 2 decimales con BigDecimal y RoundingMode
			BigDecimal bd = new BigDecimal(totalTemp).setScale(2, RoundingMode.HALF_UP);
			double total = bd.doubleValue();

			System.out.println("Total del año " + year + ": " + total + " €\n");
		} else {
			System.out.println("Primero debes generar pagos!!!");
		}
	}// Fin método InformePagos

}// Fin clase Ficheros
