import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PaymentFrame extends JFrame {


	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5,label6,label7,label8;
	private JPanel panel;
	private JTextField field1;
	private JTextField field2;
	private JTextField field3;
	private JTextField field4,field5,field6,field7,field8;
	private JButton Button1;
	private JButton Button2;
	private JButton button,button1;
	
	public PaymentFrame(){
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
		final int FIELD_WIDTH = 25;
		label1 = new JLabel("First Name ");
        field1 = new JTextField(FIELD_WIDTH);
        label2 = new JLabel("Last Nmae ");
        field2 = new JTextField(FIELD_WIDTH);
        label3 = new JLabel("Card Number ");
        field3 = new JTextField(FIELD_WIDTH);
        label4 = new JLabel("Card Holder Full Name ");
        label5 = new JLabel("Street ");
        field4 = new JTextField(FIELD_WIDTH);
        label6 = new JLabel("City");
        field5 = new JTextField(FIELD_WIDTH);
        label7 = new JLabel(" ZipCode ");
        field6 = new JTextField(FIELD_WIDTH);
        label8 = new JLabel("3 Digit Security Code ");
        field7 = new JTextField(FIELD_WIDTH);
        field8 = new JTextField(FIELD_WIDTH);
		
	}


	private void createButton() {
		// TODO Auto-generated method stub
	    button = new JButton("HOME");
		
		class HomeOKAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				new Home();
				setVisible(false);
			}
		}
		button.addActionListener(new HomeOKAction());
		
		button1 = new JButton("Back");
		
		class BackAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				new LoginFrame();
				setVisible(false);
			}
		}
		button1.addActionListener(new BackAction());
		
		Button1 = new JButton("pay");
		
		class SignAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				new FinalFrame();
				setVisible(false);
			}
	    }
		Button1.addActionListener(new SignAction());
		
		Button2 = new JButton("back");
		
        class LoginAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				new ConFirmFrame();
				setVisible(false);
			}
        }
        Button2.addActionListener(new LoginAction());
        
		
	}


	private void createPanel() {
		// TODO Auto-generated method stub
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(9,2));
		p.add(label1);
		p.add(field1);
		p.add(label2);
		p.add(field2);
		p.add(label3);
		p.add(field3);
		p.add(label4);
		p.add(field4);
		p.add(label5);
		p.add(field5);
		p.add(label6);
		p.add(field6);
		p.add(label7);
		p.add(field7);
		p.add(label8);
		p.add(field8);
		p.add(Button1);
		p.add(Button2);
		panel.add(p,BorderLayout.NORTH);
		panel.add(button, BorderLayout.SOUTH);
		add(panel);
	}


	public static void main(String[] args) {
        new AccountFrame();
    }
}
