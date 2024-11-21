package juego;

import juego.cartas.Carta;
import juego.tablero.Ficha;
import juego.tablero.estructuras.Lista;
import juego.tablero.estructuras.Pila;

public class Jugador {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
	private static int CANTIDAD_MAX_FICHAS = 5;
//ATRIBUTOS ----------------------------------------------------------------------------------------

	private Lista<Carta> manoDeCartas = null;
	private Pila<Ficha> fichas = null;
	private char simbolo;
	private int inhabilitacionesMano = 0;
	
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public Jugador(char simbolo) throws Exception {
		this.simbolo = simbolo;
		this.manoDeCartas = new Lista<Carta>();
		this.fichas = new Pila<Ficha>();
		
		for (int i = 0; i < CANTIDAD_MAX_FICHAS; i++) {	
			Ficha nuevaFicha = new Ficha(this.simbolo);
			this.fichas.apilar(nuevaFicha);
		}			
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------

	public void agarrarCarta(Carta carta) throws Exception {
		this.manoDeCartas.agregar(carta);
	}
	
	public void jugarCarta(Carta carta) throws Exception {
		this.manoDeCartas.remover(carta);
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
        String resultado = "Jugador " + this.simbolo + "\nCartas en mano: \n";
        
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
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------
}
