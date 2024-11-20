package tp2;

public class JugadaAnularCasillero extends Jugada {
	
	
	public JugadaAnularCasillero(Carta carta) {
		super(carta);
	}

    @Override
    public void jugar(Partida partida, Turno turnoActual) throws Exception {
        Casillero<Ficha> casilleroAnulado = partida.seleccionarCasillero(); 
        casilleroAnulado.anular(); 
    }
}
