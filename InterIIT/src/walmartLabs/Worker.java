package walmartLabs;
import java.util.*;
public class Worker {
static int earnings[];
static int cost[];
static int[][] dp;
static int initialEnergy;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		earnings = new int[n];
		cost = new int[n];
		for(int i = 0 ; i < n ;i++)
		{
			earnings[i] = in.nextInt();
		}
		for(int i = 0 ; i < n ;i++)
		{
			cost[i] = in.nextInt();
		}
		int energy = in.nextInt();
		initialEnergy = energy;
		dp = new int[n+1][energy+1];
		for(int i = 0 ; i <= n ;i++)
		{
			for(int j = 0 ; j <= energy ;j++)
			{
				dp[i][j] = -1;
			}
		}
		System.out.println(helper(n,energy));
//		for(int i = 0 ; i <= n ;i++)
//		{
//			for(int j = 0 ; j <= energy ;j++)
//			{
//				System.out.print(dp[i][j] + " ") ;
//			}
//			System.out.println();
//		}
	}
	public static int helper(int n,int energy)
	{
		if(n == 0)
			return 0;
		if(energy <= 0)
		{
			return 0;
		}
		if(energy > initialEnergy)
			return 0;
		if(dp[n][energy] >= 0)  //Memoization DP
		{
			return dp[n][energy];
		}
		else
		{
			//System.out.println("**");
			dp[n][energy] = Math.max((Math.max(earnings[n-1] +helper(n-1, energy - 1),// I worked and i earned 
					helper(n-1, energy+1) +earnings[n-1] - cost[n-1] )), // I worked and i earned and i ate
					(Math.max(helper(n-1,energy),          // I didnt work     
							helper(n-1,energy + 1) - cost[n-1] )));  // I didnt work and i ate.
		}
		return dp[n][energy];
	}

}
