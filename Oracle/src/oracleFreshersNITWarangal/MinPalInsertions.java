package oracleFreshersNITWarangal;
import java.util.*;
public class MinPalInsertions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			String s =in.next();
			
			int dp[][] =new int[s.length() + 1][s.length() + 1];
			for(int i = 0 ; i < s.length() + 1 ; i++ )
				for(int j = 0 ; j < s.length() + 1 ; j++ )
					dp[i][j] = - 1;
			int ans = minPalIns(s,0,s.length()-1,dp);
			System.out.println(ans);
		}
	}
	public static int minPalIns(String s,int i, int j,int[][] dp)
	{
		if(i>j)
			return 0;
		if( dp[i][j] >= 0 )
			return dp[i][j];
		if(s.charAt(i)==s.charAt(j))
			dp[i][j] = minPalIns(s, i + 1 , j - 1 , dp);
		else
			dp[i][j] = 1 + Math.min(minPalIns(s, i+1, j, dp), minPalIns(s, i, j - 1 , dp)); 
		return dp[i][j];
	}

}
