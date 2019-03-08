package goldmannSachs;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String feeOrUpfront(int n, int k, int x, int d, int[] p) {
   // 	String s="";
    	double sum=0;
        double a[]=new double[n];
        for(int i=0;i<n;i++)
        {
        	a[i]=Math.max(k, x*p[i]/100.0);
        	sum=sum+a[i];
        }
        if(sum>d)
        {
        	return "upfront";
        }
        else
        {
        	return "fee";
        }
        
    //	return s;
        // Complete this function
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int x = in.nextInt();
            int d = in.nextInt();
            int[] p = new int[n];
            for(int p_i = 0; p_i < n; p_i++){
                p[p_i] = in.nextInt();
            }
            String result = feeOrUpfront(n, k, x, d, p);
            System.out.println(result);
        }
        in.close();
    }
}