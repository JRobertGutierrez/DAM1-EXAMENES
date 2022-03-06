package examen_Eval3_ListaRepro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AccesoDatos {
	/**
	 * Lista de reproducción - Clase AccesoDatos
	 * 
	 * @author Robert G
	 */
	public static Connection conn;
	public static Statement stmt;
	public static ResultSet rset;

	// Método para conectar con la BD
	public static Connection ConectarBD(String driver, String usuario, String pass) throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		conn = DriverManager.getConnection(driver, usuario, pass);
		return conn;
	}

	// Método para hacer consultas en la BD
	public static ResultSet ConsultaBD(String consulta) throws SQLException {
		stmt = ConectarBD("jdbc:oracle:thin:@localhost:1521:XE", "listarepro", "listarepro").createStatement();
		ResultSet rset = stmt.executeQuery(consulta);
		return rset;
	}

	// Método para insertar datos en la BD
	public static void insert(Connection conn, String insert) throws SQLException {
		Statement stmt = conn.createStatement();
		int p = stmt.executeUpdate(insert);
		if (p == 1) {
			JOptionPane.showMessageDialog(null, "Acabas de insertar " + p + " línea.", "Información",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Acabas de insertar " + p + " líneas.", "Información",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// Método para borrar datos de la BD
	public static void delete(Connection conn, String delete) throws SQLException {
		Statement stmt = conn.createStatement();
		int p = stmt.executeUpdate(delete);
		if (p == 1) {
			JOptionPane.showMessageDialog(null, "Acabas de borrar " + p + " línea.", "Información",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Acabas de borrar " + p + " líneas.", "Información",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// Método para cerrar la conexion con la BD
	public static void CerrarConexion() throws SQLException {
		stmt.close();
	}
}
