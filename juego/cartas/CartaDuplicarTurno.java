package juego.cartas;

import juego.jugadas.Jugada;
import juego.jugadas.JugadaDuplicarTurno;

public class CartaDuplicarTurno extends Carta{
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public CartaDuplicarTurno() {
		super("Duplicas tu turno.");
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
//GETTERS SIMPLES ----------------------------------------------------------------------------------

	@Override
	protected String getTituloPorDefecto() {
		return "Duplicar turno";
	}
	
	@Override
	public Jugada getJugada() {
		return new JugadaDuplicarTurno(this);
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------
    
    




}
