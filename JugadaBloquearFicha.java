package tp2;

public class JugadaBloquearFicha extends Jugada {
	
	public JugadaBloquearFicha(Carta carta) {
		super(carta);
	}
	
@Override
    public void jugar(Partida partida, Turno turnoActual)  {
    	
    	Casillero<Ficha> ubicacionFicha = partida.buscarFichaSeleccionada(); 

        
        Ficha fichaBloqueada =  ubicacionFicha.getDato();
        
        fichaBloqueada.bloquear(); 

        System.out.println("Se ha bloqueado la ficha.");
    }
}
