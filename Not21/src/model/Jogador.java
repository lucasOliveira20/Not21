package model;

import java.io.Serializable;
import java.util.List;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Jogador implements Jogada{
	
	private static final long serialVersionUID = 5836112280495926118L;

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

	
	public Carta[] getMan() {
		return mao.getManeta();
	}
	
	public String getCartaDoBaralho() {
		Carta carta = this.mesa.getBaralho().getCartaTopo();
		this.mao.adicionaCarta(carta);
		return String.format("%s pega a carta %s!", this.nome, carta);
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
	
	public void setAtivo() {
		this.parado = false;
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
	 
	 public int getValorDaMao() {
		int i = 0;
		int diminui = 0;
		int soma = 0;
		int valor = 0;
		for (Carta carta : this.mao.getCartas()) {
			i++;
			if (i % 3 == 0) {
				diminui = diminui + carta.getValor();
				System.out.println("uma carta para diminuir");
			} else {
				soma = soma + carta.getValor();
				System.out.println("uma carta para somar");
			}

		}
		valor = soma - diminui;
		if (valor < 0) {
			valor = 0;
		}

		return valor;
	}
	 	
}

