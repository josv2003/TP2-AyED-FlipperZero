package juego.cartas;

import juego.jugadas.Jugada;
import juego.jugadas.JugadaInhabilitarCartas;

public class CartaInhabilitarCartas extends Carta {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------
//CONSTRUCTORES ------------------------------------------------------------------------------------
	
	public CartaInhabilitarCartas() {
	    super("Inhabilita el uso de cartas por un turno a un jugador");
	}

//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
//GETTERS SIMPLES ----------------------------------------------------------------------------------

	@Override
	protected String getTituloPorDefecto() {
		return "Inhabilitar cartas";
	}
	
	@Override
	public Jugada getJugada() {
		return new JugadaInhabilitarCartas(this);
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------



}