package main;

import javax.swing.JFrame;

public class Frame extends JFrame{
	
	private Panel pan = new Panel();
	static byte  choix = 3;

	public Frame(String nom){
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(nom);
		this.setSize(1140, 582);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setContentPane(pan);
		this.setVisible(true);
	}
	
}
