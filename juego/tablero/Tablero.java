package juego.tablero;
import juego.tablero.estructuras.Lista;

public class Tablero<T> {
	//ATRIBUTOS DE CLASE --------------------------------------------------------------------------------------
	//ATRIBUTOS -----------------------------------------------------------------------------------------------
		
		private Lista<RelacionDatoCasillero<T>> posicionDeLasDatos = null;
		private Lista<Lista<Lista<Casillero<T>>>> tablero = null;
		private int ancho = 0;
		private int alto = 0;
		private int profundidad = 0;
		
	//CONSTRUCTORES -------------------------------------------------------------------------------------------
		
		/**
		 * 
		 * @param ancho
		 * @param alto
		 * @param profundidad
		 * @throws Exception 
		 * post: crea un tablero con la dimensiones dadas
		 */
		public Tablero(int ancho, int alto, int profundidad) throws Exception {
			if ((ancho <= 0) || (alto <= 0) || (profundidad <= 0)) {
				throw new Exception("Las dimensiones tienen que ser mayores a 0");
			}
			this.ancho = ancho;
			this.alto = alto;
			this.profundidad = profundidad;
			this.posicionDeLasDatos = new Lista<RelacionDatoCasillero<T>>();
			this.tablero = new Lista<Lista<Lista<Casillero<T>>>>();
			for( int i = 1; i <= ancho; i++) {
				Lista<Lista<Casillero<T>>> piso = new Lista<Lista<Casillero<T>>>();
				this.tablero.agregar(piso);
				for(int j = 1; j <= alto; j++) {
					Lista<Casillero<T>> fila = new Lista<Casillero<T>>();
					piso.agregar(fila);
					for (int k = 1; k <= profundidad; k++) {
						Casillero<T> nuevoCasillero = new Casillero<T>(i, j, k);
						fila.agregar(nuevoCasillero);
						//Estoy en (i, j, k)
						for (int n = -1; n <= 1; n++) {
							for (int l = -1; l <= 1; l++) {
								if (this.existeElCasillero(i-1, j+l, k+n)) {
									relacionarCasillerosVecinos(this.getCasillero(i-1, j+l, k+n), nuevoCasillero, -1, l, n);
								}					
							}	
							if (this.existeElCasillero(i, j-1, k+n)) {
								relacionarCasillerosVecinos(this.getCasillero(i, j-1, k+n), nuevoCasillero, 0, -1, n);
							}
							if (this.existeElCasillero(i, j, k+n)) {
								relacionarCasillerosVecinos(this.getCasillero(i, j, k+n), nuevoCasillero, 0, 0, n);
							}
						}
					}					
				}
			}
		}

		/**
		 * pre:
		 * @param casillero: no puede ser vacio
		 * @param casillero2: no puede ser vacio
		 * @param i: rango entre -1, 0 y 1
		 * @param j: rango entre -1, 0 y 1
		 * @param k: rango entre -1, 0 y 1
		 * post: relaciona los 2 vecinos en sus matrices de vecinos, en el casillero1 como i, j y k, y en casillero2
		 * 		 como el opuesto 
		 * @throws Exception 
		 */
		public void relacionarCasillerosVecinos(Casillero<T> casillero1, Casillero<T> casillero2, int i, int j, int k) throws Exception {
			if ((i > 1 || i < -1) ||
				(j > 1 || j < -1) ||
				(k > 1 || k < -1)) {
				throw new Exception("Los valores ingresados tiene que ser -1, 0 o 1");
			}
			casillero2.setCasilleroVecino(casillero1, i, j, k);
			casillero1.setCasilleroVecino(casillero2, Casillero.invertirCoordenadaDeVecino(i), Casillero.invertirCoordenadaDeVecino(j), Casillero.invertirCoordenadaDeVecino(k));
		}

		public boolean existeElCasillero(int i, int j, int k) throws Exception {
			if ((i < 1) || 
				(j < 1) ||
				(k < 1)) {
				return false;
			}
			
			if ((i > this.tablero.getLongitud()) || 
				(j > this.tablero.obtener(i).getLongitud()) ||
				(k > this.tablero.obtener(i).obtener(j).getLongitud())) {
				return false;
			}
			return true;
		}

		/**
		 * pre:
		 * @param x
		 * @param y
		 * @param z
		 * @param ficha
		 * post: agrega el dato a al casillero que se encuentra en las coordenadas pasadas por parámetro
		 * @throws Exception
		 */
		public void agregar(int x, int y, int z, T ficha) throws Exception {
			Casillero<T> casillero = getCasillero(x, y, z);
			casillero.setDato(ficha);
			RelacionDatoCasillero<T> relacion = new RelacionDatoCasillero<T>(casillero, ficha);
			this.posicionDeLasDatos.agregar(relacion);
			
		}

		/**
		 * pre:
		 * @param x
		 * @param y
		 * @param z
		 * @return devuelve el casillero de acuerdo a las coordenadas dadas como parametros
		 * @throws Exception
		 */
		public Casillero<T> getCasillero(int x, int y, int z) throws Exception {
			if (!existeElCasillero(x, y, z)) {
				throw new Exception("Los valores ingresados estan fuera de rango");
				}
			return this.tablero.obtener(x).obtener(y).obtener(z);
		}
		
		/**
		 * pre:
		 * @param x
		 * @param y
		 * @param z
		 * @return devuelve el dato que tiene el casillero que se encuentra en las coordenadas 
		 * 			pasadas por parámetro
		 * @throws Exception
		 */
		public T obtener(int x, int y, int z) throws Exception {
			return getCasillero(x, y, z).getDato();
		}

		/**
		 * 
		 * @param ficha
		 * @return devuelve el casillero que contenga el dato pasado por parametro
		 * @throws Exception 
		 */
		public Casillero<T> getCasillero(T ficha) throws Exception {
			this.posicionDeLasDatos.iniciarCursor();
			while (this.posicionDeLasDatos.avanzarCursor()) {
				RelacionDatoCasillero<T> datoCasillero = this.posicionDeLasDatos.obtenerCursor();
				if (datoCasillero.getDato().equals(ficha)) {
					return datoCasillero.getCasillero();
				}
			}
			throw new Exception("No se encontro la ficha");
		}

		/**
		 * pre: 
		 * @param casillero: no puede ser nulo
		 * @param casilleroVecino: no puede ser nulo
		 * @param dato
		 * post: asigna a un nuevo casillero el dato pasado por parametro
		 * @throws Exception 
		 */
		public void mover(Casillero<T> casillero, Casillero<T> casilleroVecino, T dato) throws Exception {
			if (casilleroVecino == null || casillero == null) {
				throw new Exception("No se encontro el casillero");
			}
			//saca la ficha de un casillero
			casillero.vaciar();
			
			//ponerla en otro
			casilleroVecino.setDato(dato);
			
			//actualizar la lista
			this.posicionDeLasDatos.iniciarCursor();
			while (this.posicionDeLasDatos.avanzarCursor()) {
				RelacionDatoCasillero<T> posicionDato = this.posicionDeLasDatos.obtenerCursor();
				if (posicionDato.getDato().equals(dato)) {
					posicionDato.setCasillero(casilleroVecino);
				}
			}
		}
		
	//METODOS DE CLASE ----------------------------------------------------------------------------------------
	//METODOS GENERALES ---------------------------------------------------------------------------------------
	//METODOS DE COMPORTAMIENTO -------------------------------------------------------------------------------
	//GETTERS SIMPLES -----------------------------------------------------------------------------------------


		public int getAncho() {
			return ancho;
		}

		public int getAlto() {
			return alto;
		}
		
		public int getProfundidad() {
			return profundidad;
		}

		public Lista<RelacionDatoCasillero<T>> getPosicionDeLasDatos() {
			return posicionDeLasDatos;
		}
		
	//SETTERS SIMPLES -----------------------------------------------------------------------------------------	
}
