package palindromicArray;

import java.util.*;
public class GFG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
			{
				a[i] = in.nextInt();
			}
			int i=0;
			int j=n-1;
			int count = 0;
			while(i<=j)
			{
				if( a[i] == a[j] )
				{
					i++;
					j--;
				}
				 else if (a[i] > a[j])
		            {
		                // need to merge from tail.
		                j--;
		                a[j] += a[j+1] ;
		                count++;
		            }
		 
		            // Else we merge left two elements
		            else
		            {
		                i++;
		                a[i] += a[i-1];
		                count++;
		            }
			}
			System.out.println(count);
		}
	}
}
