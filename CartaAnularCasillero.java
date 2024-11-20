package tp2;



public class CartaAnularCasillero extends Carta {
    public CartaAnularCasillero() {
        super("Elegir un casillero para anular.");
    }
    
    
    @Override
    protected String getTituloPorDefecto() {
        return "Anular casillero";
    }

    @Override
    public Jugada getJugada() {
        return new JugadaAnularCasillero(this);
    }


}
