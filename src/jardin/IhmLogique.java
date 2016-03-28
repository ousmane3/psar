/**
 * 
 */
package jardin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author Ousmane3
 *
 */
public class IhmLogique extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;

	
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Color c = g.getColor();

		image=new ImageIcon("paquerette-fl.jpg").getImage();
		g.drawImage(image,20,20,30,30,null);
		
		image=new ImageIcon("tulipe.jpeg").getImage();
		g.drawImage(image,60,35,30,30,null);
		
		image=new ImageIcon("rose.jpg").getImage();
		g.drawImage(image,100,20,30,30,null);
		
		image=new ImageIcon("rose.jpg").getImage();
		g.drawImage(image,140,35,30,30,null);
		c.getBlue();
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IhmLogique ihm=new IhmLogique();
		ihm.setBackground(Color.WHITE);
		ihm.setPreferredSize(new Dimension(800,400));
		GUIHelper.showOnFrame(ihm,"test");
		
		

	}

}
