package additionOfSubMatrix;
import java.util.*;
public class GFG {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			int m = in.nextInt();
			int c[][]=new int[n][m];
			for(int i = 0 ; i < n ; i++)
			{
				for(int j = 0 ; j < m ; j++)
				{
					c[i][j] = in.nextInt();
				}
			}
			int x1 =in.nextInt();
			int y1 =in.nextInt();
			int x2 =in.nextInt();
			int y2 =in.nextInt();
			int sum = 0;
			for(int i = x1-1 ; i < x2  ; i++)
			{
				for(int j = y1-1  ; j < y2  ; j++)
				{
					sum = sum + c[i][j];
				}
			}
			System.out.println(sum);
		}
	}

}
