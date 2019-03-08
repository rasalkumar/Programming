package uniqueNumbers;

import java.util.*;

public class GFG {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int m = in.nextInt();
			int n = in.nextInt();
			for(int i = m ; i <= n;i++)
			{
				int flag = 0;
				HashSet<Integer> set = new HashSet<Integer>();
				for(int j=i;j>0;j=j/10)
				{
					int d = j % 10;
					if(!set.contains(d))
					{
						set.add(d);
					}
					else
					{
						flag = 1;
						break;
					}
				}
				if(flag == 0)
				{
					System.out.print(i+" ");
				}
			}
			System.out.println();
		}
	}
}
