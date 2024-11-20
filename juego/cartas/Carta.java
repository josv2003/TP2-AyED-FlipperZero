package juego.cartas;

import java.util.Objects;

import juego.jugadas.Jugada;


public abstract class Carta {

//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
	
	private static Long IdActual = 1L;
//ATRIBUTOS ----------------------------------------------------------------------------------------
	
	private	Long id = null;
	private String titulo = null;
	
//CONSTRUCTORES ------------------------------------------------------------------------------------
	
	protected Carta() {
		this.titulo = getTituloPorDefecto();
		this.id = Carta.getIdActual();
	}
	
	protected Carta(String titulo) {
		this.titulo = titulo;
	}


//METODOS DE CLASE ---------------------------------------------------------------------------------

	private static Long getIdActual() {
		return Carta.IdActual++;
	}
	
//METODOS GENERALES --------------------------------------------------------------------------------
	
	@Override
	public String toString() {
		return this.getTitulo() + " (" + this.id + ")";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return Objects.equals(id, other.id);
	}
	
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------

	protected abstract String getTituloPorDefecto();
	
	public abstract Jugada getJugada();
	
//GETTERS SIMPLES ----------------------------------------------------------------------------------



	public String getTitulo() {
		return titulo;
	}
	
	public Long getId() {
		return this.id;
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------
}
