package tp2;

public class JugadaDuplicarTurno extends Jugada{
	
	public JugadaDuplicarTurno(Carta carta) {
		super(carta);
	}

    @Override
    public void jugar(Partida partida, Turno turnoActual) {
        turnoActual.duplicar();
        System.out.println(" Duplicaste tu turno.");
    }

}
