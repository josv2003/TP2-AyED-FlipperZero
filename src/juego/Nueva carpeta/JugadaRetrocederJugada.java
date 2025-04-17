package tp2;

public class JugadaRetrocederJugada extends Jugada {
	

	public JugadaRetrocederJugada(Carta carta) {
		super(carta);
	}
	
   

    @Override
    public void jugar(Partida2 partida, Turno turnoActual) throws Exception {
    	
    	Jugador jugadorAnterior=partida.obtenerJugadorAnterior();
            
        RelacionDatoCasillero<T> ultimaJugada=jugadorAnterior.getUltimaPosicion();
        	
        partida.retrocederJugada(ultimaJugada, jugadorAnterior);
        	
        System.out.println("Se ha retrocedido la última jugada anterior a la tuya.");
    
}