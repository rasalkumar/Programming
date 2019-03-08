package qualifyingToPreElimination;
import java.util.*;
public class Solution {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0 )
		{
			int n = in.nextInt();
			int k = in.nextInt();
			long[] s = new long[n];
			int count = 0;
			for( int i = 0 ; i < n ; i++ )
			{
				s[i] = in.nextLong();
			}
			Arrays.sort(s);
//			for( int i = 0 ; i < n ; i++ )
//				System.out.println(s[i]+" ");
			if( n == 1)
			{
				System.out.println(1);
			}
			else
			{
				int ans = 0; 
				int flag = 0;
				for(int i = n - 2 ; i >= 0 ; i-- )
				{
					if( s[i+1] > s[i])
						count++;
					if( count == k )
					{
						flag = 1;
						ans = n - i - 1 ;
						break;
					}
				}
				if(flag == 0)
				{
					System.out.println(n);
				}
				else
				{
					System.out.println(ans);
				}
			}
		} 
	}

}
