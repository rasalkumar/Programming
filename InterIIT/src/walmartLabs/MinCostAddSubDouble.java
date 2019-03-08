package walmartLabs;

/*
Walmart Labs IIT Dhanbad 2018
For a given number A, following operations are allowed:
1. A -> A + 1
2. A -> A - 1 (provided A > 0)
3. A -> 2 * A
Cost of operation 1 and 2 is equal to A and cost of operation 2 is B.
Find the minimum cost to reach X starting from 0.
1 <= X <= 100000
0 <= A, B <= 1000000
O(X)
*/

import java.util.*;
public class MinCostAddSubDouble {
	static int a, b;
	static int dp[];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int x = in.nextInt();
			a = in.nextInt();
			b = in.nextInt();
			int[] ans = new int[4 * x];
			ans[0] = 0;
		    for (int i = 1; i <= x; i++)
		    {
		        
		    	ans[i] = ans[i - 1] + a;
		        
		        if ( (i&1) == 1 )      
		        	ans[i] = ans[i] > ans[i >> 1] + b + a ? ans[i >> 1] + b + a : ans[i];
		        else 
		        	ans[i] = ans[i] > ans[i >> 1] + b ? ans[i >> 1] + b : ans[i] ;
		        
		        if (ans[i + 1] != -1)
		        	ans[i] = ans[i] > ans[i + 1] + a ? ans[i + 1] + a : ans[i];
		        
		        ans[i << 1 | 1] = ans[i] + b + a;
		        ans[i << 1] = ans[i] + b ;
		    
		    }
		    System.out.println(ans[x]);
		}

	}
	
	

}
