package unboundedKnapsack;

import java.util.*;

public class Solution {
    static int[] dp;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            dp = new int[k + 1];
            Arrays.fill(dp, 0);
            int ans = unboundedKnapsack(k, a);
            System.out.println(ans);
        }
    }
    public static int unboundedKnapsack(int k, int[] arr) {
        for(int i = 0 ; i < arr.length ;i++)
        {
            for(int j = arr[i] ; j <= k ; j++)
            {
                if( arr[i] <= j )
                {
                    dp[j] = Math.max(dp[j] , arr[i] + dp[j - arr[i]]);
                }
            }
        }
        return dp[k];
    }
}
