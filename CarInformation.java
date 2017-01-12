
public class CarInformation {
	
	static int[] listOfCars;
	static int[] filteredCars;
	static int[] unfilteredCars;
	static boolean filterToggle;
	static int carChosen;
	
	public void setListOfCars(int[] cars){
		
		listOfCars = cars;
	}
	
	public void setListUnfiltered(int[] cars){
		unfilteredCars = cars;
	}
	
	public void setFiltered(int[] cars){
		filteredCars = cars;
	}
	
	public int[] getListOfCars(){
		return listOfCars;
	}
	
	public int[] getListUnfiltered(){
		return unfilteredCars;
	}
	
	public int[] getListFiltered(){
		return filteredCars;
	}
	public boolean getToggle(){
		return filterToggle;
	}
	
	public void setToggle(boolean b){
		filterToggle = b;
	}
	
	public void setCarChosen(int id){
		carChosen = id;
	}
	
	public int getCarChosen(){
		return carChosen;
	}

}
