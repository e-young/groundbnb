
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SignFrame extends JFrame{

	private JLabel label1;
	private JPanel panel;
	private JButton button;
	
	
	public SignFrame(){
		super("GoundBnB");
		setSize(400, 600);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		createTextField();
    	createButton();
    	createPanel();
	}


	private void createTextField() {
		// TODO Auto-generated method stub
		label1 = new JLabel("Welcome to GoundBnB");
		
	}


	private void createButton() {
		// TODO Auto-generated method stub
		button = new JButton("Continue to Login");
		
		class LoginAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				new LoginFrame();
				setVisible(false);
			}
		}
		button.addActionListener(new LoginAction());
		
	}


	private void createPanel() {
		// TODO Auto-generated method stub
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(label1, BorderLayout.CENTER);
		panel.add(button, BorderLayout.SOUTH);
		add(panel);
		
	}
		
	}
