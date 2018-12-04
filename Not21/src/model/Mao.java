package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Mao implements Jogada {
	
	private static final long serialVersionUID = 8863416118926452372L;
	
	
	protected  List<Carta> cartas;
	protected Carta[] maneta;
	protected int posCarta;
	
	public Mao(){
		this.cartas = new ArrayList<Carta>();
		this.maneta = new Carta[3];
		this.posCarta = 0;
	}
	
	public void adicionaCarta(Carta carta){
		this.cartas.add(carta);
		maneta[posCarta] = carta;
		posCarta++;
		posCarta = posCarta %3;		
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
	
}
