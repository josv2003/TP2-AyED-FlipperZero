package juego.tablero;

import juego.imagenes.Color;

public class Ficha {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------

	private static Long IdActual = 1L;
//ATRIBUTOS ----------------------------------------------------------------------------------------

	private char simbolo;
	private Color color = null;
	private Long id = null;
	private boolean bloqueado = false;
	
//CONSTRUCTORES ------------------------------------------------------------------------------------


	/**
	 * pre:
	 * @param simbolo
	 * @param color
	 * post: crea la ficha y le asigna un color y simbolo
	 * @throws Exception
	 */
	public Ficha(char simbolo, Color color) throws Exception {
		if (color == null) {
			throw new Exception("El color no puede ser vacio");
		}
		this.simbolo = simbolo;
		this.id = Ficha.getIdActual();
		this.color = color;
	}
//METODOS DE CLASE ---------------------------------------------------------------------------------

	/**
	 * 
	 * @return devuelve el nuevo id de la ficha 
	 */
	private static Long getIdActual() {
		return Ficha.IdActual++;
	}
//METODOS GENERALES --------------------------------------------------------------------------------

	@Override
	public String toString() {
		return "" + this.simbolo + " (ID:" + this.id + ")";
	}
	
	/**
	 * 
	 * @param ficha
	 * @return si el simbolo de esta ficha es igual al de la ficha pasada por parametro
	 */
	public boolean esElMismoSimbolo(Ficha ficha) {
		return getSimbolo() == ficha.getSimbolo();
	}
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------

	/**
	 * pre:
	 * post: bloquea la ficha 
	 * @throws Exception
	 */
	public void bloquear() throws Exception{
		if (this.bloqueado) {
	        throw new Exception("Esta ficha ya estaba bloqueada.");
	    }
		this.bloqueado = true;
	}
	
//GETTERS SIMPLES ----------------------------------------------------------------------------------

	/**
	 * 
	 * @return devuelve el simbolo 
	 */
	public char getSimbolo() {
		return simbolo;
	}

	/**
	 * 
	 * @return devuelve el Id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * 
	 * @return devuelve el color
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * 
	 * @return devuelve si esta bloqueado
	 */
	public boolean isBloqueado() {
		return bloqueado;
	}


//SETTERS SIMPLES ----------------------------------------------------------------------------------
	
	/**
	 * 
	 * @param simbolo
	 * post: cambia el simbolo
	 */
	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}

	/**
	 * 
	 * @param color
	 * post: cambia el color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
}