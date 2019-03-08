package balloons;
import java.util.*;
public class Solution {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int a[] = new int[n];
		Pair pair[] = new Pair[n];
		for(int  i = 0 ;i < n ;i++)
		{
			a[i] = in.nextInt();
			pair[i]= new Pair(a[i],i+1);
		}
		Arrays.sort(pair);
		if(a.length==1)
			System.out.println(-1);
		else if(a.length==2 && a[0]==a[1])
		{
			System.out.print(-1);
			
		}
		else
		{
			System.out.println(n-1);
			for(int i = a.length-1 ; i >= 1 ;i-- )
			{
				System.out.print(pair[i].index +" ");
			}
		}
		
	}
	static class Pair implements Comparable<Pair>
	{
		int num;
		int index;
		Pair(int num,int index)
		{
			this.num= num;
			this.index = index;
		}
		public int compareTo(Pair other)
		{
			return this.num-other.num;
		}
	}
}
