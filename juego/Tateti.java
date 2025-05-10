package juego;
import java.awt.image.BufferedImage;
import java.util.Random;

import juego.cartas.Carta;
import juego.imagenes.Bitmap;
import juego.imagenes.Color;
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

	/**
	 * pre:
	 * @param cantidadJugadores: tiene que ser mayor a 0
	 * @param ancho: tiene que ser mayor a 0
	 * @param alto: tiene que ser mayor a 0
	 * @param profundo: tiene que ser mayor a 0
	 * @param maxCartasMano: tiene que ser mayor a 0
	 * @param fichasPorJugador: tiene que ser mayor a 0
	 * post: Crea todo el juego Tateti con los parametros dados
	 * @throws Exception
	 */
	public Tateti(int cantidadJugadores, int ancho, int alto, int profundo, int maxCartasMano, int fichasPorJugador) throws Exception {
		if (cantidadJugadores <= 0) {
			throw new Exception("Cantidad de jugadores inferior a la mínima");
		}
		this.tablero = new Tablero<Ficha>(ancho, alto, profundo);
		this.mazoDeCartas = new Mazo(cantidadJugadores);
		this.cartasMesa = new Mazo(this.mazoDeCartas.contarCartas());
		this.maxCartasMano = maxCartasMano;
		this.turnos = new Turno[cantidadJugadores];
		this.jugadores = new Jugador[cantidadJugadores];
		for (int i = 0; i < cantidadJugadores; i++) {
			int simbolo = i + 79;
			int r = (i * 30) % 256;
			int g = (i * 160) % 256;
			int b = (i * 100) % 256;
			Color color = new Color(r, g, b);
			RelacionSimboloColor idjugador = new RelacionSimboloColor((char)simbolo, color);
			Jugador nuevoJugador = new Jugador(idjugador, maxCartasMano, fichasPorJugador);
			Turno turnoJugador = new Turno(nuevoJugador);
			this.turnos[i] = turnoJugador;
			this.jugadores[i] = nuevoJugador;
		}
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------

	/**
	 * pre: pregunta por consola las coordenadas del casillero a seleccionar
	 * @return devuelve el casillero seleccionado
	 * @throws Exception
	 */
	public Casillero<Ficha> seleccionarCasillero() throws Exception {
		System.out.println("Ingrese coordenadas para seleccionar casillero:");
		int x = Escaner.preguntarEnteroConRango("X:",1,this.tablero.getAlto());
		int y = Escaner.preguntarEnteroConRango("y:",1,this.tablero.getAlto());
		int z = Escaner.preguntarEnteroConRango("Z:",1,this.tablero.getAlto());
				
				
		Casillero<Ficha> casilleroSeleccionado = this.tablero.getCasillero(x, y, z);
		return casilleroSeleccionado;
	}
	
	
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
	
	/**
	 * pre:
	 * @param jugador
	 * post: si el jugador no tiene fichas para jugar termina el juego
	 */
	public void todasLasFichasRobadas(Jugador jugador) {
		if(jugador.getFichas()==null) {
			estadoDelJuego = false;
		}
	}
	
	/**
	 * pre: 
	 * @param casillero
	 * post: cambia el estado del juego para que termine si a partir del casillero tiene cierta
	 * 		 cantidad de fichas seguidas
	 * @throws Exception
	 */
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
	
	/**
	 * pre:
	 * @param casillero
	 * @param direccion
	 * @param ficha
	 * @return devuelve la cantidad de fichas seguidas tiene el casillero en la direccion indicada
	 * @throws Exception
	 */
	public int contarFichasSeguidas(Casillero<Ficha> casillero, Direccion direccion, Ficha ficha) throws Exception {
		if (casillero == null || casillero.getDato() == null) {
			return 0;
		}
		if (!casillero.getDato().esElMismoSimbolo(ficha)) {
			return 0;
		}
		return 1 + contarFichasSeguidas(casillero.getCasilleroVecino(direccion), direccion, ficha);
	}
	
	/**
	 * pre:
	 * @return devuelve un numero random entre 1-6
	 */
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
			if (turnoActual.estaBloqueado()) {
				System.out.println(jugadorActual.toString() + " perdiste este turno.");
		        turnoActual.terminarTurno();
			} else {
				System.out.println("Turno de: " + jugadorActual.toString());

				//Levantar la carta	
				if(this.maxCartasMano!=0) {
					System.out.println("Tirando dado...");
					int cantidadCartas = dado();
					System.out.println("Te tocó el numero: " + cantidadCartas);
					System.out.println(jugadorActual.toString() + " agarra " + cantidadCartas + " cartas.");
					if (this.mazoDeCartas.contarCartas()<=cantidadCartas) {
		            	System.out.println("Mazo vacio, se mezclaran las cartas de la mesa");
		            	mazoDeCartas.agregarCartasJugadasAlMazo(cartasMesa);
		            	mazoDeCartas.mezclarMazo();
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
					} else {
						System.out.println("No podes usar tus cartas por este turno");
						jugadorActual.restarInhabilitaciones();
					}
					verificarGanador(casilleroDestino);
					
				}
				//crea la imagen del turno
				exportarEstadoTablero("estado_turno_jugador" + (indiceTurno+1) + ".bmp");					
				
			}
			if (!turnoActual.isDuplicado()) {
				indiceTurno = (indiceTurno+=1) % this.jugadores.length;
			}
		}
		System.out.println("Juego terminado\nGanó el jugador: " + this.turnos[(indiceTurno % turnos.length) - 1].getJugador().getId().getSimbolo());
	}
	
	/**
	 * pre: pide ingresar coordenadas por consola
	 * @param jugador
	 * post: colaca una ficha del jugador en el casillero de las coordenadas ingresadas por consola 
	 * @throws Exception 
	 */
	public Casillero<Ficha> jugadaInicial(Jugador jugador) throws Exception {
		Ficha ficha = jugador.jugarFicha();
		Casillero<Ficha> casillero = seleccionarCasillero();
		
		while (verificarCasillero(casillero)) {
			if(casillero.estaAnulado()) {
				System.out.println("Tu casillero fue anulado, elegí otro.");
			}else {
				System.out.println("Tu casillero fue ocupado, elegí otro.");
				
			}
			casillero = seleccionarCasillero();
		}
		casillero.setDato(ficha);
		RelacionDatoCasillero<Ficha> fichaCasillero = new RelacionDatoCasillero<Ficha>(casillero, ficha);
		jugador.setUltimaPosicionMovida(fichaCasillero);
		this.tablero.getPosicionDeLasDatos().agregar(fichaCasillero);
		
		return casillero;
	}
	
	/**
	 * pre:
	 * @param casillero
	 * @return devuelve true si no se puede usar el casillero 
	 */
	public boolean verificarCasillero(Casillero<Ficha> casillero){
		return casillero.estaOcupado() || casillero.estaAnulado();
		
	}
	
	/**
	 * pre:
	 * @param jugador: indica el jugador que va a mover 
	 * @throws Exception: si no se puede mover, da error
	 * post: mueve la ficha de una posicion a otra, quedando el casillero vacio en el origen y la ficha en el 
	 * 		 casillero destino 
	 */
	public Casillero<Ficha> mover(Jugador jugador) throws Exception {
		System.out.println("Seleccione la ficha a mover (mediante su ID):");
		mostrarFichasPosionesPorJugador(this.tablero.getPosicionDeLasDatos(), jugador);
		Ficha ficha = null;
		
		do {
	        try {
	            Long idFicha = Escaner.preguntarLong("Ingresá una ficha no bloqueada (ID): ");
	            Lista<RelacionDatoCasillero<Ficha>> posicionesFichas = this.tablero.getPosicionDeLasDatos();
	            ficha = buscarFicha(posicionesFichas, idFicha, jugador);

	            if (ficha.isBloqueado()) {
	                System.out.println("La ficha seleccionada está bloqueada.");
	                ficha = null; 
	            }
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage() + ". Intentá nuevamente.");
	        }
	    } while (ficha == null);
	
		Casillero<Ficha> posicionActualFicha = this.tablero.getCasillero(ficha); 
		RelacionDatoCasillero<Ficha> ultimoMovimiento = new RelacionDatoCasillero<Ficha>(posicionActualFicha, ficha);
		jugador.setUltimaPosicionMovida(ultimoMovimiento);
		
		Casillero<Ficha> casilleroVecino = null;
		Casillero<Ficha> casillero = this.tablero.getCasillero(ficha);
		
		while (casilleroVecino == null) {
		    try {
		        Movimiento movimiento = Escaner.preguntarMovimiento();
		        System.out.println("Intentando mover ficha al: " + movimiento);

		        if (!casillero.existeElVecino(movimiento)) {
		            System.out.println("El movimiento está fuera de rango. El casillero vecino no existe.");
		            continue; 
		        }

		        Casillero<Ficha> vecino = casillero.getCasilleroVecino(movimiento);
		        if (vecino == null) {
		            throw new Exception("Error inesperado: casillero vecino es null.");
		        }

		        verificarMovimiento(casillero, movimiento);
		        casilleroVecino = vecino;
		    } catch (Exception e) {
		        System.out.println("Error: " + e.getMessage() + " Volvé a intentarlo.");
		    }
		}
		
		this.tablero.mover(casillero, casilleroVecino, ficha);
		return casilleroVecino;
	}
	
	/**
	 * pre:
	 * @param casillero
	 * @param movimiento
	 * @throws Exception: da error si a partir del casillero no se puede mover para ninguna dirección
	 */
	public void verificarMovimiento(Casillero<Ficha> casillero, Movimiento movimiento) throws Exception{
		if (!casillero.existeElVecino(movimiento)) {
			throw new Exception("El movimiento está fuera de rango");
		}
		if (casillero.getCasilleroVecino(movimiento).estaOcupado()) {
			throw new Exception("El casillero está ocupado");
		}
		if (casillero.getCasilleroVecino(movimiento).estaAnulado()) {
			throw new Exception("El casillero está anulado");
		}
	}
	
	/**
	 * pre:
	 * @param posicionesFichas
	 * @param idFicha
	 * @return devuelve la ficha buscada en el tablero a travez de su id
	 * @throws Exception
	 */
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
	
	/**
	 * 
	 * @param posicionesFichas
	 * @param idFicha
	 * @param jugadorActual
	 * @return devuelve la ficha buscada en el tablero usando su id y el jugador
	 * @throws Exception
	 */
	public Ficha buscarFicha(Lista<RelacionDatoCasillero<Ficha>> posicionesFichas, Long idFicha, Jugador jugadorActual) throws Exception {	
		posicionesFichas.iniciarCursor();
		while (posicionesFichas.avanzarCursor()) {
			Ficha fichaActual = posicionesFichas.obtenerCursor().getDato();
			Long idActual = fichaActual.getId();
			
			if (jugadorActual.getId().getSimbolo() == fichaActual.getSimbolo()&&(idActual.equals(idFicha))) {	
				return fichaActual;
			}
		}
		throw new Exception("No existe la ficha");
	}

	/**
	 * pre:
	 * @param fichasPosciones
	 * post: muestra por consola las fichas disponible y su ubicación
	 */
	public void mostrarFichasPosiones(Lista<RelacionDatoCasillero<Ficha>> fichasPosciones) {
		fichasPosciones.iniciarCursor();
		while (fichasPosciones.avanzarCursor()) {
			RelacionDatoCasillero<Ficha> fichaCasillero = fichasPosciones.obtenerCursor();
			System.out.println("- Ficha: " + fichaCasillero.getDato() + " Ubicación: " + fichaCasillero.getCasillero());
		}
	}
	
	/**
	 * pre:
	 * @param fichasPosciones
	 * @param jugadorActual
	 * post: muestra por consola las fichas disponible y su ubicación por jugador 
	 */
	public void mostrarFichasPosionesPorJugador(Lista<RelacionDatoCasillero<Ficha>> fichasPosciones, Jugador jugadorActual) {
		fichasPosciones.iniciarCursor();
		while (fichasPosciones.avanzarCursor()) {
			RelacionDatoCasillero<Ficha> fichaCasillero = fichasPosciones.obtenerCursor();
			if (jugadorActual.getId().getSimbolo() == fichaCasillero.getDato().getSimbolo()) {				
				System.out.println("- Ficha: " + fichaCasillero.getDato() + " Ubicación: " + fichaCasillero.getCasillero());
			}
		}
	}
	
	/** 
	 * pre:
	 * @param filename
	 * @throws Exception
	 * post: crea el tablero en archivos bmp dividido por capas
	 */
	private void exportarEstadoTablero(String filename) throws Exception {
	    int ancho = tablero.getAncho();
	    int alto = tablero.getAlto();
	    int profundidad = tablero.getProfundidad();
	    
	    for (int z = 1; z <= profundidad; z++) {			
		    Bitmap bmp = new Bitmap(ancho, alto);
		    for (int x = 1; x <= ancho; x++) {
		        for (int y = 1; y <= alto; y++) {
		        	Ficha ficha = tablero.getCasillero(x, y, z).getDato();
		        	if(ficha != null) {
		        		Color color = ficha.getColor();	        		
		        		bmp.pintarCasilleroDeMatriz(x, y, color);;
		        	}
		        }
		    }
		    BufferedImage imagen = bmp.crearImagen();
		    bmp.crearArchivo("capa"+ z + filename, imagen);
	    }
	}
	
	
//GETTERS SIMPLES ----------------------------------------------------------------------------------

	/**
	 * 
	 * @return devuelve el tablero del tateti
	 */
	public Tablero<Ficha> getTablero() {
		return tablero;
	}
	
	/**
	 * 
	 * @return devuelve el vector con todos los jugadores de la partida
	 */
	public Jugador[] getJugadores() {
		return jugadores;
	}

	/**
	 * 
	 * @return devuelve el vector con todos los turnos de la partida
	 */
	public Turno[] getTurnos() {
		return turnos;
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------

}
