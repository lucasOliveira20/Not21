package model;

import java.util.ArrayList;
import java.util.List;
;

public class Mao {
	
	private List<Carta> cartas;
	
	public Mao(){
		this.cartas = new ArrayList<Carta>();
	}
	
	public void adicionaCarta(Carta carta){
		this.cartas.add(carta);
	}
	
	public Carta removeCarta(Carta carta){
		return this.cartas.remove(this.cartas.indexOf(carta));
	}
	
	public List<Carta> getCartas(){
		return this.cartas;
	}
	
	public void limpar() {
	   this.cartas.clear();
	}

}
