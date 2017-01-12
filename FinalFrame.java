
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class FinalFrame extends JFrame{

	private JPanel panel;
	private JButton button;
	private JButton Button1;
		 
	
	public FinalFrame(){
		super("GoundBnB");
		setSize(400, 600);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
        
		CreateButton();
		CreatePanel();
		}

	
	private void CreateButton() {
		
	     Button1 = new JButton("Done");
		
		class HomeOkAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e)
			{
				new Home();
				setVisible(false);
			}
		}
			 Button1.addActionListener(new HomeOkAction());
			 
			button = new JButton("New Search");
			
			class SearchAction implements ActionListener{
				
				public void actionPerformed(ActionEvent e)
				{
					new SearchFrame();
					setVisible(false);
				}
			}
				button.addActionListener(new SearchAction());
				
	
		}
	private void CreatePanel() {
		// TODO Auto-generated method stub
		JTextField rus = new JTextField("Confirmed");
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3,1));
		p.add(rus);
		p.add(Button1);
		p.add(button);
		rus.setEditable(false);
		panel.add(p,BorderLayout.NORTH);
		add(panel);
	}
	
}