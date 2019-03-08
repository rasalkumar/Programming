package sumOfFibonacciNos;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n  = in.nextInt();
		Solution obj = new Solution();
		System.out.println(obj.fibSum(n));
	}
	public int fibSum(int n )
	{
		if(n <=2 )
		{
			return 1;
		}
		ArrayList<Integer> arr = new ArrayList<>();
		int a  = 1; 
		int b = 1;
		arr.add(a);
		while( a + b <= n )
		{
			int c = a + b ;
			arr.add(c);
			a = b ;
			b = c ;
		}
		System.out.println(arr);
		int ar[] = new int[arr.size()];
		for(int i  = 0 ; i < arr.size() ; i++ )
		{
			ar[i] = arr.get(i);
		}
		int dp[] = new int[n+1];
		for(int i = 0 ; i < n+1 ; i++)
		{
			dp[i] = Integer.MAX_VALUE ;
		}
		int ans = solve(dp, n ,ar);
		return ans;
		
	}
	public int solve(int[] dp,int n,int[] ar)
	{
		if(n<0)
		{
			return 0;
		}
		if(n==0)
		{
			return 1;
		}
		if(dp[n] != Integer.MAX_VALUE )
		{
			return dp[n];
		}
		for(int i = 0 ; i <ar.length ; i++ )
		{
			dp[n] =Math.min(1 + solve( dp , n - ar[i] , ar ) , dp[n] ); 
		}
//		for(int i = 0 ; i < dp.length ;i++)
//		{
//			System.out.println(dp[i]);
//		} 
		return dp[n];
	}

}
