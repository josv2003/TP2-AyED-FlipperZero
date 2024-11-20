package juego;
import juego.cartas.Carta;
import juego.tablero.Casillero;
import juego.tablero.Direccion;
import juego.tablero.Ficha;
import juego.tablero.Movimiento;
import juego.tablero.Tablero;
import juego.tablero.estructuras.Cola;

public class Tateti {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------

	private Tablero<Ficha> tablero = null;
	private Jugador[] jugadores = null;
	private Turno[] turnos = null;
	private Cola<Carta> mazoDeCartas = null;
	
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public Tateti() throws Exception {
		this.tablero = new Tablero<Ficha>(3, 3, 3);
		this.mazoDeCartas = new Cola<Carta>();
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------

	public void verificarGanador(Casillero<Ficha> casillero) throws Exception {
		if (casillero == null) {
			throw new Exception("El casillero no puede ser vacio");
		}
		
		int cantidadFichas = 3; //longitud del tateti
		
		int cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ARRIBA, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ABAJO, casillero.getDato());
		if (cantidadFichasSeguidas >= cantidadFichas) {
			//hay ganador
		}
		
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.IZQUIERDA, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.DERECHA, casillero.getDato());
		if (cantidadFichasSeguidas >= cantidadFichas) {
			//hay ganador
		}
		
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.IZQUIERDA_ARRIBA, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.DERECHA_ABAJO, casillero.getDato());
		if (cantidadFichasSeguidas >= cantidadFichas) {
			//hay ganador
		}
		
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.IZQUIERDA_ABAJO, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.DERECHA_ARRIBA, casillero.getDato());
		if (cantidadFichasSeguidas >= cantidadFichas) {
			//hay ganador
		}
		
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ADELANTE, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ATRAS, casillero.getDato());
		if (cantidadFichasSeguidas >= cantidadFichas) {
			//hay ganador
		}
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ADELANTE_DERECHA, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ATRAS_IZQUIERDA, casillero.getDato());
		if (cantidadFichasSeguidas >= cantidadFichas) {
			//hay ganador
		}
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ADELANTE_IZQUIERDA, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ATRAS_DERECHA, casillero.getDato());
		if (cantidadFichasSeguidas >= cantidadFichas) {
			//hay ganador
		}
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ADELANTE_ARRIBA, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ATRAS_ABAJO, casillero.getDato());
		if (cantidadFichasSeguidas >= cantidadFichas) {
			//hay ganador
		}
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ADELANTE_ABAJO, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ATRAS_ARRIBA, casillero.getDato());
		if (cantidadFichasSeguidas >= cantidadFichas) {
			//hay ganador
		}
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ADELANTE_DERECHA_ARRIBA, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ATRAS_IZQUIERDA_ABAJO, casillero.getDato());
		if (cantidadFichasSeguidas >= cantidadFichas) {
			//hay ganador
		}
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ADELANTE_DERECHA_ABAJO, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ATRAS_IZQUIERDA_ARRIBA, casillero.getDato());
		if (cantidadFichasSeguidas >= cantidadFichas) {
			//hay ganador
		}
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ADELANTE_IZQUIERDA_ARRIBA, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ATRAS_DERECHA_ABAJO, casillero.getDato());
		if (cantidadFichasSeguidas >= cantidadFichas) {
			//hay ganador
		}
		cantidadFichasSeguidas = contarFichasSeguidas(casillero, Direccion.ADELANTE_IZQUIERDA_ABAJO, casillero.getDato()) + 
				contarFichasSeguidas(casillero, Direccion.ATRAS_DERECHA_ARRIBA, casillero.getDato());
		if (cantidadFichasSeguidas >= cantidadFichas) {
			//hay ganador
		}
	}
	
	public int contarFichasSeguidas(Casillero<Ficha> casillero, Direccion direccion, Ficha ficha) throws Exception {
		if (casillero == null) {
			return 0;
		}
		if (casillero.getDato().esElMismoSimbolo(ficha)) {
			return 0;
		}
		return 1 + contarFichasSeguidas(casillero.getCasilleroVecino(direccion), direccion, ficha);
	}
	
	public void jugar() throws Exception {
		//while x turno
		Turno turnoActual = null;
		
		//Levantar la carta	
		Jugador jugadorActual = turnoActual.getJugador();
		Carta cartaSacada = this.mazoDeCartas.desacolar();
		jugadorActual.agarrarCarta(cartaSacada); 
		
		//movimientos basicos
		Casillero<Ficha> casilleroDestino = null;
		if (turnoActual.estaBloqueado()) {
			if (!turnoActual.getJugador().tieneTodasLasFichasEnElTablero()) {
				jugadaInicial(jugadorActual);
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
	}
	
	/**
	 * pre:
	 * @param jugador
	 * post: colaca una ficha del jugador en el casillero de las coordenadas ingresadas por consola 
	 * @throws Exception 
	 */
	public void jugadaInicial(Jugador jugador) throws Exception {
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
		Ficha ficha = null;//fijarse como solicitarle la ficha al usuario
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

	
//GETTERS SIMPLES ----------------------------------------------------------------------------------

	public Tablero<Ficha> getTablero() {
		return tablero;
	}
	
	public Jugador[] getJugadores() {
		return jugadores;
	}
	
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------

	//clase 20 min 1:23:30 -- habla sobre los turnos y jugador actual
}
