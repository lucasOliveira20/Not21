package net;

import javax.swing.JOptionPane;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;
import view.InterfaceNot21;

public class AtorNetGames implements OuvidorProxy {

	private InterfaceNot21 atorJogador;
	
	private Proxy proxy;
	
	private boolean ehMinhaVez = false;
	
	public AtorNetGames(InterfaceNot21 atorJogador) {
		super();
		this.atorJogador = atorJogador;
		proxy = Proxy.getInstance();
	}
	
	public void conectar(String nome, String servidor) {
		try {
			proxy.conectar(servidor, nome);
		} catch (JahConectadoException e) {
			JOptionPane.showMessageDialog(atorJogador.getFrame(), e.getMessage());
			e.printStackTrace();
		} catch (NaoPossivelConectarException e) {
			JOptionPane.showMessageDialog(atorJogador.getFrame(), e.getMessage());
			e.printStackTrace();
		} catch (ArquivoMultiplayerException e) {
			JOptionPane.showMessageDialog(atorJogador.getFrame(), e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public void iniciarPartidaRede() {
		try {
			proxy.iniciarPartida(2);
		} catch (NaoConectadoException e) {
			JOptionPane.showMessageDialog(atorJogador.getFrame(), e.getMessage());
			e.printStackTrace();
		}

	}
	
	public void enviarJogada(String mensagem) {
		
		Mensagem msg = new Mensagem(mensagem);
		try {
			proxy.enviaJogada(msg);
			ehMinhaVez = false;
		} catch (NaoJogandoException e) {
			JOptionPane.showMessageDialog(atorJogador.getFrame(), e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void receberJogada(Jogada jogada) {
		Mensagem msg = (Mensagem) jogada;
		ehMinhaVez = true;
		atorJogador.receberMensagemRede(msg.getMensagem());

	}
	
	public void desconectar() {
		try {
			proxy.desconectar();
		} catch (NaoConectadoException e) {
			JOptionPane.showMessageDialog(atorJogador.getFrame(), e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public void iniciarNovaPartida(Integer posicao) {
		
		if (posicao == 1){
			ehMinhaVez = true;
		}else if (posicao == 2){
			ehMinhaVez = false;
		}
		atorJogador.iniciarPartidaRede(ehMinhaVez);

	}

	@Override
	public void finalizarPartidaComErro(String message) {
		JOptionPane.showMessageDialog(atorJogador.getFrame(), message);

	}

	@Override
	public void receberMensagem(String msg) {
		// TODO Auto-generated method stub

	}


	@Override
	public void tratarConexaoPerdida() {
		JOptionPane.showMessageDialog(atorJogador.getFrame(), "A conexão com o servidor foi perdida!");

	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		JOptionPane.showMessageDialog(atorJogador.getFrame(), "Não foi possível iniciar a partida");

	}
	
	public String obterNomeAdversario() {
		String nome = "";
		if (ehMinhaVez){
			nome = proxy.obterNomeAdversario(2);
		}else{
			nome = proxy.obterNomeAdversario(1);
		}
		
		return nome;
	}

	public boolean ehMinhaVez() {
		return ehMinhaVez;
	}

}
