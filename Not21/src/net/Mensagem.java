package net;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Mensagem implements Jogada {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6179798086984028434L;
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public Mensagem(String mensagem) {
		super();
		this.mensagem = mensagem;
	}
}
