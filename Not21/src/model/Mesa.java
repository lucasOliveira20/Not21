package model;



public class Mesa {
	   
	protected Jogador jogador1;
	protected Jogador jogador2;
	protected Boolean partidaEmAndamento;
	protected Baralho baralho;
	protected int nRodadsJ1;
	protected int nRodadsJ2;

	   public Mesa() {
	      this.jogador1 = new Jogador();
	      this.jogador2 = new Jogador();
	      this.baralho = new Baralho();
	      this.baralho.embaralhar();
	   }
	   
	   public Boolean informaJogadorConectado(Jogador jogador) {
		   return true;
	   }
	   
	   public Boolean informaEmAndamento() {
		   return true;
	   }

	   public Baralho getBaralho() {
	      return this.baralho;
	   }

	   public void setBaralho(Baralho baralho) {
	      this.baralho = baralho;
	   }


	      
	      public void criarJogador(String nome) {
	  		if (jogador1 == null) {
	  			jogador1 = new Jogador();
	  			jogador1.setNome(nome);
	  			jogador1.contRodadas = 0;
	  			jogador1.pontuacao = 0;
	  			jogador1.tomarVez();
	  			
	  		} else if (jogador2 == null) {
	  			jogador2 = new Jogador();
	  			jogador2.setNome(nome);
	  			jogador2.contRodadas = 0;
	  			jogador2.pontuacao = 0;
	  			jogador2.passarVez();
	  		}
	  	}
	   

	   public void distribuiCartas() {
	      
	      
	   }
	   
	   public void esvaziarMesa() {
		      
		      
	   }
	   
	   public void habilitarJogada() {
		      
		      
	   }
	   
	   public Jogador verficaVencedor() throws Exception {
		return jogador1;
	   }
	     
	   public void atualizaPontuacao(Jogador jogador){
	      
	   }
	   
	   
}
