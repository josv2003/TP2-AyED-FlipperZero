package juego.tablero.estructuras;

public class Nodo<T> {
	//ATRIBUTOS DE CLASE --------------------------------------------------------------------------------------
	//ATRIBUTOS -----------------------------------------------------------------------------------------------

	private T dato;
	private Nodo<T> siguiente = null;

	//CONSTRUCTORES -------------------------------------------------------------------------------------------

	/**
	 * pre: -
	 * pos: el Nodo resulta inicializado con el dato dado
     *       y sin un Nodo siguiente.
	 */
	public Nodo(T dato) {
		this.dato = dato;
		this.siguiente = null;
	}

	//METODOS DE CLASE ----------------------------------------------------------------------------------------
	//METODOS GENERALES ---------------------------------------------------------------------------------------
	//METODOS DE COMPORTAMIENTO -------------------------------------------------------------------------------
	//GETTERS SIMPLES -----------------------------------------------------------------------------------------

	/**
	 * pre:
	 * pos: devuelve el dato del nodo
	 */
	public T getDato() {
		return this.dato;
	}

	/**
	 * pre:
	 * pos: cambia el dato del nodo
	 */
	public Nodo<T> getSiguiente() {
		return this.siguiente;
	}

	//SETTERS SIMPLES -----------------------------------------------------------------------------------------	

	/**
	 * pre:
	 * pos: devuelve el siguiente nodo
	 */
	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * pre:
	 * pos: cambia el nodo siguiente
	 */
	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}
}
