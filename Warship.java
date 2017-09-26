import java.util.*;

public class Warship {
	
	private ArrayList<String> locationCells;
	private String name;
		
	//method: set cell location
	public void setLocationCells(ArrayList<String> locs) {
		locationCells = locs;
	}
		
	//method: set name
	public void setName(String s) {
		name = s;
	}
		
	//method: check the user guess
	public String checkYourself(String stringGuess) {
		String result = "miss"; //default value of result is "miss"
		int index = locationCells.indexOf(stringGuess);
				
		if (index >=0) {
			locationCells.remove(index);			
			if (locationCells.isEmpty()) {
				result = "kill";
				System.out.println("Congrats! You just destroyed " + name + "!");
			} else {
				result = "hit";
			}
		}
		return result;
	}	
		
}
