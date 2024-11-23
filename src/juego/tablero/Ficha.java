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


	public Ficha(char simbolo, Color color) throws Exception {
		if (color == null) {
			throw new Exception("El color no puede ser vacio");
		}
		this.simbolo = simbolo;
		this.id = Ficha.getIdActual();
		this.color = color;
	}
//METODOS DE CLASE ---------------------------------------------------------------------------------

	private static Long getIdActual() {
		return Ficha.IdActual++;
	}
//METODOS GENERALES --------------------------------------------------------------------------------

	@Override
	public String toString() {
		return "" + this.simbolo + " (ID:" + this.id + ")";
	}
	
	public boolean esElMismoSimbolo(Ficha ficha) {
		return getSimbolo() == ficha.getSimbolo();
	}
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------

	public void bloquear() throws Exception{
		if (this.bloqueado) {
	        throw new Exception("Esta ficha ya estaba bloqueada.");
	    }
		this.bloqueado = true;
	}
	
//GETTERS SIMPLES ----------------------------------------------------------------------------------

	public char getSimbolo() {
		return simbolo;
	}

	public Long getId() {
		return id;
	}
	
	public Color getColor() {
		return color;
	}
	
	public boolean isBloqueado() {
		return bloqueado;
	}


//SETTERS SIMPLES ----------------------------------------------------------------------------------
	
	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}