package juego;

public class Turno {

//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------

	private Jugador jugador = null;
	private int cantidadDeSubturnos = 1;
	private int bloqueoRestantes = 0;
	
//CONSTRUCTORES ------------------------------------------------------------------------------------
//METODOS DE CLASE ---------------------------------------------------------------------------------
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
	
//GETTERS SIMPLES ----------------------------------------------------------------------------------
	
	public Jugador getJugador() {
		return jugador;
	}

	public boolean estaBloqueado() {
		return this.bloqueoRestantes <= 0;
	}
	
	public int getCantidadDeSubturnos() {
		return cantidadDeSubturnos;
	}

	public void utilizarSubturno() {
		this.cantidadDeSubturnos--;
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------
}
