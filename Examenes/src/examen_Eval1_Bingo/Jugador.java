package examen_Eval1_Bingo;

import java.util.Arrays;

public class Jugador {
	/**
	 * Juego de Bingo - Clase Jugador.
	 *
	 * @author Robert Guti�rrez
	 * @version 1.0
	 */
	private String nombre, alias;
	private int boleto[];

	Jugador() {
		nombre = "";
		alias = "";
		boleto = new int[3];
		for (int i = 0; i < boleto.length; i++)
			boleto[i] = 0;
	}

	Jugador(String nombre) {
		this.nombre = nombre;
		boleto = new int[3]; // Aqu� variamos la cantidad de numeros en el boleto
		for (int i = 0; i < boleto.length; i++)
			boleto[i] = 0;
	}

	// M�todo para obtener n�meros aleatorios
	public void ObtenerBoleto() {
		for (int i = 0; i < boleto.length; i++)
			boleto[i] = (int) (Math.random() * 20) + 1;
	}

	// M�todo para obtener el alias con el patr�n solicitado
	public String ObtenerAlias() {
		int numero = (int) (Math.random() * 100);
		alias = "J" + nombre.substring(0, 3) + numero;
		return alias;
	}

	// Getters & Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public int[] getBoleto() {
		return boleto;
	}

	public void setBoleto(int[] boleto) {
		this.boleto = boleto;
	}

	public String toString() {
		return ("El jugador " + this.getNombre() + " con alias " + this.ObtenerAlias() + " tiene el boleto "
				+ Arrays.toString(boleto));
	}

	public void imprimirBoleto() {
		System.out.print(this.getAlias());
		System.out.println(Arrays.toString(boleto));
	}

	public void cambiarValor(int posicion) {
		boleto[posicion] = 0;
	}

	public boolean EncontrarNumero(int n) {
		boolean encontrado = false;
		for (int i = 0; i < boleto.length; i++) {
			if (boleto[i] == n) {
				encontrado = true;
				this.cambiarValor(i);
				System.out.println("El n�mero est� en el boleto de  " + this.getAlias());
				this.imprimirBoleto();
			}
		}
		return encontrado;
	}

	public boolean gana() {
		for (int i = 0; i < boleto.length; i++)
			if (boleto[i] != 0)
				return false;
		return true;
	}
}
