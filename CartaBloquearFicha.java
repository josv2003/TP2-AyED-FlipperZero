package tp2;



public class CartaBloquearFicha extends Carta {
    public CartaBloquearFicha() {
        super("Elegir una ficha para bloquear.");
    }
    
    
    @Override
    protected String getTituloPorDefecto() {
        return "Bloquear ficha";
    }

    @Override
    public Jugada getJugada() {
        return new JugadaBloquearFicha(this);
    }


}
