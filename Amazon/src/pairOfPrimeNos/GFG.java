package pairOfPrimeNos;

/*package whatever //do not write package name here */

import java.util.*;
//import java.lang.*;
//import java.io.*;

class GFG {
	public static void main(String[] args) {
		// code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			ArrayList<Integer> prime = new ArrayList<>();
			boolean[] prime1 = new boolean[n + 1];
			Arrays.fill(prime1, true);
			// int count = 0 ;
			for (int p = 2; p * p <= n; p++) {
				if (prime1[p] == true) {
					for (int i = 2 * p; i <= n; i += p) {
						prime1[i] = false;
					}
				}
			}
			for (int i = 2; i < n; i++) {
				if (prime1[i] == true) {
					prime.add(i);
				}
			}

			//int i = 0;
			//int j = 0;
			for (int i =0 ; i < prime.size();i++)  
			{
				for(int j = 0 ; j < prime.size() ; j++){
				if (prime.get(i) * prime.get(j) <= n) {
					 System.out.print(prime.get(i));
					 System.out.print(" ");
					 System.out.print(prime.get(j));
					 System.out.print(" ");
					 
				} 
				}
			}
			System.out.println();
		}
	}
}