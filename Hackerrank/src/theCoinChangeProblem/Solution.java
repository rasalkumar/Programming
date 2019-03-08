package theCoinChangeProblem;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long getWays(long n, long[] c){
        // Complete this function
        long table[]=new long[(int) (n+1)];
        Arrays.fill(table,0);
        table[0]=1;
        for(int i=0;i<(c.length);i++)
        {
            for(long j=(int) c[i];j<=n;j++)
            {
                table[(int) j]+=table[(int) (j-c[(int) i])];
            }
        }
        return table[(int) n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
    }
}