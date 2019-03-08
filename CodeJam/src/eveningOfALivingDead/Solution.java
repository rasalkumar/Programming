package eveningOfALivingDead;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			int m = in.nextInt();
			int a[] = new int[n-1];
			int b[] = new int[n-1];
			for(int i = 0 ; i < n - 1 ; i++ )
			{
				a[i] = in.nextInt();
				b[i] = in.nextInt();
			}
			int y[] = new int[m];
			int h[] = new int[m];
			for(int i = 0 ; i < m ; i++ )
			{
				y[i] = in.nextInt();
				h[i] = in.nextInt();
			}
			boolean[] visited = new boolean[n];
			for(int  i = 0 ; i < m ; i++ )
			{
				visited[y[i]-1] = true;
			}
			//int x = Math.ran
		}
	}

}
