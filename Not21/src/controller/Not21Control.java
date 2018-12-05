/**
 * 
 */
package controller;


import java.util.List;

import model.JogadaN21;
import model.Jogador;
import model.Mesa;
import net.AtorNetGames;

public class Not21Control {

	protected Not21ViewControl viewControl;

	protected Mesa mesa;
	
	protected AtorNetGames atorRede;

	public Not21Control() {
		this.viewControl = new Not21ViewControl(this);
		this.atorRede = new AtorNetGames(this,this.viewControl.getView());
		this.mesa = new Mesa();
	}
	
	
	public Not21ViewControl getViewControl() {
		return viewControl;
	}


	public void setViewControl(Not21ViewControl viewControl) {
		this.viewControl = viewControl;
	}


	public Mesa getMesa() {
		return mesa;
	}


	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}


	public AtorNetGames getAtorRede() {
		return atorRede;
	}


	public void setAtorRede(AtorNetGames atorRede) {
		this.atorRede = atorRede;
	}

	public void novoJogo() {
		this.mesa.limpaJogadores();
		int numeroJogadores = 2;

		String nome = null;
		for (int b = 0; b < numeroJogadores; b++) {
			if (b == 0) {
				nome = this.viewControl.getNomeDoJogador(b + 1);
				Jogador jogador = new Jogador(nome, b + 1, this.mesa);
				this.mesa.criarJogador1(jogador);
				this.viewControl.adicionaJogador(jogador);
			} else {
				nome = this.viewControl.getNomeDoJogador(b + 1);
				Jogador jogador = new Jogador(nome, b + 1, this.mesa);
				this.mesa.criarJogador2(jogador);
				this.viewControl.adicionaJogador(jogador);
			}
		}
		
		this.mesa.distribuiCartas();
		this.viewControl.atualizaMaoJogadores();
		procederJogada(null);
	}
	
	
	public void iniciaJogo() {
		this.viewControl.exibeTelaInicial();
	}

	/**
	 * Show the main Menu
	 */
	public void mostraTelaInicial() {
		this.viewControl.exibeTelaInicial();
	}
	
	
	public void iniciarJogo(int nrJogadores){
		this.viewControl.mostraMensagemTela("iniciando jogo");	
		this.atorRede.iniciarPartidaRede(nrJogadores);
	}

	public void procederJogada(JogadaN21 jogada) {
		String resultado = null;
		Jogador jogadorAtual = null;

		jogadorAtual = this.mesa.getJogadorAtual();

			if (jogada.equals(JogadaN21.PEDIR)) {
				jogadorAtual.getCartaDoBaralho();
				jogadorAtual.getCartaDoBaralho();
				jogadorAtual.getCartaDoBaralho();
				
				this.viewControl.atualizaMaoJogadores();
				if(jogadorAtual.isParado()){
					try {
						this.verificaVez();
						this.sincronizaMesa();
						this.habilitaDesabilitaBotoes();
					} catch (Exception e) {
						mostraMensagem(e.getMessage());
						resultado = this.mesa.mostraGanhador();
					}
				}
					mostraMensagemTela(String.format("� a vez de %s!",this.mesa.getJogadorAtual()));
				} 
				else if (jogada.equals(JogadaN21.PARAR)) {

					try {
						mesa.getJogadorAtual().setParado();
						mostraMensagemTela(String.format("� a vez de %s!",this.mesa.getJogadorAtual()));
					} catch (Exception e) {
						mostraMensagem(e.getMessage());
						resultado = this.mesa.mostraGanhador();
					}

			
				if(resultado != null){
					mostraMensagem(resultado);
				}
			}
	}
	public void mostraMensagemTela(String msg){
		this.viewControl.mostraMensagemTela(msg);
	}

	public void mostraMensagem(String msg) {
		this.viewControl.mostraMensagem(msg);
	}

	public void conectar(String nick, String servidor) {
		this.atorRede.conectar(nick, servidor);
		this.atorRede.setNickJogador(nick);
	}

	public void iniciarPartidaRede(int nrJogadores) {

		/*this.mesa.limpaJogadores();

		Jogador jogador = new Jogador(this.atorRede.getNickJogador(),1,this.mesa);
		this.mesa.criarJogador1(jogador);
		this.viewControl.adicionaJogador(jogador);
		
		String nomeAdversario = null;
		
		nomeAdversario = atorRede.obterNomeAdversario();
		
		Jogador adversario = new Jogador(nomeAdversario,2,this.mesa);
		this.mesa.criarJogador2(adversario);
		this.viewControl.adicionaJogador(adversario);
	

		this.mesa.distribuiCartas();
		
		this.atorRede.iniciarPartidaRede(nrJogadores);
		
		this.procederJogada(null);*/
		
		this.mesa.limpaJogadores();

		Jogador jogador = new Jogador(this.atorRede.getNickJogador(),1,this.mesa);
		this.mesa.criarJogador1(jogador);
		this.viewControl.adicionaJogador(jogador);
		
		String nomeAdversario = null;
		
		nomeAdversario = atorRede.obterNomeAdversario();
		
		Jogador adversario = new Jogador(nomeAdversario,2,this.mesa);
		this.mesa.criarJogador2(adversario);
		this.viewControl.adicionaJogador(adversario);
	

		this.mesa.distribuiCartas();
		
		this.atorRede.iniciarPartidaRede(nrJogadores);
		
		this.procederJogada(null);
		
		
	}
	
	public void sincronizaMesa(){
		this.viewControl.sincronizaMesa();
		this.viewControl.atualizaMaoJogadores();
	}


	public void desconectar() {
		this.atorRede.desconectar();
	}

	public void enviaJogadaRede(JogadaN21 jogada) {
		this.atorRede.enviarJogada(jogada);
	}
	public void habilitaDesabilitaBotoes(){
		this.viewControl.habilitaDesabilitaBotoes();
	}
	
	public boolean ehMinhaVez(){
		return this.atorRede.ehMinhaVez();
	}

	public void enviaMensagem(String msg) {
		this.atorRede.enviaMensagem(msg);
	}
	
	public void verificaVez(){
		if(this.atorRede.getNickJogador().equals(this.mesa.getJogadorAtual().getNome()) 
				&& this.mesa.getJogadorAtual().isParado() == true){
			this.atorRede.setMinhaVez(false);
			this.mesa.passaIndependente();
		} else if (this.atorRede.getNickJogador().equals(this.mesa.getJogadorAtual().getNome()) ) {
			this.atorRede.setMinhaVez(true);
		}else{
			this.atorRede.setMinhaVez(false);
		}
	}
	
	public void sair(){
		System.exit(0);
	}
	
}