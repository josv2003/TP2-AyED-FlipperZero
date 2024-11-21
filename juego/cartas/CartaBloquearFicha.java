package juego.cartas;

import juego.jugadas.Jugada;
import juego.jugadas.JugadaBloquearFicha;

public class CartaBloquearFicha extends Carta {
    
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public CartaBloquearFicha() {
		super("Elegir una ficha para bloquear.");
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
//GETTERS SIMPLES ----------------------------------------------------------------------------------

	@Override
	protected String getTituloPorDefecto() {
		return "Bloquear ficha";
	}
	
	@Override
	public Jugada getJugada() {
		return new JugadaBloquearFicha(this);
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------    


}

