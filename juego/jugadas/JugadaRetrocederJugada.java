package juego.jugadas;

import juego.Escaner;
import juego.Jugador;
import juego.Tateti;
import juego.Turno;
import juego.cartas.Carta;
import juego.tablero.Casillero;
import juego.tablero.Ficha;
import juego.tablero.RelacionDatoCasillero;

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
		
	       
        Jugador jugadorAfectado = Escaner.preguntarJugador(partida.getJugadores());
            
        RelacionDatoCasillero<Ficha> ultimaJugada = jugadorAfectado.getUltimaPosicionMovida();
       	
        retrocederJugada(partida, ultimaJugada, jugadorAfectado);
        	
        System.out.println("Se ha retrocedido la última jugada anterior a la tuya.");
	}

	private void retrocederJugada(Tateti partida, RelacionDatoCasillero<Ficha> ultimaJugada, Jugador jugadorAfectado) throws Exception {
		Ficha ficha = ultimaJugada.getDato();
		Casillero<Ficha> casilleroOrigen = ultimaJugada.getCasillero();
		Casillero<Ficha> casilleroDestino = partida.getTablero().getCasillero(ficha);
		partida.getTablero().mover(casilleroOrigen, casilleroDestino, ficha);
	}

//GETTERS SIMPLES ----------------------------------------------------------------------------------
//SETTERS SIMPLES ----------------------------------------------------------------------------------
	
   
}