package mouseAndCheese;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int grid[][] = new int[n][m];
		for(int i = 0 ; i < n ; i++ )
		{
			for(int j = 0 ; j < m ; j++ )
			{
				grid[i][j] = in.nextInt();
			}
		}
		System.out.println(isPath(grid,n,m));
	}
	public static int isPath(int[][] grid, int rows,int columns)
	{
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		boolean[][] visited = new boolean[rows][columns];
		visited[0][0] = true;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0));
		while(!q.isEmpty())
		{
			Point curr = q.poll();
			if(grid[curr.x][curr.y] == 9)
			{
				return 1;
			}
			for(int i = 0 ; i < 4 ; i++)
			{
				if(curr.x + dx[i] < rows && curr.y + dy[i] < columns && 
						!visited[curr.x + dx[i]][curr.y + dy[i]] && grid[curr.x + dx[i]][curr.y + dy[i]] == 1)
				{
					q.add(new Point(curr.x+dx[i],curr.y+dy[i]));
					visited[curr.x + dx[i]][curr.y + dy[i]] = true;
				}
			}
		}
		return 0;
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
