package juego;

public class Turno {

//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------

	private Jugador jugador = null;
	private boolean duplicado = false;
	private int bloqueoRestantes = 0;
	
//CONSTRUCTORES ------------------------------------------------------------------------------------
	
	public Turno(Jugador jugador) {
		this.jugador = jugador;
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------

	public boolean estaBloqueado() {
		return this.bloqueoRestantes > 0;
	}
	
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------

	public void incrementarBloqueosRestantes(int cantidadDeBloqueos) {
		this.bloqueoRestantes += cantidadDeBloqueos;
	}


	public void terminarTurno() {
		if (this.bloqueoRestantes > 0) {
			this.bloqueoRestantes--;
		}
		if (this.duplicado=true) {
			this.duplicado=false;
		}
		
	}
	
	public void duplicar() {
		this.duplicado = true;
	}

//GETTERS SIMPLES ----------------------------------------------------------------------------------
	
	public Jugador getJugador() {
		return jugador;
	}
	
	public boolean isDuplicado() {
		return duplicado;
	}

//SETTERS SIMPLES ----------------------------------------------------------------------------------
	
	public void setDuplicado(boolean duplicado) {
		this.duplicado = duplicado;
	}
	
}

//	public void iniciarTurno() {
//		this.cantidadDeSubturnos += 1;
//	}
//	
//	public void agregarSubturno() {
//		this.cantidadDeSubturnos += 1;	
//	}
//	
//	public boolean haySubturnos() {
//		return this.cantidadDeSubturnos > 0;
//	}
//	
//	public void utilizarSubturno() {
//		this.cantidadDeSubturnos--;
//	}
//
//	public int getCantidadDeSubturnos() {
//		return cantidadDeSubturnos;
//	}