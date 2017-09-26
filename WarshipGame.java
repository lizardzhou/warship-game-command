import java.util.*;

public class WarshipGame {
	
	private GameHelper helper = new GameHelper();
	private ArrayList<Warship> warshipList = new ArrayList<Warship>();
	private int numOfGuesses = 0;
	
	private void setUpGame() {
		Warship one = new Warship();
		one.setName("Nimitz");
		Warship two = new Warship();
		two.setName("Carl Vinson");
		Warship three = new Warship();
		three.setName("Gerald R. Ford");
		warshipList.add(one);
		warshipList.add(two);
		warshipList.add(three);
		
		System.out.println("Your goal is to sink all three aircraft carriers.");
		System.out.println("Nimitz, Carl Vinson and Gerald R. Ford.");
		System.out.println("Try to sink them all in the fewest number of guesses. Good luck!");
		
		for(Warship warshipElement : warshipList) {
			ArrayList<String> newLocation = helper.placeWarship(3);
			warshipElement.setLocationCells(newLocation);
		}
	}
	
	public void startPlaying() {
		while(!warshipList.isEmpty()) {
			String userGuess = helper.getUserInput("Please enter a guess:");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	
	private void checkUserGuess(String userGuess) {
		numOfGuesses++;
		String result = "miss";
		for(Warship warshipElement : warshipList) {
			result = warshipElement.checkYourself(userGuess);
			if(result.equals("hit")) {
				break;
			}
			if(result.equals("kill")) {
				warshipList.remove(warshipElement);
				break;
			}
		}
		
		System.out.println(result);
	}
	
	private void finishGame() {
		System.out.println("All aircraft carriers are destroyed! You are the king of the world!");
		if(numOfGuesses < 18) {
			System.out.println("It only took you " + numOfGuesses + " guesses.");
		} else {
			System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
			System.out.println("You need a 001A and several J-20's to improve.");
		}
	}
	
	
	public static void main(String[] args) {
		WarshipGame game = new WarshipGame();
		game.setUpGame();
		game.startPlaying();
	}

}
