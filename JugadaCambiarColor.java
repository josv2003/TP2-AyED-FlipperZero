package tp2;

public class JugadaCambiarColor extends Jugada {
	
	

	public JugadaCambiarColor(Carta carta) {
		super(carta);
	}
	
	

    @Override
    public void jugar(Partida partida, Turno turnoActual)  {
       
         Casillero<Ficha> ubicacionFicha = partida.buscarFichaSeleccionada(); 
       
        Ficha ficha=  ubicacionFicha.getDato();
        
        char nuevoColor=partida.seleccionarSimbolo();
        
        
        ficha.cambiarSimbolo(nuevoColor);

        System.out.println("Se ha cambiado el color de la ficha a " + nuevoColor);
    }
}
