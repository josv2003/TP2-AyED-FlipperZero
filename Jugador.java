package tp2;


public class Jugador {
	public static final int MAX_CARTAS = 6;
    private String nombre;
    private boolean todasLasFichasEnTablero;
    private Carta[] mano;
	
	private int inhabilitacionesMano;
    private int cantidadCartasMano;


    
 

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.todasLasFichasEnTablero=false;
        this.mano=new Carta[MAX_CARTAS];
        this.inhabilitacionesMano=0;
	    this.cantidadCartasMano=0;

    }
    
    
    public boolean tieneCartas() {
    	return this.mano!=null;
    }
    
    
   public void agregarCartaALaMAno(Carta carta) throws Exception{
    	if(this.cantidadCartasMano==MAX_CARTAS) {
    		throw new Exception("Ya tenes en mano el maximo de cartas");    
    	}
    
    	
    	for(int i=0; i<this.mano.length;i++) {
        			if(this.mano[i]==null) {
        				this.mano[i]=carta;
        				this.cantidadCartasMano++;
        				return;
        		    	
        			}
    	
    	}
    	
    }
    
    
    
    public Carta quitarCartaDeLaMano(int indice) throws Exception {
        if (indice < 0 || indice >= mano.length || mano[indice] == null) {
            throw new Exception("No hay cartas en esa posición");
        }

        Carta carta = mano[indice];
        mano[indice] = null;
        cantidadCartasMano--; 
        return carta;
    }

    
    public int getInhabilitacionesMano() {
    	return this.inhabilitacionesMano;
    }
    
    public boolean getTodasLasFichasEnTablero() {
    	return this.todasLasFichasEnTablero;
    }
    public Carta[] getMano() {
    	return this.mano;
    }

    public String getNombre() {
        return this.nombre;
    }
    public void inhabilitarMano() {
    	this.inhabilitacionesMano++;
    }
    public void restarInhabilitarMano() {
    	this.inhabilitacionesMano--;
    }
    
    public void removerCarta(int indice) {
        if (indice >= 0 && indice < this.mano.length && this.mano[indice] != null) {
            
            this.mano[indice] = null;

            for (int i = indice; i < this.mano.length - 1; i++) {
                this.mano[i] = this.mano[i + 1];
            }

          
            this.mano[this.mano.length - 1] = null;
        }
    }
    
    @Override
    public String toString() {
        String resultado = "Jugador: " + this.nombre + "\nCartas en mano: \n";
        
        for (Carta carta : mano) {
            if (carta != null) {
                resultado += carta.toString();
            }
        }
        return resultado;
    }
}
