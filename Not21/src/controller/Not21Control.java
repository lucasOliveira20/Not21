/**
 * 
 */
package controller;

import java.net.PasswordAuthentication;
import java.util.List;

import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;

import model.JogadaN21;
import model.Jogador;
import model.Mesa;
import net.AtorNetGames;
import net.Estado;
import view.InterfaceNot21;

public class Not21Control {

	protected Not21ViewControl viewControl;

	protected Mesa mesa;
	protected InterfaceNot21 interfaceNot21;
	protected AtorNetGames atorRede;

	public Not21Control() {
		this.viewControl = new Not21ViewControl(this);
		this.atorRede = new AtorNetGames(this, this.viewControl.getView());
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
				Jogador jogador = new Jogador(nome, b + 1);
				this.mesa.criarJogador1(jogador);
				this.viewControl.adicionaJogador(jogador);
			} else {
				nome = this.viewControl.getNomeDoJogador(b + 1);
				Jogador jogador = new Jogador(nome, b + 1);
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

	public void iniciarJogo(int nrJogadores) {
		this.viewControl.mostraMensagemTela("iniciando jogo");
		this.atorRede.iniciarPartidaRede(nrJogadores);
	}

	public void procederLance(Estado jogada) {
		String resultado = null;
		Jogador jogadorAtual = this.mesa.getJogadorAtual();

	}

	public void procederJogada(String jogada) {
		String resultado = null;
		Jogador jogadorAtual = this.mesa.getJogadorAtual();

		String opcao = jogada;
		Estado estado = new Estado(mesa);
		if (!jogadorAtual.isParado()) {
			if (opcao == "parar") {
				jogadorAtual.setParado();
				this.mesa.passaIndependente();
				estado.setMesa(this.mesa);
				enviaJogadaRede(estado);
			}
			if (opcao == "pedir") {
				jogadorAtual.jogadorPediu();
				this.mesa.getCartaDoBaralho();
				this.mesa.getCartaDoBaralho();
				this.mesa.getCartaDoBaralho();
				this.mesa.passaIndependente();
				enviaJogadaRede(estado);
				this.viewControl.atualizaMaoJogadores();
			}

		} else {
			this.mesa.passaIndependente();
			
		}
	}

	public void mostraMensagemTela(String msg) {
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
		String nomeAdversario = null;
		List<String> nomes = atorRede.obterNomeAdversarios();
		if (nomes.get(0) == this.atorRede.getNickJogador()) {
			nomeAdversario = nomes.get(1);
		} else {
			nomeAdversario = nomes.get(0);
		}

		Jogador jogador = new Jogador(this.atorRede.getNickJogador(), 1);
		Jogador adversario = new Jogador(nomeAdversario, 2);

		this.mesa.criarJogador1(jogador);
		this.mesa.criarJogador2(adversario);

		this.viewControl.adicionaJogador(jogador);
		this.viewControl.adicionaJogador(adversario);

		this.atorRede.iniciarPartidaRede(nrJogadores);
		mesa.distribuiCartas();
		
		this.procederJogada(null);
		Estado estado = new Estado(this.mesa);		
		enviaJogadaRede(estado);
		viewControl.atualizaMaoJogadores();
		
		//sincronizaMesa();
	}

	public void recebeJogada(Estado estado) {
		habilitaDesabilitaBotoes();
		this.mesa= estado.getMesa();
		this.mesa.getJogadorAtual();
		//viewControl.atualizaMaoJogadores();
		mesa.condicaoVitoria();
		
		
	}

	public void sincronizaMesa() {
		this.viewControl.sincronizaMesa();
		//this.viewControl.atualizaMaoJogadores();
	}

	public void desconectar() {
		this.atorRede.desconectar();
	}

	public void enviaJogadaRede(Estado jogada) {
		this.atorRede.enviarJogada(jogada);
	}

	public void habilitaDesabilitaBotoes() {
		this.viewControl.habilitaDesabilitaBotoes();
	}

	public boolean ehMinhaVez() {
		return this.atorRede.ehMinhaVez();
	}

//	public void enviaMensagem(String msg) {
//		this.atorRede.enviaMensagem(msg);
//	}

	public void verificaVez() {
		if (this.atorRede.getNickJogador().equals(this.mesa.getJogadorAtual().getNome())
				&& this.mesa.getJogadorAtual().isParado() == true) {
			this.atorRede.setMinhaVez(false);
			this.mesa.passaIndependente();
		} else if (this.atorRede.getNickJogador().equals(this.mesa.getJogadorAtual().getNome())) {
			this.atorRede.setMinhaVez(true);
		} else {
			this.atorRede.setMinhaVez(false);
		}
	}

	public void sair() {
		System.exit(0);
	}

}
