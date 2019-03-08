package nextBinarySparseNumber;

import java.util.*;
import java.lang.*;
import java.io.*;

public class GFG {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int t = in .nextInt();
		while( t-- > 0)
		{
			int x = in.nextInt();
			ArrayList<Integer> bin = new ArrayList<>();
		    while (x != 0)
		    {
		        bin.add(x&1);
		        x >>= 1;
		    }
		    bin.add(0);
		    int n = bin.size();  // Size of binary representation
		    // The position till which all bits are finalized
		    int last_final = 0;
		 
		    // Start from second bit (next to LSB)
		    for (int i=1; i<n-1; i++)
		    {
		       // If current bit and its previous bit are 1, but next
		       // bit is not 1.
		       if (bin.get(i) == 1 && bin.get(i-1) == 1 && bin.get(i+1) != 1)
		       {
		            bin.set(i+1, 1);
		            for (int j=i; j>=last_final; j--)
		                bin.set(j, 0);
		            last_final = i+1;
		        }
		    }
		     int ans = 0;
		    for (int i =0; i<n; i++)
		        ans += bin.get(i)*(1<<i);
		    System.out.println(ans); 
		}
	}

}