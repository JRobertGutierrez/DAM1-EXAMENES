package examen_Eval3_ListaRepro;

public class Administrador extends Usuarios {
	/**
	 * Lista de reproducción - Clase Administrador
	 * 
	 * @author Robert G
	 */
	private int turno;

	public Administrador(String dNI, String nombre, String apellidos, String usuario, String clave, int turno) {
		super(dNI, nombre, apellidos, usuario, clave);
		this.setTurno(turno);
	}

	public Administrador() {
		super();
		this.turno = 0;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "Administrador [turno=" + turno + ", DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", usuario=" + usuario + ", clave=" + clave + "]";
	}
}
