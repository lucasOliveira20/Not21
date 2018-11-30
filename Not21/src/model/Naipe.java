package model;

public enum Naipe {
	
	   ESPADAS('E'),
	  
	   PAUS('P'),
	  
	   COPAS('C'),
	 
	   OUROS('O');
	   
	   
	   private char valNaipe;
	  
	   private Naipe(char valorNaipe) {
	      this.valNaipe = valorNaipe;
	   }

	   public char getValorNaipe() {
	      return this.valNaipe;
	   }

	   public String toString() {
	      return Character.toString(this.valNaipe);
	   }
}
