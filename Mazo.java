package tp2;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
	
	

	private Nodo<Carta> frente = null;

	private Nodo<Carta> ultimo = null;

	private int tamanio = 0;
	
	private int totalCartas;
	
	
	


	public Mazo(int cantidadJugadores) {
			this.frente = null;
			this.ultimo = null;
			this.tamanio = 0;
			this.totalCartas = calcularCantidadDeCartas(cantidadJugadores);


		}
		
		

	public boolean estaVacia() {
		return (this.tamanio == 0);
	}
	
	
	
	

	
	public int calcularCantidadDeCartas(int cantidadJugadores) {
	
		int promedioCartasPorTurno =3;
		int rondasMinimas = 5;
		
		this. totalCartas = (cantidadJugadores*promedioCartasPorTurno*rondasMinimas);
		return this.totalCartas;
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
		
	
		int restanteCartas=totalCartas%7;
		 Random rand = new Random();
		    for (int i = 0; i < restanteCartas; i++) {
		        int tipoAleatorio = rand.nextInt(5);
		        switch (tipoAleatorio) {
		            case 0 -> agregarCarta(new CartaPerderTurno());
		            case 1 -> agregarCarta(new CartaBloquearFicha());
		            case 2 -> agregarCarta(new CartaAnularCasillero());
		            case 3 -> agregarCarta(new CartaRetrocederJugada());
		            case 4 -> agregarCarta(new CartaCambiarColor());
		        }
		    }
		
	}
	
	
	public void agregarCartasJugadasAlMazo(Mazo mesa) {
        if (!mesa.estaVacia()) {
            while (!mesa.estaVacia()) {
                this.agregarCarta(mesa.sacarCarta());
            }
            mezclarMazo();
        }
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
	
	
	
	public void agregarCarta(Carta carta) {
		Nodo<Carta> nuevo = new Nodo<Carta>(carta);
		if (!this.estaVacia()) {
			this.ultimo.setSiguiente(nuevo);
			this.ultimo = nuevo;
		} else {
			this.frente = nuevo;
			this.ultimo = nuevo;
		}
		this.tamanio++;
	}
	
	
	




	public Carta sacarCarta() {
		Carta elemento = null;
		if (!this.estaVacia()) {
			elemento = this.frente.getDato();
			this.frente = this.frente.getSiguiente();
			this.tamanio--;
			if (estaVacia()) {
				this.ultimo = null;
			}
		}
		return elemento;
	}
	
	public void devolverCarta(Carta carta) {
		 Nodo<Carta> nuevo = new Nodo<Carta>(carta);
		    if (estaVacia()) {
		        frente = nuevo;
		        ultimo = nuevo;
		    } else {
		        ultimo.setSiguiente(nuevo);
		        ultimo = nuevo;
		    }
		    tamanio++;
	}
	
	

	public int contarCartas() {

		return this.tamanio;
	}

}
