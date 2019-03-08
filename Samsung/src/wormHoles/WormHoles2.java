package wormHoles;
import java.util.*;
public class WormHoles2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Point[] entry = new Point[n+2];
		Point[] exit = new Point[n+2];
		int[] cost = new int[n+2];
		for( int i = 0 ; i < n ; i++ )
		{
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			int d = in.nextInt();
			entry[i] = new Point(x1,y1);
			exit[i] = new Point(x2,y2);
			cost[i] = d;
		}
		int sx = in.nextInt();
		int sy = in.nextInt();
		int ex = in.nextInt();
		int ey = in.nextInt();
		entry[n] = new Point(sx,sy);
		entry[n+1] = new Point(ex,ey);
		exit[n] = new Point(sx,sy);
		exit[n+1] = new Point(ex,ey);
		cost[n] = 0 ;
		cost[n+1] = 0 ;
		int[][] dis = new int[n+2][n+2];
		for(int i = 0 ; i < n + 2 ; i++ )
		{
			for(int j = 0 ; j < n + 2 ; j++ )
			{
				if(i == j)
					continue;
				int d1 = Math.abs(exit[i].x - entry[j].x) + Math.abs(exit[i].y - entry[j].y) + cost[i];
				int d2 = Math.abs(exit[i].x - exit[j].x) + Math.abs(exit[i].y - exit[j].y) + cost[i];
				int d = Math.min(d1, d2);
				dis[i][j] = d;
			}
		}
		for( int k = 0 ; k < n + 2 ; k++ )
		{
			for( int i = 0 ; i < n + 2 ; i++ )
			{
				for( int j = 0 ; j < n + 2 ; j++ )
				{
					if( dis[i][k] + dis[k][j] < dis[i][j] )
						dis[i][j] = dis[i][k] + dis[k][j];
				}
			}
		}
		System.out.println(dis[n][n+1]);
		
	}
	static class Point
	{
		int x,y;
		Point(int x ,int y)
		{
			this.x = x;
			this.y = y;
		}
	}

}
