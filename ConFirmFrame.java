
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ConFirmFrame extends JFrame{

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JPanel panel;
	//private JButton button;
	private JButton Button1;
	private JButton Button2;
		 
	
	public ConFirmFrame(){
		super("GoundBnB");
		setSize(400, 600);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
        
		CreateButton();
		CreatePanel();
		}

	
	private void CreateButton() {
		
	     Button1 = new JButton("back");
		
		class BackAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e)
			{
				new DetailFrame();
				setVisible(false);
			}
		}
			 Button1.addActionListener(new BackAction());
		
		Button2 = new JButton("Confirm");
		
		class ConfirmAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e)
			{
				new PaymentFrame();
				setVisible(false);
			}
		}
		
		Button2.addActionListener( new ConfirmAction());
			
		}
	private void CreatePanel() {
		// TODO Auto-generated method stub
		JTextField rus = new JTextField("Are you sure you want to book this car");
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3,1));
		p.add(rus);
		p.add(Button1);
		p.add(Button2);
		rus.setEditable(false);
		panel.add(p,BorderLayout.NORTH);
		add(panel);
	}
	
}
