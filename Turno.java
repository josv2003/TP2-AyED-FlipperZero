package tp2;

import java.util.Random;


public class Turno {
	
	private boolean duplicado;
	private int restantesBloqueados;
	private Jugador jugadorActual;
	private Mazo mazo;
	private Mazo mesa;


	
	
	public Turno(Jugador jugadorActual, Mazo mazo) {
		this.restantesBloqueados=0;
		this.jugadorActual=jugadorActual;
		this.mazo=mazo;
		this.duplicado=false;


	}
	
	public void duplicar() {
		this.duplicado=true;
	}
	

	public int dado() {
		Random rand = new Random();
        return rand.nextInt(6) + 1;
		
	}
	
	public void sumarBloqueo() {
		this.restantesBloqueados++;
	}
	
	public void iniciarTurno() throws Exception{
	
		if(restantesBloqueados==0) {
			System.out.println("Tirando dado...");
			int cantidadCartas=dado();
			System.out.println("Te tocó el numero: "+cantidadCartas);
			for (int i = 0; i < cantidadCartas; i++) {
	            		if (mazo.estaVacia()) {
	            			System.out.println("Mazo vacio, se mezclaran las cartas de la mesa");
	            			mazo.agregarCartasJugadasAlMazo(mesa);
	            	
	            		}
	            		Carta nuevaCarta=mazo.sacarCarta();
	           	 	try {
	            			jugadorActual.agregarCartaALaMAno(nuevaCarta);
	            		} catch(Exception e) {
	            			System.out.println(e.getMessage());
	            		}
	        
			}
			
		} else {
			System.out.println("Tu turno fue bloqueado");
		}
		
		
	}
	
	
	
	public void finalizarTurno() {
		if(restantesBloqueados>0) {
			this.restantesBloqueados--;
		}
		if(duplicado) {
			this.duplicado=false;
		}
	}
	
	public Jugador getJugador() {
		return this.jugadorActual;
	}
	
	
	public int restantesBloqueados() {
		return this.restantesBloqueados;
	}

	

}
