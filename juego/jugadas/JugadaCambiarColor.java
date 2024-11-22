package juego.jugadas;

import juego.Escaner;
import juego.Tateti;
import juego.Turno;
import juego.cartas.Carta;
import juego.tablero.Ficha;

public class JugadaCambiarColor extends Jugada {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public JugadaCambiarColor(Carta carta) {
		super(carta);
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------
	
	@Override
	public void jugar(Tateti partida, Turno turnoActual) throws Exception {
		partida.mostrarFichasPosiones(partida.getTablero().getPosicionDeLasDatos());
		Ficha ficha = null;
		while (ficha==null) {
			try {
				Long idFicha = Escaner.preguntarLong("Id:");
				ficha = partida.buscarFicha(partida.getTablero().getPosicionDeLasDatos(), idFicha);
			}catch (Exception e) {
				System.out.println("Intentá de nuevo, error: "+ e.getMessage());
			}
			
		}
		
        char nuevoColor = Escaner.preguntarSimbolo("Seleccione a que simbolo quiere cambiarla ficha", partida.getJugadores());
       
        ficha.setSimbolo(nuevoColor);
        System.out.println("Se ha cambiado el color de la ficha a " + nuevoColor);
	}

//GETTERS SIMPLES ----------------------------------------------------------------------------------
//SETTERS SIMPLES ----------------------------------------------------------------------------------
	
	
}