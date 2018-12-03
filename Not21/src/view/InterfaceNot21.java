package view;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import controller.Not21ViewControl;
import model.Jogador;
import model.Mesa;
import net.AtorNetGames;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfaceNot21 extends JFrame {
	
	AtorNetGames atorRede;
	Mesa mesa;
	private Not21ViewControl controle;
	private String nome = "";

	private JPanel contentPane;
	
	public static final int INFORMACAO = INFORMATION_MESSAGE;
	public static final String TITULO_JANELA = "NOT21";
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public InterfaceNot21() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(70, 25, 1131, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 100, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel btnReiniciar = new JLabel("Reiniciar");
		btnReiniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnReiniciar.setHorizontalAlignment(SwingConstants.CENTER);
		btnReiniciar.setForeground(Color.WHITE);
		btnReiniciar.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnReiniciar.setBounds(559, 555, 63, 84);
		contentPane.add(btnReiniciar);
		
		JLabel btnDesconectar = new JLabel("Desconectar");
		btnDesconectar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InterfaceNot21.this.atorRede.desconectar();
			}
		});
		btnDesconectar.setHorizontalAlignment(SwingConstants.CENTER);
		btnDesconectar.setForeground(Color.WHITE);
		btnDesconectar.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnDesconectar.setBounds(648, 541, 74, 98);
		contentPane.add(btnDesconectar);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.BLACK);
		label.setIcon(new ImageIcon("C:\\Users\\Lucas\\Desktop\\APS\\principal1.png"));
		label.setBounds(549, 541, 183, 109);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(34, 139, 34));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 431, 360);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnC = new JButton("C1");
		btnC.setBounds(10, 93, 114, 24);
		panel.add(btnC);
		btnC.setFont(new Font("Agency FB", Font.PLAIN, 18));
		btnC.setBackground(Color.WHITE);
		
		JButton btnC_1 = new JButton("C2");
		btnC_1.setBounds(152, 93, 114, 23);
		panel.add(btnC_1);
		btnC_1.setFont(new Font("Agency FB", Font.PLAIN, 18));
		btnC_1.setBackground(Color.WHITE);
		
		JButton btnCounter = new JButton("COUNTER");
		btnCounter.setBounds(295, 93, 114, 23);
		panel.add(btnCounter);
		btnCounter.setFont(new Font("Agency FB", Font.PLAIN, 18));
		btnCounter.setBackground(Color.WHITE);
		
		JLabel lblC3J1 = new JLabel("");
		lblC3J1.setBounds(295, 117, 114, 156);
		panel.add(lblC3J1);
		lblC3J1.setIcon(new ImageIcon("C:\\Users\\Lucas\\Desktop\\APS\\Not21\\imagens\\Default\\Default.jpg"));
		
		JLabel lblJogador = new JLabel("Jogador 1");
		lblJogador.setBounds(10, 11, 114, 56);
		panel.add(lblJogador);
		lblJogador.setForeground(Color.WHITE);
		lblJogador.setFont(new Font("Agency FB", Font.PLAIN, 38));
		
		JLabel lblC2J1 = new JLabel("");
		lblC2J1.setIcon(new ImageIcon("C:\\Users\\Lucas\\Desktop\\APS\\Not21\\imagens\\Default\\Default.jpg"));
		lblC2J1.setBounds(152, 117, 114, 156);
		panel.add(lblC2J1);
		
		JLabel lblC1J1 = new JLabel("");
		lblC1J1.setIcon(new ImageIcon("C:\\Users\\Lucas\\Desktop\\APS\\Not21\\imagens\\Default\\Default.jpg"));
		lblC1J1.setBounds(10, 117, 114, 156);
		panel.add(lblC1J1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(34, 139, 34));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(660, 11, 443, 360);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblJogador_1 = new JLabel("Jogador 2");
		lblJogador_1.setBounds(315, 11, 115, 46);
		panel_1.add(lblJogador_1);
		lblJogador_1.setForeground(Color.WHITE);
		lblJogador_1.setFont(new Font("Agency FB", Font.PLAIN, 38));
		
		JButton btnCounter_1 = new JButton("COUNTER");
		btnCounter_1.setBounds(295, 91, 114, 23);
		panel_1.add(btnCounter_1);
		btnCounter_1.setFont(new Font("Agency FB", Font.PLAIN, 18));
		btnCounter_1.setBackground(Color.WHITE);
		
		JButton button_1 = new JButton("C2");
		button_1.setBounds(152, 91, 114, 23);
		panel_1.add(button_1);
		button_1.setFont(new Font("Agency FB", Font.PLAIN, 18));
		button_1.setBackground(Color.WHITE);
		
		JButton button = new JButton("C1");
		button.setBounds(10, 91, 114, 24);
		panel_1.add(button);
		button.setFont(new Font("Agency FB", Font.PLAIN, 18));
		button.setBackground(Color.WHITE);
		
		JLabel lblC1J2 = new JLabel("");
		lblC1J2.setIcon(new ImageIcon("C:\\Users\\Lucas\\Desktop\\APS\\Not21\\imagens\\Default\\Default.jpg"));
		lblC1J2.setBounds(10, 115, 114, 156);
		panel_1.add(lblC1J2);
		
		JLabel lblC2J2 = new JLabel("");
		lblC2J2.setIcon(new ImageIcon("C:\\Users\\Lucas\\Desktop\\APS\\Not21\\imagens\\Default\\Default.jpg"));
		lblC2J2.setBounds(152, 115, 114, 156);
		panel_1.add(lblC2J2);
		
		JLabel lblC3J2 = new JLabel("");
		lblC3J2.setIcon(new ImageIcon("C:\\Users\\Lucas\\Desktop\\APS\\Not21\\imagens\\Default\\Default.jpg"));
		lblC3J2.setBounds(295, 115, 114, 156);
		panel_1.add(lblC3J2);
		
		JLabel lblConectar = new JLabel("Conectar");
		lblConectar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nome = JOptionPane.showInputDialog(null, "Escolha o nome do participante");
				atorRede.conectar(nome, "localhost");
				InterfaceNot21.this.atorRede.iniciarPartidaRede();
				
			}
		});
		lblConectar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConectar.setForeground(Color.WHITE);
		lblConectar.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblConectar.setBounds(391, 555, 74, 84);
		contentPane.add(lblConectar);
		
		JLabel lblIniciar = new JLabel("    Iniciar");
		lblIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		lblIniciar.setForeground(Color.WHITE);
		lblIniciar.setFont(new Font("Agency FB", Font.PLAIN, 20));
		lblIniciar.setBounds(475, 551, 74, 92);
		contentPane.add(lblIniciar);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Lucas\\Desktop\\APS\\principal1 - Copia.png"));
		label_1.setForeground(Color.BLACK);
		label_1.setBounds(383, 541, 183, 109);
		contentPane.add(label_1);
		
		JLabel lblDeckJogador2 = new JLabel("");
		lblDeckJogador2.setBounds(451, 11, 199, 290);
		contentPane.add(lblDeckJogador2);
		lblDeckJogador2.setIcon(new ImageIcon("C:\\Users\\Lucas\\Desktop\\APS\\Not21\\imagens\\Default\\DefaultM.jpg"));
		
		JButton btnNovaMao = new JButton("Nova M\u00E3o");
		btnNovaMao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNovaMao.setBounds(451, 312, 199, 23);
		contentPane.add(btnNovaMao);
		btnNovaMao.setBackground(SystemColor.text);
		btnNovaMao.setFont(new Font("Agency FB", Font.PLAIN, 18));
		
		JButton btnParar = new JButton("Parar");
		btnParar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnParar.setBounds(451, 348, 199, 23);
		contentPane.add(btnParar);
		btnParar.setBackground(SystemColor.text);
		btnParar.setFont(new Font("Agency FB", Font.PLAIN, 18));
		
		
		
	}
	

	public void habilitaDesabilitaBotoes(){
		boolean minhaVez = this.controle.ehMinhaVez();
		//btnNovaMao.setEnabled(minhaVez);
		//btnParar.setEnabled(minhaVez);
	}
	
	public JFrame getFrame() {
		return this.getFrame();
	}

	

	

	public void receberMensagemRede(String mensagem) {
		// TODO Auto-generated method stub
		
	}


	public void mostraMensagemTela(String msg) {
		//this.lblMsgTela.setText(msg);
		
	}
	
	public void mostraMensagem(String msg){
		this.mostraMensagem(msg,INFORMACAO);
	}

	private void mostraMensagem(String msg, int tipoMensagem) {
		showMessageDialog(this, msg,TITULO_JANELA,tipoMensagem);
	}

	public String getNomeDoJogador(int numero) {
		return showInputDialog(this,"Digite o nome do jogador "+numero+": ",TITULO_JANELA,QUESTION_MESSAGE);
	}

	public void atualizaMaoJogadores() {
		// TODO Auto-generated method stub
		
	}

	public void criar(Jogador jogador) {
		// TODO Auto-generated method stub
		
	}
	
	public void confirmaSaida(){
		int result = showConfirmDialog(this, "Deseja mesmo sair?",TITULO_JANELA,YES_NO_OPTION);
		if(result == 0)
			this.controle.sair();
	}
	

	public void conectar(){
		String nick = showInputDialog(this,"Digite seu nick: ",TITULO_JANELA,QUESTION_MESSAGE);
		String servidor = showInputDialog(this,"Digite o servidor: ",TITULO_JANELA,QUESTION_MESSAGE);
		this.controle.conectar(nick,servidor);
	}
	public void desconectar(){
		this.controle.desconectar();
	}
	public void sincronizaMesa(Mesa mesa){
		
		for(Jogador jogador : mesa.getJogadores()){
			adicionaJogador(jogador);
		}
		
		System.gc();
		habilitaDesabilitaBotoes();
	}
	
	private void adicionaJogador(Jogador jogador) {
		// TODO Auto-generated method stub
		
	}

	
	public void enviaJogadaRede(String jogada){
		this.controle.enviaJogadaRede(jogada);
	}
	
	public void mostraRegras(){
		String regras = 
			":::::::::::::::::::::::::::::Not 21:::::::::::::::::::::::::::::\n"+
			"Este jogo é uma versão simplificada do jogo Blackjack (ou 21).\n" +
			"O objetivo do jogo, é conseguir a pontuação mais alta, que todos,\n" +
			"porém, inferior a 21. Caso o jogador ultrapasse 21 pontos, ele\n" +
			"estará fora! Existem 2 tipos de combinações que valem mais que 21 pontos.\n" +
			"-Blackjack:\n" +
			"  O jogador possui apenas 1 Ás preto e 1 Valete preto.\n" +
			"-Cinco Cartas Charlie:\n" +
			"  O jogador possui cinco cartas na mão, mas sem ultrapassar 21 pontos.\n\n" +
			"Pontuação das Cartas:\n" +
			"-ÁS: 1 ou 11 (o que melhor for para o jogador).\n" +
			"-Cartas de 1 a 10, valem o próprio número.\n" +
			"-Rei, Dama e Valete valem 10 pontos.";
		mostraMensagem(regras);
	}
}
	
	

	
