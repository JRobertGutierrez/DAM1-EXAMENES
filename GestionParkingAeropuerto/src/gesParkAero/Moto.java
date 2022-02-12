package gesParkAero;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Moto.
 */
public class Moto extends Vehiculo implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 *
	 * @author Robert Gutiérrez
	 */
	private static final long serialVersionUID = 1L;

	/** The tipo. */
	private String tipo;

	/** The cilindrada. */
	private int cilindrada;

	/** The carnet. */
	private String carnet;

	/**
	 * Instantiates a new moto.
	 *
	 * @param matricula  the matricula
	 * @param color      the color
	 * @param marca      the marca
	 * @param modelo     the modelo
	 * @param tipo       the tipo
	 * @param cilindrada the cilindrada
	 * @param carnet     the carnet
	 */
	public Moto(String matricula, String color, String marca, String modelo, String tipo, int cilindrada,
			String carnet) {
		super(matricula, color, marca, modelo);// Campos comunes de la clase vehiculo
		this.tipo = tipo;
		this.cilindrada = cilindrada;
		this.carnet = carnet;
	}

	/**
	 * Instantiates a new moto.
	 */
	public Moto() {
		super();
		this.tipo = "";
		this.cilindrada = 0;
		this.carnet = "";
	}

	/**
	 * Gets the tipo.
	 *
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Sets the tipo.
	 *
	 * @param tipo the new tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Gets the cilindrada.
	 *
	 * @return the cilindrada
	 */
	public int getCilindrada() {
		return cilindrada;
	}

	/**
	 * Sets the cilindrada.
	 *
	 * @param cilindrada the new cilindrada
	 */
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	/**
	 * Checks if is carnet.
	 *
	 * @return the string
	 */
	public String isCarnet() {
		return carnet;
	}

	/**
	 * Sets the carnet.
	 *
	 * @param carnet the new carnet
	 */
	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see GesParkAero.vehiculo#toString()
	 */
	@Override
	public String toString() {
		return "moto [tipo=" + tipo + ", cilindrada=" + cilindrada + ", carnet=" + carnet + ", matricula=" + matricula
				+ ", color=" + color + ", marca=" + marca + ", modelo=" + modelo + "]";
	}
}// Fin clase moto
