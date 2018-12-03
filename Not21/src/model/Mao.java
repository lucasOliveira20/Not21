package model;

import java.util.ArrayList;
import java.util.List;

public class Mao {
	
	protected Carta[] cartas;
	private int posCarta=0;
	
	public Mao(){
		this.cartas = new Carta[3];
	}
	
	public void adicionaCarta(Carta carta){
		this.cartas[posCarta] = carta;
		posCarta++;
		posCarta = posCarta % 3;
	}
	
	public void limpar() {
		for(int i =0;i<3;i++) {
			   cartas[i] =null;
		}
	}
	
	public int calculaValorMao() {
		Carta primeira = cartas[0];
		Carta segunda = cartas[1];
		Carta terceira = cartas[2];
		return primeira.getValor() + segunda.getValor() - terceira.getValor();
	}

}
