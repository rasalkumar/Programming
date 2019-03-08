package longestArithmeticProgression;
import java.util.*;
public class Solution {
	public int solve(ArrayList<Integer> a)
	{
		
		int n=a.size();
		
		if (n <= 2)  return n;
		// LLAP Largest arithmetic progression
	    // Create a table and initialize all values as 2. The value of
	    // L[i][j] stores LLAP with set[i] and set[j] as first two
	    // elements of AP. Only valid entries are the entries where j>i
	    Collections.sort(a);
		int L[][]=new int[n][n];
	    int llap = 2;  // Initialize the result
	 
	    // Fill entries in last column as 2. There will always be
	    // two elements in AP with last number of set as second
	    // element in AP
	    for (int i = 0; i < n; i++)
	        L[i][n-1] = 2;
	 
	    // Consider every element as second element of AP
	    for (int j=n-2; j>=1; j--)
	    {
	        // Search for i and k for j
	        int i = j-1, k = j+1;
	        while (i >= 0 && k <= n-1)
	        {
	           if (a.get(i) + a.get(k) < 2*a.get(j))
	               k++;
	 
	           // Before changing i, set L[i][j] as 2
	           else if (a.get(i) + a.get(k) > 2*a.get(j))
	           {   
	        	   L[i][j] = 2;
	               i--; 
	           }
	 
	           else
	           {
	               // Found i and k for j, LLAP with i and j as first two
	               // elements is equal to LLAP with j and k as first two
	               // elements plus 1. L[j][k] must have been filled
	               // before as we run the loop from right side
	               L[i][j] = L[j][k] + 1;
	 
	               // Update overall LLAP, if needed
	               llap = Math.max(llap, L[i][j]);
	 
	               // Change i and k to fill more L[i][j] values for
	               // current j
	               i--; k++;
	           }
	        }
	 
	        // If the loop was stopped due to k becoming more than
	        // n-1, set the remaining entties in column j as 2
	        while (i >= 0)
	        {
	            L[i][j] = 2;
	            i--;
	        }
	    }
	    return llap;
	}
	public static void main(String args[])
	{
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(100);
		a.add(10);
		a.add(8);
		a.add(300);
		a.add(6);
		a.add(1);
		a.add(4);
		a.add(2);
		Solution obj=new Solution();
		int ans=obj.solve(a);
		System.out.println(ans);
	}

}
