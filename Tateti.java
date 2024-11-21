package juego;
import java.util.Random;


import juego.cartas.Carta;
import juego.tablero.Casillero;
import juego.tablero.Direccion;
import juego.tablero.Ficha;
import juego.tablero.Movimiento;
import juego.tablero.RelacionDatoCasillero;
import juego.tablero.Tablero;
import juego.tablero.estructuras.Lista;


public class Tateti {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------

	private Tablero<Ficha> tablero = null;
	private Jugador[] jugadores = null;
	private Turno[] turnos = null;
	private Mazo mazoDeCartas = null;
	private Mazo mesa = null;
	private boolean estadoDelJuego = true; 

	
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public Tateti(int cantidadJugadores, int ancho, int alto, int profundo) throws Exception {
		if (cantidadJugadores <= 0) {
			throw new Exception("Cantidad de jugadores inferior a la mínima");
		}
		this.tablero = new Tablero<Ficha>(ancho, alto, profundo);
		this.mazoDeCartas = new Mazo(cantidadJugadores);
		this.mesa = new Mazo(cantidadJugadores); //corregir
		this.turnos = new Turno[cantidadJugadores];
		this.jugadores = new Jugador[cantidadJugadores];
		for (int i = 0; i < cantidadJugadores; i++) {
			int simbolo = i + 87;
			Jugador nuevoJugador = new Jugador((char)simbolo);
			Turno turnoJugador = new Turno(nuevoJugador);
			this.turnos[i] = turnoJugador;
			this.jugadores[i] = nuevoJugador;
		}
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------

	public Casillero<Ficha> seleccionarCasillero() throws Exception {
		System.out.println("Ingrese coordenadas para seleccionar casillero:");
		int x = Escaner.preguntarEntero("X:");
		int y = Escaner.preguntarEntero("y:");
		int z = Escaner.preguntarEntero("Z:");
		 Casillero<Ficha> casilleroSeleccionado = this.tablero.getCasillero(x, y, z);
		
		return casilleroSeleccionado;
	}
	
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------

	public void verificarGanador(Casillero<Ficha> casillero) throws Exception {
		if (casillero == null) {
			throw new Exception("El casillero no puede ser vacio");
		}
		
		int cantidadFichasGanador = 3; //longitud del tateti
		
		int cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ARRIBA, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ABAJO, casillero.getDato()) - 1;
		if (cantidadFichasSeguidas >= cantidadFichasGanador) {
			estadoDelJuego = false;
		}
		
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.IZQUIERDA, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.DERECHA, casillero.getDato()) - 1;
		if (cantidadFichasSeguidas >= cantidadFichasGanador) {
			estadoDelJuego = false;
		}
		
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.IZQUIERDA_ARRIBA, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.DERECHA_ABAJO, casillero.getDato()) - 1;
		if (cantidadFichasSeguidas >= cantidadFichasGanador) {
			estadoDelJuego = false;
		}
		
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.IZQUIERDA_ABAJO, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.DERECHA_ARRIBA, casillero.getDato()) - 1;
		if (cantidadFichasSeguidas >= cantidadFichasGanador) {
			estadoDelJuego = false;
		}
		
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ADELANTE, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ATRAS, casillero.getDato()) - 1;
		if (cantidadFichasSeguidas >= cantidadFichasGanador) {
			estadoDelJuego = false;
		}
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ADELANTE_DERECHA, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ATRAS_IZQUIERDA, casillero.getDato()) - 1;
		if (cantidadFichasSeguidas >= cantidadFichasGanador) {
			estadoDelJuego = false;
		}
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ADELANTE_IZQUIERDA, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ATRAS_DERECHA, casillero.getDato()) - 1;
		if (cantidadFichasSeguidas >= cantidadFichasGanador) {
			estadoDelJuego = false;
		}
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ADELANTE_ARRIBA, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ATRAS_ABAJO, casillero.getDato()) - 1;
		if (cantidadFichasSeguidas >= cantidadFichasGanador) {
			estadoDelJuego = false;
		}
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ADELANTE_ABAJO, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ATRAS_ARRIBA, casillero.getDato()) - 1;
		if (cantidadFichasSeguidas >= cantidadFichasGanador) {
			estadoDelJuego = false;
		}
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ADELANTE_DERECHA_ARRIBA, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ATRAS_IZQUIERDA_ABAJO, casillero.getDato()) - 1;
		if (cantidadFichasSeguidas >= cantidadFichasGanador) {
			estadoDelJuego = false;
		}
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ADELANTE_DERECHA_ABAJO, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ATRAS_IZQUIERDA_ARRIBA, casillero.getDato()) - 1;
		if (cantidadFichasSeguidas >= cantidadFichasGanador) {
			estadoDelJuego = false;
		}
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ADELANTE_IZQUIERDA_ARRIBA, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ATRAS_DERECHA_ABAJO, casillero.getDato()) - 1;
		if (cantidadFichasSeguidas >= cantidadFichasGanador) {
			estadoDelJuego = false;
		}
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ADELANTE_IZQUIERDA_ABAJO, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ATRAS_DERECHA_ARRIBA, casillero.getDato()) - 1;
		if (cantidadFichasSeguidas >= cantidadFichasGanador) {
			estadoDelJuego = false;
		}
	}
	
	public int contarFichasSeguidas(Casillero<Ficha> casillero, Direccion direccion, Ficha ficha) throws Exception {
		if (casillero == null || casillero.getDato() == null) {
			return 0;
		}
		if (!casillero.getDato().esElMismoSimbolo(ficha)) {
			return 0;
		}
		return 1 + contarFichasSeguidas(casillero.getCasilleroVecino(direccion), direccion, ficha);
	}
	
	
	
	public int dado() {
		Random rand = new Random();
        return rand.nextInt(6) + 1;
		
	}
	
	
	/**
	 * pre:
	 * post: ejecuta la jugabilidad del tateti 
	 * @throws Exception
	 */
	public void jugar() throws Exception {
		int indiceTurno=0;
	
		//while x turno
		while (estadoDelJuego) {
			System.out.println("Índice actual: " + indiceTurno);
			Turno turnoActual = this.turnos[indiceTurno];				
			Jugador jugadorActual = turnoActual.getJugador();
			if (!turnoActual.estaBloqueado()) {
				//Levantar la carta	
				System.out.println("Tirando dado...");
				int cantidadCartas=dado();
				System.out.println("Te tocó el numero: "+cantidadCartas);
				for (int i = 0; i < cantidadCartas; i++) {
		            if (mazoDeCartas.estaVacia()) {
		            	System.out.println("Mazo vacio, se mezclaran las cartas de la mesa");
		            	mazoDeCartas.agregarCartasJugadasAlMazo(mesa);
		            	
		            }
		            Carta nuevaCarta=mazoDeCartas.sacarCarta();
		            try {
		            	jugadorActual.agarrarCarta(nuevaCarta);
		            } catch(Exception e) {
		            	System.out.println(e.getMessage());
		            	
		            }
		        
				}
				
				System.out.println("Turno de: " + turnoActual.getJugador().toString());
				
				//movimientos basicos
				Casillero<Ficha> casilleroDestino = null;
				if (!turnoActual.estaBloqueado()) {
					if (!turnoActual.getJugador().tieneTodasLasFichasEnElTablero()) {
						casilleroDestino = jugadaInicial(jugadorActual);
					} else {
						casilleroDestino = mover(jugadorActual);
					}
				}
				
				turnoActual.terminarTurno();
				
				//Si juega una carta
				if (jugadorActual.getInhabilitacionesMano() <= 0) {
					Carta cartaActual = Escaner.preguntarCarta(jugadorActual.getCartas());
					if(cartaActual != null) {
						cartaActual.getJugada().jugar(this, turnoActual);
					}
				}
				verificarGanador(casilleroDestino);
				
			}
			if (!turnoActual.getDuplicado()) {
				indiceTurno = (indiceTurno+=1)%this.jugadores.length;	
			}
			
			System.out.println("Índice siguiente: " + indiceTurno);
		}
		System.out.println("Juego terminado\nGanó el jugador: " + this.turnos[indiceTurno].getJugador().getSimbolo());
	}
	/*
	public void jugar() throws Exception {
		int i = 0;
		//while x turno
		while (estadoDelJuego) {
			System.out.println("Índice actual: " + i);
			Turno turnoActual = this.turnos[i % turnos.length];				
			Jugador jugadorActual = turnoActual.getJugador();
			while (turnoActual.haySubturnos()) {
				//Levantar la carta	
				Carta cartaSacada = this.mazoDeCartas.sacarCarta();
				jugadorActual.agarrarCarta(cartaSacada); 
				System.out.println("Turno de: " + turnoActual.getJugador().toString());
				
				//movimientos basicos
				Casillero<Ficha> casilleroDestino = null;
				if (turnoActual.estaBloqueado()) {
					if (!turnoActual.getJugador().tieneTodasLasFichasEnElTablero()) {
						casilleroDestino = jugadaInicial(jugadorActual);
					} else {
						casilleroDestino = mover(jugadorActual);
					}
				}
				//Si juega una carta
				if (jugadorActual.getInhabilitacionesMano() <= 0) {
					Carta cartaActual = Escaner.preguntarCarta(jugadorActual.getCartas());
					if(cartaActual != null) {
						cartaActual.getJugada().jugar(this, turnoActual);
					}
				}
				verificarGanador(casilleroDestino);
				turnoActual.utilizarSubturno();
			}
			i++;
			System.out.println("Índice siguiente: " + i);
		}
		System.out.println("Juego terminado\nGanó el jugador: " + this.turnos[(i % turnos.length) - 1].getJugador().getSimbolo());
	}
	
	/**
	 * pre:
	 * @param jugador
	/**
	 * pre:
	 * @param jugador
	 * post: colaca una ficha del jugador en el casillero de las coordenadas ingresadas por consola 
	 * @throws Exception 
	 */
	public Casillero<Ficha> jugadaInicial(Jugador jugador) throws Exception {
		Ficha ficha = jugador.jugarFicha();
		System.out.println("Ingrese Coordenadas");
		int x = Escaner.preguntarEntero("X:");
		int y = Escaner.preguntarEntero("Y:");
		int z = Escaner.preguntarEntero("Z:");
		
		Casillero<Ficha> casillero = this.tablero.getCasillero(x, y, z);
		if(casillero.estaOcupado()) {
			throw new Exception("No se puede mover, el casillero esta ocupado");
		}
		if (casillero.estaAnulado()) {
			throw new Exception("No se puede mover, el casillero esta anulado");
		}
		casillero.setDato(ficha);
		return casillero;
	}
	
	/**
	 * pre:
	 * @param ficha: indica la ficha a mover
	 * @param movimiento: indica el movimiento a realizar ( horizontal, vertical o profundo))
	 * @throws Exception: si no se puede mover, da error
	 * post: mueve la ficha de una posicion a otra, quedando el casillero vacio en el origen y la ficha en el 
	 * 		 casillero destino 
	 */
	public Casillero<Ficha> mover(Jugador jugador) throws Exception {
		
		Long idFicha = Escaner.preguntarLong("Ingrese el id de la ficha que quiere mover");
		Lista<RelacionDatoCasillero<Ficha>> posicionesFichas = this.tablero.getPosicionDeLasDatos();
		Ficha ficha = buscarFicha(posicionesFichas, idFicha); 
		
		Movimiento movimiento = Escaner.preguntarMovimiento();
		Casillero<Ficha> casillero = this.tablero.getCasillero(ficha);
		if (!casillero.existeElVecino(movimiento)) {
			throw new Exception("No existe el movimiento");
		}
		if (casillero.getCasilleroVecino(movimiento).estaOcupado()) {
			throw new Exception("No existe el movimiento");
		}
		if (casillero.getCasilleroVecino(movimiento).estaAnulado()) {
			throw new Exception("El casillero esta anulado");
		}
		this.tablero.mover(casillero, casillero.getCasilleroVecino(movimiento), ficha);
		return casillero.getCasilleroVecino(movimiento);
	}
	
	private Ficha buscarFicha(Lista<RelacionDatoCasillero<Ficha>> posicionesFichas, Long idFicha) throws Exception {	
		posicionesFichas.iniciarCursor();
		while (posicionesFichas.avanzarCursor()) {
			Ficha fichaActual = posicionesFichas.obtenerCursor().getDato();
			Long idActual = fichaActual.getId();
			if (idActual.equals(idFicha)) {
				return fichaActual;
			}
		}
		throw new Exception("No existe la ficha");
	}
	
	
	public Turno obtenerTurno(Jugador jugador) {
		for (int i = 0; i < this.jugadores.length; i++) {
	        if (this.jugadores[i].equals(jugador)) {
	            return this.turnos[i];
	        }
		} 
		return null;
	
	
	}

	
	
	
	



	
//GETTERS SIMPLES ----------------------------------------------------------------------------------

	public Tablero<Ficha> getTablero() {
		return tablero;
	}
	
	public Jugador[] getJugadores() {
		return jugadores;
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------

}
