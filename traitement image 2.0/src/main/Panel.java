package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panel extends JPanel implements MouseListener{
	
	parcourir par = new parcourir("Parcourir...");
	Bouton1 bt1 = new Bouton1("Flammes ou rien");
	Bouton2 bt2 = new Bouton2("Noir et blanc");
	Bouton3 bt3 = new Bouton3("Transparence");
	Retour ret = new Retour("Retour");
	Raz raz = new Raz("RàZ");
	
	private int tailleX;
	private int tailleY;
		
	private  Image img = new ImageIcon(getClass().getResource("/feu-de-foret.jpg")).getImage();
	private  Image img1 = new ImageIcon(getClass().getResource("/feuforet_0.jpg")).getImage();
	private  Image img2 = new ImageIcon(getClass().getResource("/testrouge.jpg")).getImage();
	private  Image img3 = new ImageIcon(getClass().getResource("/test.jpg")).getImage();
	private  Image img4 = new ImageIcon(getClass().getResource("/test2.jpg")).getImage();
	private  Image img5 = new ImageIcon(getClass().getResource("/images.jpg")).getImage();
	
	private Color co = new Color(255,0,0);
	
	private int mouseX;
	private int mouseY;
	
	private byte image;
	private byte trait1 = 1;
	private byte trait2 = 1;
	private byte trait3 = 1;
	private byte trait4 = 1;
	private byte trait5 = 1;
	private byte trait6 = 1;
	private byte trait7 = 1;
	
	private boolean n = false;
	private boolean premier = true;
	
	static boolean choix1 = false;
	static boolean choix2 = false;
	static boolean choix3 = false;
	static boolean choix4 = false;
	static boolean choix5 = false;
	static boolean choix6 = false;
	static boolean choix7 = false;
	
	static byte mode = 1;
	
	static ImageIcon myImg = new ImageIcon();
	static int f = 200;
	
	
	public void paintComponent(Graphics g){
		
		//Positionnement des boutons
		par.setLocation(94, 100);
		bt1.setLocation(this.getWidth()/2-this.getWidth()/4+50, 25);
		bt2.setLocation(this.getWidth()/2+50, 25);
		bt3.setLocation(this.getWidth()/2+this.getWidth()/4+50, 25);
		ret.setLocation(5, this.getHeight()-30);
		raz.setLocation(115, 60);
		
		//Instructions à executer seulement lors de l'instaciation
		if(premier){
			this.addMouseListener(this);
			premier = false;
		
		this.add(bt1);
		this.add(bt2);
		this.add(bt3);
		this.add(ret);
		this.add(par);
		this.add(raz);
		}
		
		//Connaître la position du curseur
		mouseX= MouseInfo.getPointerInfo().getLocation().x-getLocationOnScreen().x;
		mouseY= MouseInfo.getPointerInfo().getLocation().y-getLocationOnScreen().y;
		
		//"Calque qui se superpose sur les images affichées
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//Curseur du seuil de reconnaissance des flames
		g.setColor(Color.black);
		g.fillRect(50, 38, 205, 3);
		g.setColor(co);
		g.fillOval(f, 31, 16, 16);
		
		//Si on teste les images par défaut :
		if(mode==1){
			
		//Si on n'a pas cliqué sur l'image...	
		if(!choix1){
			
		//...L'image normale s'affiche
		g.drawImage(img,
				50, 150,
				200, 150,null );
		
		//...Sinon c'est l'image avec le traitement choisi
		}else{
		
			g.drawImage(traitement(img, trait1, f), 
					50, 150, 200, 150, null);
			
		}
		
		if(!choix2){
		g.drawImage(img1,
				this.getWidth()/2-225, 150,
				367, 150,null );
		}
		else{
			
			g.drawImage(traitement(img1, trait2, f), 
					this.getWidth()/2-225, 150, 367, 150, null);
			
		}
		
		if(!choix3){
		g.drawImage(img5,
				this.getWidth()-325, 150,
				275, 150,null );
		}
		else{
			
			g.drawImage(traitement(img5, trait3, f), 
					this.getWidth()-325, 150, 275, 150, null);
			
		}
		
		if(!choix4){
		g.drawImage(img2,
				50, 365,
				200, 150,null );
		}
		else{
			
			g.drawImage(traitement(img2, trait4, f), 
					50, 365, 200, 150, null);
			
		}
		
		if(!choix5){
		g.drawImage(img4,
				this.getWidth()/2-160, 365,
				245, 150,null );
		}
		else{
			
			g.drawImage(traitement(img4, trait5, f), 
					this.getWidth()/2-160, 365, 245, 150, null);
			
		}
		
		if(!choix6){
		g.drawImage(img3,
				this.getWidth()-317, 365,
				267, 150,null ); 
		}
		else{
			
			g.drawImage(traitement(img3, trait6, f), 
					this.getWidth()-317, 365, 267, 150, null);
			
		}
		
		//Si on survole l'image , un rectangle s'affiche
		if(mouseX>=50 && mouseX<=250 && mouseY>=150 && mouseY<=300)
		{
			image=1;
			g.setColor(Color.RED);
			g.drawRect(49, 149, 201, 151);
			g.setColor(Color.black);
		}
		else if(mouseX>=this.getWidth()/2-225 && mouseX<=this.getWidth()/2+142 && mouseY>=150 && mouseY<=300)
		{
			image=2;
			g.setColor(Color.RED);
			g.drawRect(this.getWidth()/2-226, 149, 368, 151);
			g.setColor(Color.black);
		}
		else if(mouseX>=this.getWidth()-325 && mouseX<=this.getWidth()-50 && mouseY>=150 && mouseY<=300)
		{
			image=3;
			g.setColor(Color.RED);
			g.drawRect(this.getWidth()-326, 149, 276, 151);
			g.setColor(Color.black);
		}
		else if(mouseX>=50 && mouseX<=250 && mouseY>=365 && mouseY<=515)
		{
			image=4;
			g.setColor(Color.RED);
			g.drawRect(49, 364, 201, 151);
			g.setColor(Color.black);
		}
		else if(mouseX>=this.getWidth()/2-160 && mouseX<=this.getWidth()/2+85 && mouseY>=365 && mouseY<=515)
		{
			image=5;
			g.setColor(Color.RED);
			g.drawRect(this.getWidth()/2-161, 364, 246, 151);
			g.setColor(Color.black);
			}
		else if(mouseX>=this.getWidth()-317 && mouseX<=this.getWidth()-50 && mouseY>=365 && mouseY<=515)
		{
			image=6;
			g.setColor(Color.RED);
			g.drawRect(this.getWidth()-318, 364, 268, 151);
			g.setColor(Color.black);
		}
		else {
			image = 0;
			}
		
		if(n && mouseY >= 30 && mouseY <= 50 && mouseX >= 50 && mouseX <= 255){
			co = Color.green;
			f = mouseX;
		}
		}
		//Si on a choisi d'importer son image
		else if(mode==2){
			
			//L'image est redimensionnée si elle est plus grande que la fenêtre
			if(myImg.getIconWidth() > 800){
				tailleX = 400;
				tailleY = (int)(myImg.getIconHeight()*tailleX/myImg.getIconWidth());
			}
			else if(myImg.getIconHeight() > 500){
				tailleX = 400;
				tailleY = (int)(myImg.getIconHeight()*tailleX/myImg.getIconWidth());
			}else{
				tailleX = myImg.getIconWidth();
				tailleY = myImg.getIconHeight();
		}
			
			if(!choix7){
				
			g.drawImage(myImg.getImage(), this.getWidth()/2-tailleX/2, 150, tailleX, tailleY, null);
			
			}else {
				
				g.drawImage(traitement(myImg.getImage() ,trait7, f), this.getWidth()/2-tailleX/2, 150, tailleX, tailleY, null);
					
			}
		
		if(mouseX>= this.getWidth()/2-tailleX/2&& mouseX<=this.getWidth()/2 + tailleX/2 
				&& mouseY>=150 && mouseY <= 150 + tailleY){
			g.setColor(Color.red);
			g.drawRect(this.getWidth()/2-tailleX/2-1, 149, tailleX+1, tailleY+1);
			image = 7;
		}else {
			image = 0;
			}
		if(n && mouseY >= 30 && mouseY <= 50 && mouseX >= 50 && mouseX <= 255){
			co = Color.green;
			f = mouseX;
		}
		
		}
		//Actualiser la fenêtre dès que toutes ces actions sont finie
		this.repaint();
		}	
	
	//méthode pour convertir une image en une "BufferedImage"
	private BufferedImage getImage(Image img){
		if(img instanceof BufferedImage) {
            return((BufferedImage)img);
    } else {
            BufferedImage bufferedImage = 
            		new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_RGB );
            Graphics g = bufferedImage.createGraphics();
            g.drawImage(img,0,0,null);
            return(bufferedImage);
    	}
	}
	
	//méthode pour traiter une image
	private Image traitement(Image var, byte choix, int f){ 
			  BufferedImage bi= getImage(var);

			  int w=bi.getWidth(); int h=bi.getHeight();
			   for(int x=0;x<h;x++){
			    for(int y=0;y<w;y++){
			      int rgb = bi.getRGB(y,x);

			      int r = (rgb & 0xff0000) >> 16 ;	
			      int v = (rgb & 0xff00) >> 8 ;		 
			      int b = (rgb & 0xff) ;
			      int moy = (r+v+b)/3;
			      int col = 2;
			      if(choix ==1){
			      Color tr = new Color(255,255,255);
			      col = tr.getRGB();
			      
			      }
			      else if (choix == 2){
			      Color nb = new Color(moy, moy, moy);
			      col = nb.getRGB();
			    	  
			      }
			      else if (choix == 3){
			      Color alp = new Color(0, r, v, b);
			      col = alp.getRGB();
			      }
			      	if(r<f && v<(f+20) || b>100 ){
			      		
			      		bi.setRGB(y, x, col);
			      	}
			    }
			  }
			  Image img1 = bi;
			  return img1;
			}
	
	//Instructions si l'on clicke
	@Override
	public void mousePressed(MouseEvent arg0) {
		switch(image){
		case 1 :
			choix1 = !choix1;
			if(Frame.choix==1){
				trait1 = 1;
			}else if(Frame.choix==2)
			{
				trait1 = 2;
			}else if(Frame.choix==3){
				trait1 = 3;
			}
			
			
			break;
		case 2 :
			choix2 = !choix2;
			if(Frame.choix==1){
				trait2 = 1;
			}else if(Frame.choix==2)
			{
				trait2 = 2;
			}else if(Frame.choix==3){
				trait2 = 3;
			}
			break;
		case 3 :
			choix3 = !choix3;
			if(Frame.choix==1){
				trait3 = 1;
			}else if(Frame.choix==2)
			{
				trait3 = 2;
			}else if(Frame.choix==3){
				trait3 = 3;
			}
			break;
		case 4 :
			choix4 = !choix4;
			if(Frame.choix==1){
				trait4 = 1;
			}else if(Frame.choix==2)
			{
				trait4 = 2;
			}else if(Frame.choix==3){
				trait4 = 3;
			}
			break;
		case 5 :
			choix5 = !choix5;
			if(Frame.choix==1){
				trait5 = 1;
			}else if(Frame.choix==2)
			{
				trait5 = 2;
			}else if(Frame.choix==3){
				trait5 = 3;
			}
			break;
		case 6 :
			choix6 = !choix6;
			if(Frame.choix==1){
				trait6 = 1;
			}else if(Frame.choix==2)
			{
				trait6 = 2;
			}else if(Frame.choix==3){
				trait6 = 3;
			}
			break;
		case 7 :
			choix7 = !choix7;
			if(Frame.choix == 1){
				trait7 = 1;
			}else if(Frame.choix == 2){
				trait7 = 2;
			}else if(Frame.choix == 3){
				trait7 = 3;
			}
		}
		
		n = true;
		
	}
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
			}
	public void mouseEntered(MouseEvent arg0) {
		
	}
	public void mouseExited(MouseEvent arg0) {
		
	}
	public void mouseReleased(MouseEvent arg0) {
		co = Color.red;
		n = false;
	}
}

