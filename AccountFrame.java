
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AccountFrame extends JFrame {


	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5,label6,label7,label8;
	private JLabel passwordNoMatch;
	private JLabel usernameTaken;
	private JPanel panel, errors;
	private JTextField username;
	private JTextField password;
	private JTextField email;
	private JTextField fname,lname,field6,pnum;
	private JButton Button1;
	private JButton Button2;
	private JButton button,button1;
	private String[] accountInfo;
	
	public AccountFrame(){
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
		final int FIELD_WIDTH = 10;
		label1 = new JLabel("User Name ");
        username = new JTextField(FIELD_WIDTH);
        label2 = new JLabel("Password ");
        password = new JTextField(FIELD_WIDTH);
        label3 = new JLabel("Email ");
        email = new JTextField(FIELD_WIDTH);
        label4 = new JLabel("Already have an account? ");
        label5 = new JLabel("First Name ");
        fname = new JTextField(FIELD_WIDTH);
        label6 = new JLabel("Last Name");
        lname = new JTextField(FIELD_WIDTH);
        label7 = new JLabel("Confirm Password ");
        field6 = new JTextField(FIELD_WIDTH);
        label8 = new JLabel("Phone Number ");
        pnum = new JTextField(FIELD_WIDTH);
        usernameTaken = new JLabel("Username is taken!");
        passwordNoMatch = new JLabel("Passwords do not match!");
        usernameTaken.setVisible(false);
        passwordNoMatch.setVisible(false);
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
		
		Button1 = new JButton("Sign up");
		
		class SignAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				accountInfo = new String[6];
				
				accountInfo[0] = fname.getText();
				accountInfo[1] = lname.getText();
				accountInfo[2] = username.getText();
				accountInfo[3] = password.getText();
				accountInfo[4] = email.getText();
				accountInfo[5] = pnum.getText();
				
				
				for(int i = 0 ; i < accountInfo.length; i++){
					System.out.println(accountInfo[i]);
				}
				
				boolean passNoMatch = false;
				boolean userTaken = false;
				LogInMethods insertLogin = new LogInMethods();
				System.out.println(field6.getText());
				System.out.println(accountInfo.length);
				if(password.getText().equals(field6.getText())){
					passNoMatch = true;
				}
				userTaken = !insertLogin.userNameCheck(username.getText());
				if(!userTaken){
					usernameTaken.setVisible(true);
				}
				else if(!passNoMatch){
					passwordNoMatch.setVisible(true);
				}
				
				
				if(passNoMatch&&userTaken){
					insertLogin.insertLogIn(accountInfo);
					new SignFrame();
					setVisible(false);}
				
				}
			}
	    
		Button1.addActionListener(new SignAction());
		
		Button2 = new JButton("Login");
		
        class LoginAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				new LoginFrame();
				setVisible(false);
			}
        }
        Button2.addActionListener(new LoginAction());
        
		
	}


	private void createPanel() {
		// TODO Auto-generated method stub
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		errors = new JPanel();
		errors.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(9,2));
		p.add(label5);
		p.add(fname);
		p.add(label6);
		p.add(lname);
		p.add(label1);
		p.add(username);
		p.add(label2);
		p.add(password);
		p.add(label7);
		p.add(field6);
		p.add(label3);
		p.add(email);
		p.add(label8);
		p.add(pnum);
		p.add(Button1);
		p.add(button1);
		p.add(label4);
		p.add(Button2);
		errors.add(usernameTaken, BorderLayout.AFTER_LINE_ENDS);
		errors.add(passwordNoMatch, BorderLayout.AFTER_LAST_LINE);
		panel.add(p,BorderLayout.NORTH);
		panel.add(button, BorderLayout.SOUTH);
		panel.add(errors, BorderLayout.SOUTH);
		add(panel);
	}


	public static void main(String[] args) {
        new AccountFrame();
    }
}
