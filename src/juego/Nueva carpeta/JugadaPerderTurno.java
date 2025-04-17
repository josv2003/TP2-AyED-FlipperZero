package tp2;

public class JugadaPerderTurno extends Jugada {

	public JugadaPerderTurno(Carta carta) {
		super(carta);
	}

    @Override
    public void jugar(Partida2 partida, Turno1 turnoActual) {
        Jugador jugadorAfectado=partida.seleccionarObjetivo();
        Turno1 turnoBloqueado = partida.obtenerTurno(jugadorAfectado);
        turnoBloqueado.sumarBloqueo();
        
        System.out.println(jugadorAfectado.getNombre() + " pierde un turno.");
    }
}