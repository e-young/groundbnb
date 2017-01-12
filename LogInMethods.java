import com.mysql.jdbc.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LogInMethods {
	
	private Statement st;
	private ResultSet rs;
	private Connection con;
	private PreparedStatement pt;
	
	public LogInMethods() {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car", "root", "");
			st = con.createStatement();

		} catch (Exception e) {

			System.out.println("Error: " + e);

		}
	}
	
	public void insertLogIn(String[] logIn){
		
		String query = "insert into users(fname,lname,username,password,email";
		String values = "values(?";
		for(int i = 0 ; i < logIn.length-1; i++){
			values += ",?";
		}
		
		if(logIn.length == 6){
			query += ",pnum) ";
		}
		else{
			query += " ) ";
		}
		
		query += values;
		query += " ) ";
		
		try{
			System.out.println(query);
			pt = (PreparedStatement) con.prepareStatement(query);
			
			for(int i = 0; i < logIn.length; i++){
				pt.setString(i + 1, logIn[i]);
				System.out.println(logIn[i]+ " SETSTRING " + i);
			}
			
			pt.executeUpdate();
		}
		
		catch(Exception e){
			System.out.println("Error: " + e);
		}		
	}
	
	public boolean userNameCheck(String username){
		boolean match = false;
		String query = "select username from users where username = ";
		String user = "\"" + username + "\"";
		query += user;
		try{
		rs = st.executeQuery(query);
		if(rs.next()){
			String result = rs.getString("username");
			System.out.println(result);
		
			match = username.equalsIgnoreCase(result);
		}
		}
		catch(Exception e){
			System.out.println("Error: " + e);
		}
		return match;
	}
	
	public boolean passwordMatch(String username, String password){
		boolean match = false;
		String query = "select password from users where username = ";
		
		String pw = "\"" + username + "\"";
		
		query += pw;
		try{
			
			rs = st.executeQuery(query);
			rs.next();
			String result = rs.getString("password");
			System.out.println("trinyg to match" + result);
			
			match = password.equals(result);
		}
		catch(Exception e){
			System.out.println("Error: " + e);
		}
		
		
		
		return match;
	}
	
	
	
	

}
