package juego.cartas;

import juego.jugadas.Jugada;
import juego.jugadas.JugadaPerderTurno;

public class CartaPerderTurno extends Carta {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public CartaPerderTurno() {
		super("Hace perder el siguiente turno al jugador elegido.");
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
//GETTERS SIMPLES ----------------------------------------------------------------------------------
	
	@Override
	protected String getTituloPorDefecto() {
		return "Pierde turno";
	}
	
	@Override
	public Jugada getJugada() {
		return new JugadaPerderTurno(this);
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------
    

}