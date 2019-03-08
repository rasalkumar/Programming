package dp;
import java.util.*;
public class Test1 {
	static int n;
	static int a[];
	static int dp[][];
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 
	}
	public static void optimalStratey()
	{
		dp = new int[n+1][n+1];
		for(int i = 0 ; i < n + 1 ; i++)
		{
			for(int j = 0 ; j < n + 1 ; j++ )
			{
				dp[i][j] = -1;
			}
		}
		System.out.println(helper(1,n));
	}
	public static int helper(int i,int j)
	{
		if(i == 0 || j == 0)
			return 0;
		if(i == j )
			return a[i-1];
		if(i == j + 1 )
			return Math.max(a[j], a[j-1]);
		if(dp[i][j] >= 0)
			return dp[i][j];
		dp[i][j] = Math.max( a[i-1] + Math.min( helper( i + 2 , j ), helper(i + 1 , j - 1)) 
					, a[j-1] + Math.min( helper( i , j - 2 ) , helper( i + 1 , j - 1 ) ));
		return dp[i][j];
	}
	public static void palindromePartition()
	{
		String s = in.next();
		dp = new int[n+1][n+1];
		for(int i = 0 ; i < n + 1 ; i++)
		{
			for(int j = 0 ; j < n + 1 ; j++ )
			{
				dp[i][j] = -1;
			}
		}
		System.out.println(helper2(s,0,n));
		
	}
	public static int helper2(String s ,int i ,int j)
	{
		if(i == j)
			return 0;
		if(isPalin(s,i,j))
			return 0;
		if(dp[i][j] >= 0)
			return dp[i][j];
		dp[i][j] = Integer.MAX_VALUE;
		for( int k = i ; k < j ; k++ )
		{
			dp[i][j] = Math.min(dp[i][j], 1 + helper2(s,i,k) + helper2(s,k+1,j));
		}
		return dp[i][j];
		
	}
	public static boolean isPalin(String s, int i ,int j)
	{
		while(i <= j)
		{
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	public static void diceThrow()
	{
		int m = in.nextInt();
		int x = in.nextInt();
		dp = new int[n+1][n+1];
		for(int i = 0 ; i <= m ; i++)
		{
			for(int j = 0 ; j <= x ; j++ )
			{
				dp[i][j] = -1;
			}
		}
		System.out.println(helper3(m,x));
		
		
	}
	public static int helper3(int m ,int x)
	{
		if(x <= 0 || m <= 0 )
			return 0;
		if(x == 0)
			return 0;
		if(dp[m][x] >= 0)
			return dp[m][x];
		int max = Integer.MAX_VALUE;
		for(int i = 1; i <= m && i <=x ; i++)
		{
			dp[m][x] = helper3(m-1 , x - i) + dp[m][x];
		}
		return dp[m][x];
	}
	public static void partition()
	{
		int sum = in.nextInt();
		int n = in.nextInt();
		if(sum % 2 != 0 )
			System.out.println("FALSE");
		for(int i = 0 ; i < n ; i++	)
		{
			a[i] = in.nextInt();
		}
		boolean dp[][] = new boolean[n+1][sum/2 + 1];
		System.out.println(helper4(dp, n , sum /2));
	}
	public static boolean helper4(boolean[][] dp,int n ,int sum)
	{
		if(sum==0)
			return true;
		if(n == 0 && sum != 0 )
			return false;
		if( a[n-1] > sum )
		{
			dp[n][sum] = helper4( dp , n - 1 , sum );
			return false;
		}
		dp[n][sum] = helper4( dp,n - 1 , sum ) || helper4( dp ,n - 1 , sum - a[n] );
		if(dp[n][sum])
			return true;
		return false;
	}
	public static void rodCutting()
	{
		int n = in.nextInt();
		int[] prices = new int[n];
		for(int i = 0 ; i < n ; i++ )
			prices[i] = in.nextInt();
		int dp[] = new int[n+1];
		Arrays.fill(dp,-1);
		System.out.println(helper5(prices,n,dp));
	}
	public static int helper5(int[] prices, int n, int[] dp)
	{
		if( dp[n] >= 0 )
			return dp[n];
		int max = Integer.MIN_VALUE;
		if(n == 0)
			max = 0 ; 
		
		for(int i = 0 ; i < n ; i++ )
			max = Math.max( max , prices[i] + helper5(prices , n - i - 1, dp ));
		dp[n] = max;
		return dp[n];
	}
	public static void longestPalindromicSubsequence()
	{
		String s = in.next();
		int dp[][] = new int[s.length()][s.length()];
		for(int i = 0 ; i <= s.length() ; i++ )
		{
			for(int j = 0 ; j <= s.length() ; j++ )
			{
				dp[i][j] = -1 ;
			}
		}
		System.out.println(helper6(s,0,n-1,dp));
	}
	public static int helper6(String s,int i,int j , int[][] dp)
	{
		if( i == j )
			return 1;
		if(s.charAt(i) == s.charAt(j) && i + 1 == j )
		{
			return 2;
		}
		if(dp[i][j] >= 0)
			return dp[i][j];
		if(s.charAt(i) == s.charAt(j) )
		{
			dp[i][j] = helper6(s, i + 1, j - 1, dp) + 2;
		}
		else
		{
			dp[i][j] = helper6(s, i + 1 , j , dp ) + helper6(s, i , j - 1 , dp); 
		}
		return dp[i][j];
	}
	public static void eggDrop()
	{
		int n = in.nextInt(); // No of eggs
		int k = in.nextInt(); // No of floors
		int dp[][] = new int[n+1][k+1];
		for(int i = 0 ; i <= n ; i++ ){
			for(int j = 0 ; j <= k ; j++)
			{
				dp[i][j] = -1;
			}
		}
		System.out.println(helper7(n,k,dp));
	}
	public static int helper7(int n,int k ,int[][] dp)
	{
		if( k == 1 || k == 0 )
			return k;
		if( n == 1 )
			return k;
		if(dp[n][k] >= 0 )
			return dp[n][k];
		for(int i = 1 ; i <= k ; i++ )
		{
			dp[n][k] = Math.min(dp[n][k], helper7(n-1, k-1,dp) + helper7(n,k-i,dp));
		}
		return dp[n][k];
	}
	public static void knapsack()
	{
		int n = in.nextInt();
		int[] val = new int[n];
		int[] w = new int[n];
		for(int i = 0 ; i < n ; i++ )
		{
			val[i] = in.nextInt();
		}
		for(int i = 0 ;  i <  n ; i++)
		{
			w[i] = in.nextInt();
		}
		int wt = in.nextInt();
		dp = new int[n+1][wt+1];
		for(int i = 0  ;i  <= n ; i++ )
		{
			for(int j = 0 ; j <= wt ; j++ )
			{
				dp[i][j] = -1;
			}
		}
		System.out.println(helper8(val,w,n,wt));
	}
	public static int helper8(int[] val ,int[] w,int n,int wt)
	{
		if(dp[n][wt] >= 0 )
			return dp[n][wt];
		if( w[n-1] > wt  )
			return helper8(val,w,n-1,wt);
		else
			dp[n][wt] = Math.max(val[n-1] + helper8(val,w,n-1,wt-w[n-1]) , 
					helper8(val,w,n-1,wt) );
		return dp[n][wt];
	}
	public static void matrixMultiplication()
	{
		int n = in.nextInt();
		int p[] = new int[n + 1];
		for(int i = 0 ; i <= n ; i++ )
		{
			p[i] = in.nextInt();
		}
		dp = new int[n][n];
		for(int i = 0 ;  i <= n ;i++)
		{
			for(int j = 0 ;j <= n ; j++ )
			{
				dp[i][j] = -1;
			}
		}
		System.out.println(helper9(p,1,n));
	}
	public static int helper9(int[] p , int i ,int j)
	{
		if(i == j)
			return 0;
		if(dp[i][j] >= 0 )
			return dp[i][j];
		dp[i][j] = Integer.MAX_VALUE;
		for(int k = i ; i < j ; i++ )
		{
			dp[i][j] = Math.min(dp[i][j], helper9(p,i,k)+helper9(p,k+1,j)+p[i-1]*p[k]*p[j]); 
		}
		return dp[i][j];
	}
	public static void coinChange()
	{
		int m =in.nextInt();
		n = in.nextInt();
		int[] s = new int[m];
		for(int i = 0 ; i < m ; i++ )
		{
			s[i] = in.nextInt();
		}
		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		System.out.println( helper10(dp,s,n,m) );
	}
	public static int helper10( int[] dp , int[] s,int n,int m )
	{
		if( n == 0 )
			return 1;
		if(n < 0)
			return 0;
		if( m <= 0 && n >= 1)
			return 0;
		if( dp[n] >= 0 )
			return dp[n];			
		for(int  i = s[m-1] ; i <= n ; i++ )
			dp[i] = helper10(dp,s,n-i,m-1) + helper10(dp,s,n,m-1);
		return dp[n];
	}
}
