package juego;

import juego.imagenes.Color;

public class RelacionSimboloColor {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------
	private char simbolo;
	private Color color;
	
//CONSTRUCTORES ------------------------------------------------------------------------------------
	
	public RelacionSimboloColor(char simbolo, Color color) {
		this.simbolo = simbolo;
		this.color = color;
	}

//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
//GETTERS SIMPLES ----------------------------------------------------------------------------------
	
	public Color getColor() {
		return color;
	}
	
	public char getSimbolo() {
		return simbolo;
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------

	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
}
