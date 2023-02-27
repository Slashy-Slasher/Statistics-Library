import java.util.*; // import the ArrayList class

public class tester 
{
	
	
	public static void main(String[] args)
	{
		//testStatLib();
		//testProject1();
		//testSD();
	}
	/*
	public static void testSD()
	{
		StatsLibrary statlib = new StatsLibrary();
		ArrayList<Integer> A = new ArrayList<Integer>();
		Collections.addAll(A, 1, 3, 3, 3, 3, 5, 6, 7);
		//statlib.standardDeviation(A);
		System.out.print(statlib.standardDeviation(A));
		
	}
	public static void testStatLib() 
	{
		StatsLibrary statlib = new StatsLibrary();
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		Collections.addAll(A, 1, 3, 3, 3, 3, 5, 6, 7);

		
		System.out.println(A);
		
		
		System.out.println("Mean operation result: " + statlib.mean(A));
		System.out.println("Median operation result: " + statlib.median(A));
		System.out.println("Mode operation result: " + statlib.mode(A));

		
		
		
	}
	public static void testProject1()
	{
		SetOperations project1 = new SetOperations();

		ArrayList<Integer> S = new ArrayList<Integer>();
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		for(int i = 0; i<10; i++)
		{
			S.add(i+1);
		}
		
		A.add(2);
		A.add(4);
		A.add(6);
		
		B.add(1);
		B.add(2);
		B.add(5);
		B.add(7);
		B.add(9);
		
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

		
		//project1.union(S, A);
	}
	*/
}
