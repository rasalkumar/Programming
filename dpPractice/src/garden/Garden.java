package garden;
import java.util.*;
class Garden {
	static int a[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		a = new int[n];
		for(int i = 0 ; i < n ; i++ )
			a[i] = in.nextInt();
		int dp[] = new int[n];
		for(int i = 0 ; i < n ; i++)
		{
			if(k % a[i] == 0 )
				dp[i] = k / a[i];
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i < dp.length ;i++)
		{
			if(dp[i] != 0)
			{
				min = Math.min(dp[i], min);
			}
		}
		System.out.println(min);
	}

}
