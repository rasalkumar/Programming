package integralSolutions;
import java.util.*;
public class IntegerSolutions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			int coeff[] = new int[n];
			for(int i = 0 ; i < n ; i++ )
			{
				coeff[i] = in.nextInt();
			}
			int rhs = in.nextInt();
			System.out.println(integerSol(coeff, rhs));
		}
	}
	public static int integerSol(int[] coeff,int rhs)
	{
		int[] dp = new int[ rhs + 1 ];
		Arrays.fill(dp, 0);
		dp[0] = 1;
		for(int i = 0 ;i < coeff.length ; i++ )
		{
			for(int j = coeff[i] ; j <= rhs ; j++)
			{
				dp[j] = dp[j] + dp[j - coeff[i]]; 
			}
		}
		return dp[rhs];
	}

}
