package juego;

import juego.cartas.Carta;
import juego.tablero.Ficha;
import juego.tablero.estructuras.Lista;
import juego.tablero.estructuras.Pila;

public class Jugador {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
	private static int CANTIDAD_MAX_FICHAS = 5;
//ATRIBUTOS ----------------------------------------------------------------------------------------

	private Lista<Carta> cartas = null;
	private Pila<Ficha> fichas = null;
	private char simbolo;
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public Jugador(char simbolo) throws Exception {
		this.simbolo = simbolo;
		this.cartas = new Lista<Carta>();
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
		this.cartas.agregar(carta);
	}
	
	public void jugarCarta(Carta carta) throws Exception {
		this.cartas.remover(carta);
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

	
//GETTERS SIMPLES ----------------------------------------------------------------------------------
	
	public Lista<Carta> getCartas() {
		return cartas;
	}
	
	public Pila<Ficha> getFichas() {
		return fichas;
	}
	
	public char getSimbolo() {
		return simbolo;
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------
}
