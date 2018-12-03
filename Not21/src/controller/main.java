package controller;

import java.awt.EventQueue;

public class main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				Not21Control control = new Not21Control();
				control.iniciaJogo();
			}
		});
	}

}
