package juego;

public class PruebasJuego {

	public static void main(String[] args) throws Exception {
		try {
			Menu menu = new Menu();
			menu.ejecutarMenu();
		}catch (Exception e){
			System.out.println("Error de prueba: ");
		}
	}

}
