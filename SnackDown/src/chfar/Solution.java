package chfar;
import java.util.*;
public class Solution {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- >0 )
		{
			int n = in.nextInt();
			int k = in.nextInt();
			int a[] = new int[n];
			int count = 0;
			for(int i = 0 ;i < n ; i++ )
			{
				a[i] = in.nextInt();
			}
			int flag = 0;
			for(int i = 0 ;i < n ; i++ )
			{
				if(a[i] != 1 )
					count++;
				if(count > k)
				{
					flag = 1;
					break;
				}
			}
			if(flag == 0)
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
		}
	}

}
