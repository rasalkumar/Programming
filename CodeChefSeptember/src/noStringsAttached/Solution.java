package noStringsAttached;

import java.util.*;

class Solution {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0 )
		{
			String s = "dbca";
			int n = s.length();
			Pair pair[] = new Pair[n];
			for(int i = 0 ; i < n ; i++ )
			{
				pair[i] = new Pair(s.charAt(i),i);
			}
			Arrays.sort(pair);
			int i, j ;
			i = 0;
			j = n - 1;
			while( i < j )
			{
				
			}
			
		}
	}
	static class Pair implements Comparable<Pair>
	{
		char a;
		int index;
		Pair(char A, int ind)
		{
			a = A;
			index = ind;
		}
		public int compareTo(Pair otherPair)
		{
			return (this.a - otherPair.a);
		}
	}
	
}
