package flipkart;
/*
 * Given an integer, , we want to find the largest subset of integers in the
 *  inclusive range from  to  such that the Least Common Multiple (LCM) of the
 *   elements in the subset is equal to . We then want to find the of all integers in this subset.

Complete the  function in the editor below. It has one parameter: an array of  integers, .
 The function must return an array of  long integers where the value at each index  (where ),
  denotes the  of the elements in the largest subset of integers in the inclusive range from  
  to  such that the LCM of the elements in the subset is .

Input Format

The first line contains an integer, , denoting the number of elements in . 
Each line  of the  subsequent lines (where ) contains an integer describing .

Constraints

Output Format

The function must return an array of  long integers where the value at each index  (where ), 
denotes the sum of the elements in the largest subset of numbers in the inclusive range from  
to  such that the LCM of the elements in the subset is .

Sample Input 0

2
2
4
Sample Output 0

3
7
Explanation 0

Given , we perform the following sequence of operations to fill our return array, :

, so our set of numbers is . The longest subset with LCM  is , so we set .
, so our set of numbers is . The longest subset with LCM  is , so we set .
We then return  as our answer.

Sample Input 1

1
10
Sample Output 1

18
Sample Input 2

2
5
6
Sample Output 2

6
12
 * */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class LargestSubsetSum {
	
	

	public static long[] maxSubsetSum(int[] k) {
		long[] ans = new long[k.length];
		for (int i = 0; i < k.length; i++) {
			long sum = 0;
			for (int j = 1; j * j <= k[i]; j++) {
				if (k[i] % j == 0) {
					if (j != k[i] / j)
						sum += j + k[i] / j;
					else
						sum += j;
				}
			}
			ans[i] = sum;
		}
		return ans;
		// Complete this function
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] k = new int[size];
		for (int k_i = 0; k_i < size; k_i++) {
			k[k_i] = in.nextInt();
		}
		long[] res = maxSubsetSum(k);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i] + (i != res.length - 1 ? " " : ""));
		}
		System.out.println("");

		in.close();
	}
}
