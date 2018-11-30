package model;

public class Jogador {
	
	protected boolean vencedor;
	protected boolean jogadorDavez;
	protected boolean parado;
	protected String nome;
	protected int pontuacao;
	protected int contRodadas;
	protected boolean conectado;
	
	
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	public int getContRodadas() {
		return contRodadas;
	}
	public void setContRodadas(int contRodadas) {
		this.contRodadas = contRodadas;
	}
	public boolean isConectado() {
		return conectado;
	}
	public void setConectado(boolean conectado) {
		this.conectado = conectado;
	}

	public boolean isVencedor() {
		return vencedor;
	}
	public void setVencedor(boolean vencedor) {
		this.vencedor = vencedor;
	}
	public boolean isJogadorDavez() {
		return jogadorDavez;
	}
	public void setJogadorDavez(boolean jogadorDavez) {
		this.jogadorDavez = jogadorDavez;
	}
	public boolean isParado() {
		return parado;
	}
	public void setParado(boolean parado) {
		this.parado = parado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void tomarVez(){
		setJogadorDavez(true);
	}
	
	public void passarVez(){
		setJogadorDavez(false);
	}
	
	
}

