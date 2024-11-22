package juego;

import juego.cartas.Carta;
import juego.tablero.Ficha;
import juego.tablero.RelacionDatoCasillero;
import juego.tablero.estructuras.Lista;
import juego.tablero.estructuras.Pila;

public class Jugador {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
	/*private static int CANTIDAD_MAX_FICHAS = 1;
	/*private static int CANTIDAD_MAX_CARTAS = 6;*/
//ATRIBUTOS ----------------------------------------------------------------------------------------

	private Lista<Carta> manoDeCartas = null;
	private Pila<Ficha> fichas = null;
	private RelacionDatoCasillero<Ficha> ultimaPosicionMovida = null;
	private char simbolo;
	private int inhabilitacionesMano = 0;
	private int maxCartasMano;
	
	
	
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public Jugador(char simbolo, int maxCartasMano, int fichasPorJugador) throws Exception {
		this.maxCartasMano=maxCartasMano;
		this.simbolo = simbolo;
		this.manoDeCartas = new Lista<Carta>();
		this.fichas = new Pila<Ficha>();
		
		for (int i = 0; i < fichasPorJugador; i++) {	
			Ficha nuevaFicha = new Ficha(this.simbolo);
			this.fichas.apilar(nuevaFicha);
		}			
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------

	public void agarrarCarta(Carta carta) throws Exception {
		if (this.getCantidadCartas() >= maxCartasMano ) {
			return;
		}
		this.manoDeCartas.agregar(carta);
	}
	

	public void jugarCarta(Carta carta) throws Exception {
		this.manoDeCartas.remover(carta);
	}
		
	
	public void devolverFicha(Ficha ficha) {
		this.fichas.apilar(ficha);
	}
	
	public Ficha jugarFicha() {
		return this.fichas.desapilar();
	}
	
	public boolean tieneTodasLasFichasEnElTablero() {
		if(this.fichas.estaVacia()) {
			return true;
		}
		return false;
	}

	@Override
    public String toString() {
        return "Jugador " + this.simbolo;
    }
	
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
	
	public void inhabilitarMano() {
	    this.inhabilitacionesMano++;
	}
	
//GETTERS SIMPLES ----------------------------------------------------------------------------------
	
	public Lista<Carta> getCartas() {
		return manoDeCartas;
	}
	
	public Pila<Ficha> getFichas() {
		return fichas;
	}
	
	public char getSimbolo() {
		return simbolo;
	}

	public int getInhabilitacionesMano() {
		return inhabilitacionesMano;
	}

	public RelacionDatoCasillero<Ficha> getUltimaPosicionMovida() {
		return ultimaPosicionMovida;
	}
	
	public int getCantidadCartas() {
		return this.manoDeCartas.getLongitud();
	}

//SETTERS SIMPLES ----------------------------------------------------------------------------------

	public void setUltimaPosicionMovida(RelacionDatoCasillero<Ficha> ultimaPosicionMovida) {
		this.ultimaPosicionMovida = ultimaPosicionMovida;
	}
	
}
