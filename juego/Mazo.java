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
	
	private Cola<Carta> mazo;
	private int totalCartas;
	
	
	public Mazo(int cantidadJugadores) throws Exception{
		if(cantidadJugadores < 2) {
			throw new Exception ("El minimo de jugadores es 2");
		}
		this.mazo= new Cola<Carta>();
		this.totalCartas=calcularCantidadDeCartas(cantidadJugadores);
		
		asignarTipoYDescripcion();
		mezclarMazo();
	}
	
	public Mazo() {
		this.mazo= new Cola<Carta>();
	}
	
	public int contarCartas() {
		return this.mazo.contarElementos();
	}
	
	public void agregarCarta(Carta carta) {
		this.mazo.acolar(carta);
	}
	
	
	public Carta sacarCarta() {
		return this.mazo.desacolar();
	}
	
	public boolean estaVacia() {
		return this.mazo.estaVacia();
	}
	
	public int calcularCantidadDeCartas(int cantidadJugadores) {
		int promedioCartasPorTurno=3;
		int rondasMinimas=5;
		return  cantidadJugadores * promedioCartasPorTurno * rondasMinimas;
	}
	
	
	public int getTotalCartas() {
		return this.totalCartas;
	}
	public void agregarCartasJugadasAlMazo(Mazo mesa) {
		while(!mesa.estaVacia()) {
			this.agregarCarta(mesa.sacarCarta());
		}
		mezclarMazo();
	}
	
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
	
	
	
	
}