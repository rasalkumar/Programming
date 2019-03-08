package quick2;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Rasal
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        MajinVegeta solver = new MajinVegeta();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class MajinVegeta {
    	
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            long sum = 0;
            //long p = primeFactors(n);
            //sum = sum+p;
            int i, j;
			int[] factorCount=new int[m+1]; 
		    for (i = 0; i <= m; i++) {
		        factorCount[i] = 0;
		    }

		    for (i = 2; i <= m; i++) {
		        if (factorCount[i] == 0) { // Number is prime
		            for (j = i; j <= m; j += i) {
		                factorCount[j]++;
		            }
		        }
		    }
		    for(int t = n; t<m;t++)
		    {
		    	sum = sum+factorCount[t];
		    }
            out.println(sum);
        }
         
       

		
    }
}

