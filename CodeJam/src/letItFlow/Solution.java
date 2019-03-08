package letItFlow;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int m = 1;
        while(t-->0)
        {
        	int n = in.nextInt();
        	char g[][] = new char[3][n];
        	for(int i = 0 ; i < 3 ;i++)
        	{
        		String s = in.next();
        		for(int j = 0 ; j < s.length() ; j++)
        		{
        			g[i][j]= s.charAt(j);
        		}
        	}
        	if(m==1)
        	{
        		System.out.println();
        	}
        	System.out.println("Case #" + m + ": " + solve(g,n));
        	m++;
        }
	}
	public static long solve(char[][] g,int n)
	{
		//if Odd
		if( n%2 != 0 )
		{
			return 0;
		}
		// if start and end blocked
		if(g[0][0]=='#'|| g[2][n-1]=='#')
		{
			return 0; 
		}
		// ignore other diagonal corners
		g[2][0]='.';
		g[0][n-1]='.';
		// if middle row blocked
		for(int i = 0 ; i < n ;i++)
		{
			if(g[1][i] == '#' )
			{
				return 0;
			}
		}
		if(n==2)
		{
			return 1; 
		}
		int count = n/2 -1 ; 
		//if upper and bottom row of the same column both blocked
		for(int i = 1 ; i < n - 1 ; i+=2)
		{
			if(g[0][i]=='#' && g[2][i]=='#')
			{
				return 0;
			}
			if(g[0][i+1]=='#' && g[2][i]=='#')
			{
				return 0;
			}
			if(g[0][i+1]=='#' && g[2][i+1]=='#')
			{
				return 0;
			}
			if(g[0][i]=='#' && g[2][i+1]=='#')
			{
				return 0;
			}
		}
		for(int i = 1 ; i < n - 1 ; i+=2)
		{
			if (g[0][i]=='#'||g[2][i]=='#'||g[0][i+1]=='#'||g[2][i+1]=='#')
			{
				count--;
			}
		}
		return calculate(count);
	}
	public static long calculate(int count)
	{
		long mod = 1000000007;
		long ans = 1;
		for(int i = count ; i > 0 ; i-- )
		{
			ans = (2 * ( ans % mod ) ) % mod;
		}
		return ans;
	}

}
