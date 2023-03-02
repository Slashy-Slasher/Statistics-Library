import java.math.BigInteger;
import java.util.*; // import the ArrayList class

public class tester 
{
	
	
	public static void main(String[] args)
	{
		StatsLibrary stats = new StatsLibrary();
		System.out.println(stats.binomialDistribution(15, 10, 0.3));

		BigInteger n = BigInteger.valueOf(10);
		testPerm();
		testProject1();
		testStatLib();
		testProject1();
		testSD();
		System.out.println("nCr: " + stats.combination(52, 4));
		System.out.println("nPr: " +stats.permutation(52, 4));
		System.out.println("Factorial: " + stats.factorial(n));

	}
	public static void testPerm()
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		StatsLibrary stats = new StatsLibrary();
		int n = 52;
		int r = 5;

		int desiredOutcome = 1;         //Desired binomial
		double successProbability = .5; //Chance of Success
		int add = 4;                    //Additional probabilities
		boolean inverse = false;        //Inverse?

		int trials = 5;                 //Number of trials simulated
		double p = .50;

		//System.out.println(geometricDistribution(trials, p, 0, false));
		System.out.println("The combination of " + n + " and " + r + " is " + stats.combination(n, r));
		System.out.println("The permutation of " + n + " and " + r + " is " + stats.permutation(n, r));
		System.out.printf("P(%d) =  %.3f%%\n", desiredOutcome, 100 * stats.binomialDistribution(trials, desiredOutcome, successProbability));
		System.out.printf("Inversed?: %b; P(%d) * %d =  %.3f%%\n", inverse, desiredOutcome, add, 100 * stats.binomialDistribution(trials, desiredOutcome, successProbability, add, inverse));
		System.out.printf("P(X = %d) =  %.3f%%\n", desiredOutcome, 100 * stats.geometricDistribution(trials, p, 0, false));
	}


	public static void testSD()
	{
		StatsLibrary statlib = new StatsLibrary();
		ArrayList<Integer> A = new ArrayList<Integer>();
		Collections.addAll(A, 1, 3, 3, 3, 3, 5, 6, 7);
		//statlib.standardDeviation(A);
		System.out.println(A);
		System.out.println(statlib.standardDeviation(A));
	}
	public static void testStatLib() 
	{
		StatsLibrary statslib = new StatsLibrary();
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		Collections.addAll(A, 1, 3, 3, 3, 3, 5, 5, 5, 6, 7);

		
		System.out.println(A);
		
		
		System.out.println("Mean operation result: " + statslib.mean(A));
		System.out.println("Median operation result: " + statslib.median(A));
		System.out.println("Mode operation result: " + statslib.mode(A));

	}
	public static void testProject1()
	{
		SetOperations project1 = new SetOperations();

		ArrayList<Integer> S = new ArrayList<Integer>();
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		for(int i = 0; i<10; i++) {
			S.add(i+1);
		}
		Collections.addAll(A, 2, 4, 6);
		Collections.addAll(B, 1,2,5,7,9);

		System.out.println("A: "+ A);
		System.out.println("B: "+B);
		System.out.println("S: "+S);
		System.out.println("__________________________________________________");

		System.out.println("INTERSECTION between "+ A +" and "+ B+ ": Expected: [2]; Returned: " + project1.intersection(A, B));
		project1.testCase("[2]", project1.intersection(A, B).toString());
		System.out.println("UNION between "+ A +" and "+ B+ ": Expected: {1, 2, 4, 5, 6, 7, 9}; Returned: " + project1.union(A, B));
		project1.testCase("[1, 2, 4, 5, 6, 7, 9]", project1.union(A, B).toString());
		System.out.println("COMPLIMENT between " + A +" and "+ B+ ": Expected: {1, 3, 5, 7, 8, 9, 10}; Returned: " + project1.complement(A, B));
		project1.testCase("[1, 3, 5, 7, 8, 9, 10]", project1.complement(A, S).toString());
	}

}
