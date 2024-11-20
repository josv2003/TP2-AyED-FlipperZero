package tp2;

public class CartaPerderTurno extends Carta {
	    public CartaPerderTurno() {
	        super("Hace perder el siguiente turno al jugador elegido.");
	    }
	    
	    
	    @Override
	    protected String getTituloPorDefecto() {
	        return "Pierde turno";
	    }

	    @Override
	    public Jugada getJugada() {
	        return new JugadaPerderTurno(this);
	    }
	

}
