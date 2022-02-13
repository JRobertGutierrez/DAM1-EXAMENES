package examen_Eval1_Bingo;

public class Juego {

	private int ganador, numero;
	private boolean fin = false;
	private Jugador j1, j2, j3;

	Juego(String n1, String n2, String n3) {
		j1 = new Jugador(n1);
		j1.ObtenerBoleto();
		j2 = new Jugador(n2);
		j2.ObtenerBoleto();
		j3 = new Jugador(n3);
		j3.ObtenerBoleto();
	}

	// Método para extraer las bolas con número aleatorio del 1 al 20
	public int extraerBola() {
		return ((int) (Math.random() * 20) + 1);
	}

	public void Sorteo() {

		System.out.println("Los jugadores que van a participar son: ");
		System.out.println("****************************************");
		System.out.println(j1.toString());
		System.out.println(j2.toString());
		System.out.println(j3.toString());
		System.out.println("****************************************");

		do {
			numero = this.extraerBola();
			System.out.println("\tBOLA CON NÚMERO: " + numero);

			j1.EncontrarNumero(numero);
			j2.EncontrarNumero(numero);
			j3.EncontrarNumero(numero);

			try {// Para ir segundo a segundo
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (j1.gana() || j2.gana() || j3.gana())
				fin = true;
		} while (!fin);
	}

	private void ganador(Jugador j) {
		System.out.println(j.getNombre() + " ha ganado!!!");
	}

	public void imprimirResultados() {
		if (j1.gana())
			ganador = 1;
		else if (j2.gana())
			ganador = 2;
		else
			ganador = 3;

		switch (ganador) {

		case 1:
			ganador(j1);
			break;
		case 2:
			ganador(j2);
			break;
		case 3:
			ganador(j3);
			break;
		}
	}
}
