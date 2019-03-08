 package shortestUnsortedSubarray;
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
			int b[] = new int[n];
			for(int i = 0 ; i < n ;i++ )
			{
				a[i] = in.nextInt();
				b[i] = a[i];
			}
			if(n < 2)
			{
				System.out.println(0);
			}
			else
			{
				Arrays.sort(b);
				int flag1 = 0 ;
				int flag2 = 0 ;
				for(int i = 0 ; i < n ; i++ )
				{
					if(b[i] !=  a[i] )
					{
						flag1 = 1;
						break;
					}
				}
				for(int i = 0 ; i < n ; i++ )
				{
					if(b[a.length-1] !=  a[i] )
					{
						flag2 = 1;
						break;
					}
				}
				if(flag1 == 1 && flag2 ==1)
					System.out.println(3);
				else
					System.out.println(0);
			}
		}

	}

}
