package model;

import java.io.Serializable;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Carta implements Jogada {

	private static final long serialVersionUID = 2598540039678509964L;

	protected Naipe idNipe;

	protected NumCarta idCarta;

	public Carta(Naipe naipe, NumCarta numero) {
		this.idNipe = naipe;
		this.idCarta = numero;
	}

	public Naipe getNaipe() {
		return this.idNipe;
	}

	public void setNaipe(Naipe naipe) {
		this.idNipe = naipe;
	}

	NumCarta getNumero() {
		return this.idCarta;
	}

	public void setNumero(NumCarta numero) {
		this.idCarta = numero;
	}

	public String toString() {
		return this.idCarta.toString() + this.idNipe.toString();
	}

	public int getValor() {
		return this.idCarta.getValor();
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Carta other = (Carta) obj;
		if (this.idCarta == null) {
			if (other.idCarta != null)
				return false;
		} else if (!this.idCarta.equals(other.idCarta))
			return false;
		if (this.idNipe == null) {
			if (other.idNipe != null)
				return false;
		} else if (!this.idNipe.equals(other.idNipe))
			return false;
		return true;
	}
}
