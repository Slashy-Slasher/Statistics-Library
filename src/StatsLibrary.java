import java.util.*;
public class StatsLibrary 
{
	
	public double mean(ArrayList<Integer> a)
	{
		double total = 0;
		for(int i = 0; i<a.size(); i++)
			total += a.get(i);
		//System.out.println(a);
		return (total/a.size());
	}
	public double median(ArrayList<Integer> a)
	{
		//If even, take the middle two numbers and take the mean
		//If odd, take the middle number
		double median = 0;
		ArrayList<Integer> middleTwo = new ArrayList<Integer>();
		if(a.size()%2 == 0)
		{
			middleTwo.add(a.get((a.size()/2))-1);
			middleTwo.add(a.get((a.size()/2)));
			System.out.println("The middle two numbers are: " + middleTwo);
			return(mean(middleTwo));
		}
		if(a.size()%2 == 1)
		{
			median = a.get(((int)(a.size()/2)));
		}
		return median;
	}
	public Double mode(ArrayList<Integer> a)
	{
		double mode = 0;
		int tally = 0;
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		
		
		for(int i = 0; i<a.size(); i++)
		{
			for(int j = 0; j<a.size(); j++)
			{
				System.out.println("Test Case: " + a.get(i) + " vs " + a.get(j));
				if(a.get(i) == a.get(j))
				{
					tally++;
				}
				//B.get(i.get()).add(tally);
				tally = 0;
				//System.out.println(commonalityRecorder);
				//Tgus us a kut
			}
		}
		return mode;
	}
	public double standardDeviation(ArrayList<Integer> a)
	{
		double placeholder = 0;
		for(int i = 0; i<a.size();i++)
		{
			placeholder += Math.pow(a.get(i) -  mean(a), 2);
		}
		return Math.sqrt(placeholder/a.size());
	}
	
	

}
