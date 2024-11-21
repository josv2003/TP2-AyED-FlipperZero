package juego.tablero;


public class Ficha {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------

	private static Long IdActual = 1L;
//ATRIBUTOS ----------------------------------------------------------------------------------------

	private char simbolo;
	private Long id = null;
	
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public Ficha(char simbolo) {
		//validar
		this.simbolo = simbolo;
		this.id = Ficha.getIdActual();
	}
//METODOS DE CLASE ---------------------------------------------------------------------------------

	private static Long getIdActual() {
		return Ficha.IdActual++;
	}
//METODOS GENERALES --------------------------------------------------------------------------------

	@Override
	public String toString() {
		return "" + this.simbolo;
	}
	
	public boolean esElMismoSimbolo(Ficha ficha) {
	return getSimbolo() == ficha.getSimbolo();
	}
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
//GETTERS SIMPLES ----------------------------------------------------------------------------------

	public char getSimbolo() {
		return simbolo;
	}

	public Long getId() {
		return id;
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------

}