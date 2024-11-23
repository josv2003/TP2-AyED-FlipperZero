package juego.imagenes;

public class Color {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------

	private int red = 0;
	private int green = 0;
	private int blue = 0;
	
//CONSTRUCTORES ------------------------------------------------------------------------------------
	
	public Color(int red, int green, int blue) {
		this.red = Math.max(0, Math.min(255, red));
		this.green = Math.max(0, Math.min(255, green));
		this.blue = Math.max(0, Math.min(255, blue));
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
	
	@Override
		public String toString() {
		return String.format("Color: #%02X%02X%02X", red, green, blue);
		}
	
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
//GETTERS SIMPLES ----------------------------------------------------------------------------------

	public int getRed() {
		return red;
	}
	
	public int getGreen() {
		return green;
	}
	
	public int getBlue() {
		return blue;
	}
	
	public int getRGB() {
		return(this.red << 16) | (this.green << 8) | this.blue;
	}
	
//SETTERS SIMPLES ----------------------------------------------------------------------------------


}
