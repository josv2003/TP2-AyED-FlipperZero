package juego;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import juego.cartas.Carta;
import juego.cartas.CartaAnularCasillero;
import juego.cartas.CartaBloquearFicha;
import juego.cartas.CartaCambiarColor;
import juego.cartas.CartaDuplicarTurno;
import juego.cartas.CartaInhabilitarCartas;
import juego.cartas.CartaPerderTurno;
import juego.cartas.CartaRetrocederJugada;
import juego.tablero.estructuras.Cola;

public class Mazo {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------
	private Cola<Carta> mazo;
	private int totalCartas;
	
//CONSTRUCTORES ------------------------------------------------------------------------------------
	
	/**
	 * 
	 * @param cantidadJugadores
	 * post: crea un mazo de cartas de acuerdo a la cantidad de jugadores, llena de cartas y las mezcla
	 * @throws Exception
	 */
	public Mazo(int cantidadJugadores) throws Exception{
		if(cantidadJugadores < 2) {
			throw new Exception ("El minimo de jugadores es 2");
		}
		this.mazo= new Cola<Carta>();
		this.totalCartas=calcularCantidadDeCartas(cantidadJugadores);
		
		asignarTipoYDescripcion();
		mezclarMazo();
	}
	
	/**
	 * post: crea un mazo de cartas vacio
	 */
	public Mazo() {
		this.mazo= new Cola<Carta>();
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
	
	/**
	 * 
	 * @return devuelve la cantidad de cartas del mazo
	 */
	public int contarCartas() {
		return this.mazo.contarElementos();
	}
	
	/**
	 * 
	 * @param carta
	 * post: agrega una carta al mazo
	 */
	public void agregarCarta(Carta carta) {
		this.mazo.acolar(carta);
	}
	
	/**
	 * 
	 * @return quita una carta del mazo y la devuelve
	 */
	public Carta sacarCarta() {
		return this.mazo.desacolar();
	}
	
	/**
	 * 
	 * @return devuelve si esta vacio el mazo o no
	 */
	public boolean estaVacia() {
		return this.mazo.estaVacia();
	}
	
	/**
	 * 
	 * @param cantidadJugadores
	 * @return devuelve la cantidad de cartas que ingresa de acuerdo a la cantidad de jugadores
	 */
	public int calcularCantidadDeCartas(int cantidadJugadores) {
		int promedioCartasPorTurno=3;
		int rondasMinimas=5;
		return  cantidadJugadores * promedioCartasPorTurno * rondasMinimas;
	}
	
	/**
	 * pre: a partir de el mazo de la meza done estan las cartas jugadas
	 * @param mesa
	 * post: agrega las cartas ya jugadas al mazo de nuevo y lo mezcla
	 */
	public void agregarCartasJugadasAlMazo(Mazo mesa) {
		while(!mesa.estaVacia()) {
			this.agregarCarta(mesa.sacarCarta());
		}
		mezclarMazo();
	}
	/**
	 * post: mezcla el mazo de cartas
	 */
	public void mezclarMazo() {
		
		List<Carta> listaCartas = new ArrayList<>();
		while (!estaVacia()) {
			listaCartas.add(sacarCarta());
		}
		Collections.shuffle(listaCartas);
		
		for (Carta carta : listaCartas) {
			agregarCarta(carta);
		}
	}
		
	/**
	 * post: asigna los tipos y la cantidad de cartas a ingresa en el mazo
	 * @throws Exception
	 */
	public void asignarTipoYDescripcion() throws Exception{
		int cartasPorTipo=this.totalCartas/7;
		
		for (int i = 0; i < cartasPorTipo; i++) {
			agregarCarta(new CartaPerderTurno());
		}
		
		
		for (int i = 0; i < cartasPorTipo; i++) {
			agregarCarta(new CartaBloquearFicha());
		}
		
		
		for (int i = 0; i < cartasPorTipo; i++) {
			agregarCarta(new CartaAnularCasillero());
		}
		
		for (int i = 0; i < cartasPorTipo; i++) {
			agregarCarta(new CartaRetrocederJugada());
		}
		
		
		for (int i = 0; i < cartasPorTipo; i++) {
			agregarCarta(new CartaCambiarColor());
		}
		
		for (int i = 0; i < cartasPorTipo; i++) {
			agregarCarta(new CartaDuplicarTurno());
		}
		
		for (int i = 0; i < cartasPorTipo; i++) {
			agregarCarta(new CartaInhabilitarCartas());
		}
		
		
		int restanteCartas=totalCartas%7;
		Random rand = new Random();
		for (int i = 0; i < restanteCartas; i++) {
			int tipoAleatorio = rand.nextInt(7);
			switch (tipoAleatorio) {
			case 0 -> agregarCarta(new CartaPerderTurno());
			case 1 -> agregarCarta(new CartaBloquearFicha());
			case 2 -> agregarCarta(new CartaAnularCasillero());
			case 3 -> agregarCarta(new CartaRetrocederJugada());
			case 4 -> agregarCarta(new CartaCambiarColor());
			case 5 -> agregarCarta(new CartaDuplicarTurno());
			case 6 -> agregarCarta(new CartaInhabilitarCartas());
			}
		}
		
	}
	
//GETTERS SIMPLES ----------------------------------------------------------------------------------

	public int getTotalCartas() {
		return this.totalCartas;
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------
	
	
	
}