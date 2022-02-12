package gesParkAero;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Furgoneta.
 */
public class Furgoneta extends Vehiculo implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 *
	 * @author Robert Gutiérrez
	 */
	private static final long serialVersionUID = 1L;

	/** The capacidad. */
	private int capacidad;

	/**
	 * Instantiates a new furgoneta.
	 *
	 * @param matricula the matricula
	 * @param color     the color
	 * @param marca     the marca
	 * @param modelo    the modelo
	 * @param capacidad the capacidad
	 */
	public Furgoneta(String matricula, String color, String marca, String modelo, int capacidad) {
		super(matricula, color, marca, modelo);// Campos comunes de la clase vehiculo
		this.capacidad = capacidad;
	}

	/**
	 * Instantiates a new furgoneta.
	 */
	public Furgoneta() {
		super();
		this.capacidad = 0;
	}

	/**
	 * Gets the capacidad.
	 *
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * Sets the capacidad.
	 *
	 * @param capacidad the new capacidad
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see GesParkAero.vehiculo#toString()
	 */
	@Override
	public String toString() {
		return "furgoneta [capacidad=" + capacidad + ", matricula=" + matricula + ", color=" + color + ", marca="
				+ marca + ", modelo=" + modelo + "]";
	}
}// Fin clase furgoneta
