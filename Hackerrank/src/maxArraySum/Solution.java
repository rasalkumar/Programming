package maxArraySum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        for(int i = 1 ; i < arr.length;i++)
        {
            dp[i] = Math.max(dp[i-1],arr[i]);
        }
        for( int i = 2; i < arr.length ; i++ )
        {
            dp[i] = Math.max( dp[i-2] + arr[i] , Math.max(dp[i-1] , arr[i])); 
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < dp.length ;i++)
        {
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
