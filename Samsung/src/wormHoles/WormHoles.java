package wormHoles;

import java.util.*;

public class WormHoles {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0)
		{
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			//Point src = new Point(x1, y1);
			//Point dest = new Point(x2, y2);
			Point[] point = new Point[Math.abs((x2 - x1 + 1) * (y2 - y1 + 1))];
			int c = 0;
			for (int i = x1 ; i <= x2; i++)
			{
				for (int j = y1 ; j <= y2; j++)
				{
					point[c++] = new Point(i, j);
				}
			}
			Edge edge[] = new Edge[point.length * point.length];
			int n = in.nextInt();
			Worm wormhole[] = new Worm[n];
			for (int i = 0; i < n; i++) 
			{
				int xs = in.nextInt();
				int ys = in.nextInt();
				int xd = in.nextInt();
				int yd = in.nextInt();
				int cost = in.nextInt();
				wormhole[i] = new Worm(new Point(xs, ys), new Point(xd, yd), cost);
			}
			c = 0;
			for (Point p : point) {
				for (Point q : point) {
					int weight = Integer.MAX_VALUE;
					int flag = 0 ;
					for (int i = 0; i < n; i++) {
						if((wormhole[i].src.x == p.x && wormhole[i].src.y == p.y
								 && wormhole[i].dest.x == q.x && wormhole[i].dest.y == q.y)
								 ||(wormhole[i].dest.x == p.x && wormhole[i].dest.y == p.y
								 && wormhole[i].src.x == q.x && wormhole[i].src.y == q.y)
								 )
						{
							weight = Math.min(wormhole[i].cost , Math.abs(q.x - p.x) + Math.abs(q.y - p.y));
							edge[c++] = new Edge(p, q, weight);
							flag = 1 ;
						}
					}
					if( flag == 0 ){
						weight = Math.abs(q.x - p.x) + Math.abs(q.y - p.y);
						edge[c++] = new Edge(p,q,weight);
					}
				}
			}
//			for(Edge e : edge)
//			{
//				System.out.println(e.src.x +"," + e.src.y +" "+e.dest.x +"," + e.dest.y+ " " + e.weight);
//			}
			// Floyd Warshall Setup Taking place
			int graph[][] = new int[point.length][point.length];
			for( int i = 0 ; i < point.length ; i++ )
			{
				for( int j = 0 ; j < point.length ; j++ )
				{
					graph[i][j] = edge[( i * point.length ) + j ].weight;
					//System.out.print(graph[i][j] + " ");
				}
				//System.out.println();
			}
			int[][] dist = new int[graph.length][graph[0].length];
			for( int i = 0 ; i < point.length ; i++ )
			{
				for( int j = 0 ; j < point.length ; j++ )
				{
					dist[i][j] = graph[i][j] ;
				}
			}
			// Floyd Warshal Implemented
			for(int k = 0 ; k < point.length; k++)
			{
				for(int i = 0 ; i < point.length; i++)
				{
					for(int j = 0 ; j < point.length; j++)
					{
						if(dist[i][k] + dist[k][j] < dist[i][j] )
						{
							dist[i][j] = dist[i][k] + dist[k][j]; 
						}
					}
				}
			}
			System.out.println(dist[0][dist.length-1]);
//			for( int i = 0 ; i < point.length ; i++ )
//			{
//				for( int j = 0 ; j < point.length ; j++ )
//				{
//					System.out.print( dist[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
	}

	static class Worm {
		Point src, dest;
		int cost;

		Worm(Point src, Point dest, int cost) {
			this.src = src;
			this.dest = dest;
			this.cost = cost;
		}
	}

	static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Edge {
		Point src;
		Point dest;
		int weight;

		Edge(Point src, Point dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}

}
