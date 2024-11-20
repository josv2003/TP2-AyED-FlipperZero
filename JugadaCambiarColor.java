package tp2;

public class JugadaCambiarColor extends Jugada {
	
	

	public JugadaCambiarColor(Carta carta) {
		super(carta);
	}
	
	

    @Override
    public void jugar(Partida partida, Turno turnoActual) throws Exception {
       
        Casillero ubicacionFicha = partida.seleccionarCasillero(); 
        if(ubicacionFicha.getDato()==null) {
        	throw new Exception("No hay ninguna ficha en este casillero");
        }
        
        Ficha ficha= (Ficha) ubicacionFicha.getDato();
        
        char nuevoColor=partida.seleccionarSimbolo();
        
        
        ficha.cambiarSimbolo(nuevoColor);

        System.out.println("Se ha cambiado el color de la ficha a " + nuevoColor);
    }
}
