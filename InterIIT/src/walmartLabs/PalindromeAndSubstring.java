package walmartLabs;
/*
Walmart Labs IIT Dhanbad 2018
Given strings A and B, find the minimum number of manipulation done in string A
to achieve the following:
1. A is a palindrome
2. B is a substring in A
Here manipulation is defined as changing a character to some other character
1 <= String Lengths <= 5000
O(N^2)
*/
/*
SAMPLE INPUT:
7
xycdabyx abcd
acba abc
abcba abc
aaaa bbb
aa ab
aba c
abba c
SAMPLE OUTPUT:
6
-1
0
4
-1
1
2
*/

import java.util.*;
public class PalindromeAndSubstring {
	public static void main(String args[]) 
	{
		Scanner in = new Scanner(System.in);
	    int t = in.nextInt(); 
	    while ( t-- > 0 ) {
	        String a = in.next();
	        String b = in.next();
	        System.out.println(palSubstring(a, b));
	    }
	   
	}
	public static int palSubstring(String a, String b) {
	    int n = a.length(), m = b.length();

	    int ans = n + 1;
	    for (int i = 0; i <= n - m; i++) {
	        // Assuming A[i .. i + m - 1] is equal to B
	        int cost = 0, error = 0;
	        
	        char[] s = a.toCharArray();
	        char[] p = b.toCharArray();
	        for (int j = 0; j < m; j++) {
	            if (s[i + j] != p[j]) {
	                s[i + j] = p[j];
	                cost++;
	            }
	        }
	        
	        for (int j = 0; j < n / 2; j++) {
	            if (s[j] != s[n - 1 - j]) {
	                // ensure that at least one of the characters is modifiable
	                // j < i or n - 1 - j > i + m - 1
	                if (j < Math.max(i, n - m - i)) cost++;
	                else error++;
	            }
	        }

	        if (ans > cost &&  error == 0) {
	            ans = cost;
	        }
	    }
	    return (ans > n ? -1 : ans);
	}
}
