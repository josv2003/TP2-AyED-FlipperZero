package juego.cartas;

import juego.jugadas.Jugada;
import juego.jugadas.JugadaCambiarColor;

public class CartaCambiarColor extends Carta {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public CartaCambiarColor() {
		super("Cambiar el color de una ficha");
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
//GETTERS SIMPLES ----------------------------------------------------------------------------------

	@Override
	protected String getTituloPorDefecto() {
		return "Cambiar color";
	}
	
	@Override
	public Jugada getJugada() {
		return new JugadaCambiarColor(this);
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------

}

