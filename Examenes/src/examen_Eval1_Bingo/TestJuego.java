package examen_Eval1_Bingo;

public class TestJuego {

	public static void main(String[] args) {
		Juego j = new Juego("Robert", "José", "Susana");
		j.Sorteo();
		j.imprimirResultados();
	}
}
