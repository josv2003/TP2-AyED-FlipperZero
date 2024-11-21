package tp2;


	public Jugador obtenerJugadorAnterior() {
		jugador jugadorAnterior=jugadores[(indiceJugadorActual -1 + jugadores.length) %jugadores.length];
		return jugadorAnterior;
	}
	
	public void guardarPosicion (ficha) {
		Casillero<Ficha> ultPosicion = this.tablero.getCasillero(ficha);
		RelacionDatoCasillero<Ficha> datoCasillero = new RelacionDatoCasillero<>(ultPosicion, ficha);
        jugadorActual.registrarDatoPosicionAnterior(datoCasillero);
	}
	
	public void retrocederJugada(RelacionDatoCasillero<Ficha> ultimaJugada, Jugador jugadorAnterior) throws Exdception {
		if(ultimaJugada==null) {
			throw new Exception("No tenes jugadas para retroceder");
		}
		Ficha fichaARetroceder = ultimaJugada.getDato();
		Casillero<Ficha> ubicacionActual=this.tablero.getCasillero(fichaARetroceder);
		Casillero<Ficha> casilleroARetroceder=ultimaJugada.getCasillero();
		if(casilleroARetroceder==null) {
			jugadorAnterior.devolverFicha(fichaARetroceder);
			ubicacionActual.getDato()=null;
		} else {
			this.tablero.mover(ubicacionActual, casilleroARetroceder, fichaARetroceder);
		}
			
		}
		
	}
	
	


	
	
	
	public Jugador seleccionarObjetivo(){
		Scanner scanner = new Scanner(System.in);
        System.out.println("Podes seleccionar entre los siguientes jugadores para aplicar tu efecto: ");
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println((i + 1) + ". " + this.jugadores[i].getNombre()); 
        }
        
        int seleccion=0;
        while(seleccion<1||seleccion>this.jugadores.length || !scanner.hasNextInt()) {
        	System.out.print("Ingrese el número del jugador objetivo: ");
            seleccion = scanner.nextInt() - 1; 
        }
        return this.jugadores[seleccion];
		
	}
	
       
	 public char seleccionarSimbolo() {
	    	Scanner scanner = new Scanner(System.in);
	        char simbolo;

	        System.out.print("Ingrese el simbolo nuevo: ");
	        simbolo = scanner.next().charAt(0); 
	        return simbolo;
	    	
	 }
	
	public Casillero<Ficha> buscarFichaSeleccionada() {
		System.out.println("Ingresa el id de la ficha que quiere buscar: ");
		Scanner scanner = new Scanner(System.in);
	    long idFicha;
	    idFicha = scanner.nextLong();
	    Casillero<Ficha> ubicacionFicha=this.tablero.getCasillero(idFicha);
	    return ubicacionFicha;
	    
	    
		
	}
	
	
	
	public Casillero<Ficha> seleccionarCasillero() {
		System.out.println("Ingresa las coordenadas del casillero a anular ");
		
		int x = Escaner.preguntarEntero("X: ");
		int y = Escaner.preguntarEntero("Y: ");
		int z = Escaner.preguntarEntero("Z: ");
	
        
		
		return Casillero<Ficha> casillero = this.tablero.getCasillero(x, y,z);
	}
       
	
}