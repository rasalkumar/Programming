package oracle;
import java.util.*;
public class TreasureAndCities {
static int[] cities;
static int[] colors;
static int n,A,B;
static int MAX = 1001;
static int dp[][];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		A = in.nextInt();
		B = in.nextInt();
		cities = new int[n];
		colors = new int[n];
		for(int i = 0 ; i < n ; i++)
			cities[i] = in.nextInt();
		for(int i = 0 ; i < n ; i++)
			colors[i] = in.nextInt();
		dp = new int[MAX][MAX];
		for(int i = 0 ;i < MAX ;i++)
			for(int j = 0 ; j< MAX ; j++ )
				dp[i][j] = -1;
		System.out.println(solve(0,0));
	}
	public static int solve(int k, int col)
	{
		if(k == n)
			return  dp[k][col] = 0;
		if(dp[k][col] != -1)
			return dp[k][col];
		int sum = 0;
		if(col == colors[k])
		{
			sum += Math.max(A * cities[k] + solve(k+1,colors[k]), solve(k+1 ,col));
		}
		else
		{
			sum += Math.max(B * cities[k] + solve(k+1, colors[k]), solve(k+1,col));
		}
		dp[k][col] = sum;
		return dp[k][col];
	}

}
