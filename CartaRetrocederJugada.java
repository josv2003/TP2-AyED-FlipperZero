package tp2;



public class CartaRetrocederJugada extends Carta {
    public CartaRetrocederJugada() {
        super("Retroceder una jugada del turno.");
    }
    
    
    @Override
    protected String getTituloPorDefecto() {
        return "Retroceder jugada";
    }

    @Override
    public Jugada getJugada() {
        return new JugadaRetrocederJugada(this);
    }


}