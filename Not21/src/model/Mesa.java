package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
      this.vencedor = null;
      
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
    
	public void avaliaVencedor(List<Jogador> jogadores) {
		int j1 = jogadores.get(0).distanciaMult();
		int j2 = jogadores.get(1).distanciaMult();

		if (j1 != 0 && j2 != 0) {

			if (j1 < j2) {
				setVencedor(jogadores.get(0));
				JOptionPane.showMessageDialog(null, String.format("O 2%d ganhou", jogadores.get(0).getNome()));
			} else if (j1 == j2) {
				if (jogadores.get(0).getValorDaMao() > jogadores.get(1).getValorDaMao()) {
					setVencedor(jogadores.get(0));
					JOptionPane.showMessageDialog(null, String.format("O 2%d ganhou", jogadores.get(0).getNome()));
				} else {
					setVencedor(jogadores.get(1));
					JOptionPane.showMessageDialog(null, String.format("O 2%d ganhou", jogadores.get(1).getNome()));
				}
			} else {
				setVencedor(jogadores.get(1));
				JOptionPane.showMessageDialog(null, String.format("O 2%d ganhou", jogadores.get(1).getNome()));
			}

		} else if (j1 == 0 && j2 != 0) {
			setVencedor(jogadores.get(1));
			JOptionPane.showMessageDialog(null, String.format("O 2%d ganhou", jogadores.get(1).getNome()));
		} else if (j1 != 0 && j2 == 0) {
			setVencedor(jogadores.get(0));
			JOptionPane.showMessageDialog(null, String.format("O 2%d ganhou", jogadores.get(0).getNome()));

		} else {
			JOptionPane.showMessageDialog(null, "Algo deu errado");
		}
	}

	public boolean condicaoVitoria() {
		int pJ1 = jogadores.get(0).getPediu();
		boolean j1Parado = jogadores.get(0).isParado();
		int pJ2 = jogadores.get(1).getPediu();
		boolean j2Parado = jogadores.get(1).isParado();
		if (pJ1 >= 5 && pJ2 >= 5 || pJ1 >= 5 && j2Parado == true || j1Parado == true && pJ2 >= 5
				|| j1Parado == true && j2Parado == true) {
			avaliaVencedor(jogadores);
			return true;
		} else {
			return false;
		}
	}
	
	public int getNumeroJogadoresAtivos() {
		int cont = 0;
		for (Jogador player : jogadores) {
			if (!player.isParado())
				cont++;
		}
		return cont;
	}
	
	public void setTodosJogadoresAtivos() {

		for (Jogador j : this.jogadores) {
			j.setAtivo();
		}
	}

	public void limpaJogadores() {
		this.jogadores.clear();		
	}

	public String mostraGanhador() {
		return getVencedor().getNome();
	}	   
}
