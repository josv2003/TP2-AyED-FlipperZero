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
	private Mazo cartasMesa = null;	
	private boolean estadoDelJuego = true;
	private int maxCartasMano;

	
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public Tateti(int cantidadJugadores, int ancho, int alto, int profundo, int maxCartasMano, int fichasPorJugador) throws Exception {
		if (cantidadJugadores <= 0) {
			throw new Exception("Cantidad de jugadores inferior a la mínima");
		}
		this.tablero = new Tablero<Ficha>(ancho, alto, profundo);
		this.mazoDeCartas = new Mazo(cantidadJugadores);
		this.cartasMesa = new Mazo();
		this.maxCartasMano = maxCartasMano;
		this.turnos = new Turno[cantidadJugadores];
		this.jugadores = new Jugador[cantidadJugadores];
		for (int i = 0; i < cantidadJugadores; i++) {
			int simbolo = i + 87;
			Jugador nuevoJugador = new Jugador((char)simbolo, maxCartasMano, fichasPorJugador);
			Turno turnoJugador = new Turno(nuevoJugador);
			this.turnos[i] = turnoJugador;
			this.jugadores[i] = nuevoJugador;
		}
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------

	public Casillero<Ficha> seleccionarCasillero() throws Exception {
		System.out.println("Ingrese coordenadas para seleccionar casillero:");
		int x = Escaner.preguntarEnteroConRango("X:",1,this.tablero.getAlto());
		int y = Escaner.preguntarEnteroConRango("y:",1,this.tablero.getAlto());
		int z = Escaner.preguntarEnteroConRango("Z:",1,this.tablero.getAlto());
				
				
		Casillero<Ficha> casilleroSeleccionado = this.tablero.getCasillero(x, y, z);
		return casilleroSeleccionado;
	}
	
	
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
	
	/*public boolean todasLasFichasBloqueadas(Jugador jugador) {
		if()
	}*/
	
	
	public void verificarGanador(Casillero<Ficha> casillero) throws Exception {
		if (casillero == null) {
			throw new Exception("El casillero no puede ser vacio");
		}
		
		int cantidadFichasGanador = this.tablero.getAlto(); //longitud del tateti
		
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
		int indiceTurno = 0;
		//while x turno
		while (estadoDelJuego) {
			Turno turnoActual = this.turnos[indiceTurno % turnos.length];				
			Jugador jugadorActual = turnoActual.getJugador();
			if (!turnoActual.estaBloqueado()) {
				System.out.println("Turno de: " + jugadorActual.toString());

				//Levantar la carta	
				if(this.maxCartasMano!=0) {
					System.out.println("Tirando dado...");
					int cantidadCartas = dado();
					System.out.println("Te tocó el numero: " + cantidadCartas);
					System.out.println(jugadorActual.toString() + " agarra " + cantidadCartas + " cartas.");
					if (this.mazoDeCartas.contarCartas()<cantidadCartas) {
		            	System.out.println("Mazo vacio, se mezclaran las cartas de la mesa");
		            	mazoDeCartas.agregarCartasJugadasAlMazo(cartasMesa);
		            }
					for (int i = 0; i < cantidadCartas; i++) {
			            
			            Carta nuevaCarta = this.mazoDeCartas.sacarCarta();
			            try {
			            	jugadorActual.agarrarCarta(nuevaCarta);
			            } catch(Exception e) {
			            	System.out.println(e.getMessage());
			            }		        
			        
					}
					System.out.println(jugadorActual.cartasEnMano());
					
				}
				
				//movimientos basicos
				Casillero<Ficha> casilleroDestino = null;
				if (!turnoActual.estaBloqueado()) {
					if (!turnoActual.getJugador().tieneTodasLasFichasEnElTablero()) {
						casilleroDestino = jugadaInicial(jugadorActual);
					} else {
						casilleroDestino = mover(jugadorActual);
					}
					
					if (turnoActual.isDuplicado()) {
						turnoActual.setDuplicado(false);
					}
				}
				
				turnoActual.terminarTurno();
				verificarGanador(casilleroDestino);
				
				if (this.maxCartasMano!=0) {
					
					//Si juega una carta
					if (jugadorActual.getInhabilitacionesMano() <= 0) {
						Carta cartaActual = Escaner.preguntarCarta(jugadorActual.getCartas());
						if(cartaActual != null) {
							cartaActual.getJugada().jugar(this, turnoActual);
							jugadorActual.jugarCarta(cartaActual);
							this.cartasMesa.agregarCarta(cartaActual);
						}
					}
					verificarGanador(casilleroDestino);
					
				}
				
			
			}
			if (!turnoActual.isDuplicado()) {
				indiceTurno = (indiceTurno+=1) % this.jugadores.length;
			}
		}
		System.out.println("Juego terminado\nGanó el jugador: " + this.turnos[(indiceTurno % turnos.length) - 1].getJugador().getSimbolo());
	}
	
	/**
	 * pre:
	 * @param jugador
	 * post: colaca una ficha del jugador en el casillero de las coordenadas ingresadas por consola 
	 * @throws Exception 
	 */
	public Casillero<Ficha> jugadaInicial(Jugador jugador) throws Exception {
		Ficha ficha = jugador.jugarFicha();
		Casillero<Ficha> casillero = seleccionarCasillero();
		
		while (verificarCasillero(casillero)) {
			System.out.println("Tu casillero no está disponible, elegí otro.");
			casillero = seleccionarCasillero();
		}
		casillero.setDato(ficha);
		RelacionDatoCasillero<Ficha> fichaCasillero = new RelacionDatoCasillero<Ficha>(casillero, ficha);
		jugador.setUltimaPosicionMovida(fichaCasillero);
		this.tablero.getPosicionDeLasDatos().agregar(fichaCasillero);
		
		return casillero;
	}
	
	
	public boolean verificarCasillero(Casillero<Ficha> casillero){
		return casillero.estaOcupado() || casillero.estaAnulado();
		
	}
	
	
	public boolean verificarFicha(Ficha ficha) throws Exception{
		return ficha.isBloqueado();
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
		System.out.println("Seleccione la ficha a mover (mediante su ID):");
		mostrarFichasPosiones(this.tablero.getPosicionDeLasDatos(), jugador);
		Ficha ficha = null;
	
		do {
				Long idFicha = Escaner.preguntarLong("Ingresá una ficha no bloqueada (ID): ");
				Lista<RelacionDatoCasillero<Ficha>> posicionesFichas = this.tablero.getPosicionDeLasDatos();
				ficha = buscarFicha(posicionesFichas, idFicha); 
				verificarFicha(ficha);
			
		}while (ficha.isBloqueado());
		
		Casillero<Ficha> posicionActualFicha = this.tablero.getCasillero(ficha); 
		RelacionDatoCasillero<Ficha> ultimoMovimiento = new RelacionDatoCasillero<Ficha>(posicionActualFicha, ficha);
		jugador.setUltimaPosicionMovida(ultimoMovimiento);
	
		
		Movimiento movimiento = Escaner.preguntarMovimiento();
		Casillero<Ficha> casillero = this.tablero.getCasillero(ficha);
		Casillero<Ficha> casilleroVecino = casillero.getCasilleroVecino(movimiento);
		while (verificarCasillero(casilleroVecino)) {
			System.out.println("Tu casillero no está disponible, elegí otro movimiento.");
			movimiento = Escaner.preguntarMovimiento();
			casilleroVecino = casillero.getCasilleroVecino(movimiento);
		}
		
		this.tablero.mover(casillero, casilleroVecino, ficha);
		return casilleroVecino;
	}
	
	
	public void verificarMovimiento(Casillero<Ficha> casillero, Movimiento movimiento) throws Exception{
		if (!casillero.existeElVecino(movimiento)) {
			throw new Exception("No existe el movimiento");
		}
		if (casillero.getCasilleroVecino(movimiento).estaOcupado()) {
			throw new Exception("No existe el movimiento");
		}
		if (casillero.getCasilleroVecino(movimiento).estaAnulado()) {
			throw new Exception("El casillero esta anulado");
		}
	}
	
	
	public Ficha buscarFicha(Lista<RelacionDatoCasillero<Ficha>> posicionesFichas, Long idFicha) throws Exception {	
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

	public void mostrarFichasPosiones(Lista<RelacionDatoCasillero<Ficha>> fichasPosciones) {
		fichasPosciones.iniciarCursor();
		while (fichasPosciones.avanzarCursor()) {
			RelacionDatoCasillero<Ficha> fichaCasillero = fichasPosciones.obtenerCursor();
			System.out.println("- Ficha: " + fichaCasillero.getDato() + " Ubicación: " + fichaCasillero.getCasillero());
		}
	}
	
	public void mostrarFichasPosiones(Lista<RelacionDatoCasillero<Ficha>> fichasPosciones, Jugador jugadorActual) {
		fichasPosciones.iniciarCursor();
		while (fichasPosciones.avanzarCursor()) {
			RelacionDatoCasillero<Ficha> fichaCasillero = fichasPosciones.obtenerCursor();
			if (jugadorActual.getSimbolo() == fichaCasillero.getDato().getSimbolo()) {				
				System.out.println("- Ficha: " + fichaCasillero.getDato() + " Ubicación: " + fichaCasillero.getCasillero());
			}
		}
	}
	
	
//GETTERS SIMPLES ----------------------------------------------------------------------------------

	public Tablero<Ficha> getTablero() {
		return tablero;
	}
	
	public Jugador[] getJugadores() {
		return jugadores;
	}

	public Turno[] getTurnos() {
		return turnos;
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------

}
