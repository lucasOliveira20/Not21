package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Baralho {
	
	protected List<Carta> cartas;

	public Baralho(){
		
		this.cartas = new ArrayList<Carta>();
		
		for(Naipe naipe : Naipe.values()){
			for(NumCarta number : NumCarta.values()){
				this.cartas.add(new Carta(naipe,number));
			}
		}
	}

	public Carta getCarta(int indice){
		return this.cartas.get(indice);
	}

	public void setCarta(int indice,Carta carta){
		this.cartas.set(indice, carta);
	}

	public Carta removerCarta(int indice){
		return this.cartas.remove(indice);
	}

	public Carta getCartaTopo() {
	   return this.cartas.remove(0);
	}

	public void embaralhar() {
		Collections.shuffle(cartas);
	}

	public void adicionaCarta(Carta carta) {
	   if(!this.cartas.contains(carta))
	      this.cartas.add(carta);
	}
}
