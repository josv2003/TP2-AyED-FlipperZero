package juego.jugadas;

import juego.Escaner;
import juego.Jugador;
import juego.Tateti;
import juego.Turno;
import juego.cartas.Carta;

public class JugadaInhabilitarCartas extends Jugada{
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public JugadaInhabilitarCartas(Carta carta) {
		super(carta);
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------

	@Override
	public void jugar(Tateti partida, Turno turnoActual) {
		Jugador jugadorAfectado = Escaner.preguntarJugador(partida.getJugadores());
		jugadorAfectado.inhabilitarMano();
		System.out.println(jugadorAfectado.getSimbolo() + " no podes usar tus cartas por un turno.");
	}
	
//GETTERS SIMPLES ----------------------------------------------------------------------------------
//SETTERS SIMPLES ----------------------------------------------------------------------------------

}