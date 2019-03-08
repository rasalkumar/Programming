package samsung;
import java.util.Scanner;
public class RockClimbing {
static int[][] a;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int ans = -1;
			int di = 0 ; 
			int dj = 0 ;
			int n = in.nextInt();
			int m = in.nextInt();
			a = new int[1000][1000];
			for( int i = 1 ;i <= n ; i++ )
			{
				for(int j = 1 ; j <= m ;j++ )
				{
					a[i][j] = in.nextInt();
					if(a[i][j] == 3)
					{
						di = i;
						dj = j;
					}
				}
			}
			int h = n -1;
			for(int i = 1 ; i <= h ; i++)
			{
				ans = helper(n, m ,di,dj ,i);
				if(ans >= 1)
				{
					break;
				}
			}
			System.out.println(ans);
			
			
		}
	}
	public static int helper(int n, int m ,int i,int j, int h)
	{
		int ans;
		if(i <= 0 || i > n || j <= 0 || j > m)
		{
			return -1;
		}
		if( a[i][j] == 1 || a[i][j] == 3 )
		{
			int temp = a[i][j];
			a[i][j] = -1;
			
			ans = helper(n,m,i,j - 1,h);
			if(ans >= 1)
				return ans;
			
			for(int  k = 1 ; k <= h ; k++ )
			{
				ans = helper(n,m,i-k,j,h);
				if(ans >= 1)
					return ans;
			}
			
			ans = helper(n, m, i, j + 1 , h);
			if(ans >= 1)
				return ans;
			
			for(int  k = 1 ; k <= h ; k++ )
			{
				ans = helper(n,m,i+k,j,h);
				if(ans >= 1)
					return ans;
			}
			a[i][j] = temp;
			return ans;
		}
		else if(a[i][j] <= 0)
			return -1;
		else if(a[i][j] == 2)
			return h;
		else
			return -1;
	}

}
