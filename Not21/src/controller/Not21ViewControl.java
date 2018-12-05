package controller;

import model.JogadaN21;
import model.Jogador;
import view.InterfaceNot21;

public class Not21ViewControl {
	
	private InterfaceNot21 view;
   
   	private Not21Control control;
   

   	public Not21ViewControl(Not21Control control) {
	   this.control = control;
       view = new InterfaceNot21(this);
   	}
   
   	public InterfaceNot21 getView() {
	return view;
	}

	public void setView(InterfaceNot21 view) {
		this.view = view;
	}

	public Not21Control getControl() {
		return control;
	}

	public void setControl(Not21Control control) {
		this.control = control;
	}
	
	public void exibeTelaInicial() {
	      this.view.setLocationRelativeTo(null);
	      this.view.setVisible(true);
	      this.view.mostraTelaInicial();
	}
	
	
 
   public void adicionaJogador(Jogador jogador){
	   this.view.criar(jogador);
   }
   
   public void atualizaMaoJogadores(){
	   this.view.atualizaMaoJ1();
	   this.view.atualizaMaoJ2();
   }
   
   public void sair(){
	   this.control.sair();
   }

   public String getNomeDoJogador(int numero){
      return this.view.getNomeDoJogador(numero);
   }

   public void mostraMensagem(String msg) {
      this.view.mostraMensagem(msg);
   }
	   
	public void novoJogo() {
		this.control.novoJogo();
	}
	public void procederLance(JogadaN21 jogada){
		this.control.procederJogada(jogada);
	}
	public void mostraMensagemTela(String msg){
		this.view.mostraMensagem(msg);
	}

	public void conectar(String nick, String servidor) {
		this.control.conectar(nick,servidor);
	}

	public void iniciarPartidaRede(int nrJogadores) {
		this.control.iniciarPartidaRede(nrJogadores);
	}
	
	public boolean ehMinhaVez(){
		return this.control.ehMinhaVez();
	}
	
	public void sincronizaMesa(){
		this.view.sincronizaMesa(this.control.getMesa());
	}

	public void desconectar() {
		this.control.desconectar();
	}

	public void enviaJogadaRede(JogadaN21 jogada) {
		this.control.enviaJogadaRede(jogada);
	}

	public void habilitaDesabilitaBotoes() {
		this.view.habilitaDesabilitaBotoes();
	}

	public void enviaMensagem(String msg) {
		this.control.enviaMensagem(msg);
	}
	
	

}