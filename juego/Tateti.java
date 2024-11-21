package juego;
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
	private boolean estadoDelJuego = true; 
	
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public Tateti(int cantidadJugadores, int ancho, int alto, int profundo) throws Exception {
		if (cantidadJugadores <= 0) {
			throw new Exception("Cantidad de jugadores inferior a la mínima");
		}
		this.tablero = new Tablero<Ficha>(ancho, alto, profundo);
		this.mazoDeCartas = new Mazo(cantidadJugadores);
		this.turnos = new Turno[cantidadJugadores];
		for (int i = 0; i < cantidadJugadores; i++) {
			int simbolo = i + 87;
			Jugador nuevoJugador = new Jugador((char)simbolo);
			Turno turnoJugador = new Turno(nuevoJugador);
			this.turnos[i] = turnoJugador;
		}
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
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
	
	public void jugar() throws Exception {
		int i = 0;
		//while x turno
		while (estadoDelJuego) {
			Turno turnoActual = this.turnos[i % turnos.length];	
			System.out.println("Turno de: " + turnoActual.getJugador().toString());
			
			//Levantar la carta	
			Jugador jugadorActual = turnoActual.getJugador();
			Carta cartaSacada = this.mazoDeCartas.sacarCarta();
			jugadorActual.agarrarCarta(cartaSacada); 
			
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
			Carta cartaActual = Escaner.preguntarCarta(jugadorActual.getCartas());
			if(cartaActual != null) {
				cartaActual.getJugada().jugar(this, turnoActual);
			}
			verificarGanador(casilleroDestino);
			i++;
		}
		System.out.println("Juego terminado\nGanó el jugador: " + this.turnos[(i % turnos.length) - 1].getJugador().getSimbolo());
	}
	
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
			throw new Exception("No se puede mover a ese casillero, esta ocupado");
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

	
//GETTERS SIMPLES ----------------------------------------------------------------------------------

	public Tablero<Ficha> getTablero() {
		return tablero;
	}
	
	public Jugador[] getJugadores() {
		return jugadores;
	}
	
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------

}
