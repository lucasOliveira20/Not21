package model;

import java.io.Serializable;

import br.ufsc.inf.leobr.cliente.Jogada;

public enum Naipe implements Jogada{
	
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
