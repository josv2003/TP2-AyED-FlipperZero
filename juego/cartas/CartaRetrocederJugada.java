package juego.cartas;

import juego.jugadas.Jugada;
import juego.jugadas.JugadaRetrocederJugada;

public class CartaRetrocederJugada extends Carta {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public CartaRetrocederJugada() {
		super("Retroceder una jugada del turno.");
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
//GETTERS SIMPLES ----------------------------------------------------------------------------------
	
	@Override
	protected String getTituloPorDefecto() {
		return "Retroceder jugada";
	}
	
	@Override
	public Jugada getJugada() {
		return new JugadaRetrocederJugada(this);
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------

}