package gesParkAero;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Aparcamiento.
 */
public class Aparcamiento implements Serializable {

	/**
	 * Programa para la gestión de aparcamiento de un aeropuerto.
	 *
	 * @author Robert Gutiérrez
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;

	/** The c. */
	static Cliente c = new Cliente();// Objeto "c" de la clase cliente

	/**
	 * The main method.
	 *
	 * @param args Clase principal para mostrar menú al usuario
	 * @throws IOException Excepción para errores
	 */
	public static void main(String[] args) throws IOException {// Método main

		ArrayList<Conductor> conductores = new ArrayList<Conductor>();

		ArrayList<Cliente> clientesaparcamiento = new ArrayList<Cliente>();

		Vehiculo c1 = new Coche("1111-AAA", "Blanco", "Seat", "Ibiza", 5);// coche
		Vehiculo c2 = new Coche("2222-BBB", "Negro", "Volkswagen", "Passat", 4);// coche

		Vehiculo m1 = new Moto("3333-CCC", "Verde", "Kawasaky", "ER-6F", "Naked", 650, "A2");// moto
		Vehiculo m2 = new Moto("4444-DDD", "Naranja", "Kawasaky", "Z850", "Naked", 850, "A2");// moto

		Vehiculo f1 = new Furgoneta("5555-EEE", "Blanca", "Mercedes", "Vito", 8);// furgoneta
		Vehiculo f2 = new Furgoneta("6666-FFF", "Gris", "Volkswagen", "Happy", 8);// furgoneta

//(String dNI, String nombre, String apellidos, int edad, String direccion, String email, vehiculo v, int horallegada, int diasestancia)		
		Cliente p1 = new Cliente("02327342H", "Carmen", "Jiménez", 21, "Calle Flor", "carmen@gmail.com", c1, 16, 9);
		Cliente p2 = new Cliente("02327342H", "Alex", "García", 25, "Calle Hoja", "alex@gmail.com", c2, 1, 13);
		Cliente p3 = new Cliente("02327342H", "Jennifer", "Ramírez", 20, "Calle árbol", "jennifer@gmail.com", m1, 9, 2);
		Cliente p4 = new Cliente("04185272P", "Robert", "Gutiérrez", 31, "Calle Rama", "robert@gmail.com", m2, 11, 4);
		Cliente p5 = new Cliente("02327342H", "Susana", "Fernández", 43, "Calle Petalo", "susana@gmail.com", f1, 8, 7);
		Cliente p6 = new Cliente("02327342H", "Pedro", "Rodríguez", 56, "Calle Estambre", "pedro@gmail.com", f2, 20, 6);

		clientesaparcamiento.add(p1);// Añadimos al ArrayList los datos del cliente
		clientesaparcamiento.add(p2);// Añadimos al ArrayList los datos del cliente
		clientesaparcamiento.add(p3);// Añadimos al ArrayList los datos del cliente
		clientesaparcamiento.add(p4);// Añadimos al ArrayList los datos del cliente
		clientesaparcamiento.add(p5);// Añadimos al ArrayList los datos del cliente
		clientesaparcamiento.add(p6);// Añadimos al ArrayList los datos del cliente

		int opciones = 0;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("\n\n//////////////////////////////////////////");
			System.out.println("Menú principal");
			System.out.println("******************************************");
			System.out.println("Por favor elija una opción del 1 al 6 o 0 para salir");
			System.out.println("1. Leer conductores");
			System.out.println("2. Dar de alta cliente");
			System.out.println("3. Guardar clientes");
			System.out.println("4. Leer clientes");
			System.out.println("5. Generar Tickets");
			System.out.println("6. Imprimir turno de entrega");
			System.out.println("0. Salir del programa");
			opciones = sc.nextInt();

			switch (opciones) {

			case 1:// Leer conductores

				conductores = Conductor.conductores();
				// System.out.println(conductores); Con esto veriamos si el ArrayList conductores
				// contiene datos
				System.out.println("****************************************************\nConductores leídos");
				break;

			case 2:// Dar de alta cliente

				clientesaparcamiento.add(c.darAlta());

				System.out.println("Cliente añadido");
				break;

			case 3:// Guardar clientes

				EscribeClientes entrada = new EscribeClientes();
				entrada.abrir();// Abrimos el fichero

				for (Cliente i : clientesaparcamiento)
					entrada.escribir(i);// Escribimos el fichero

				System.out.println("Clientes guardados");
				entrada.cerrar();// Cerramos el fichero
				break;

			case 4:// Leer clientes
				String respuesta = "";
				Scanner r = new Scanner(System.in);
				System.out.println("!!!Aviso¡¡¡ - Se perderan los datos anteriores\n Pulsa S/N");
				respuesta = r.nextLine();

				if (respuesta.equalsIgnoreCase("S")) {
					LeeClientes lee = new LeeClientes();
					lee.abrir();// Abrimos el fichero

					clientesaparcamiento = lee.leer();// Leemos el fichero
					for (Cliente i : clientesaparcamiento)
						System.out.println(i);

					System.out.println("Clientes leidos");
					lee.cerrar();// Cerramos el fichero
				} else {
					System.out.println("Clientes no leidos");
				}
				break;

			case 5:// Generar Tickets

				for (Cliente c : clientesaparcamiento) {
					FileWriter fw = new FileWriter(".\\ficheros\\Ticket" + c.getNombre() + c.getApellidos() + ".txt");
					PrintWriter salida = new PrintWriter(fw);

					if (c.getV() instanceof Coche) {
						int precio = c.getDiasestancia() * 10;

						salida.println(c.getNombre() + " debe pagar " + precio + "€");

					} else if (c.getV() instanceof Moto) {
						int precio = c.getDiasestancia() * 5;

						salida.println(c.getNombre() + " debe pagar " + precio + "€");

					} else if (c.getV() instanceof Furgoneta) {
						int precio = c.getDiasestancia() * 15;

						salida.println(c.getNombre() + " debe pagar " + precio + "€");

					}
					fw.close();// Cerramos el archivo ya que si no se quedan vacios los txt
					salida.close();
				}
				System.out.println("Tickets generados");
				break;

			case 6:// Imprimir turno de entrega
				System.out.println("\n||||||||||||||||||\nTurnos de entrega:");
				Conductor cond = new Conductor();
				cond.turnoEntrega(conductores, clientesaparcamiento);
				break;

			default:// El cliente no ha introducido un número del 1 al 6
				System.out.println("No ha pulsado un número del 1 al 6");
				System.out.println("******************************************");
				break;
			}// Fin del switch
		} while (opciones != 0);// Mientras no pulsamos 0 seguimos dentro del programa
		sc.close();
		System.out.println("Ha salido del programa - Hasta pronto");
	}// Fin del Main
}// Fin de clase
