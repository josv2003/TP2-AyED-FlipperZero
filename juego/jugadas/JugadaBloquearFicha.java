package juego.jugadas;

import juego.Escaner;
import juego.Tateti;
import juego.Turno;
import juego.cartas.Carta;
import juego.tablero.Ficha;
import juego.tablero.RelacionDatoCasillero;
import juego.tablero.estructuras.Lista;

public class JugadaBloquearFicha extends Jugada {
//ATRIBUTOS DE CLASE -------------------------------------------------------------------------------
//ATRIBUTOS ----------------------------------------------------------------------------------------
//CONSTRUCTORES ------------------------------------------------------------------------------------

	public JugadaBloquearFicha(Carta carta) {
		super(carta);
	}
	
//METODOS DE CLASE ---------------------------------------------------------------------------------
//METODOS GENERALES --------------------------------------------------------------------------------
//METODOS DE COMPORTAMIENTO ------------------------------------------------------------------------

	@Override
	public void jugar(Tateti partida, Turno turnoActual) throws Exception {
		try {
			Lista<RelacionDatoCasillero<Ficha>> fichasPosciones = partida.getTablero().getPosicionDeLasDatos();
			
			System.out.println("Seleccione la ficha a bloquear (seleccione ID):");
			partida.mostrarFichasPosiones(fichasPosciones);
			Ficha fichaBloqueada = null;
			while(fichaBloqueada == null) {
				try {
					Long IdFicha = Escaner.preguntarLong("Ingrese ID: ");
					fichaBloqueada = partida.buscarFicha(fichasPosciones, IdFicha);
				}catch (Exception e) {
					System.out.println("Intentá de nuevo, error: "+ e.getMessage());
				}
				
			}
			
	        
	        fichaBloqueada.bloquear(); 

	        System.out.println("Se ha bloqueado la ficha.");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}


	
//GETTERS SIMPLES ----------------------------------------------------------------------------------
//SETTERS SIMPLES ----------------------------------------------------------------------------------
	
}