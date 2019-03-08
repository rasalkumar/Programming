package researchCenter;

/*A Research team want to establish a research center in a region where they found some rare-elements.
 * They want to make it closest to all the rare-elements as close as possible so that they can reduce 
 * overall cost of research over there.It is given that all the rare-element’s location is connected
 *  by roads.It is also given that Research Center can only be build on road.Team decided to assign 
 *  this task to a coder.If you feel you have that much potential..Here is the Task :- Find the 
 *  shortest of the longest distance of research center from given locations of rare-elements.

locations are given in the matrix cell form where 1 represents roads and 0 no road..
number of rare-element and their location was also given(number<=5)
and order of square matrix was less than equal to (20).
*/
import java.util.Scanner;

public class ResearchCenter {
	static int n, c;
	static int[][] dist ;
	static int[][] grid ;
	static Point[] rare_elem;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			n = in.nextInt();
			c = in.nextInt();
			
			rare_elem = new Point[c];
			for (int i = 0; i < c; i++) {
				rare_elem[i] = new Point();
				rare_elem[i].x = in.nextInt();
				rare_elem[i].y = in.nextInt();
			}
			grid = new int[20][20];
			for (int i = 0; i < n; i++){
				for (int j = 0; j < n; j++){
					grid[i][j] = in.nextInt();}}
			
			
			int res = 999999;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == 1) {
						dist = new int[20][20];
						bfs(i, j);
						int ans = 0;
						for (int k = 0; k < c; k++) {
							ans = Math.max(ans, dist[rare_elem[k].x-1][rare_elem[k].y-1]);
						}
						//System.out.println(ans);
						res = Math.min(res, ans);
					}
				}
			}
			System.out.println(res);
		}
	}
	static void bfs(int x, int y) {
		Queue q = new Queue();
		boolean[][] vis = new boolean[20][20];
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++) {
				vis[i][j] = false;
			}
		}
		Point start = new Point();
		start.x = x;
		start.y = y;
		vis[x][y] = true;
		dist[x][y] = 0;
		q.add(start);
		int xx[] = { 1, 0, 0, -1 };
		int yy[] = { 0, 1, -1, 0 };
		while (!q.isEmpty()) {
			Point curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int xnew = curr.x + xx[i];
				int ynew = curr.y + yy[i];
				if (isValid(xnew, ynew) && !vis[xnew][ynew]) {
					dist[xnew][ynew] = dist[curr.x][curr.y] + 1;
					Point next = new Point();
					next.x = xnew;
					next.y = ynew;
					vis[next.x][next.y] = true;
					q.add(next);
				}
			}
		}
	}
	static boolean isValid(int x, int y) {
		if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1)
			return true;
		return false;
	}
	static class Point {
		int x, y;

		public Point() {
			
		}
	}

	static class Queue {
		Point[] A;
		int front, rear;

		Queue() {
			A = new Point[100000];
			//for(int i = 0 ; i < 100000 ; i++ )
			//	A[i] = new Point();
			front = rear = 0;
		}

		void add(Point e) {
			A[rear] = new Point();
			A[rear].x = e.x;
			A[rear].y = e.y;
			rear++;
		}

		Point poll() {
			return A[front++];
		}

		boolean isEmpty() {
			return front >= rear ? true : false;
		}
	}
}
