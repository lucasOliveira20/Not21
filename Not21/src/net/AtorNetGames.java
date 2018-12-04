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
	
	public void setMinhaVez(boolean vez){
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
	
	public void iniciarNovaPartida(Integer posicao) {
		if (posicao == 1){
			ehMinhaVez = true;
			
		}else{
			ehMinhaVez = false;
		}
	}
	
	public void enviarJogada(String mensagem) {
		
		Mensagem msg = new Mensagem(mensagem);
		try {
			proxy.enviaJogada(msg);
			ehMinhaVez = false;
			JOptionPane.showMessageDialog(null, "Jogada Enviada!");
		} catch (NaoJogandoException e) {
			JOptionPane.showMessageDialog(atorJogador, e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void enviarJogada(Jogada jogada){
		
		try {
			proxy.enviaJogada(jogada);
			JOptionPane.showMessageDialog(null, "Jogada Enviada!");
		} catch (NaoJogandoException e) {
			JOptionPane.showMessageDialog(atorJogador, "ERRO: " + e.getMessage());
			e.printStackTrace();
		}
		
		if(jogada instanceof JogadaN21){
			JogadaN21 jbj = (JogadaN21)jogada;
			if(jbj.equals(JogadaN21.PARAR)){
				JOptionPane.showMessageDialog(null, "Jogada Enviada!");
			}
			if(jbj.equals(JogadaN21.PEDIR)){
				JOptionPane.showMessageDialog(null, "Jogada Enviada!");
			}
		}
	}

	@Override
	public void receberJogada(Jogada jogada) {
		if(jogada instanceof Estado){
			Estado estado = (Estado)jogada;
			this.control.setMesa(estado.getMesa());
			this.control.sincronizaMesa();
		}else if(jogada instanceof JogadaN21){
			JogadaN21 jog = (JogadaN21)jogada;
			this.control.procederJogada(jog);
			if(jog.equals(JogadaN21.PARAR)){
				if(nickJogador.equals(this.control.getMesa().getJogadorAtual().getNome())){
					
					ehMinhaVez = false;
					JOptionPane.showMessageDialog(null, "Jogada Recebida!");
				}
				if(jog.equals(JogadaN21.PEDIR)){
					
					ehMinhaVez = true;
					JOptionPane.showMessageDialog(null, "Jogada Recebida!");
					
				}	
				
			}
		}else if(jogada instanceof Mensagem){
			Mensagem msg = (Mensagem)jogada;
			this.control.mostraMensagem(msg.getMensagem());
		}
		
	}
	
	public void desconectar() {
		try {

			int resp = JOptionPane.showConfirmDialog(null, "Deseja desconectar da partida?", "NOT 21", JOptionPane.YES_NO_OPTION);
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
		JOptionPane.showMessageDialog(atorJogador, "A conexão com o servidor foi perdida!");

	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		JOptionPane.showMessageDialog(atorJogador, "Não foi possível iniciar a partida");

	}
	
	public String obterNomeAdversario() {
		return proxy.obterNomeAdversario(2);
	}

	public boolean ehMinhaVez() {
		return ehMinhaVez;
	}

	public void enviaMensagem(String msg) {
		Mensagem mensagem = new Mensagem(nickJogador+" diz: "+msg);
		enviarJogada(mensagem);
	}
	
	public void sincronizaMesa(){
		if(ehMinhaVez){
			Estado estado = new Estado(control.getMesa());
			try {
				proxy.enviaJogada(estado);
			} catch (NaoJogandoException e) {
				JOptionPane.showMessageDialog(atorJogador, e.getMessage());
				e.printStackTrace();
			}
		}
	}


}
