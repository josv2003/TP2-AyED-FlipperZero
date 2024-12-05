package juego.jugadas;

import juego.Tateti;
import juego.Turno;
import juego.cartas.Carta;

public class JugadaDuplicarTurno extends Jugada{
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public JugadaDuplicarTurno(Carta carta) {
		super(carta);
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------

	@Override
	public void jugar(Tateti partida, Turno turnoActual) {
		turnoActual.setDuplicado(true);
		System.out.println(" Duplicaste tu turno.");
	}
	
//GETTERS SIMPLES ----------------------------------------------------------------------------------
//SETTERS SIMPLES ----------------------------------------------------------------------------------
}