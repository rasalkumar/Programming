package longestDancingSubsequence;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0)
		{
			int n = in .nextInt();           //Length of input array
			int a[] = new int[n];            //Input Array
			for(int i = 0 ; i < n ;i++)
				a[i] = in.nextInt();

			int d[] = convertDancing(a);    //Dancing array
			int ans = dance(d,d.length);
			System.out.println(ans+1);     //Because array has one more element than the dancing subsequence 
		}
	}
	public static int dance(int[]a ,int n)  //LIS logic Bottom Up manner
	{
		int dp[]= new int[a.length+1];
		Arrays.fill(dp, 1);
		for(int i = 1 ;i < n; i++)
		{
			for(int j = 0 ; j < i ; j++ )
			{
				if(Math.signum(a[i]) != Math.signum(a[j]) && dp[i] < dp[j] + 1 )
				{
					dp[i] = dp[j] + 1;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < dp.length ; i++)
			max = Math.max(max, dp[i]);
		return max;
	}
	public static int[] convertDancing(int[] a)  // Helper function for dancing conversion
	{
		int ans[] = new int[a.length-1];
		for(int i = 1 ; i < a.length; i++)
			ans[i-1] = a[i]- a[i-1];
		return ans;
	}
 
}
