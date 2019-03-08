package floydWarshalDirected;

import java.util.Scanner;
public class Solution {
	static int Max = 9999;
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int m = in.nextInt();
		int graph[][] = new int[n][n];
		for(int i = 1 ;i <= m ; i++ )
		{
			int x = in.nextInt();
			int y = in.nextInt();
			int r = in.nextInt();
			graph[x-1][y-1] = r;
		}
		for(int i = 0 ; i < n ; i++ )
		{
			for(int j = 0 ; j< n ; j++ )
			{
				if(i == j)
					graph[i][j] = 0;
				if(graph[i][j] == 0)
					graph[i][j] = Max;
			}
		}
		
		int dist[][] = floyd(graph);
		
		int q = in.nextInt();
		for(int i = 0 ; i < q ; i++)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			if(a == b)
			{
				System.out.println("0");
			}
			else if(dist[a-1][b-1] == Max)
			{
				System.out.println("-1");
			}
			else
			{
				System.out.println(dist[a-1][b-1]);
			}
		}
		 
	}
	public static int[][] floyd(int[][] graph)
	{
		int dist[][] = new int[n][n];
		for(int i = 0 ; i < n ; i++ )
		{
			for(int j = 0 ; j< n ; j++ )
			{
				dist[i][j] = graph[i][j];
			}
		}
		for( int k = 0 ; k < n ; k++ )
		{
			for( int i = 0 ; i < n ; i++ )
			{
				for(int j = 0 ; j < n ; j++ )
				{
					if(dist[i][k] + dist[k][j] < dist[i][j])
					{
						dist[i][j] = dist[i][k] + dist[k][j]; 
					}
				}
			}
		}
		return dist;
		
	}

}
