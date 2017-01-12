import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.imageio.ImageIO;

public class DetailFrame extends JFrame{
	
	private JButton button,button1,button2;
	private JPanel panel;
	private TextField detail;
	
	private JLabel label;
	private JLabel label1;
	private JLabel imagelabel;
	private JLabel resultlabel;
	private JTextField daysfield;
	private JTextField pricefield;
	private JTextField totalfield;
	SearchBarResults tempHold;
	
	private JButton Button3;
    
	private ImageIcon image ;	
	
	public DetailFrame (){
		super("GoundBnB");
		setSize(500, 600);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		//image=new ImageIcon(getClass().getResource("C://Users//xiangyiwei//1126//Start from new//Goundbnb//image//BMW.JPG"));
	    imagelabel=new JLabel(image);
	    
		createTextField();
    	createButton();
    	createPanel();
    	tempHold = new SearchBarResults();
		
	}
	
		
		
	
	private void createTextField(){
		final int FIELD_WIDTH =10;
		label=new JLabel("How many days do u want to rental?");
		daysfield=new JTextField(FIELD_WIDTH);
		label1=new JLabel("The car price will be :");
		pricefield=new JTextField();
	    pricefield.setEditable(false);
	    totalfield=new JTextField(FIELD_WIDTH);
	    totalfield.setEditable(false);
	}
	//

	
    //	
	private void createButton() {
		// TODO Auto-generated method stub
        button = new JButton("Confirm");
		
		class ConfirmFrameAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				new ConFirmFrame();
				setVisible(false);
			}
		}
		button.addActionListener(new ConfirmFrameAction());
		
        button1 = new JButton("Back");
		
		class BackAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				new SearchFrame();
				setVisible(false);
			}
		}
		button1.addActionListener(new BackAction());
		
        button2=new JButton("Calculator");
		
		/*button2 CalcAction implements ActionListener{
			
			public void actionPerformed( ActionEvent e){
				
				int days=Integer.parseInt(daysfield1.getText());
				// LINK TO DATABASE TO GET PRICE
				 int price=100;
				int total=price*days

				setVisible(false);
			}
		} 
		button2.addActionListener(new CalcAction()); */
	}

	private void createPanel() {
		// TODO Auto-generated method stub
		JTextField cdf = new JTextField("Car detail");
		panel = new MyPanel();
		panel.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.add(cdf);
		p.add(button1);
		p.setOpaque(false);
		JPanel p1 = new JPanel();
		p1.add(button);
		p1.setOpaque(false);
		
		
		JPanel PI=new JPanel();
		JPanel info=new JPanel();
		
		PI.setLayout(new GridLayout(2,1));
		PI.add(imagelabel,BorderLayout.NORTH);
		PI.add(info,BorderLayout.SOUTH);
		
		info.setLayout(new GridLayout(3,2));
		info.add(label);
		info.add(daysfield);
		info.add(label1);
		info.add(pricefield);
		info.add(button2);
		info.add(totalfield);
		info.setOpaque(false);
		
		
		cdf.setEditable(false);
		panel.add(p1, BorderLayout.SOUTH);
		panel.add(PI,BorderLayout.CENTER);
		panel.add(p, BorderLayout.NORTH);
		add(panel);
	}

}
