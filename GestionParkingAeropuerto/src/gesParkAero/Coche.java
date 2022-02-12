package gesParkAero;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Coche.
 */
public class Coche extends Vehiculo implements Serializable{
	
	/**
	 * The Constant serialVersionUID.
	 *
	 * @author Robert Gutiérrez
	 */
	private static final long serialVersionUID = 1L;
	
	/** The numpuertas. */
	private int numpuertas;
		
	/**
	 * Instantiates a new coche.
	 *
	 * @param matricula the matricula
	 * @param color the color
	 * @param marca the marca
	 * @param modelo the modelo
	 * @param numpuertas the numpuertas
	 */
	public Coche(String matricula, String color, String marca, String modelo, int numpuertas) {
		super(matricula, color, marca, modelo);//Campos comunes de la clase vehiculo
		this.numpuertas = numpuertas;
	}

	/**
	 * Instantiates a new coche.
	 */
	public Coche() {
		super();
		this.numpuertas=0;
	}

	/**
	 * Gets the numpuertas.
	 *
	 * @return the numpuertas
	 */
	public int getNumpuertas() {
		return numpuertas;
	}

	/**
	 * Sets the numpuertas.
	 *
	 * @param numpuertas the new numpuertas
	 */
	public void setNumpuertas(int numpuertas) {
		this.numpuertas = numpuertas;
	}
	
	/* (non-Javadoc)
	 * @see GesParkAero.vehiculo#toString()
	 */
	@Override
	public String toString() {
		return "coche [numpuertas=" + numpuertas + ", matricula=" + matricula + ", color=" + color + ", marca=" + marca
				+ ", modelo=" + modelo + "]";
	}
}//Fin clase coche
