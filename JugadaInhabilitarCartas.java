package tp2;

public class JugadaInhabilitarCartas extends Jugada{
	public JugadaInhabilitarCartas(Carta carta) {
		super(carta);
	}

    @Override
    public void jugar(Partida partida, Turno turnoActual) {
        Jugador jugadorAfectado=partida.seleccionarObjetivo();
        jugadorAfectado.inhabilitarMano();
        System.out.println(jugadorAfectado.getNombre() + " no podes usar tus cartas por un turno.");
    }


}
