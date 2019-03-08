package bitCoins;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int B = in.nextInt();
		int a[] = new int[n];
		int dp[] = new int[n];
		// dp[0]=0;
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			if (a[i] % 2 == 0) {
				dp[i] = -1;
			} else {
				dp[i] = 1;
			}
			System.out.print(dp[i]+" ");
		}
		System.out.println();
		int dp2[] = new int[n];
		int dp3[] = new int[n];
		dp2[0] = dp[0];
		System.out.print(dp2[0]+" ");
		dp3[n - 1] = dp[n - 1];
		for (int i = 1; i < n; i++) {
			dp2[i] = dp2[i - 1] + dp[i];
			System.out.print(dp2[i]+" ");
		}
		System.out.println();
	//	System.out.print(dp3[0]+" ");
		for (int i = n - 2; i >= 0; i--) {
			dp3[i] = dp3[i + 1] + dp[i];
			//System.out.print(dp3[i]+" ");
		}
		for(int  i = 0 ; i < n ;i++ )
		{
			System.out.print(dp3[i]+ " ");
		}
//		int count = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (dp2[i] == 0 && i+1 < n && dp3[i+1] == 0  ) {
				arr.add(i);
	//			count++;
			}
		}
		System.out.println(arr);
	
		 	int sum = 0 ;
			int ans = 0 ;
			for (int i = 0; i < arr.size(); i++) {
                 sum = Math.abs(a[arr.get(i)]-a[arr.get(i)+1]);
                 System.out.println(sum);
                 if(sum>B)
                 {
                	 
                	 break;
                 }
                 ans = i+1;
			}
			//System.out.println(ans);
		}
	}


