package laughingBombs;
import java.util.Scanner;
public class LaughingBombs {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	static int[][] a;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int count = 0;
		while(t-- > 0 )
		{
			count++;
			int n = in.nextInt();
			int m = in.nextInt();
			a = new int[m+1][n+1];
			
			for(int i = 1; i <= m ;i++)
			{
				for(int j = 1 ; j <= n; j++ )
				{
					a[i][j] = in.nextInt();
				}
			}
			int r = in.nextInt();
			int c = in.nextInt();
			Point p = new Point();
			p.x = c;
			p.y = r;
			p.level = 1;
			int ans  = 0;
			Queue q = new Queue();
			q.add(p);
			a[p.x][p.y] = 2 ;
			while(!q.isEmpty())
			{
				Point curr = q.poll();
				for( int i = 0 ; i < 4 ; i++ )
				{
					ans = curr.level + 1;
					if(curr.x + dx[i] <= m && curr.y + dy[i] <= n && 
							a[curr.x + dx[i]][curr.y + dy[i]] == 1 )
					{
						Point k = new Point();
						k.x = curr.x + dx[i];
						k.y = curr.y + dy[i];
						k.level = curr.level + 1;
						a[k.x][k.y] = 2;
						q.add(k);
					}
				}
			}
			System.out.println("Case #" + count + ":" + (ans-1));
			
		}

	}
	static class Point
	{
		int x,y,level;
		
	}
	static class Queue
	{
		Point a[];
		int top,rear;
		Queue()
		{
			a = new Point[10000];
			top = rear = 0;
		}
		public void add(Point p)
		{
			a[rear++] = p;
		}
		public Point poll()
		{
			return a[top++];
		}
		public boolean isEmpty()
		{
			return top >= rear ? true : false;
		}
	}

}
