package balloons;


import java.util.Scanner;
import java.util.Arrays;
//import java.util.*;
public class Balloons {
	
	//code
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n  = in.nextInt();
			int b[] =new int[n+2];
			b[0] = 1;
			b[n+1] = 1;
			for(int i = 1; i < n + 1 ; i++ )
			{
				b[i] = in.nextInt();
			}
			int dp[][] = new int[n + 2][n + 2];
			for(int i = 0 ; i < n ; i++ )
			{
				for(int j = 0 ; j < n ; j++ )
				{
					dp[i][j] = 0 ;
				}
			}
		//	Balloons obj = new Balloons();
			long startTime = System.currentTimeMillis();
			System.out.println(burstUsingRecursion(dp,b,0,n+1,n));
			long endTime = System.currentTimeMillis();
			System.out.println("Took "+(endTime - startTime) + " millis Uding Recursion");
			
			for(int i = 0 ; i < n ; i++ )
			{
				for(int j = 0 ; j < n ; j++ )
				{
					dp[i][j] = 0 ;
				}
			}
			
			startTime = System.currentTimeMillis();
			System.out.println(burstUsingDp(b,n)+"********");
			endTime = System.currentTimeMillis();
			System.out.println("Took "+(endTime - startTime) + " millis Uding Dp");
		}
	}
	public static int burstUsingDp(int[] arr,int n)
	{
		int[] b = new int[n];
		for(int i = 1 ;i <= n ;i++)
		{
			b[i-1] = arr[i];
		}
		int dp[][]= new int[20][20];
		for(int length = 1 ; length <= n ; length++ )
		{
			for( int i = 0 ; i <= n - length ; i++ )
			{
				int j = i + length - 1;
				for(int k = i ; k <= j ; k++ )
				{
					int leftVal = 1;
					int rightVal = 1;
					if( i != 0 )
					{
						leftVal = b[i-1];
					}
					if( j != n - 1)
					{
						rightVal = b[j + 1];
					}
					int before = 0; 
					if(k != i)
						before = dp[i][k-1];
					int after = 0;
					if(k != j)
						after = dp[k+1][j];
					if(i == 0 && j == n - 1)
						dp[i][j] = Math.max(b[k] + before +after, dp[i][j]);
					else
						dp[i][j] = Math.max((leftVal*rightVal)+ before + after, dp[i][j]);
				}
			}
		}
		return dp[0][n-1];
	}
	
	
	public static int burstUsingRecursion(int[][] dp, int[] b, int left, int right,int n)
	{
		int max = 0;
		for( int i  = left + 1 ; i < right ; i++ )
		{
			int curr = 0 ;
			curr = burstUsingRecursion(dp , b , left , i , n ) + burstUsingRecursion( dp , b , i , right , n );
			if( left == 0 && right == n + 1 )
			{
				curr += b[i];
			}
			else
			{
				curr += b[left] * b[right]; 
			}
			if( curr > max )
			{
				max = curr;
			}
		}
	    return max;
	}
}
