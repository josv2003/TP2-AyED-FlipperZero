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
		Lista<RelacionDatoCasillero<Ficha>> fichasPosciones = partida.getTablero().getPosicionDeLasDatos();
		
		System.out.println("Seleccione la ficha a bloquear (seleccione ID):");
		partida.mostrarFichasPosiones(fichasPosciones);
		Long IdFicha = Escaner.preguntarLong("Ingrese ID: ");
		
		Ficha fichaBloqueada = partida.buscarFicha(fichasPosciones, IdFicha);   
        
        fichaBloqueada.bloquear(); 

        System.out.println("Se ha bloqueado la ficha.");
	}


	
//GETTERS SIMPLES ----------------------------------------------------------------------------------
//SETTERS SIMPLES ----------------------------------------------------------------------------------
	
}