package tp2;

import java.util.Objects;

public abstract class Carta {
	
	
	
		private static Long IdActual = 1L;
		
			
		private Long id = null; 
		private String titulo = null;
		
	
		protected Carta() {
			this.titulo = getTituloPorDefecto();
			this.id = Carta.getIdActual();
		}
		
		protected Carta(String titulo) {
			this.titulo = titulo;
			this.id = Carta.getIdActual();
		}
			
		
		private static Long getIdActual() {
			return Carta.IdActual++;
		}
		
		
		@Override
		public String toString() {
			return this.getTitulo() + " (" + this.id + ")";
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Carta other = (Carta) obj;
			return Objects.equals(id, other.id);
		}
		
		
		protected abstract String getTituloPorDefecto();
		
		public abstract Jugada getJugada();
	
		public String getTitulo() {
			return this.titulo;
		}
		
		public Long getId() {
			return this.id;
		}
		
}