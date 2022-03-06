package examen_Eval3_ListaRepro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Canciones {
	/**
	 * Lista de reproducción - Clase Canciones
	 * 
	 * @author Robert G
	 */
	private int codigogrupo;
	private String disco;
	private String titulo;
	private int minutos;
	private int segundos;
	private static Scanner sc;

	public Canciones(int codigogrupo, String disco, String titulo, int minutos, int segundos) {
		super();
		this.codigogrupo = codigogrupo;
		this.disco = disco;
		this.titulo = titulo;
		this.minutos = minutos;
		this.segundos = segundos;
	}

	public Canciones() {
		super();
		this.codigogrupo = 0;
		this.disco = "";
		this.titulo = "";
		this.minutos = 0;
		this.segundos = 0;
	}

	public int getCodigogrupo() {
		return codigogrupo;
	}

	public void setCodigogrupo(int codigogrupo) {
		this.codigogrupo = codigogrupo;
	}

	public String getDisco() {
		return disco;
	}

	public void setDisco(String disco) {
		this.disco = disco;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	@Override
	public String toString() {
		return "Canciones [codigogrupo=" + codigogrupo + ", disco=" + disco + ", titulo=" + titulo + ", minutos="
				+ minutos + ", segundos=" + segundos + "]";
	}

	// Método para dar de baja canciones de una base de datos
	public static void bajaCancion() throws SQLException {
		sc = new Scanner(System.in);
		String opcion1 = "";
		String opcion2 = "";

		ResultSet rset = AccesoDatos.ConsultaBD// Consulto si el codigo esta o no en la base de datos
		("select codigo, nombre from grupos order by codigo");// Muestro los codigos y grupos ordenado por codigo
		System.out.println("\n\t** Acabo de listar los grupos que existen en la BD **");
		System.out.println("\n\tElige un grupo para borrar una canción o pulsa 0 para volver atras");
		System.out.println("\t******************************************************************\n");
		while (rset.next()) {// Con la siguiente linea poniendo el . hago que parezca un menú con los códigos de
								// grupo
			System.out.println(rset.getString(1) + ". " + rset.getString(2));
		}
		do {
			System.out.println("");
			System.out.println("Introduce un grupo que esté en la lista: ");
			opcion1 = sc.nextLine();
		} while (Grupos.checkCodigo(opcion1) && !opcion1.equals("0")); // Comprueba que el código introducido existe.
		System.out.println("");
		// }while(!opcion.equals("0"));
		if (!opcion1.equals("0")) { // Si opcion no es 0...

			// Mostrar canciones del grupo.
			ResultSet rset2 = AccesoDatos
					.ConsultaBD("select titulo from canciones where codigo_grupo='" + opcion1 + "'");
			do {
				System.out.println("\n\t** Acabo de listar las canciones del grupo elegido **");
				System.out.println("\n\t¿Qué canción quieres borrar?\n");
				while (rset2.next()) {
					System.out.println(rset2.getString(1));
				}
				do {
					System.out.print("\nSi el grupo elegido tiene canciones escribe la que quieres borrar\n"
							+ "si no tiene canciones pulsa 0 para volver atras: ");
					opcion2 = sc.nextLine();
				} while (!checkExisteCancion(opcion2) && !opcion2.equals("0")); // Comprueba que el código introducido
																				// existe.
				System.out.println("");
				if (checkExisteCancion(opcion2)) {// Si la canción existe me pregunta primero
					int confirmar = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres borrarla?", "Aviso",
							JOptionPane.YES_NO_OPTION);
					if (confirmar == JOptionPane.YES_OPTION) {
						// Accedo al método delete de la clase AccesoDatos para borrar canciones
						AccesoDatos.delete(
								AccesoDatos.ConectarBD("jdbc:oracle:thin:@localhost:1521:XE", "examen", "examen"),
								"delete canciones where titulo='" + opcion2 + "'"); // Se borran las canciones primero.
						opcion2 = "0"; // Salir tras borrar.
					}
				}
			} while (!opcion2.equals("0"));
		}
	}

	// Método para comprobar si existe una canción o no
	public static boolean checkExisteCancion(String can) throws SQLException {
		boolean valida = false;
		ResultSet rset = AccesoDatos.ConsultaBD// Hago una consulta
		("select titulo from canciones");
		while (rset.next()) {
			if (rset.getString(1).equalsIgnoreCase(can)) {
				valida = true;
			}
		}
		return valida;
	}

	// Método para dar de alta canciones de una base de datos
	public static void altaCancion() throws SQLException {
		sc = new Scanner(System.in);
		String cod;
		ResultSet rset = AccesoDatos.ConsultaBD// Consulto si el codigo esta o no en la base de datos
		("select codigo,nombre from grupos order by codigo");// Muestro los codigos y grupos ordenado por codigo
		do {
			System.out.println("\n\t** Acabo de listar los grupos que existen en la BD **");
			System.out.println("\n\tElige un grupo para añadir una canción o pulsa 0 para volver atras");
			System.out.println("\t******************************************************************\n");
			while (rset.next()) {// Con la siguiente linea poniendo el . hago que parezca un menú con los códigos de
									// grupo
				System.out.println(rset.getString(1) + ". " + rset.getString(2));
			}

			do {
				System.out.println("");
				System.out.print("Elige un código de grupo que esté en la lista o pulsa 0 para volver atras: ");
				cod = sc.nextLine();
			} while (!Grupos.valido2(cod));// Compruebo que sea un número y no una cadena
		} while (Grupos.checkCodigo(cod) && !cod.equals("0"));// Compruebo que el código introducido existe en la BD
		System.out.println("");
		if (!cod.equals("0")) { // Si opcion no es 0...
			ResultSet rset2 = AccesoDatos.ConsultaBD// Consulto el código que acabo de introducir
			("select nombre from grupos where codigo like '" + cod + "'");
			rset2.next();
			String nom = rset2.getString(1);// Almaceno el nombre del grupo que pertenece al codigo introducido
			System.out.println("");
			System.out.println("El código elegido pertenece al grupo: " + nom);

			System.out.println("");
			System.out.println("Disco: ");
			String disc = sc.nextLine();
			System.out.println("");

			System.out.print("Título: ");
			String tit = sc.nextLine();
			System.out.println("");

			String mins;
			do {
				System.out.print("Minutos: ");
				mins = sc.nextLine();
			} while (!Grupos.valido2(mins));// Compruebo que sea un número y no una cadena
			System.out.println("");

			String segs;
			do {
				System.out.print("Segundos: ");
				segs = sc.nextLine();
			} while (!Grupos.valido2(segs));// Compruebo que sea un número y no una cadena
			System.out.println("");

			int confirmar = JOptionPane.showConfirmDialog(null, "¿Añadir canción \"" + tit + "\"?", "Aviso",
					JOptionPane.YES_NO_OPTION);
			if (confirmar == JOptionPane.YES_OPTION) {
				// System.out.println("insert into canciones
				// (codigo_grupo,disco,titulo,minutos,segundos) values
				// ("+cod+",'"+disc+"','"+tit+"',"+mins+","+segs+")");
				AccesoDatos.insert(AccesoDatos.ConectarBD("jdbc:oracle:thin:@localhost:1521:XE", "examen", "examen"),
						"insert into canciones (codigo_grupo,disco,titulo,minutos,segundos) values (" + cod + ",'"
								+ disc + "','" + tit + "'," + mins + "," + segs + ")");
			}
		} // Fin if 0
	}

	// Método para crear el archivo canciones.csv desde la base de datos
	public static void CrearFicheroCanciones(ResultSet rset) throws SQLException, IOException {

		FileWriter fw = new FileWriter("src/examen_Eval3_ListaRepro/ficheros/canciones.csv");
		PrintWriter fichero = new PrintWriter(fw);
		fichero.println("Codigo Grupo;Disco;Titulo;Minutos;Segundos");
		while (rset.next()) {
			fichero.println(rset.getInt(1) + ";" + rset.getString(2) + ";" + rset.getString(3) + ";" + rset.getInt(4)
					+ ";" + rset.getInt(5));
			MenuAdmin.listacanciones.add(new Canciones(rset.getInt(1), rset.getString(2), rset.getString(3),
					rset.getInt(4), rset.getInt(5)));
		}
		System.out.println("Archivo generado correctamente");
		System.out.println("******************************");
		fichero.flush();
		fichero.close();
	}

	// Método para leer el archivo csv - lo uso al pinchar en el menú opciones el boton
	// lista de reproducción
	@SuppressWarnings("resource")
	public static void leerCsv() throws SQLException, IOException {
		FileReader fr = new FileReader("src/examen_Eval3_ListaRepro/ficheros/grupos.csv");
		BufferedReader br = new BufferedReader(fr);
		String linea = "";
		String[] lineaArr = new String[4];
		Grupos g = null;
		linea = br.readLine(); // Se salta la primera fila.
		while ((linea = br.readLine()) != null) {
			// System.out.println(linea); -- Con esto he hecho comprobaciones
			lineaArr = linea.split(";");
			g = new Grupos(Integer.parseInt(lineaArr[0]), lineaArr[1], Integer.parseInt(lineaArr[2]), lineaArr[3]);
			MenuAdmin.listagrupos.add(g); // Añadir los grupos al arralist
		}
		fr = new FileReader("src/examen_Eval3_ListaRepro/ficheros/canciones.csv");
		br = new BufferedReader(fr);
		linea = "";
		lineaArr = new String[5];
		Canciones c = null;
		linea = br.readLine(); // Se salta la primera fila.
		while ((linea = br.readLine()) != null) {

			lineaArr = linea.split(";");
			c = new Canciones(Integer.parseInt(lineaArr[0]), lineaArr[1], lineaArr[2], Integer.parseInt(lineaArr[3]),
					Integer.parseInt(lineaArr[4]));
			MenuAdmin.listacanciones.add(c); // Añadir las canciones al arraylist
		}
	}

	// Método para crear lista de reproducción - Lo uso en Ventana ListaRepro
	public static ArrayList<String> crearListaReproduccion(int duracionMax) {
		ArrayList<String> canciones = new ArrayList<String>();
		int duracion = 0;
		for (Grupos g : MenuAdmin.listagrupos) {
			if (g.getTipomusica().equalsIgnoreCase(InicioLR.gustoUser)) {// Si el tipo de música es igual que el gusto
																			// del usuario
				for (Canciones c : MenuAdmin.listacanciones) {
					if (c.getCodigogrupo() == g.getCodigo()) {// Si el código del grupo es igual que el código del grupo
																// del array de la lista de grupos
						if (duracion < duracionMax) {// Si duración es menor que duracion máxima
							canciones.add(c.getTitulo());// Lleno el array con los titulos de las canciones
							duracion += c.getMinutos();// duración = duración + minutos de la canción
						}
					}
				}
			}
		}
		return canciones;
	}// Fin de método crear lista reproducción
}// Fin de clase Canciones
