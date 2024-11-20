package tp2;

public class JugadaRetrocederJugada extends Jugada {
	

	public JugadaRetrocederJugada(Carta carta) {
		super(carta);
	}
	
   

    @Override
    public void jugar(Partida partida, Turno turnoActual) throws Exception {
        
        Casillero ultimaPosicion = partida.obtenerUltimaJugada(); 
        if (ultimaPosicion == null) {
            throw new Exception("No se puede retroceder, no hay jugadas anteriores.");
        }

        
        ultimaPosicion.retroceder(); 

        System.out.println("Se ha retrocedido la última jugada anterior a la tuya.");
    }
}