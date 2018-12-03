package model;

import java.util.List;

public class Jogador {
	
	protected String nome;

	protected int numero;

	protected Mao mao;

	protected Mesa mesa;
	
	protected int nRodads;
	
	protected int pediu;
	
	protected boolean parado = false;

	public int getnRodads() {
		return nRodads;
	}

	public void setnRodads(int nRodads) {
		this.nRodads = nRodads;
	}

	

	public Jogador(String nome, int numero, Mesa mesa) {
		this.nome = nome;
		this.numero = numero;
		this.mesa = mesa;
		this.mao = new Mao();
		this.nRodads = 0;
		this.pediu = 0;
	}

	public String getCartaDoBaralho() {
		Carta carta = this.mesa.getBaralho().getCartaTopo();
		this.mao.adicionaCarta(carta);
		return String.format("%s pega a carta %s!", this.nome, carta);
	}

	public int getValorDaMao() {
		return mao.calculaValorMao();
	}

	public void limparMao() {
		this.mao.limpar();
	}

	public String toString() {
		return String.format("Jogador %s", this.nome);
	}

	public void setParado() {
		this.parado = true;
	}

	public boolean isParado() {
		return this.parado;
	}

	public String getNome() {
		return nome;
	}
	
	public int getNumero() {
		return numero;
	}

	public void addNRodads() {
		int nRodads = getnRodads();
		nRodads ++;
		setnRodads(nRodads);	
	}
	
	 public int distanciaMult() {
		   
		int pontos = this.getValorDaMao();
		int aux = 0;
		int temp = 0;
		aux = pontos % 21;

		if (aux != 0) {
			temp = aux;
			aux = aux - 21;
			if (Math.abs(aux) < temp) {
				return Math.abs(aux);
			} else {
			return temp;
			}
		} else {
			return 0;
		}
	}
	 
	 public void jogadorPediu() {
	 	pediu++;
	 }
	 
	 public int getPediu() {
	 	return pediu;
	 }
	 
	
}

