package juego;

import juego.cartas.Carta;
import juego.tablero.Ficha;
import juego.tablero.RelacionDatoCasillero;
import juego.tablero.estructuras.Lista;
import juego.tablero.estructuras.Pila;

public class Jugador {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------

	private Lista<Carta> manoDeCartas = null;
	private Pila<Ficha> fichas = null;
	private RelacionDatoCasillero<Ficha> ultimaPosicionMovida = null;
	private RelacionSimboloColor id = null;
	private int inhabilitacionesMano = 0;
	private int maxCartasMano;
	
	
	
//CONSTRUCTORES ------------------------------------------------------------------------------------

	/**
	 * pre:
	 * @param idJugador
	 * @param maxCartasMano
	 * @param fichasPorJugador
	 * post: crea un jugador con una mano de cartas, una pila de fichas y le asigna su simbolo-color
	 * @throws Exception
	 */
	public Jugador(RelacionSimboloColor idJugador, int maxCartasMano, int fichasPorJugador) throws Exception {
		this.maxCartasMano=maxCartasMano;
		this.id = idJugador;
		this.manoDeCartas = new Lista<Carta>();
		this.fichas = new Pila<Ficha>();
		
		for (int i = 0; i < fichasPorJugador; i++) {	
			Ficha nuevaFicha = new Ficha(id.getSimbolo(), id.getColor());
			this.fichas.apilar(nuevaFicha);
		}			
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------

	@Override
	public String toString() {
		return "Jugador " + id.getSimbolo() + " (" + id.getColor() + ")";
	}
	
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------

	/**
	 * 
	 * @param carta
	 * post: agarra un carta y la suma a su mano
	 * @throws Exception
	 */
	public void agarrarCarta(Carta carta) throws Exception {
		if (this.getCantidadCartas() >= maxCartasMano ) {
			return;
		}
		this.manoDeCartas.agregar(carta);
	}
	
	/**
	 * 
	 * @param carta
	 * post: usa una carta de su mano
	 * @throws Exception
	 */
	public void jugarCarta(Carta carta) throws Exception {
		this.manoDeCartas.remover(carta);
	}
		
	/**
	 * pre:
	 * @param ficha
	 * post: le agrega una ficha a su pila de fichas
	 */
	public void devolverFicha(Ficha ficha) {
		this.fichas.apilar(ficha);
	}
	
	/**
	 * 
	 * @return usa una ficha y la devuelve
	 */
	public Ficha jugarFicha() {
		return this.fichas.desapilar();
	}
	
	/**
	 * 
	 * @return devuelve si ya jugo todas las fichas de su pila de fichas
	 */
	public boolean tieneTodasLasFichasEnElTablero() {
		if(this.fichas.estaVacia()) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return devuelve un string mostrando todas las cartas que tiene disponible en su mano
	 */
	public String cartasEnMano() {
		String resultado ="Cartas en mano: \n";
		
		manoDeCartas.iniciarCursor();
		while (manoDeCartas.avanzarCursor()) {
			Carta carta = manoDeCartas.obtenerCursor();
			if (carta != null) {
				resultado += ("- " + carta.toString() + "\n");
			}
		}
		return resultado;
	}
	
	/**
	 * post: le suma el contador de inhabilitaciones de su mano
	 */
	public void inhabilitarMano() {
	    this.inhabilitacionesMano++;
	}
	
	/**
	 * post: le resta el contador de inhabilitaciones de su mano
	 */
	public void restarInhabilitaciones() {
	    this.inhabilitacionesMano--;
	}
	
	
//GETTERS SIMPLES ----------------------------------------------------------------------------------
	
	/**
	 * 
	 * @return devuelve la mano de cartas
	 */
	public Lista<Carta> getCartas() {
		return manoDeCartas;
	}
	
	/**
	 * 
	 * @return devuelve la pila de fichas
	 */
	public Pila<Ficha> getFichas() {
		return fichas;
	}

	public int getInhabilitacionesMano() {
		return inhabilitacionesMano;
	}

	public RelacionDatoCasillero<Ficha> getUltimaPosicionMovida() {
		return ultimaPosicionMovida;
	}
	
	/**
	 * 
	 * @return devuelve la cantidad de cartas que tiene
	 */
	public int getCantidadCartas() {
		return this.manoDeCartas.getLongitud();
	}

	/**
	 * 
	 * @return devuelve su simbolo-color
	 */
	public RelacionSimboloColor getId() {
		return id;
	}


//SETTERS SIMPLES ----------------------------------------------------------------------------------

	/**
	 * 
	 * @param ultimaPosicionMovida
	 * post: devuelve la ultima posicion movida
	 */
	public void setUltimaPosicionMovida(RelacionDatoCasillero<Ficha> ultimaPosicionMovida) {
		this.ultimaPosicionMovida = ultimaPosicionMovida;
	}
	
}
