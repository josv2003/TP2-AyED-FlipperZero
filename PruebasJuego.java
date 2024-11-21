package juego;

public class PruebasJuego {

	public static void main(String[] args) throws Exception {
		try {
			Tateti juego = new Tateti(2, 3, 3, 3);
			
			juego.jugar();
			
		} catch (Exception e) {
			System.out.println("Error de prueba: "+ e.getMessage());
		}
	
		
	}

}
