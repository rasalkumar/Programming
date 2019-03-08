package optimalBinarySearchTree;
import java.util.*;
public class Obst {
	static int[] key;
	static int[] freq;
	static int[][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		key = new int[n];
		freq = new int[n];
		for( int i = 0 ; i < n ; i++ )
		{
			key[i] = in.nextInt();
		}
		for( int i = 0 ; i < n ; i++ )
		{
			freq[i] = in.nextInt();
		}
		Pair[] pair = new Pair[n];
		for(int i = 0 ; i < n; i++ )
		{
			pair[i] = new Pair(key[i],freq[i]);
		}
		Arrays.sort(pair);
		for( int i = 0 ; i < n ; i++ )
		{
			key[i] = pair[i].key;
			freq[i] = pair[i].freq;
		}
		int[][] dp = new int[n][n];
		for( int i = 0 ; i < n ; i++ )
		{
			for( int j = 0 ; j < n ; j++ )
			{
				dp[i][j] = -1;
			}
		}
		//System.out.println(mincost);
		
	}
	public static int minCost(int i,int j)
	{
		if( i > j )
			return 0;
		if( i == j )
			return freq[i];
		int sum = sumFreq(i,j);
		if( dp[i][j] >= 0 )
			return dp[i][j];
		for( int k = i ; k <= j ; k++ )
		{
			dp[i][j] = minCost(i, k-1) + minCost(k+1, j);
		}
		 
		return dp[i][j] + sum;
	}
	static int sumFreq(int i, int j)
	{
		int sum = 0;
		for(int k = i; k <= j ; k++ )
		{
			sum += freq[k]; 
		}
		return sum;
	}
	static class Pair implements Comparable<Pair>
	{
		int key;
		int freq;
		Pair(int val,int freq)
		{
			this.key = val;
			this.freq = freq;
		}
		public int compareTo(Pair other)
		{
			return this.key - other.key;
		}
	}

}
