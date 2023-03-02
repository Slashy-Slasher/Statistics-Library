import java.util.ArrayList; // import the ArrayList class
import java.util.*;


public class SetOperations 
{
	//ArrayList<Integer> input = new ArrayList<Integer>(); // Create an ArrayList object
	
	
	public ArrayList<Integer> ArrayListTrim()
	{
		ArrayList<Integer> set3 = new ArrayList<>();
		
		return set3;
	}
	
	public void testCase(String expected, String result)
	{
		String grade = "Failed-----------------";
		System.out.println("");
		System.out.println(expected + " vs " + result);
		System.out.println("");
		if(expected.equals(result))
			grade = "Pased+++++++++++++++++";
		
		System.out.println(grade);
		System.out.println("");
	}
	public ArrayList<Integer> sortAndTrim(ArrayList<Integer> A)
	{
		Collections.sort(A);
		for(int i = 1; i<A.size(); i++)
		{
			if(A.get(i) == A.get(i-1))
			{
				A.remove(i);
			}
		}
		return A;
	}
	
	public ArrayList<Integer>ArrayListClone(ArrayList<Integer> A)
	{
		ArrayList<Integer> B = new ArrayList<Integer>();
		for(int i = 0; i < A.size(); i++)
		{
			B.add(A.get(i));
		}
		
		
		return B;
	}
	
	public ArrayList<Integer> union(ArrayList<Integer> A, ArrayList<Integer> B)
	{
		ArrayList<Integer> C = new ArrayList<Integer>();
		for(int i = 0; i<B.size(); i++)
		{
			C.add(B.get(i));
		}
		for(int i = 0; i<A.size(); i++)
		{
			C.add(A.get(i));
		}
		return sortAndTrim(C);
	}
	public ArrayList<Integer> intersection(ArrayList<Integer> set1, ArrayList<Integer> set2)
	{
		ArrayList<Integer> set3 = new ArrayList<Integer>();
		for(Integer i = 0; i < set1.size(); i++)
		{
			for(Integer j = 0; j<set2.size();j++)
			{
				//System.out.println(set1.get(i) + " vs " + set2.get(j));
				if(set1.get(i) == set2.get(j))
				{
					set3.add(set1.get(i));
					j = set2.size();
				}
			}
		}
		return set3;
	}
	public ArrayList<Integer> complement(ArrayList<Integer> A, ArrayList<Integer> B)
	{
		ArrayList<Integer> C = new ArrayList<Integer>();

		for(int i = 0; i<B.size(); i++)
		{
			C.add(B.get(i));
		}
		for(int i = 0; i<A.size(); i++)
		{
			C.add(A.get(i));
		}
		Collections.sort(C);
		
		for(int i = 1; i<C.size(); i++)
		{
			if(C.get(i) == C.get(i-1))
			{
				C.remove(i);
				C.remove(i-1);
			}
		}
		//System.out.println("UNION OF A AND S" + C);

		return sortAndTrim(C);
	}
	
	
}
