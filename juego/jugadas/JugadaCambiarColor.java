package juego.jugadas;

import juego.Tateti;
import juego.Turno;
import juego.cartas.Carta;

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
		    
//       Casillero<Ficha> ubicacionFicha = partida.buscarFichaSeleccionada(); 
//        
//       Ficha ficha=  ubicacionFicha.getDato();
//       
//       char nuevoColor=partida.seleccionarSimbolo();
//       
//       
//       ficha.cambiarSimbolo(nuevoColor);
//
//       System.out.println("Se ha cambiado el color de la ficha a " + nuevoColor);
	}

//GETTERS SIMPLES ----------------------------------------------------------------------------------
//SETTERS SIMPLES ----------------------------------------------------------------------------------
	
	
}