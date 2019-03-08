package oracle;
import java.util.*;
public class CountWays {
static int[][] dp;
static int MAX = 101;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		dp = new int[MAX][2];
		int n = in.nextInt();
		for(int i  = 0; i < MAX ; i++ )
		{
			for(int j = 0 ; j < 2 ; j++ )
			{
				dp[i][j] = -1;
			}
		}
		System.out.println(helper(n,0));

	}
	static int helper(int n, int flag) 
	{ 
	    if (dp[n][flag] != -1) 
	        return dp[n][flag]; 
	  
	    if (n == 0) 
	        return 1; 
	  
	    // 2 is not scored last time so we can 
	    // score either 2 or 1 
	    int sum = 0; 
	    if (flag == 0 && n > 1) 
	        sum = sum + helper(n - 1, 0) + helper(n - 2, 1); 
	  
	    // 2 is scored last time so we can only score 1 
	    else
	        sum = sum + helper(n - 1, 0); 
	  
	    return dp[n][flag] = sum; 
	} 

}
