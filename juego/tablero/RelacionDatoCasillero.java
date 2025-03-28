package juego.tablero;
public class RelacionDatoCasillero<T> {  
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------

	private T dato = null;
	private Casillero<T> casillero = null;
	
//CONSTRUCTORES ------------------------------------------------------------------------------------
	
	public RelacionDatoCasillero() {}
	
	/**
	 * pre: 
	 * @param casillero
	 * @param dato
	 * post: crea un el contenedor de un casillero y un dato
	 */
	public RelacionDatoCasillero(Casillero<T> casillero, T dato) {
		this.casillero = casillero;
		this.dato = dato;
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
//GETTERS SIMPLES ----------------------------------------------------------------------------------

	/**
	 * 
	 * @return devuelve el dato
	 */
	public T getDato() {
		return dato;
	}
	
	/**
	 * 
	 * @return devuelve el casillero
	 */
	public Casillero<T> getCasillero() {
		return casillero;
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------

	/**
	 * pre:
	 * @param dato
	 * post: cambia el dato
	 */
	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * pre:
	 * @param casillero
	 * post: cambia el casillero
	 */
	public void setCasillero(Casillero<T> casillero) {
		this.casillero = casillero;
	}

}