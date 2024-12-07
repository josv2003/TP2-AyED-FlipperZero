package juego;

import juego.imagenes.Color;

public class RelacionSimboloColor {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------
	
	private char simbolo;
	private Color color;
	
//CONSTRUCTORES ------------------------------------------------------------------------------------
	
	/**
	 * 
	 * @param simbolo
	 * @param color
	 * post: se crea una relacion entre un simbolo y un color
	 */
	public RelacionSimboloColor(char simbolo, Color color) {
		this.simbolo = simbolo;
		this.color = color;
	}

//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
//GETTERS SIMPLES ----------------------------------------------------------------------------------
	
	/**
	 * 
	 * @return devuelve el color del simbolo
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * 
	 * @return devuelve el simbolo del color
	 */
	public char getSimbolo() {
		return simbolo;
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------

	/**
	 * 
	 * @param simbolo
	 * post: asigna el simbolo
	 */
	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}
	
	/**
	 * 
	 * @param color
	 * post: asigna el color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
}
