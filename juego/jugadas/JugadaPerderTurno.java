package juego.jugadas;

import juego.Escaner;
import juego.Jugador;
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
	
	public Turno obtenerTurno(Tateti partida, Jugador jugadorAfectado) throws Exception {
		for (int i = 0; i < partida.getTurnos().length; i++) {
			Turno turnoActual = partida.getTurnos()[i];
			if (jugadorAfectado.equals(turnoActual.getJugador())) {
				return turnoActual;
			}
		}
		throw new Exception("No se encontro el turno a afectar");
	}
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
	
	@Override
	public void jugar(Tateti partida, Turno turnoActual) throws Exception {
        Jugador jugadorAfectado = Escaner.preguntarJugador(partida.getJugadores());
        Turno turnoBloqueado = obtenerTurno(partida, jugadorAfectado);
        turnoBloqueado.incrementarBloqueosRestantes(1);
        
        System.out.println(jugadorAfectado.toString() + " pierde un turno.");
	}

//GETTERS SIMPLES ----------------------------------------------------------------------------------
//SETTERS SIMPLES ----------------------------------------------------------------------------------
}