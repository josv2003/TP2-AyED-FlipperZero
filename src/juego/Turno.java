package juego;

public class Turno {

//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------

	private Jugador jugador = null;
	private boolean duplicado = false;
	private int bloqueoRestantes = 0;
	private int[] coordenadasCambioColor = null;
	
//CONSTRUCTORES ------------------------------------------------------------------------------------
	
	/**
	 * 
	 * @param jugador
	 * post: crea un turno a partir de un jugador
	 */
	public Turno(Jugador jugador) {
		this.jugador = jugador;
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------

	/**
	 * 
	 * @return devuelve si el turno esta bloqueado
	 */
	public boolean estaBloqueado() {
		return this.bloqueoRestantes > 0;
	}
	
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------

	/**
	 * 
	 * @param cantidadDeBloqueos
	 * post: incrementa la cantidad de bloqueos que tiene el turno
	 */
	public void incrementarBloqueosRestantes(int cantidadDeBloqueos) {
		this.bloqueoRestantes += cantidadDeBloqueos;
	}

	/**
	 * pre:-
	 * post: resta la cantidad de bloqueos del turno y restaura el duplicado 
	 */
	public void terminarTurno() {
		if (this.bloqueoRestantes > 0) {
			this.bloqueoRestantes--;
		}
		if (this.duplicado=true) {
			this.duplicado=false;
		}
		
	}

//GETTERS SIMPLES ----------------------------------------------------------------------------------
	
	/**
	 * 
	 * @return devuelve el jugador
	 */
	public Jugador getJugador() {
		return jugador;
	}
	
	/**
	 * 
	 * @return devuelve si está duplicado 
	 */
	public boolean isDuplicado() {
		return duplicado;
	}

	public int[] getCoordenadasCambioColor() {
		return coordenadasCambioColor;
	}

//SETTERS SIMPLES ----------------------------------------------------------------------------------
	
	/**
	 * 
	 * @param duplicado
	 * post: cambia el estado de duplicado
	 */
	public void setDuplicado(boolean duplicado) {
		this.duplicado = duplicado;
	}


	public void setCoordenadasCambioColor(int[] coordenadasCambioColor) {
		this.coordenadasCambioColor = coordenadasCambioColor;
	}
	
	
	
}