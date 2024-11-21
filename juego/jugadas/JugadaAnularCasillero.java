package juego.jugadas;

import juego.Tateti;
import juego.Turno;
import juego.cartas.Carta;
import juego.tablero.Casillero;
import juego.tablero.Ficha;

public class JugadaAnularCasillero extends Jugada {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public JugadaAnularCasillero(Carta carta) {
		super(carta);
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
	
	@Override
	public void jugar(Tateti partida, Turno turnoActual) throws Exception {
        Casillero<Ficha> casilleroAnulado = partida.seleccionarCasillero(); 
        casilleroAnulado.anular(); 
        System.out.println("Se ha anulado el casillero.");
	}
	
//GETTERS SIMPLES ----------------------------------------------------------------------------------
//SETTERS SIMPLES ----------------------------------------------------------------------------------

}