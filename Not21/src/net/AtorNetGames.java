package net;

import java.util.List;

import javax.swing.JOptionPane;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;
import controller.Not21Control;
import model.JogadaN21;
import view.InterfaceNot21;

public class AtorNetGames implements OuvidorProxy {

	private static final long serialVersionUID = 1L;

	private InterfaceNot21 atorJogador;

	private Proxy proxy;

	private boolean ehMinhaVez = false;

	private Not21Control control;

	private String nickJogador;

	public AtorNetGames(Not21Control control, InterfaceNot21 atorJogador) {
		super();
		this.atorJogador = atorJogador;
		this.control = control;
		proxy = Proxy.getInstance();
		proxy.addOuvinte(this);
	}

	public String getNickJogador() {
		return nickJogador;
	}

	public void setNickJogador(String nickJogador) {
		this.nickJogador = nickJogador;
	}

	public void setMinhaVez(boolean vez) {
		this.ehMinhaVez = vez;
	}

	public void conectar(String nome, String servidor) {
		try {
			proxy.conectar(servidor, nome);
		} catch (JahConectadoException e) {
			JOptionPane.showMessageDialog(atorJogador, e.getMessage());
			e.printStackTrace();
		} catch (NaoPossivelConectarException e) {
			JOptionPane.showMessageDialog(atorJogador, e.getMessage());
			e.printStackTrace();
		} catch (ArquivoMultiplayerException e) {
			JOptionPane.showMessageDialog(atorJogador, e.getMessage());
			e.printStackTrace();
		}
	}

	public void iniciarPartidaRede(int nrJogadores) {
		try {
			proxy.iniciarPartida(nrJogadores);
		} catch (NaoConectadoException e) {
			JOptionPane.showMessageDialog(atorJogador, e.getMessage());
			e.printStackTrace();
		}

	}

	/*
	 * @Override public void iniciarNovaPartida(Integer posicao) {
	 * control.iniciarPartidaRede(posicao == 1); }
	 */
	public void iniciarNovaPartida(Integer posicao) {
		if (posicao == 1) {
			ehMinhaVez = true;

		} else {
			ehMinhaVez = false;
		}
	}

	/*
	 * public void enviarJogada(String mensagem) {
	 * 
	 * Mensagem msg = new Mensagem(mensagem); try { proxy.enviaJogada(msg);
	 * JOptionPane.showMessageDialog(null, "Jogada Enviada!"); } catch
	 * (NaoJogandoException e) { JOptionPane.showMessageDialog(atorJogador,
	 * e.getMessage()); e.printStackTrace(); } }
	 */
	public void enviarJogada(Estado jogada) {

		try {
			proxy.enviaJogada(jogada);
			JOptionPane.showMessageDialog(null, "Jogada Enviada (proxy, ator netgames) ln 103!");
		} catch (NaoJogandoException e) {
			JOptionPane.showMessageDialog(atorJogador, "ERRO: " + e.getMessage());
			e.printStackTrace();
		}

	}

	
	public void receberJogada(Estado jogada) {
		if (jogada instanceof Estado) {
			Estado estado = (Estado)jogada;
			this.control.setMesa(estado.getMesa());
			control.recebeJogada(jogada);
		}
//		} else if (jogada instanceof Mensagem) {
//			Mensagem msg = (Mensagem) jogada;
//			this.control.mostraMensagem(msg.getMensagem());
//		}

	}

	public void desconectar() {
		try {

			int resp = JOptionPane.showConfirmDialog(null, "Deseja desconectar da partida?", "NOT 21",
					JOptionPane.YES_NO_OPTION);
			if (resp == JOptionPane.YES_OPTION) {
				proxy.desconectar();
			}

		} catch (NaoConectadoException e) {
			JOptionPane.showMessageDialog(atorJogador, e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void finalizarPartidaComErro(String message) {
		JOptionPane.showMessageDialog(atorJogador, message);

	}

	@Override
	public void receberMensagem(String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tratarConexaoPerdida() {
		JOptionPane.showMessageDialog(atorJogador, "A conex�o com o servidor foi perdida!");

	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		JOptionPane.showMessageDialog(atorJogador, "N�o foi poss�vel iniciar a partida");

	}

	public List<String> obterNomeAdversarios() {
		return proxy.obterNomeAdversarios();
	}

	// public String obterNomeAdversario() {
	// return proxy.obterNomeAdversario(1);
	// }

	public boolean ehMinhaVez() {
		return ehMinhaVez;
	}

//	public void enviaMensagem(String msg) {
//		Mensagem mensagem = new Mensagem(nickJogador + " diz: " + msg);
//		enviarJogada(msg);
//	}

	public void sincronizaMesa() {
		if (ehMinhaVez) {
			Estado estado = new Estado(control.getMesa());
			try {
				proxy.enviaJogada(estado);
			} catch (NaoJogandoException e) {
				JOptionPane.showMessageDialog(atorJogador, e.getMessage());
				e.printStackTrace();
			}
		}
	}

	@Override
	public void receberJogada(Jogada jogada) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void receberJogada(Jogada jogada) {
//		// TODO Auto-generated method stub
//		
//	}

}
