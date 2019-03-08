package largestDistance;

/*
   Given an array A of integers, find the maximum of j - i 
   subjected to the constraint of A[i] <= A[j].
   If there is no solution possible, return -1.
 */




import java.util.*;
public class Solution {
	static int[] a;
	static int[] Lmin;
	static int[] Rmax;
	static int n;
	static int max;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			n = in.nextInt();
			a = new int[n];
			max = Integer.MIN_VALUE;
			for(int i = 0 ; i < n ;i++)
				a[i] = in.nextInt();
			solve();
			System.out.println(max);
		}
	}
	public static void solve()
	{
		if(a.length == 1)
			max = 0;
		Lmin = new int[n];
		Rmax = new int[n];
		
		Lmin[0] = a[0];
		for(int i = 1 ;i < n ; i++)
			Lmin[i] = Math.min( Lmin[i-1] , a[i] );
		
		Rmax[0] = a[n-1];
		for(int i = n-2 ;i >= 0 ; i--)
			Rmax[i] = Math.max( Lmin[i+1] , a[i] );
		
		int i = 0 , j = 0;
		while(i < n && j < n)
		{
			if( Lmin[i] <= Rmax[j] )
			{
				max = Math.max(max, j - i );
				j++;
			}
			else
			{
				i++;
			}
		}
	}
}
