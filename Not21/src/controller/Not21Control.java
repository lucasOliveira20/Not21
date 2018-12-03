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

		String nome = null;//this.viewControl.getNomeDoJogador(1);
		for (int b = 0; b < numeroJogadores; b++) {
			nome = this.viewControl.getNomeDoJogador(b + 1);
			Jogador jogador = new Jogador(nome, b + 1, this.mesa);
			this.mesa.criarJogador(jogador);
			this.viewControl.adicionaJogador(jogador);
		}
		
		this.mesa.distribuiCartas();

		procederJogada(null);
	}
	
	
	public void iniciarJogo(int nrJogadores){
		this.viewControl.mostraMensagemTela("iniciando jogo");
		
		
		this.atorRede.iniciarPartidaRede();
	}

	public void procederJogada(JogadaN21 jogada) {
		String resultado = null;
		Jogador jogadorAtual = null;

		jogadorAtual = this.mesa.getJogadorAtual();

			if (jogada.equals(JogadaN21.PEDIR)) {
				jogadorAtual.getCartaDoBaralho();
				

				if(jogadorAtual.isParado()){
					try {
						this.verificaVez();
						
						this.habilitaDesabilitaBotoes();
					} catch (Exception e) {
						mostraMensagem(e.getMessage());
						resultado = this.mesa.mostraGanhador();
					}
				}
					mostraMensagemTela(String.format("É a vez de %s!",this.mesa.getJogadorAtual()));
				} 
				else if (jogada.equals(JogadaN21.PARAR)) {

					try {
						jogadorAtual.setParado();
						mostraMensagemTela(String.format("É a vez de %s!",this.mesa.getJogadorAtual()));
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

		this.mesa.limpaJogadores();

		Jogador jogador1 = new Jogador(this.atorRede.getNickJogador()+"",1,this.mesa);
		this.mesa.criarJogador(jogador1);
		this.viewControl.adicionaJogador(jogador1);
		
		if(nrJogadores == 1)
			mostraMensagem("Aguardando outro jogador");
		String nomeAdversario = atorRede.obterNomeAdversario();

		Jogador jogador2 = new Jogador(nomeAdversario,2,this.mesa);
		this.mesa.criarJogador(jogador2);
		this.viewControl.adicionaJogador(jogador2);

		this.mesa.distribuiCartas();
		this.procederJogada(null);
		this.atorRede.iniciarPartidaRede();
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
		if(this.atorRede.getNickJogador().equals(this.mesa.getJogadorAtual().getNome())){
			this.atorRede.setMinhaVez(true);
		}else{
			this.atorRede.setMinhaVez(false);
		}
	}
	
	public void sair(){
		System.exit(0);
	}
	
}
