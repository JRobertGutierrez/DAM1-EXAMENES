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

public class Grupos implements Valida {
	/**
	 * Lista de reproducci�n - Clase Grupos
	 * 
	 * @author Robert G
	 */
	private int codigo;
	private String nombre;
	private int a�o;
	private String tipomusica;
	private static Scanner sc;

	public Grupos(int codigo, String nombre, int a�o, String tipomusica) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.a�o = a�o;
		this.tipomusica = tipomusica;
	}

	public Grupos() {
		super();
		this.codigo = 0;
		this.nombre = "";
		this.a�o = 0;
		this.tipomusica = "";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
	}

	public String getTipomusica() {
		return tipomusica;
	}

	public void setTipomusica(String tipomusica) {
		this.tipomusica = tipomusica;
	}

	@Override
	public String toString() {
		return "Grupos [codigo=" + codigo + ", nombre=" + nombre + ", a�o=" + a�o + ", tipomusica=" + tipomusica + "]";
	}

	// M�todo para dar de alta un grupo
	public static void altaGrupo() throws SQLException {

		sc = new Scanner(System.in);
		System.out.println("\n** Introduce ahora los datos del nuevo grupo **\n");
		String cod;

		do {
			System.out.println("");
			System.out.println("\n\t** Acabo de listar los grupos que existen en la BD **");
			System.out.println("\n\tElige un grupo que no est� en la lista o pulsa 0 para volver atras");
			System.out.println("\t******************************************************************\n");
			ResultSet rset = AccesoDatos.ConsultaBD// Muestro el listado de los grupos ordenados por codigo
			("select codigo,nombre from grupos order by codigo");
			while (rset.next()) {// Con la siguiente linea poniendo el . hago que parezca un men� con los c�digos de
									// grupo
				System.out.println(rset.getString(1) + ". " + rset.getString(2));
			}
			do {
				System.out.println("");
				System.out.print("Elige un c�digo que no est� en la lista o pulsa 0 para volver atras: ");
				cod = sc.nextLine();
			} while (!valido2(cod));
		} while (!checkCodigo(cod));
		System.out.println("");

		if (!cod.equals("0")) { // Si opcion no es 0...

			System.out.print("Nombre: ");
			String nom = sc.nextLine();
			System.out.println("");

			String a�o;
			do {
				System.out.print("A�o de creaci�n: ");
				a�o = sc.nextLine();
			} while (!valido2(a�o));
			System.out.println("");

			System.out.print("Tipo de m�sica: ");
			String tipoMus = sc.nextLine();
			System.out.println("");

			int confirmar = JOptionPane.showConfirmDialog(null, "�Quieres a�adir el grupo \"" + nom + "\"?", "Aviso",
					JOptionPane.YES_NO_OPTION);
			if (confirmar == JOptionPane.YES_OPTION) {
				InicioLR.rset = AccesoDatos.ConsultaBD// Consulto si el codigo esta o no en la base de datos
				("insert into grupos (codigo,nombre,a�o,tipo_musica) values (" + cod + ",'" + nom + "'," + a�o + ",'"
						+ tipoMus + "')");
				System.out.println("El grupo se ha a�adido a la BD");
				System.out.println("******************************");
			}
		} // if cod no es 0
	}

	// M�todo para dar de baja un grupo (ojo borrando todas sus canciones)
	@SuppressWarnings("resource")
	public static void bajaGrupo() throws SQLException {
		Scanner sc = new Scanner(System.in);
		String opcion = "";

		ResultSet rset = AccesoDatos.ConsultaBD// Consulto si el codigo esta o no en la base de datos
		("select codigo,nombre from grupos order by codigo");// Ordeno la consulta por codigo
		do {
			System.out.println("�Que grupo quieres borrar? !!!Ojo se borraran todas sus canciones...");
			System.out.println("********************************************************************");
			while (rset.next()) {// Con la siguiente linea poniendo el . hago que parezca un men� con los c�digos de
									// grupo
				System.out.println(rset.getString(1) + ". " + rset.getString(2));
			}
			do {

				System.out.println("");
				System.out.println("Elige un c�digo que est� en la lista o pulsa 0 para volver atras: ");

				opcion = sc.nextLine();

			} while (checkCodigo(opcion) && !opcion.equals("0"));

			if (!opcion.equals("0")) { // Si opcion no es 0...

				int confirmar = JOptionPane.showConfirmDialog(null, "�Seguro que quieres borrarlo?", "Aviso",
						JOptionPane.YES_NO_OPTION);
				if (confirmar == JOptionPane.YES_OPTION) {
					InicioLR.rset = AccesoDatos.ConsultaBD// Consulto si el codigo esta o no en la base de datos
					("delete canciones where codigo_grupo='" + opcion + "'"); // Se borran las canciones primero.
					InicioLR.rset = AccesoDatos.ConsultaBD// Consulto si el codigo esta o no en la base de datos
					("delete grupos where codigo='" + opcion + "'"); // Se borra el grupo.
					System.out.println("Canciones y grupo borrados correctamente");
					System.out.println("****************************************");
				}
			}
		} while (!opcion.equals("0"));

	}// Fin m�todo dar de baja un grupo

	// M�todo para generar un fichero csv desde una base de datos
	public static void CrearFicheroGrupos(ResultSet rset) throws SQLException, IOException {

		FileWriter fw = new FileWriter("src/examen_Eval3_ListaRepro/ficheros/grupos.csv");
		PrintWriter fichero = new PrintWriter(fw);
		fichero.println("Codigo;Nombre;A�o;Tipo M�sica");
		while (rset.next()) {
			fichero.println(rset.getInt(1) + ";" + rset.getString(2) + ";" + rset.getInt(3) + ";" + rset.getString(4));
			MenuAdmin.listagrupos.add(new Grupos(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getString(4)));
		}
		System.out.println("Archivo generado correctamente");
		System.out.println("******************************");
		fichero.flush();
		fichero.close();
	}

	// M�todo para impedir la entrada de datos String en int a traves de interface valida
	@SuppressWarnings("unused")
	public static boolean valido2(String ed) {

		boolean error = true;
		int entero = 0;
		try {
			entero = Integer.parseInt(ed);
		} catch (NumberFormatException e1) {
			error = false;
			System.out.println("Error en el formato del n�mero, intentelo de nuevo");
		} catch (Exception e1) {
			error = false;
			System.out.println("Error en el formato del n�mero, intentelo de nuevo");
		}
		return error;
	}// Fin de m�todo valido

	// Comprueba si existe el c�digo para no repetir en la base de datos
	public static boolean checkCodigo(String cod) throws SQLException {
		boolean valido = true;
		InicioLR.rset = AccesoDatos.ConsultaBD// Consulto si el codigo esta o no en la base de datos
		("SELECT codigo from grupos");

		while (InicioLR.rset.next()) {
			// System.out.println("codigos: "+rset.getString(1));
			if (cod.equals(InicioLR.rset.getString(1))) {
				valido = false;
			}
		}
		return valido;
	}// Fin de m�todo

	@SuppressWarnings("resource")
	public static void leerCsv() throws SQLException, IOException {
		FileReader fr = new FileReader("src/examen_Eval3_ListaRepro/ficheros/grupos.csv");
		BufferedReader br = new BufferedReader(fr);
		String linea = "";
		String[] lineaArr = new String[4];
		Grupos g = null;
		linea = br.readLine(); // Se salta la primera fila.
		while ((linea = br.readLine()) != null) {
			// System.out.println(linea);
			lineaArr = linea.split(";");
			g = new Grupos(Integer.parseInt(lineaArr[0]), lineaArr[1], Integer.parseInt(lineaArr[2]), lineaArr[3]);
			MenuAdmin.listagrupos.add(g); // A�adir grupos al arraylist.
		}
		fr = new FileReader("src/examen_Eval3_ListaRepro/ficheros/canciones.csv");
		br = new BufferedReader(fr);
		linea = "";
		lineaArr = new String[5];
		Canciones c = null;
		linea = br.readLine(); // Se salta la primera fila.
		while ((linea = br.readLine()) != null) {
			System.out.println(linea);
			lineaArr = linea.split(";");
			c = new Canciones(Integer.parseInt(lineaArr[0]), lineaArr[1], lineaArr[2], Integer.parseInt(lineaArr[3]),
					Integer.parseInt(lineaArr[4]));
			MenuAdmin.listacanciones.add(c); // A�ade canciones al arraylist
		}
	}

	// Comprueba si existe el grupo. Si existe, devuelve sus canciones.
	public static ArrayList<String> comprobarGrupo(String grupo) throws SQLException, IOException {
		ArrayList<String> canAL = new ArrayList<String>();
		for (Grupos i : MenuAdmin.listagrupos) {
			if (i.getNombre().equalsIgnoreCase(grupo)) {
				for (Canciones p : MenuAdmin.listacanciones) {
					if (i.getCodigo() == p.getCodigogrupo()) {
						canAL.add(p.getTitulo());
					}
				}
			}
		}
		return canAL;
	}
}// Fin de la clase Grupos
