package dpSet24;
import java.util.*;
public class OptimalBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] keys = new int[n];
		int[] freq = new int[n];
		for(int i = 0 ; i < n ; i++ )
		{
			keys[i] = in.nextInt();
		}
		for(int i = 0 ; i < n ; i++ )
		{
			freq[i] = in.nextInt();
		}
		Pair[] pair = new Pair[n];
		for(int i = 0 ; i < n ; i++ )
		{
			pair[i] = new Pair(keys[i],freq[i]);
		}
		Arrays.sort(pair);
		for(int i = 0 ; i < n ; i++ )
		{
			pair[i].key = keys[i];
			pair[i].freq = freq[i];
		}
		int dp[][] = new int[n][n];
		for(int i = 0 ; i < n ; i++ )
		{
			for(int j = 0 ; j < n ; j++)
			{
				dp[i][j] = -1;
			}
		}
		OptimalBinarySearchTree obj =new OptimalBinarySearchTree();
		System.out.println(obj.minCost(0,n-1,keys,freq,dp));
	}

	public int minCost(int i, int j, int[] keys, int[] freq, int[][] dp) {
		// TODO Auto-generated method stub
		if(i>j)
		{
			return 0;
		}
		if(i==j)
		{
			return freq[i];
		}
		if(dp[i][j]>=0)
		{
			return dp[i][j];
		}
		for( int k = i ; k <= j ; k++ )
		{
			dp[i][j] = minCost(i, k-1, keys, freq, dp) + minCost(k+1, j, keys, freq, dp);
		}
		int sum = sumFreq(freq,i,j);
		return sum+dp[i][j];
	}
	public int sumFreq(int[] freq ,int i ,int j)
	{
		int sum= 0 ;
		for(int k = i; k <= j ; k++ )
		{
			sum += freq[k];
		}
		return sum;
	}
	static class Pair implements Comparable<Pair>
	{
		int key,freq;
		Pair(int key,int freq)
		{
			this.key = key;
			this.freq = freq;
		}
		public int compareTo(Pair other)
		{
			return this.key-other.key;
		}
	}
}
