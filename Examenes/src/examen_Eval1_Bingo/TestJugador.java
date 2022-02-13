package examen_Eval1_Bingo;

public class TestJugador {
	/**
	 * Juego de Bingo - Clase Main para probar Jugador.
	 *
	 * @author Robert Gutiérrez
	 * @version 1.0
	 */
	public static void main(String[] args) {
		Jugador j = new Jugador("Robert");
		j.ObtenerBoleto();
		System.out.println(j.toString());
	}
}
