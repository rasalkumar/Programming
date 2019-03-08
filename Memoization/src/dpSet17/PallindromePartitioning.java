package dpSet17;
import java.util.*;
public class PallindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in) ;
		String a = in.next();
		int dp[][] = new int[a.length()+1][a.length()+1];
		for(int i = 0 ; i < a.length() + 1 ; i++)
		{
			for(int j = 0 ; j < a.length() + 1 ; j++)
			{
				dp[i][j] = -1;
			}
		}
		PallindromePartitioning obj = new PallindromePartitioning();
		System.out.println(obj.palpartition(a,0,a.length()-1,dp));

	}

	public int palpartition(String a, int i, int j, int[][] dp) {
		if(i==j)
		{
			return 0;
		}
		if(isPalin(a,i,j))
		{
			return 0;
		}
		if(dp[i][j] >= 0)
		{
			return dp[i][j];
		}
		dp[i][j] = Integer.MAX_VALUE;
		for(int k = i ; k < j ; k++)
		{
			dp[i][j] = Math.min(dp[i][j], 1 + palpartition(a, i, k, dp) + palpartition(a, k+1, j, dp));
		}
		return dp[i][j];
	}

	public boolean isPalin(String a, int i, int j) {
		// TODO Auto-generated method stub
		int flag =1;
		while(i<=j)
		{
			if((a.charAt(i) != a.charAt(j)))
			{
				flag = 0;
				break;
			}
			i++;
			j--;
		}
		if(flag == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

}
