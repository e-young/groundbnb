
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
	
	private static String searchQuery;
	private int[] listOfCars;
	private CarInformation tempHold;
	
	JButton searchButton = new JButton("Search");

	JTextField searchBar = new JTextField();

	class ReserveOKAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			searchQuery = searchBar.getText();
			SearchBarResults getListOfCars = new SearchBarResults();
			tempHold.setListOfCars(getListOfCars.getListOfCars(searchQuery));
			listOfCars = tempHold.getListOfCars();

			new SearchFrame();
			setVisible(false);
			
			
		}
	}

	JButton loginButton = new JButton("Login");

	class LoginOKAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			new LoginFrame();
			setVisible(false);
		}
	}

	public Home() {
		super();
		this.setResizable(false);
		this.setContentPane(new MyPanel());
		this.setSize(new Dimension(400, 600));
		this.setTitle("GoundBnB");
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// this.setLocation(300, 200);
		this.setVisible(true);

		this.getContentPane().add(searchButton, null);
		searchButton.setBounds(150, 290, 100, 30);
		searchButton.addActionListener(new ReserveOKAction());
		

		this.getContentPane().add(loginButton, null);
		loginButton.setBounds(275, 20, 100, 27);
		loginButton.addActionListener(new LoginOKAction());

		this.getContentPane().add(searchBar, null);
		searchBar.setText("Enter a search...");
		searchBar.setBounds(80, 240, 240, 50);
		tempHold = new CarInformation(); 

	}

}
