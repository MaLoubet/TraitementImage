package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Retour extends JButton implements MouseListener {

	public Retour(String nom){
		
		super(nom);
		this.addMouseListener(this);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		Panel.choix1 = false;
		Panel.choix2 = false;
		Panel.choix3 = false;
		Panel.choix4 = false;
		Panel.choix5 = false;
		Panel.choix6 = false;
		Panel.mode = 1;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
