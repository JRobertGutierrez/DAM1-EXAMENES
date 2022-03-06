package examen_Eval3_ListaRepro;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAdmin {
	/**
	 * Lista de reproducción - Clase MenuAdmin
	 * 
	 * @author Robert G
	 */
	static ArrayList<Canciones> listacanciones = new ArrayList<Canciones>();
	static ArrayList<Grupos> listagrupos = new ArrayList<Grupos>();
	ArrayList<Personas> listausuario = new ArrayList<Personas>();
	private static Scanner sc;

	public static void menuPrincipal() throws SQLException, IOException {

		String opciones = "";
		sc = new Scanner(System.in);

		do {
			System.out.println("Zona de administración");
			System.out.println("**********************");
			System.out.println("1. Dar de alta nuevo grupo en la BD");
			System.out.println("2. Dar de baja un grupo borrando todas sus canciones");
			System.out.println("3. Dar de baja una canción de un grupo");
			System.out.println("4. Dar de alta una canción de un grupo");
			System.out.println("5. Generar usuarios.txt - Consulta de usuarios");
			System.out.println("6. Generar grupos.csv - Consulta de grupos");
			System.out.println("7. Generar canciones.csv - Consulta de canciones");
			System.out.println("8. Volver a la ventana de login");
			System.out.println("9. Salir del programa");
			opciones = sc.nextLine();

			switch (opciones) {

			case "1": // Alta nuevo grupo
				Grupos.altaGrupo();
				break;
			case "2": // Baja grupo
				Grupos.bajaGrupo();
				break;
			case "3": // Baja canción
				Canciones.bajaCancion();
				break;
			case "4": // Alta canción
				Canciones.altaCancion();
				break;
			case "5": // Consultar usuarios genera usuarios.txt
				Personas.CrearFicheroUsuario(AccesoDatos.ConsultaBD("select * from usuarios"));
				break;
			case "6": // Generar archivo grupos.csv
				Grupos.CrearFicheroGrupos(AccesoDatos.ConsultaBD("select * from GRUPOS"));
				break;
			case "7": // Generar archivo canciones.csv
				Canciones.CrearFicheroCanciones(AccesoDatos.ConsultaBD("select * from CANCIONES"));
				break;
			case "8": // Volver a la ventana de login
					InicioLR.frame1 = new InicioLR();
					InicioLR.frame1.setVisible(true);
				break;
			case "9": // Salir
				System.out.println("Has salido del programa, hasta pronto");
				System.exit(0);
				break;
			default:
				System.out.println("Opcion incorrecta - Pulse del 1 al 8 o 9 para salir");
				System.out.println("***************************************************");
				break;
			}
		} while (!opciones.equals("8") && !opciones.equals("9"));
	}
}
