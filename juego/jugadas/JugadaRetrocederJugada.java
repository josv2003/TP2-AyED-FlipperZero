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
		try {
			Jugador jugadorAfectado = Escaner.preguntarJugador(partida.getJugadores());
            
	        RelacionDatoCasillero<Ficha> ultimaJugada = jugadorAfectado.getUltimaPosicionMovida();
	       	
	        retrocederJugada(partida, ultimaJugada, jugadorAfectado);
	        	
	        System.out.println("Se ha retrocedido la última jugada del jugador seleccionado.");
			
		}catch (Exception e) {
			System.out.println("Error: "+ e.getMessage());
		}
		
	       
        
	}

	private void retrocederJugada(Tateti partida, RelacionDatoCasillero<Ficha> ultimaJugada, Jugador jugadorAfectado) throws Exception {
		if(ultimaJugada==null) {
			throw new Exception ("No es posible retroceder una jugada");
		}
		Ficha ficha = ultimaJugada.getDato();
		Casillero<Ficha> casilleroRetroceder = ultimaJugada.getCasillero();
		
		if (jugadorAfectado.tieneTodasLasFichasEnElTablero()) {
			Casillero<Ficha> casilleroOrigen = partida.getTablero().getCasillero(ficha);
			partida.getTablero().mover(casilleroOrigen, casilleroRetroceder, ficha);
			
		} else {
			jugadorAfectado.devolverFicha(ficha);
			casilleroRetroceder.vaciar();
			partida.getTablero().getPosicionDeLasDatos().remover(ultimaJugada);
	
	}
			System.out.println("Se vacio el casillero");
			
			
		}
		
	}

//GETTERS SIMPLES ----------------------------------------------------------------------------------
//SETTERS SIMPLES ----------------------------------------------------------------------------------
	
   
