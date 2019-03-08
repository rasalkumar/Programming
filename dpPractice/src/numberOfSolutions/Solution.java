package numberOfSolutions;
import java.util.*;
public class Solution {
	static int coeff[];
	static int[] dp;
	public static void main(String[] args) {
		// TODO generated method stub
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while( t-- > 0 )
        {
        	int n = in.nextInt();
        	coeff = new int[n];
        	for(int i = 0 ; i < n ; i++ )
        		coeff[i] = in.nextInt();
        	int rhs = in.nextInt();
        	dp = new int[rhs + 1];
        	for(int i = 0 ; i <= rhs ; i++ )
        		dp[rhs] = 0;
        	System.out.println(countSolutions(rhs,0,n));
        	System.out.println(bottomUpDp(rhs,n));
//        	for(int i = 0 ; i <= rhs ; i++ )
//        		System.out.println(dp[i]);;
        }
        
	}
	//Bottom Up Solution :
	static int bottomUpDp(int rhs,int n)
	{
		int[] dp = new int[rhs + 1];
		Arrays.fill(dp, 0);
		dp[0] = 1 ;
		for(int i = 0; i < n; i++)
		{
			for( int j = coeff[i]; j <= rhs ; j++ )
			{
				dp[j] += dp[j-coeff[i]];
			}
		}
		return dp[rhs];
	}
	//Top Down
	public static int countSolutions(int rhs,int start,int end)
	{
		if(rhs == 0)
			return 1;
//		if(dp[rhs] > 0)
//			return dp[rhs];
		
		int result = 0;
		for(int i = start ;i < end ; i++)
		{
			if(coeff[i] <= rhs )
				result = result + countSolutions(rhs - coeff[i] , i, end);
		}
		return result;
	}

}
