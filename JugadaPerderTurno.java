package tp2;

public class JugadaPerderTurno extends Jugada {

	public JugadaPerderTurno(Carta carta) {
		super(carta);
	}

    @Override
    public void jugar(Partida partida, Turno turnoActual) {
        turnoActual.sumarBloqueo();
        Jugador jugadorAfectado=partida.seleccionarObjetivo();
        System.out.println(jugadorAfectado.getNombre() + " pierde un turno.");
    }
}