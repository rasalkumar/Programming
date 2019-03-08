package mobileSale;
import java.util.Scanner;
public class Mobiles {
static int[][] a;
static boolean[][] visited;
static int n;
static int dx[] = {0, -1, 0, 1};
static int dy[] = {-1, 0, 1, 0};
static int count;
static int count2 =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0)
		{
			n = in.nextInt();
			a = new int[n][n];
			for(int i = 0 ; i < n ; i++)
			{
				for(int j = 0 ; j < n ; j++ )
				{
					a[i][j] = in.nextInt();
				}
			}
			count = 0;
			dfs();
			System.out.println(count);
			System.out.println(count2);
		}
		

	}
	static void dfs()
	{
		
		visited = new boolean[n][n];
		for(int i = 0 ; i < n ; i++ )
		{
			for(int  j = 0 ; j < n ; j++ )
			{
				if(!visited[i][j] && a[i][j] == 5)
				{
					dfs(i,j);
					count++;
					System.out.println();
				}
			}
		}
		
		for(int i = 0 ; i < n ; i++ )
		{
			for(int  j = 0 ; j < n ; j++ )
			{
				if(!visited[i][j] && a[i][j] == 4)
				{
					dfs(i,j);
					count++;
					System.out.println();
				}
			}
		}
		for(int i = 0 ; i < n ; i++ )
		{
			for(int  j = 0 ; j < n ; j++ )
			{
				if(!visited[i][j] && a[i][j] == 3)
				{
					dfs(i,j);
					count++;
					System.out.println();
				}
			}
		}
		for(int i = 0 ; i < n ; i++ )
		{
			for(int  j = 0 ; j < n ; j++ )
			{
				if(!visited[i][j] && a[i][j] == 2)
				{
					dfs(i,j);
					count++;
					System.out.println();
				}
			}
		}
		for(int i = 0 ; i < n ; i++ )
		{
			for(int  j = 0 ; j < n ; j++ )
			{
				if(!visited[i][j] && a[i][j] == 1)
				{
					dfs(i,j);
					count++;
					System.out.println();
				}
			}
		}
	}
	
	public static void dfs(int i,int j)
	{
		count2++;
		visited[i][j] = true;
		System.out.print(a[i][j] + " ");
		for(int k = 0 ; k < dx.length ; k++)
		{
			if(isSafe(i+dx[k],j+dy[k]) && !visited[i+dx[k]][j+dy[k]] &&(
					a[i][j] == a[i+dx[k]][j+dy[k]] || a[i+dx[k]][j+dy[k]] == 0))
			{
				a[i+dx[k]][j+dy[k]] = a[i][j];
				dfs(i+dx[k],j+dy[k]);
			}
		}
	}
	public static boolean isSafe(int x,int y)
	{
		if(x < 0 || x >= n || y < 0 || y >= n )
			return false;
		return true;
	}

}
