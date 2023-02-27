/**
 * This class is used to simulate the famous Monte Hall problem that was present on the game show
 * "Lets make a deal", the goal is to show that if you always switch your door when given the chance
 * that you odds of winning will be much higher than if you were to remain with your previous choice.
 *
 *
 * @author Alexander Mortillite
 */

import java.util.Random;

public class DoorChance
{
	public static void main(String args[])
	{
		boolean switchDoor = false;
		DoorChance sim = new DoorChance();
		sim.gameLoop(switchDoor);
		sim.gameLoop(!switchDoor);
	}
	public void gameLoop(boolean switchDoor)
	{
		int runCount = 0;
		int correctCount = 0;
		int runtimes = 10000000;
		int[] arr = {0,0,0};
		int[] case1 = {1, 0, 0};
		int[] case2 = {0, 1, 0};
		int[] case3 = {0, 0, 1};
		double[] caseCounts = {0, 0, 0};
		int[] doorChosen = {0,0,0};


		boolean gameState = true;
		boolean switchCase = switchDoor;

		while(gameState)
		{
			init(arr, doorChosen);
			randomizeDoors(doorChosen);		//Slated for removmal, seems redundant to randomize then init, when you can just init
			randomizeDoors(arr);
			caseTicker(arr, case1, case2, case3, caseCounts);

			if(runGame(arr, doorChosen, switchCase) == 1)
				correctCount++;
			runCount++;
			if(runCount == runtimes)
				gameState = false;
		}

		runTimeStats(runCount, doorChosen, caseCounts, switchDoor, correctCount);


	}
	public void init(int [] arr, int[] doorChosen) {
		for(int i = 0; i<arr.length; i++) {
			arr[i] = 0;
			doorChosen[i] = 0;
		}
	}
	public int indexFinder(int[] arr, int treasure)
	{
		int indexOf = -1;
		for(int i = 0; i<arr.length; i++)
			if(arr[i] == treasure)
				indexOf = i;
		return indexOf;
	}
	public int runGame(int[] arr, int[] doorChosen, boolean switchState)
	{
		//pick door(random)
		//Unveil a non car door
		// either pick a new or don't
		//record stats and place them in run time stats method
		int correct = 0;
		int choiceIndex = 0;
		int carIndex = 0;

		carIndex = indexFinder(arr, 1);
		choiceIndex = indexFinder(doorChosen, 1);

		if(!switchState)
		{
			if(choiceIndex  == carIndex)
				correct = 1;
		}
		else
		if(choiceIndex  == carIndex)
			correct = 0;
		else
			correct = 1;
		return correct;

	}

	public void runTimeStats(int runCount, int[] doorChosen, double[] caseCounts, boolean switchDoor, int correctCount)
	{
		System.out.println("Currently Switching Doors: " + switchDoor);


		System.out.println("Number of time looped: " + runCount);
		System.out.println("Percentage of Case 1's: " + (double)(caseCounts[0]/runCount)*100 + "%");
		System.out.println("Percentage of Case 2's: " + (double)(caseCounts[1]/runCount)*100 + "%");
		System.out.println("Percentage of Case 3's: " + (double)(caseCounts[2]/runCount)*100 + "%");

		System.out.println("Correct: " + correctCount);
		System.out.println("Runs: " + runCount);
		System.out.println("Ratio: " + (double)((double)correctCount/(double)runCount)*100 + "%");
		System.out.println();

	}
	public void caseTicker(int[] arr,int[] case1,int[]  case2, int[] case3,double[] caseCounts)
	{
		//Verifies weather or not the distrobution is even or not
		//Doesn't return any values directly but modifies arrays
		if(arr[0] == 1)
			caseCounts[0]++;
		else if(arr[1] == 1)
			caseCounts[1]++;
		else if(arr[2] == 1)
			caseCounts[2]++;
	}
	public void randomizeDoors(int[] arr)
	{
		//Random rand = new Random();
		double random = Math.random();
		Math.round(random);
		//System.out.println(random);
		if(random > (.66666666666666666666666666666666666666666)){
			arr[0] = 1;
			//System.out.println(random + " is greater than " + .66);
			//random = -1;
		}
		else if(random > (.333333333333333333333333333333333333)){
			arr[1] = 1;
			//System.out.println(random + " is greater than " + .33 + "and less than .66");
			//random = -1;
		}
		else if(random > (0)){
			arr[2] = 1;
			//System.out.println(random + " is greater than " + .0 + " and less than .33 and .66");
			//random = -1;
		}
	}

	public void printArr(int[] arr){
		for(int i = 0; i< arr.length; i++)
		{
			System.out.print(arr[i]);
		}
		System.out.println();

	}

}