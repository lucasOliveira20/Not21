package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Mao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8863416118926452372L;
	protected  List<Carta> cartas;
	
	
	public Mao(){
		this.cartas = new ArrayList<Carta>();
	}
	
	public void adicionaCarta(Carta carta){
		this.cartas.add(carta);
	}
	
	public Carta removeCarta(Carta carta){
		return this.cartas.remove(this.cartas.indexOf(carta));
	}
	
	public void limpar() {
		this.cartas.clear();
	}
	
	public List<Carta> getCartas(){
		return this.cartas;
	}
	
	public int calculaValorMao() {
		Carta primeira = cartas.get(0);
		Carta segunda = cartas.get(1);
		Carta terceira = cartas.get(2);
		return primeira.getValor() + segunda.getValor() - terceira.getValor();
	}

}
