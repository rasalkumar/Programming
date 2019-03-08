package amazon;
import java.util.*;
public class BuySellStock {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Interval> sol = new ArrayList<>();
		int n = in.nextInt();
		int a[] = new int[n];
		for( int i = 0 ; i < n ; i++ )
			a[i] = in.nextInt();
		int i = 0;
		//int count = 0 ;
		while(i < n - 1)
		{
			//Find Minima
			while(i < n && a[i+1] <= a[i] )
			{
				i++;
			}
			if(i == n-1)
				break;
			Interval e = new Interval();
			e.buy = i++;
			
			//Find Maxima
			while(i < n && a[i] >= a[i - 1])
				i++;
			e.sell = i - 1;
			sol.add(e);
			//count++;
			
		}
		for(int  j = 0 ; j < sol.size() ; j++ )
		{
			System.out.println(sol.get(j).buy + " " + sol.get(j).sell);
		} 
		

	}
	static class Interval
	{
		int buy,sell;
	}

}