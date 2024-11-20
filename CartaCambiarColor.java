package tp2;



public class CartaCambiarColor extends Carta {
    public CartaCambiarColor() {
        super("Cambiar el color de una ficha");
    }
    
    
    @Override
    protected String getTituloPorDefecto() {
        return "Cambiar color";
    }

    @Override
    public Jugada getJugada() {
        return new JugadaCambiarColor(this);
    }


}
