package model;

public class Carta {
	   
	   private Naipe idNipe;
	   
	   private NumCarta idCarta;

	   public Carta(Naipe naipe,NumCarta numero) {
	      this.idNipe = naipe;
	      this.idCarta = numero;
	   }

	   public Naipe getNaipe() {
	      return this.idNipe;
	   }

	   public void setNaipe(Naipe naipe) {
	      this.idNipe = naipe;
	   }

	   NumCarta getNumero() {
	      return this.idCarta;
	   }

	   public void setNumero(NumCarta numero) {
	      this.idCarta = numero;
	   }

	   public String toString() {
	      return this.idCarta.toString()+this.idNipe.toString();
	   }

	   public int getValor(){
		   return this.idCarta.getValor();
	   }


	   public int hashCode() {
	      final int prime = 31;
	      int result = 1;
	      result = prime * result + ((this.idCarta == null) ? 0 : this.idCarta.hashCode());
	      result = prime * result + ((this.idNipe == null) ? 0 : this.idNipe.hashCode());
	      return result;
	   }

	   public boolean equals(Object obj) {
	      if (this == obj)
	         return true;
	      if (obj == null)
	         return false;
	      if (getClass() != obj.getClass())
	         return false;
	      final Carta other = (Carta) obj;
	      if (this.idCarta == null) {
	         if (other.idCarta != null)
	            return false;
	      } else if (!this.idCarta.equals(other.idCarta))
	         return false;
	      if (this.idNipe == null) {
	         if (other.idNipe != null)
	            return false;
	      } else if (!this.idNipe.equals(other.idNipe))
	         return false;
	      return true;
	   }
}
