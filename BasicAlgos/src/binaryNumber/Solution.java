package binaryNumber;

import java.util.Scanner;
public class Solution {



    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        

        String s = Integer.toString(n,2);
        System.out.println(s);
        int dp[] = new int[s.length()];
        dp[0] = (int)(s.charAt(0) - '0' );
        for(int i = 1; i < s.length() ; i++ )
        {
            if(s.charAt(i) == '0')
                dp[i] = 0 ;
            else
                dp[i] = dp[i-1] + 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < dp.length ; i++ )
            max = Math.max(dp[i],max);
        System.out.println(max);

       
    }
}
