package flipkart;
/*
 * Given a square chessboard of N x N size, 
 * the position of Knight and position of a target is given. 
 * We need to find out minimum steps a Knight will take to
 *  reach the target position.
 */
import java.util.*;
public class KnightMin {
	static int dx[] = { -2 , -1 , 1 , 2 , 2 , 1 , -1 , -2 };
	static int dy[] = { 1 , 2 , 2 , 1 , -1 , -2 , -2 , -1 };
	static boolean visited[][];
	static int n;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		visited = new boolean[n][n];
		visited[x1-1][y1-1] = true;
		Point start = new Point(x1,y1);
		int x2 = in.nextInt() - 1;
		int y2 = in.nextInt() - 1;
		Queue<Point> q = new LinkedList<>();
		start.dist = 0;
		q.add(start);
		int flag = 0 ;
		while(!q.isEmpty())
		{
			Point curr = q.poll();
			if(curr.x == x2 && curr.y == y2)
			{
				flag = 1;
				System.out.println(curr.dist);
				break;
			}
			for(int i = 0 ; i < dx.length ; i++ )
			{
				if(isSafe(curr.x + dx[i] , curr.y + dy[i]) )
				{
					Point k = new Point(curr.x + dx[i] , curr.y + dy[i]);
					k.dist = curr.dist + 1;
					q.add(k);
				}
			}
		}
		if( flag == 0 )
			System.out.println(-1);
	}
	public static boolean isSafe(int x ,int y)
	{
		if(x < 0 || x >= n || y < 0 || y >= n || visited[x][y])
			return false;
		return true;
	}
	static class Point
	{
		int x , y ,dist ;
		Point(int x ,int y)
		{
			this.x = x;
			this.y = y;
		}
		
	}

}
