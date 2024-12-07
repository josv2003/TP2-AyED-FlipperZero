package juego.jugadas;

import juego.Escaner;
import juego.RelacionSimboloColor;
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
				int[] coordenadasCambioColor = partida.buscarPosicionFicha(partida.getTablero().getPosicionDeLasDatos(), idFicha);
				turnoActual.setCoordenadasCambioColor(coordenadasCambioColor);
			}catch (Exception e) {
				System.out.println("Intentá de nuevo, error: "+ e.getMessage());
			}			
		}
		
        RelacionSimboloColor nuevoId = Escaner.preguntarId("Seleccione a que simbolo quiere cambiarla ficha", partida.getJugadores());
       
        ficha.setSimbolo(nuevoId.getSimbolo());
        ficha.setColor(nuevoId.getColor());
        System.out.println("Se ha cambiado el color de la ficha a " + nuevoId.getColor());
	}

//GETTERS SIMPLES ----------------------------------------------------------------------------------
//SETTERS SIMPLES ----------------------------------------------------------------------------------
	
	
}