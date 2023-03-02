/**
 * This class is used to simulate the famous Monty Hall problem that was present on the game show
 * "Lets make a deal", the goal is to show that if you always switch your door when given the chance
 * that you odds of winning will be much higher than if you were to remain with your previous choice.
 *
 *
 * @author Alexander Mortillite
 */

public class DoorGame {
	/**
	 * Follows requirements of not having more than 4 lines of code
	 *
	 * @param args
	 */
	public static void main(String args[]) {
		boolean switchDoor = false;
		DoorGame sim = new DoorGame();
		sim.gameLoop(switchDoor);
		sim.gameLoop(!switchDoor);
	}

	/**
	 * This method is used as the "Game loop" which runs for the desired number of times. The higher the "simCount"
	 * the more accurate the result is going to be; Set by default to 10000000.
	 * Within the game loop this program initializes the gameState(Doors and choices)
	 * Provides the User with verification that the doors are evenly randomized behind the scenes
	 * The concludes by dumping all the statistics that the program has gathered
	 */
	public void gameLoop(boolean switchDoor) {
		int runCount = 0;
		int correctCount = 0;
		int simCount = 10000000;
		int[] arr = {0, 0, 0};
		double[] caseCounts = {0, 0, 0};
		int[] doorChosen = {0, 0, 0};


		boolean gameState = true;
		boolean switchCase = switchDoor;

		while (gameState) {
			init(arr, doorChosen);
			caseTicker(arr, caseCounts);
			if (runGame(arr, doorChosen, switchCase) == 1)
				correctCount++;
			runCount++;
			if (runCount == simCount)
				gameState = false;
		}
		runTimeStats(runCount, caseCounts, switchDoor, correctCount);
	}

	/**
	 * Initializes the moving parts of the program such as The door chosen by the "Player" as well as the correct door
	 *
	 * @param arr
	 * @param doorChosen
	 */
	public void init(int[] arr, int[] doorChosen) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
			doorChosen[i] = 0;
		}
		randomizeDoors(doorChosen);
		randomizeDoors(arr);
	}

	/**
	 * This method is used to find the index of both the Car and player choice once they have been randomized
	 *
	 * @param arr
	 * @param treasure
	 * @return
	 */
	public int indexFinder(int[] arr, int treasure) {
		int indexOf = -1;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == treasure)
				indexOf = i;
		return indexOf;
	}

	/**
	 * Picks a door, Unveils a non car door
	 * Either picks a new door or doesn't
	 * returns the result
	 *
	 * @param arr
	 * @param doorChosen
	 * @param switchState
	 * @return
	 */
	public int runGame(int[] arr, int[] doorChosen, boolean switchState) {
		int correct = 0;
		int choiceIndex = 0;
		int carIndex = 0;

		carIndex = indexFinder(arr, 1);
		choiceIndex = indexFinder(doorChosen, 1);

		if (!switchState) {
			if (choiceIndex == carIndex)
				correct = 1;
		} else {
			if (choiceIndex == carIndex)
				correct = 0;
			else
				correct = 1;
		}

		return correct;
	}

	/**
	 * Used to dump the recorded statistics to the console
	 *
	 * @param runCount
	 * @param caseCounts
	 * @param switchDoor
	 * @param correctCount
	 */
	public void runTimeStats(int runCount, double[] caseCounts, boolean switchDoor, int correctCount) {
		System.out.println("Currently Switching Doors: " + switchDoor);

		System.out.println("Number of time looped: " + runCount);
		System.out.println("Percentage of Case 1's: " + (double) (caseCounts[0] / runCount) * 100 + "%");
		System.out.println("Percentage of Case 2's: " + (double) (caseCounts[1] / runCount) * 100 + "%");
		System.out.println("Percentage of Case 3's: " + (double) (caseCounts[2] / runCount) * 100 + "%");

		System.out.println("Correct: " + correctCount);
		System.out.println("Runs: " + runCount);
		System.out.println("Ratio: " + (double) ((double) correctCount / (double) runCount) * 100 + "%");
		System.out.println();
	}

	/**
	 * Used for verification of the distribution being even is uses an array to hold the number of times each door
	 * is randomized.
	 * Doesn't return any values directly but modifies arrays to get the data out
	 * @param arr
	 * @param caseCounts
	 */
	public void caseTicker(int[] arr, double[] caseCounts) {
		if (arr[0] == 1)
			caseCounts[0]++;
		else if (arr[1] == 1)
			caseCounts[1]++;
		else if (arr[2] == 1)
			caseCounts[2]++;
	}

	/**
	 * Randomizer method, randomizes both the doors and the users choice
	 *
	 * @param arr
	 */
	public void randomizeDoors(int[] arr) {
		double random = Math.random();
		Math.round(random);
		if (random > (((double)2)/((double)3))) {
			arr[0] = 1;
		} else if (random > ((double)1)/((double)3)) {
			arr[1] = 1;
		} else if (random >= (0)) {
			arr[2] = 1;
		}
	}
}