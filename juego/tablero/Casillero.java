package juego.tablero;

public class Casillero<T> {
//ATRIBUTOS DE CLASE --------------------------------------------------------------------------------------
	public static int CANTIDAD_DE_VECINOS = 3;
	
//ATRIBUTOS -----------------------------------------------------------------------------------------------
	
	private int x = 0;
	private int y = 0;
	private int z = 0;
	private T dato = null;
	private Casillero<T>[][][] vecinos;
	
//CONSTRUCTORES -------------------------------------------------------------------------------------------
	
	/**
	 * pre:
	 * @param x: 1 o mayor
	 * @param y: 1 o mayor
	 * @param z: 1 o mayor
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Casillero(int x, int y, int z) throws Exception {
		if (x < 1) {
			throw new Exception("X debe ser mayor a 0");
		}
		if (y < 1) {
			throw new Exception("Y debe ser mayor a 0");
		}
		if (z < 1) {
			throw new Exception("Z debe ser mayor a 0");
		}
		this.x = x;
		this.y = y;
		this.z = z;
		this.vecinos = new Casillero[CANTIDAD_DE_VECINOS][CANTIDAD_DE_VECINOS][CANTIDAD_DE_VECINOS];
		for(int i = 0; i < this.vecinos.length; i++) {
			for(int j= 0; j < this.vecinos.length; j++) {
				for (int k = 0; k < this.vecinos.length; k++) {
					this.vecinos[i][j][k] = null;					
				}
			}
		}
		this.vecinos[1][1][1] = this; //definirlo
	}
	
//METODOS DE CLASE ----------------------------------------------------------------------------------------
	
	public static int invertirCoordenadaDeVecino(int i) {
		return i * -1;
	}
	
//METODOS GENERALES ---------------------------------------------------------------------------------------
	
	@Override
	public String toString() {	
		return "Casillero (" + this.x + ", " + this.y + ", " + this.z + ")";
	}
	
//METODOS DE COMPORTAMIENTO -------------------------------------------------------------------------------
	
	public boolean estaOcupado() {
		return this.dato != null;
	}
	
	/**
	 * pre:
	 * @param dato: no puede ser vacio
	 * @return: devuelve verdadero si el dato es el mismo
	 * @throws Exception 
	 */
	public boolean tiene(T dato) throws Exception {
		if (dato == null) {
			throw new Exception("El dato no puede ser vacio");
		}
		return this.dato.equals(dato);
	}

	/**
	 * pre:
	 * @param direccion: una direccion en 3d, no puede ser nulo
	 * @return devuelve verdadero si existe el casillero vecino en esa direccion o falso si no existe
	 * 		   (por ejemplo en el borde)
	 */
	public boolean existeElVecino(Direccion direccion) {
		switch (direccion) {
		case ABAJO:
			return this.vecinos[2][1][1] != null;
		case ARRIBA:
			return this.vecinos[0][1][1] != null;
		case DERECHA:
			return this.vecinos[1][2][1] != null;
		case IZQUIERDA:
			return this.vecinos[1][0][1] != null;
		case ATRAS:
			return this.vecinos[1][1][2] != null;			
		case ADELANTE:
			return this.vecinos[1][1][0] != null;	
		case ADELANTE_ABAJO:			
			return this.vecinos[2][1][0] != null;
		case ADELANTE_ARRIBA:			
			return this.vecinos[0][1][0] != null;
		case ADELANTE_DERECHA:			
			return this.vecinos[1][0][0] != null;
		case ADELANTE_IZQUIERDA:			
			return this.vecinos[1][2][0] != null;
		case ADELANTE_DERECHA_ABAJO:			
			return this.vecinos[2][0][0] != null;
		case ADELANTE_DERECHA_ARRIBA:			
			return this.vecinos[0][0][0] != null;
		case ADELANTE_IZQUIERDA_ABAJO:			
			return this.vecinos[2][2][0] != null;
		case ADELANTE_IZQUIERDA_ARRIBA:			
			return this.vecinos[0][2][0] != null;
		case ATRAS_ABAJO:			
			return this.vecinos[2][1][2] != null;
		case ATRAS_ARRIBA:			
			return this.vecinos[0][1][2] != null;
		case ATRAS_DERECHA:			
			return this.vecinos[1][0][2] != null;
		case ATRAS_IZQUIERDA:			
			return this.vecinos[1][2][2] != null;
		case ATRAS_DERECHA_ABAJO:			
			return this.vecinos[2][0][2] != null;
		case ATRAS_DERECHA_ARRIBA:			
			return this.vecinos[0][0][2] != null;
		case ATRAS_IZQUIERDA_ABAJO:			
			return this.vecinos[2][2][2] != null;
		case ATRAS_IZQUIERDA_ARRIBA:			
			return this.vecinos[0][2][2] != null;
		case DERECHA_ABAJO:			
			return this.vecinos[2][0][1] != null;
		case DERECHA_ARRIBA:			
			return this.vecinos[0][0][1] != null;
		case IZQUIERDA_ABAJO:
			return this.vecinos[2][2][1] != null;			
		case IZQUIERDA_ARRIBA:
			return this.vecinos[0][2][1] != null;
		default:
			break;
		}
		return false;
	}
	public boolean existeElVecino(Movimiento movimiento) {
		return existeElVecino(Direccion.valueOf(movimiento.toString()));
	}
	
	/**
	 * pre:
	 * post: remueve la ficha del casillero
	 */
	public void vaciar() {
		this.setDato(null);
	}

//GETTERS SIMPLES -----------------------------------------------------------------------------------------
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}

	public T getDato() {
		return this.dato;
	}

	/**
	 * pre: 
	 * @param x: -1 0 y 1, para indicar izquierda centro o derecho respectivamente
	 * @param y: -1 0 y 1, para indicar arriba centro o abajo respectivamente
	 * @param z: -1 0 y 1, para indicar adelante centro o atras respectivamente
	 * @return devuelve el casillero
	 * @throws Exception 
	 */
	public Casillero<T> getCasilleroVecino(int x, int y, int z) throws Exception {
		if ((x > 1 || x < -1) ||
			(y > 1 || y < -1) ||
			(z > 1 || z < -1)) {
			throw new Exception("Los valores ingresados tiene que ser -1, 0 o 1");
		}
		return this.vecinos[x+1][y+1][z+1];
	}
	
	public Casillero<T> getCasilleroVecino(Movimiento movimiento) throws Exception {
		return getCasilleroVecino(Direccion.valueOf(movimiento.toString()));
	}
		
	public Casillero<T> getCasilleroVecino(Direccion direccion) throws Exception {
		switch (direccion) {
			case ABAJO:
				return this.vecinos[2][1][1];
			case ARRIBA:
				return this.vecinos[0][1][1];
			case DERECHA:
				return this.vecinos[1][2][1];
			case IZQUIERDA:
				return this.vecinos[1][0][1];
			case ATRAS:
				return this.vecinos[1][1][2];			
			case ADELANTE:
				return this.vecinos[1][1][0];	
			case ADELANTE_ABAJO:			
				return this.vecinos[2][1][0];
			case ADELANTE_ARRIBA:			
				return this.vecinos[0][1][0];
			case ADELANTE_DERECHA:			
				return this.vecinos[1][0][0];
			case ADELANTE_IZQUIERDA:			
				return this.vecinos[1][2][0];
			case ADELANTE_DERECHA_ABAJO:			
				return this.vecinos[2][0][0];
			case ADELANTE_DERECHA_ARRIBA:			
				return this.vecinos[0][0][0];
			case ADELANTE_IZQUIERDA_ABAJO:			
				return this.vecinos[2][2][0];
			case ADELANTE_IZQUIERDA_ARRIBA:			
				return this.vecinos[0][2][0];
			case ATRAS_ABAJO:			
				return this.vecinos[2][1][2];
			case ATRAS_ARRIBA:			
				return this.vecinos[0][1][2];
			case ATRAS_DERECHA:			
				return this.vecinos[1][0][2];
			case ATRAS_IZQUIERDA:			
				return this.vecinos[1][2][2];
			case ATRAS_DERECHA_ABAJO:			
				return this.vecinos[2][0][2];
			case ATRAS_DERECHA_ARRIBA:			
				return this.vecinos[0][0][2];
			case ATRAS_IZQUIERDA_ABAJO:			
				return this.vecinos[2][2][2];
			case ATRAS_IZQUIERDA_ARRIBA:			
				return this.vecinos[0][2][2];
			case DERECHA_ABAJO:			
				return this.vecinos[2][0][1];
			case DERECHA_ARRIBA:			
				return this.vecinos[0][0][1];
			case IZQUIERDA_ABAJO:
				return this.vecinos[2][2][1];			
			case IZQUIERDA_ARRIBA:
				return this.vecinos[0][2][1];
			default:
				break;
		}
		throw new Exception("No se encontro la posicion vecina");
	}

	/**
	 * Devuelve un cubo con los vecinos, y el casillero actual en el centro
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Casillero<T>[][][] getCasillerosVecinos() {
		Casillero<T>[][][] matriz = new Casillero[3][3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {					
					matriz[i][j][k] = this.vecinos[i][j][k];
				}
			}
		}
		return matriz;
	}
		
//SETTERS SIMPLES -----------------------------------------------------------------------------------------	
	
	public void setDato(T dato) {
		this.dato = dato;		
	}
	
	/**
	 * pre: 
	 * @param x: -1 0 y 1, para indicar izquierda centro o derecho respectivamente
	 * @param y: -1 0 y 1, para indicar arriba centro o abajo respectivamente
	 * @param z: -1 0 y 1, para indicar adelante centro o atras respectivamente
	 * @return devuelve el casilero
	 * @throws Exception 
	 */
	public void setCasilleroVecino(Casillero<T> casillero, int i, int j, int k) throws Exception {
		if ((x > 1 || x < -1) ||
			(y > 1 || y < -1) ||
			(z > 1 || z < -1)) {
			throw new Exception("Los valores ingresados tiene que ser -1, 0 o 1");
			}
		this.vecinos[i+1][j+1][k+1] = casillero;
	}

}

