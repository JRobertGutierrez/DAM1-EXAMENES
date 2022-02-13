package examen_Eval1_Bingo;

public class TestJugador {

	public static void main(String[] args) {
		Jugador j = new Jugador("Robert");
		j.ObtenerBoleto();
		System.out.println(j.toString());
	}
}
