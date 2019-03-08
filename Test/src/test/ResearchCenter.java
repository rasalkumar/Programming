package test;
import java.util.*;
public class ResearchCenter {
static int [][]a;
static int [][]dist;
static Point[] rare_elem;
static int n,c;
static int dx[] = { 0 , 0 , 1 , -1 };
static int dy[] = { 1 , -1 , 0 , 0 };
 
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0)
		{
			a = new int[20][20];
			
			//dist = new int[20][20];
			n = in.nextInt();
			c = in.nextInt();
			rare_elem = new Point[5];
			for(int i = 0 ; i < c ;i++)
			{
				int x = in.nextInt() - 1 ;
				int y = in.nextInt() - 1 ;
				rare_elem[i] = new Point(x,y); 
			}
			for( int i = 0 ; i < n; i++ )
			{
				for( int j = 0 ; j  < n ; j++ )
				{
					a[i][j] = in.nextInt();
				}
			}
			int result = 999999;
			for(int i = 0 ; i < n ; i++ )
			{
				for( int j = 0 ; j < n ; j++ )
				{
					if(a[i][j] == 1)
					{
						dist = new int[20][20];
						bfs(i,j);
						int ans = 0;
						for(int k = 0 ; k < c ; k++)
						{
							ans = Math.max( ans, dist[rare_elem[k].x][rare_elem[k].y] ); 
							
						}
						//System.out.println(ans);
						result = Math.min(result, ans);
					}
				}
			}
			System.out.println(result);
			
		}
	}
	static void bfs(int i ,int j)
	{
		Queue q = new Queue();
		boolean[][] visited = new boolean[20][20];
		q.add(new Point(i,j));
		dist[i][j] = 0;
		visited[i][j] = true; 
		while(!q.isEmpty())
		{
			Point curr = q.poll();
			//System.out.println(dist[curr.x][curr.y]);
			for(int k = 0 ; k < 4 ; k++)
			{
				if( isSafe(curr.x + dx[k] ,curr.y + dy[k]) && !visited[curr.x + dx[k]][curr.y + dy[k]] )
				{
					visited[curr.x + dx[k]][curr.y + dy[k]] = true;
					dist[curr.x + dx[k]][curr.y + dy[k]] = dist[curr.x][curr.y] + 1 ;
					q.add(new Point(curr.x + dx[k], curr.y + dy[k] ));
				}
			}
			
		}
	}
	static boolean isSafe(int x ,int y)
	{
		if(x >= 0 && x < n && y >= 0 && y < n && a[x][y] == 1)
			return true;
		return false;
	}
	static class Point
	{
		int x, y;
		Point(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	static class Queue
	{
		int front,rear;
		Point[] a;
		Queue()
		{
			front = rear = 0;
			a = new Point[1000000];
		}
		public void add(Point x)
		{
			a[rear++] = x;
		}
		public Point poll()
		{
			return a[front++];
		}
		public boolean isEmpty()
		{
			return front >= rear;
		}
	}

}
