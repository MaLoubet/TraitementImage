package main;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class parcours extends JFileChooser{

	int retour = this.showOpenDialog(null);
	public parcours(){
		if(retour==JFileChooser.APPROVE_OPTION){
		  Panel.myImg = new ImageIcon(this.getSelectedFile().
		          		getAbsolutePath());
		  Panel.mode = 2;
	}
	}
}
