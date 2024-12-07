package juego;

public class Menu {
	private int cantidadJugadores;
	private int x,y,z;
	private int cartasMano;
	private int dificultad;
	private int fichasPorJugador;
	
	
	public Menu () {
		this.cantidadJugadores = 0;
		this.x= 0;
		this.y=0;
		this.z=0;
		this.dificultad=0;
		this.fichasPorJugador=0;
	}

	
	
	public void ejecutarMenu() throws Exception{

		mostrarBienvenida();
		
		configurarInicio();
		
		Tateti partida = construirTateti();

		System.out.println("¡Comencemos a jugar!");
		partida.jugar();
		
	}
	
	
	
	public Tateti construirTateti() throws Exception {
		
        return new Tateti(cantidadJugadores, x, y, z, cartasMano, fichasPorJugador );
    }
	
	public void cartasAJugar(int x) {
		if(x ==0) {
			this.cartasMano=0;
		}else {
			this.cartasMano=6;
		}
		
	}
	
	public void configurarInicio()throws Exception{
		System.out.println("MENÚ INICIAL");
		
		this. cantidadJugadores=Escaner.preguntarEnteroConRango("Ingresá la cantidad de jugadores (2 a 6): ", 2, 6);
		
		int cantidadCartas = Escaner.preguntarEnteroConRango("Ingresá 1 si queres usar cartas, sino ingresá 0 (0 a 1): ", 0,1);
		
		cartasAJugar(cantidadCartas);
		
		System.out.println("Elegí el nivel de dificultad:");
        System.out.println("1. Fácil: 6 fichas por jugador en tablero de 3x3x3");
        System.out.println("2. Medio: 5 fichas por jugador en tablero de 4x4x4");
        System.out.println("3. Difícil: 6 fichas por jugador  en tablero de 6x6x6");
		
        this. dificultad = Escaner.preguntarEnteroConRango("Ingresá la dificultad (1-3): ",1,3);
        
        switch (this.dificultad) {
        case 1: 
        	System.out.println("Elegiste dificultad fácil");
            this.x =this.y = this.z = 3;
            this.fichasPorJugador = 6;
            break;
        case 2: 
        	System.out.println("Elegiste dificultad intermedio");
            this.x = this.y = this.z = 4;
            this.fichasPorJugador = 5;
            break;
        case 3: 
        	System.out.println("Elegiste dificultad dificil");
            this.x = this.y = this.z = 6;
            this.fichasPorJugador = 6;
            break;
        default:
            throw new Exception("Dificultad no válida.");
        }
		
	}
	
	public void mostrarBienvenida() {
		System.out.println("¡Bienvenidos al tateti 3D!");
		System.out.println("Cada jugador intentará alinear sus fichas de forma vertical, diagonal u horizontal.");
		System.out.println("El máximo de jugadores es 6, y el minimo 2.");
		System.out.println("Podrán elegir el nivel de dificultad y el uso de cartas con efectos especiales.");
		
	}

}
