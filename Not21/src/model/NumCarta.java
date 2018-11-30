package model;

public enum NumCarta {
	 
	   AS(1,"1"),
	
	   DOIS(2,"2"),
	
	   TRES(3,"3"),
	 
	   QUATRO(4,"4"),
	
	   CINCO(5,"5"),
	
	   SEIS(6,"6"),

	   SETE(7,"7"),

	   OITO(8,"8"),
	
	   NOVE(9,"9"),

	   DEZ(10,"10"),
	
	   VALETE(10,"J"),
	  
	   DAMA(10,"Q"),
	
	   REI(10,"K");
	
	 private int valor;
	  
	 private String nomeRepresentativo;
	 
	 private NumCarta(int valor,String nomeRepresentativo) {
	      this.valor = valor;
	      this.nomeRepresentativo = nomeRepresentativo;
	   }

	   
	   public int getValor() {
	      return this.valor;
	   }

	   public String getNomeRepresentativo() {
	      return this.nomeRepresentativo;
	   }

	   public String toString() {
	      return nomeRepresentativo;
	   }
}
