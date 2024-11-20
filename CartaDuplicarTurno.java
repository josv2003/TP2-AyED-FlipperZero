package tp2;

public class CartaDuplicarTurno extends Carta{
	
	public CartaDuplicarTurno() {
        super("Duplicas tu turno.");
    }
    
    
    @Override
    protected String getTituloPorDefecto() {
        return "Duplicar turno";
    }

    @Override
    public Jugada getJugada() {
        return new JugadaDuplicarTurno(this);
    }




}
