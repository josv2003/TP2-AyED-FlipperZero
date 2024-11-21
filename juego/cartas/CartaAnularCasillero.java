package juego.cartas;

import juego.jugadas.Jugada;
import juego.jugadas.JugadaAnularCasillero;

public class CartaAnularCasillero extends Carta {
  
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------
//CONSTRUCTORES ------------------------------------------------------------------------------------
	
	public CartaAnularCasillero() {
		super("Elegir un casillero para anular.");
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
//GETTERS SIMPLES ----------------------------------------------------------------------------------

	@Override
	protected String getTituloPorDefecto() {
		return "Anular casillero";
	}
	
	@Override
	public Jugada getJugada() {
		return new JugadaAnularCasillero(this);
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------
    
    

}
