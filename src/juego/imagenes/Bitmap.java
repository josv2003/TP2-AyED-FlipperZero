package juego.imagenes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import juego.tablero.estructuras.Lista;

public class Bitmap {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------

	private int ancho;
	private int alto;
	private Lista<Lista<Color>> matriz;
	
//CONSTRUCTORES ------------------------------------------------------------------------------------

	/**
	 * 
	 * @param ancho
	 * @param alto
	 * post: crea una matriz de colores donde por defecto todos los colores son blanco
	 * @throws Exception
	 */
	public Bitmap(int ancho, int alto) throws Exception {
		this.ancho = ancho;
		this.alto = alto;
		this.matriz = new Lista<Lista<Color>>();
		for (int y = 0; y < alto; y++) {
			Lista<Color> fila = new Lista<Color>();
			this.matriz.agregar(fila);
			for (int x = 0; x < ancho; x++) {
				Color color = new Color(255, 255, 255); // Blanco por defecto
				fila.agregar(color); 
			}
		}
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------

	/**
	 * 
	 * @param nombreArchivo
	 * @param image
	 * post: crea un archivo bmp a partir de una BufferedImage
	 * @throws IOException
	 */
	public void crearArchivo(String nombreArchivo, BufferedImage image) throws IOException { 
		File archivo = new File(nombreArchivo);
		ImageIO.write(image, "bmp", archivo);
	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @param color
	 * post: pinta la matriz  con el color y en las coordenadas pasadas por parametros
	 * @throws Exception
	 */
	public void pintarCasilleroDeMatriz(int x, int y, Color color) throws Exception {
	     if (x >= 0 && x < ancho && y >= 0 && y < alto) {
	            matriz.obtener(x).cambiar(color, y);
	     }
	}
	
	/**
	 * 
	 * @return devuelve una imagen creada a partir de la matriz
	 * @throws Exception
	 */
	public BufferedImage crearImagen() throws Exception{
		BufferedImage image = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
		for (int i = 1; i <= alto; i++) {
			for (int j = 1; j <= ancho; j++) {
				int rgb = this.matriz.obtener(i).obtener(j).getRGB();
				image.setRGB(i-1, j-1, rgb);
			}
		}
		return image;
	}

//GETTERS SIMPLES ----------------------------------------------------------------------------------
//SETTERS SIMPLES ----------------------------------------------------------------------------------
}
