package interception;

import java.util.*;

public class Solution {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int m = 1;
		while( t-- > 0 )
		{
			int n = in.nextInt();
			int[] a = new int[n+1];
			for(int i = 0 ; i < n + 1 ; i++ )
			{
				a[i] = in.nextInt();
			}
			if(n%2!=0)
			{
				System.out.println("Case #"+ m+":"+" 1");
				System.out.println("0.0");
			}
			else
			{
				System.out.println("Case #"+ m+":"+" 0");
			}
			m++;
		}
	}
}
