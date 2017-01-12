
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class LoginFrame extends JFrame{
	
	private JLabel label1;
	private JLabel label2;
	private JLabel passNoMatch, notUsername;
	private JPanel panel, error;
	private JTextField field1;
	private JTextField field2;
	private JButton Button1;
	private JButton Button2;
	private JButton button;


	public LoginFrame(){
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
        field1 = new JTextField(FIELD_WIDTH);
        label2 = new JLabel("Password ");
        field2 = new JTextField(FIELD_WIDTH);
        
        passNoMatch = new JLabel("Incorrect password!");
        notUsername = new JLabel("Incorrect username!");
        passNoMatch.setVisible(false);
        notUsername.setVisible(false);
        
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
		
		Button1 = new JButton("login");
		
		class LoginAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				boolean passMatch = false;
				boolean isUsername = false;
				LogInMethods login = new LogInMethods();
				
				String username = field1.getText();
				System.out.println("THIS IS USER " + username);
				String password = field2.getText();
				System.out.println("THIS IS pw " + password);
				isUsername = login.userNameCheck(username);
				
				if(isUsername){
					passMatch = login.passwordMatch(username, password);
					if(!passMatch){
						System.out.println("passnomatch");
						passNoMatch.setVisible(true);
					}
				}
				else{
					System.out.println("usernomatch");
					notUsername.setVisible(true);
				}
				
						
				if(passMatch){
					new Home();
					setVisible(false);
				}
			}
	    }
		Button1.addActionListener(new LoginAction());
		
		Button2 = new JButton("Sign Up");
		
        class SignAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e){
				
				new AccountFrame();
				setVisible(false);
			}
        }
        Button2.addActionListener(new SignAction());
        
	}

	private void createPanel() {
		// TODO Auto-generated method stub
		panel = new MyPanel();
		error = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3,2));
		p.add(label1);
		p.add(field1);
		p.add(label2);
		p.add(field2);
		p.add(Button1);
		p.add(Button2);
		error.add(notUsername);
		error.add(passNoMatch);
		panel.add(p,BorderLayout.NORTH);
		panel.add(error, BorderLayout.CENTER);
		panel.add(button,BorderLayout.SOUTH);
		add(panel);
		
	}



	public static void main(String[] args) {
        new LoginFrame();
    }
}
