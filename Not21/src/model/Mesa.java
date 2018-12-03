package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Mesa implements Serializable {
	   
	/**
	 * 
	 */
	private static final long serialVersionUID = -4752419345217136903L;
	
	
	private List<Jogador> jogadores;
	protected Boolean partidaEmAndamento;
	protected Baralho baralho;
	private Jogador vencedor = null;
	
	private Jogador jogadorAtual;

   public Mesa() {
	   
	  this.jogadores = new ArrayList<Jogador>();
      this.baralho = new Baralho();
      this.baralho.embaralhar();
      
   }
   
   public List<Jogador> getJogadores() {
	   return this.jogadores;
   }
   
   public void setJogadores(List<Jogador> jogadores) {
	   this.jogadores = jogadores;
   }

   
   public Boolean informaJogadorConectado(Jogador jogador) {
	   return true; // FAZER
   }
   
   public Boolean informaEmAndamento() {
   return true;  // FAZER
	   }

	   public Baralho getBaralho() {
	      return this.baralho;
	   }

	   public void setBaralho(Baralho baralho) {
	      this.baralho = baralho;
	   }
   
	   public void criarJogador(Jogador jogador) {
		   this.jogadores.add(jogador);
	  		
	   }

	   public void distribuiCartas() {
		   
		   for(Jogador j : this.jogadores) {	         
			   	 j.limparMao();
		         j.getCartaDoBaralho();
		         j.getCartaDoBaralho();
		         j.getCartaDoBaralho();
		   }
	      
	   }
	   
	   public void maximoCincoJogadas(Jogador jogador){
		   if(jogador.getnRodads() > 4){
			   jogador.setParado();
		   }
	   }
	   
	   public Jogador getJogadorAtual() {
		   if(this.jogadorAtual == null)this.jogadorAtual = jogadores.get(0);
		   return this.jogadorAtual;
	   }
	   

	public Jogador getVencedor() {
		return vencedor;
	}
	   
    public void setVencedor(Jogador j) {
	   this.vencedor = j;
    }
    
    public void avaliaVencedor(List<Jogador> jogadores){
 	   int j1 = jogadores.get(1).distanciaMult();
 	   int j2 =	jogadores.get(2).distanciaMult();
 	   
 	   if ( j1 != 0 && j2 != 0 ) {
 		   
 		      if ( j1 < j2 ) {
 			      setVencedor(jogadores.get(1));
 		      } else if (j1 == j2) {
 			       if( jogadores.get(1).getValorDaMao() > jogadores.get(2).getValorDaMao() ){
 			     	   setVencedor(jogadores.get(1));
 			       } else {
 				   setVencedor(jogadores.get(2));
 			       }
   		      } else {
 			   setVencedor(jogadores.get(2));
   		      } 
 	    
 	   
 	   }else if (j1 == 0 && j2 != 0) {
 		   setVencedor(jogadores.get(2));
 		   
 	   } else if (j1 !=0 && j2 ==0) {
 		   setVencedor(jogadores.get(1));
 		   
    	   }else {
    		   System.out.println("Algo deu errado");
 	   }
 			   
 	   
    }

	public void limpaJogadores() {
		// TODO Auto-generated method stub
		
	}

	public String mostraGanhador() {
		// TODO Auto-generated method stub
		return null;
	}	   
}
