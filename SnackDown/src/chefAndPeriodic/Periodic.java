package chefAndPeriodic;
import java.util.*;
public class Periodic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			int[] a = new int[n];
			for(int i = 0 ; i < n ; i++ )
			{
				a[i] = in.nextInt();
			}
			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			int max = Integer.MIN_VALUE;
			int maxIndex = -1;
			for(int i = 0 ; i < n; i++ )
			{
				if(min > a[i] && a[i] != -1)
				{
					min = a[i];
					minIndex = i;
				}
			}
			for(int i = n - 1 ; i >= 0 ; i--)
			{
				if(max < a[i] && a[i] != -1)
				{
					max = a[i];
					maxIndex = i;
				}
			}
			if( a[0] == -1 && a[n-1] == -1 )
			{
				System.out.println("inf");
			}
			else if( minIndex == -1 || maxIndex == -1 )
			{
				System.out.println("inf");
			}
			else if(minIndex == maxIndex)
			{
				System.out.println(1);
			}
			else
			{
				int flag = 0;
				int c = a[minIndex];
				int ans = -1;
				//System.out.println(minIndex);
				//System.out.println(maxIndex);
				for(int i = minIndex + 1; i < n ; i++ )
				{
					if(a[i] != -1 && a[i] != a[minIndex] && c + 1 != a[i] )
					{
						flag = 1 ;
						//System.out.println(i);
						break;
					}
					if(a[i] == a[minIndex])
					{
						c = a[minIndex];
						ans = i ;
					}
					c++;
				}
				if(flag == 1)
				{
					System.out.println("impossible");
				}
				else
				{
					System.out.println(ans - minIndex);
				}
			}
			
		}

	}

}
