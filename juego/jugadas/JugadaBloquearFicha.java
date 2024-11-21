package juego.jugadas;

import juego.Tateti;
import juego.Turno;
import juego.cartas.Carta;
import juego.tablero.Casillero;
import juego.tablero.Ficha;

public class JugadaBloquearFicha extends Jugada {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public JugadaBloquearFicha(Carta carta) {
		super(carta);
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------

	@Override
	public void jugar(Tateti partida, Turno turnoActual) throws Exception {
		
//		Casillero<Ficha> ubicacionFicha = partida.buscarFichaSeleccionada(); 
//
//        
//        Ficha fichaBloqueada =  ubicacionFicha.getDato();
//        
//        fichaBloqueada.bloquear(); 
//
//        System.out.println("Se ha bloqueado la ficha.");
	}
	
//GETTERS SIMPLES ----------------------------------------------------------------------------------
//SETTERS SIMPLES ----------------------------------------------------------------------------------
	
}