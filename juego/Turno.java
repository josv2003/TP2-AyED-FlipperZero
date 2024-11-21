package juego;

public class Turno {

//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------

	private Jugador jugador = null;
	private int cantidadDeSubturnos = 1;
	private int bloqueoRestantes = 0;
	
//CONSTRUCTORES ------------------------------------------------------------------------------------
	
	public Turno(Jugador jugador) {
		this.jugador = jugador;
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------

	public boolean estaBloqueado() {
		return this.bloqueoRestantes <= 0;
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
	}
	
	public void iniciarTurno() {
		this.cantidadDeSubturnos += 1;
	}
	
	public void agregarSubturno() {
		this.cantidadDeSubturnos += 1;	
	}
	
	public boolean haySubturnos() {
		return this.cantidadDeSubturnos >= 0;
	}
	
	public void utilizarSubturno() {
		this.cantidadDeSubturnos--;
	}

//GETTERS SIMPLES ----------------------------------------------------------------------------------
	
	public Jugador getJugador() {
		return jugador;
	}

	public int getCantidadDeSubturnos() {
		return cantidadDeSubturnos;
	}

	
//SETTERS SIMPLES ----------------------------------------------------------------------------------
}
