package examen_Eval3_ListaRepro;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Personas extends Usuarios {
	/**
	 * Lista de reproducción - Clase Personas
	 * 
	 * @author Robert G
	 */
	private String tipomusica;

	public Personas(String dNI, String nombre, String apellidos, String usuario, String clave, String tipomusica) {
		super(dNI, nombre, apellidos, usuario, clave);
		this.tipomusica = tipomusica;
	}

	public Personas() {
		super();
		this.tipomusica = "";
	}

	public String getTipomusica() {
		return tipomusica;
	}

	public void setTipomusica(String tipomusica) {
		this.tipomusica = tipomusica;
	}

	@Override
	public String toString() {
		return "Usuario [tipomusica=" + tipomusica + ", DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", usuario=" + usuario + ", clave=" + clave + "]";
	}

	// Método para crear fichero TXT
	public static void CrearFicheroUsuario(ResultSet rset) throws IOException, SQLException {

		FileWriter fw = new FileWriter("src/examen_Eval3_ListaRepro/ficheros/fichero.txt");
		PrintWriter fichero = new PrintWriter(fw);
		fichero.println("Usuario  || Clave    || DNI      || Nombre   || Apellidos   || Tipo Musica");
		fichero.println("--------------------------------------------------------------------------");
		while (rset.next()) {
			if (rset.getString(3).equals("U")) {
				fichero.println(rset.getString(1) + "   \t" + rset.getString(2) + "\t" + rset.getString(4) + "   "
						+ rset.getString(5) + "\t\t" + rset.getString(6) + "\t\t\t" + rset.getString(7));
			}
		}
		System.out.println("Archivo usuarios.txt generado correctamente");
		System.out.println("*******************************************");
		fichero.flush();
		fichero.close();
	}
}
