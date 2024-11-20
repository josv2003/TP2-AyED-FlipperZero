package tp2;

public class CartaInhabilitarCartas extends Carta {
	
	public CartaInhabilitarCartas() {
        super("Inhabilita el uso de cartas por un turno a un jugador");
    }
    
    
    @Override
    protected String getTituloPorDefecto() {
        return "Inhabilitar cartas";
    }

    @Override
    public Jugada getJugada() {
        return new JugadaInhabilitarCartas(this);
    }

}
