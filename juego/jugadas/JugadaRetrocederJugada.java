package juego.jugadas;

import juego.Tateti;
import juego.Turno;
import juego.cartas.Carta;
import juego.tablero.Casillero;
import juego.tablero.Ficha;

public class JugadaRetrocederJugada extends Jugada {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------
//CONSTRUCTORES ------------------------------------------------------------------------------------
	
	public JugadaRetrocederJugada(Carta carta) {
		super(carta);
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
	
	@Override
	public void jugar(Tateti partida, Turno turnoActual) throws Exception {
		
//		Casillero<Ficha> ultimaPosicion = partida.obtenerUltimaJugada(); 
//		if (ultimaPosicion == null) {
//			throw new Exception("No se puede retroceder, no hay jugadas anteriores.");
//		}
//		
//		
//		ultimaPosicion.retroceder(); 
//		
//		System.out.println("Se ha retrocedido la última jugada anterior a la tuya.");
	}

//GETTERS SIMPLES ----------------------------------------------------------------------------------
//SETTERS SIMPLES ----------------------------------------------------------------------------------
	
   
}