package juego.jugadas;

import juego.Tateti;
import juego.Turno;
import juego.cartas.Carta;

public class JugadaPerderTurno extends Jugada {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public JugadaPerderTurno(Carta carta) {
		super(carta);
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
	
	@Override
	public void jugar(Tateti partida, Turno turnoActual) {
//		turnoActual.sumarBloqueo();
//		Jugador jugadorAfectado=partida.seleccionarObjetivo();
//		System.out.println(jugadorAfectado.getNombre() + " pierde un turno.");
	}

//GETTERS SIMPLES ----------------------------------------------------------------------------------
//SETTERS SIMPLES ----------------------------------------------------------------------------------
}