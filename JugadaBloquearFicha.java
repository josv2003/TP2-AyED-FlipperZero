package tp2;

public class JugadaBloquearFicha extends Jugada {
	
	public JugadaBloquearFicha(Carta carta) {
		super(carta);
	}
	
@Override
    public void jugar(Partida partida, Turno turnoActual) throws Exception {
    	
    	Casillero ubicacionFicha = partida.seleccionarCasillero(); 
    	
    	
        if (ubicacionFicha == null || ubicacionFicha.getDato() == null) {
            throw new Exception("El casillero seleccionado no contiene ninguna ficha.");
        }
  
        
        
        Ficha fichaBloqueada = (Ficha) ubicacionFicha.getDato();
        
        fichaBloqueada.setBloquear(); 

        System.out.println("Se ha bloqueado la ficha.");
    }
}