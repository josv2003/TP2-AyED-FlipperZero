package juego.jugadas;

import juego.Tateti;
import juego.Turno;
import juego.cartas.Carta;

public abstract class Jugada {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------

	private Carta carta = null;
	
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public Jugada(Carta carta) {
		this.carta = carta;
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------

	public abstract void jugar(Tateti tateti,
								Turno turnoActual) throws Exception;

//GETTERS SIMPLES ----------------------------------------------------------------------------------

	public Carta getCarta() {
		return carta;
	}
	
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------
}
