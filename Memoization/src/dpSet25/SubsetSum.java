package dpSet25;
import java.util.*;
public class SubsetSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for(int i = 0 ; i < n ; i++ )
		{
			a[i] = in.nextInt();
		}
		int sum = in.nextInt();
		boolean dp[] = new boolean[n+1];
		for(int i = 0 ; i <= n ; i++ )
		{
			dp[i] = false;
		}
		SubsetSum obj = new SubsetSum();
		System.out.println(obj.isSubsetSum(a,n,dp,sum));
	}
	public boolean isSubsetSum(int[] a,int n,boolean[] dp,int sum)
	{
		if(sum > 0 && n == 0)
		{
			return false;
		}
		if( sum == 0 )
		{
			return true;
		}
		
		return isSubsetSum(a, n - 1, dp, sum - a[n-1] ) || isSubsetSum(a, n - 1, dp, sum);
	}

}
