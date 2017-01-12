import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;


	 public class MyPanel extends JPanel{
 		//@Override
 		protected void paintComponent(Graphics g) {
 			Image img = Toolkit.getDefaultToolkit ().getImage ("image/Carrental.jpg");
             g.drawImage (img, 0, 0, this.getWidth (), this.getHeight (), this);
 		}
     	 
      }
