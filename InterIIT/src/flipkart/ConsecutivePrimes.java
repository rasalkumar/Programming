package flipkart;
/*
 * There are n Integers given in an Array Numbers. 
 * The maximum size of contiguous subarray has to be calculated where all integers are prime
 * it is known that that the difference between the smallest and the largest Integer is < 10 ^ 6.
 * 
 */
		
import java.util.*;
public class ConsecutivePrimes {
	static int a[];
	static int dp[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		a = new int[n];
		for(int i = 0 ; i < n ;i++)
		{
			a[i] = in.nextInt();
		}
		dp = new int[n];
		dp[0] = isPrime(a[0]) ? 1 : 0 ;
		for(int i = 0 ; i < n; i++ )
		{
			if(isPrime(a[i]))
				dp[i]= dp[i-1] + 1;
			else
				dp[i] = 0;
		}
		int ans = Integer.MIN_VALUE;
		for(int i = 0 ; i < n  ;i++)
			ans = Math.max(dp[i], ans);
		System.out.println(ans);
	}
	
	public static boolean isPrime(int n)
	{
		 if(n==1)return false;
		 if(n==2)return true;
		 if(n==3)return true;
		 if(n % 2 == 0)return false;
		 if(n % 3 == 0)return false;
		 long i = 5 ; int k = 2;
		 while( i * i <= n)
		 {
			 if(n % i == 0)
				 return false;
			 i = k + i ;
			 k = 6 - k;
		 }
		 return true;
	}

}
