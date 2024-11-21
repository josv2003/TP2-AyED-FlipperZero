package tp2;

public class JugadaPerderTurno extends Jugada {

	public JugadaPerderTurno(Carta carta) {
		super(carta);
	}

    @Override
    public void jugar(Partida partida, Turno turnoActual) {
        Jugador jugadorAfectado=partida.seleccionarObjetivo();
        Turno turnoBloqueado = partida.obtenerTurno(jugadorAfectado);
        turnoBloqueado.sumarBloqueo();
        
        System.out.println(jugadorAfectado.getNombre() + " pierde un turno.");
    }
}
