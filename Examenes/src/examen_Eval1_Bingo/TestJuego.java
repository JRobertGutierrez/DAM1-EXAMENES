package examen_Eval1_Bingo;

public class TestJuego {
	/**
	 * Juego de Bingo - Clase Main para probar Juego.
	 *
	 * @author Robert Gutiérrez
	 * @version 1.0
	 */
	public static void main(String[] args) {
		Juego j = new Juego("Robert", "José", "Susana");
		j.Sorteo();
		j.imprimirResultados();
	}
}
