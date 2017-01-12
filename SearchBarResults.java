
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchBarResults {

	private Statement st;
	private ResultSet rs;
	private String searchQuery;
	private Connection con;
	private int[] listOfCars;

	public SearchBarResults() {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car", "root", "");
			st = con.createStatement();

		} catch (Exception e) {

			System.out.println("Error: " + e);

		}
	}

	public int[] getListOfCars(String searchQuery) {

		String[] keywords = searchQuery.split(" ");

		String query = "select car_id from car where ";

		String color;
		String make;
		String type;
		String carName;

		ArrayList<Integer> results = new ArrayList<Integer>();

		for (int i = 0; i < keywords.length; i++) {
			color = "\"" + keywords[i] + "\"";
			make = "\"" + keywords[i] + "\"";
			type = "\"" + keywords[i] + "\"";
			carName = "\"" + keywords[i] + "\"";

			try {

				String query1 = query + "color = " + color + " or maker = " + make + " or type = " + type
						+ " or car_name = " + carName;

				rs = st.executeQuery(query1);

				while (rs.next()) {

					results.add(rs.getInt("car_id"));

				}

			} catch (Exception e) {
				System.out.println("Error: " + e);
			}

		}

		int[] resultArray = new int[results.size()];
		for (int i = 0; i < results.size(); i++) {
			resultArray[i] = results.get(i);
		}

		quickSort(resultArray, 0, resultArray.length - 1);

		int[] freqArray = sortedFreqResult(resultArray);

		return freqArray;
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;

		if (low >= high)
			return;

		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		if (low < j)
			quickSort(arr, low, j);

		if (high > i)
			quickSort(arr, i, high);
	}

	public int[] sortedFreqResult(int[] arr) {
		int countUnique = 0;
		int prev = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != prev)
				countUnique++;

			prev = arr[i];
		}

		int[][] freqArray = new int[countUnique][2];

		prev = 0;
		countUnique = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != prev) {
				countUnique++;
				freqArray[countUnique - 1][0] = arr[i];
				freqArray[countUnique - 1][1]++;
			}

			if (arr[i] == prev) {
				freqArray[countUnique - 1][1]++;

			}

			prev = arr[i];
		}
		int[] allFreq = new int[countUnique];

		for (int i = 0; i < allFreq.length; i++) {
			allFreq[i] = freqArray[i][1];
		}

		quickSort(allFreq, 0, allFreq.length - 1);

		int[] sortedEle = new int[countUnique];

		for (int i = 0; i < allFreq.length; i++) {
			breakloop: for (int j = 0; j < freqArray.length; j++) {
				if (allFreq[i] == freqArray[j][1]) {
					sortedEle[i] = freqArray[j][0];
					freqArray[j][1] = 0;
					break breakloop;
				}
			}

		}

		for (int i = 0; i < sortedEle.length / 2; i++) {
			int temp = sortedEle[i];
			sortedEle[i] = sortedEle[sortedEle.length - 1 - i];
			sortedEle[sortedEle.length - 1 - i] = temp;

		}

		return sortedEle;
	}

	public int[] getListOfColors(int[] listOfCars, String color){
		
		this.listOfCars = listOfCars;
		
		String query = "select color from car where car_id = ";
		
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		try{
			
			for(int i =0 ; i< listOfCars.length; i ++){
				String query1 = query + "\"" + listOfCars[i] + "\"";
				rs = st.executeQuery(query1);
				rs.next();
				String colorResult = rs.getString("color");

				
				if(colorResult.equalsIgnoreCase(color)){
					results.add(listOfCars[i]);
				}
			}
		}
		catch(Exception e){
			System.out.println("Error " + e);
		}
		
		int[] resultArray = new int[results.size()];
		for (int i = 0; i < results.size(); i++) {
			resultArray[i] = results.get(i);
		}
		
		return resultArray;
	}
	
	public int[] getListOfType(int[] listOfCars, String type){
		this.listOfCars = listOfCars;
		String query = "select type from car where car_id = ";
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		try{
			
			for(int i =0 ; i< listOfCars.length; i ++){
				String query1 = query + "\"" + listOfCars[i] + "\"";
				rs = st.executeQuery(query1);
				rs.next();
				String typeResult = rs.getString("type");

				
				if(typeResult.equalsIgnoreCase(type)){
					results.add(listOfCars[i]);
				}
			}
		}
		catch(Exception e){
			System.out.println("Error " + e);
		}
		
		int[] resultArray = new int[results.size()];
		for (int i = 0; i < results.size(); i++) {
			resultArray[i] = results.get(i);
		}
		
		return resultArray;
		
	}
	
	public int[] getListOfPrice(int[] listOfCars, int min, int max){
		
		this.listOfCars = listOfCars;
		
		String query = "select price from car where car_id = ";
		
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		try{
			
			for(int i =0 ; i< listOfCars.length; i ++){
				String query1 = query + "\"" + listOfCars[i] + "\"";
				rs = st.executeQuery(query1);
				rs.next();
				int priceResult = Integer.parseInt(rs.getString("price"));

				
				if(priceResult >= min && priceResult <= max){
					results.add(listOfCars[i]);
				}
			}
		}
		catch(Exception e){
			System.out.println("Error " + e);
		}
		
		int[] resultArray = new int[results.size()];
		for (int i = 0; i < results.size(); i++) {
			resultArray[i] = results.get(i);
		}
		
		return resultArray;
		
	}
	
public int[] getListOfYear(int[] listOfCars, int year){
		
		this.listOfCars = listOfCars;
		
		String query = "select year from car where car_id = ";
		
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		try{
			
			for(int i =0 ; i< listOfCars.length; i ++){
				String query1 = query + "\"" + listOfCars[i] + "\"";
				rs = st.executeQuery(query1);
				rs.next();
				int yearResult = Integer.parseInt(rs.getString("year"));

				System.out.println("SEARCHING YEAR" + yearResult);
				
				if(yearResult == year){
					results.add(listOfCars[i]);
				}
			}
		}
		catch(Exception e){
			System.out.println("Error " + e);
		}
		
		int[] resultArray = new int[results.size()];
		for (int i = 0; i < results.size(); i++) {
			resultArray[i] = results.get(i);
		}
		
		return resultArray;
	}

	public int getPrice(int carID){
		int price = 0;
		try{
			rs = st.executeQuery("select price from car where car_id = " + "\"" + carID + "\"");
			rs.next();
			price = rs.getInt("price");
		}
		catch(Exception e){
			
		}
		return price;
	}
	

	
	public String getCarInfo(int carID){
		String results = "";
		String query = "select * from car where car_id = " + "\"" + carID + "\"";
		
		try{
			rs = st.executeQuery(query);
			
			
			while(rs.next()){
				for(int i = 1; i < 7; i++){
					results += rs.getString(i) + " ";
				}
			
			}
	
			
		}
		catch(Exception e){
			System.out.println("Error " + e);
		}

		
		return results;
	}
	
	
	
}
