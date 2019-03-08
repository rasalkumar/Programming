package flipkart;
/*
Flipkart IIT Kanpur 2018
Given a limited number of coins of denominations 1, 5, 10, and 25
as p, q, r, and s respectively, return the maximum number of coins 
which can be used to reach a target "price", if possible.
Your function should return a vector of length 4 representing the
number of coins used for the denominations 1, 5, 10, 25 respectively.
If no solution is possible, return a vector of 0s.
0 <= price, p, q, r, s <= 100000
*/

import java.util.*;
public class MaxCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =new Scanner(System.in);
		int coins[] = new int[4];
		for(int i = 0 ; i < 4 ;i++)
		{
			coins[i] = in.nextInt();
		}
		int price = in.nextInt();
		int[] dp = new int[price + 1];
		Arrays.fill(dp, 0);
		for(int i = 0 ; i < coins.length ; i++ )
		{
			dp[coins[i]] = Math.max(1, dp[coins[i]] );
			for(int j = coins[i] + 1 ;j <= price ; j++ )
			{
				if(dp[j - coins[i]] != 0)
					dp[j] = Math.max(dp[j],1 + dp[j - coins[i]] );
			}
		}
		System.out.println(dp[price]);
		//Arrays.sort(coins);
		//int x[] = new int[4];
		int a = price / coins[0];
		int b = price / coins[1];
		int c = price / coins[2];
		int d = price / coins[3];
		int flag = 0;
		for(int i = 0 ; i <= a ; i++ )
		{
			for(int  j = 0 ; j <= b ; j++ )
			{
				for(int k = 0 ; k <= c; k++ )
				{
					for( int l = 0 ; l <= d ; l++ )
					{
						if(i + j + k + l == dp[price] 
							&& (i * coins[0]) + (j * coins[1]) + (k * coins[2]) + (l * coins[3]) == price )
						{
							flag = 1;
							System.out.println(i + " " + j + " " + k + " " + l );
							break;
						}
					}
					if(flag==1)break;
				}if(flag==1)break;
			}if(flag==1)break;
		}
		if( flag == 0 )
			System.out.println("0" + " " + "0" + " " + "0" + " " + "0" );
	}

}
