package tourist;
import java.util.*;
public class Solution {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int m = 1 ;
		while( t-- >= 0 )
		{
			
			int n = in.nextInt();
			int k = in.nextInt();
			long v = in.nextLong();
			String[] a = new String[n];
			for(int  i = 0 ; i < n ; i++ )
			{
				a[i] = in.next();
			}
			 
			System.out.print("Case #" + m++ + ":" + " ");
			long p = ((k % n)*(v % n)) % n;
			if( p < k )
			{
				for(int i = 0 ; i < p ; i++ )
				{
					System.out.print(a[i] + " ");
				}
				for(int i = (int)(n - (k - p)) ; i < n ; i++ )
				{
					System.out.print(a[i]+" ");
				}
				
			}
			else
			{
				for(int i = (int)(p - k) ; i < p ; i++  )
				{
					System.out.print(a[i]+" ");
				}
			}
			//if(t!=1)
			System.out.println();
		}
	}
}
