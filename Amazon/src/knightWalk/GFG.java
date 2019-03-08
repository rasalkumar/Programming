package knightWalk;

import java.util.*;

public class GFG {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
	
		while (t-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			int s1 = in.nextInt();
			int s2 = in.nextInt();
			int d1 = in.nextInt();
			int d2 = in.nextInt();
			int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
			int[] dy = { -1, 1, -2, 2, -2, 2, -1, 1 };
			int ans = solve(n, m, s1, s2, d1, d2, dx, dy);
			System.out.println(ans);
		}
	}

	public static int solve(int n, int m, int s1, int s2, int d1, int d2, int[] dx, int[] dy) {
		if(s1==d1 && s2==d2)
        {
            return 0;
        }
         if(m < 2 || n < 2)
            {
                return -1;
            }
		boolean visited[][] = new boolean[n][m];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(s1 - 1, s2 - 1));
		Point dummy = new Point(-1, -1);
		q.add(dummy);
		boolean found = false;
		int count = 0;
		while (q.size() != 1) {
			Point curr = q.poll();
			int r = curr.x;
			int c = curr.y;
			if (r >= 0 && c >= 0 && r < n && r < m) {
				visited[r][c] = true;
			}
			if (r == d1 && c == d2) {
				found = true;
				return count;
			}
			if (r == -1 && c == -1) {
				count++;
				q.add(dummy);
			} else {
				for (int i = 0; i < 8; i++) {
					if (r + dx[i] >= 0 && c + dy[i] >= 0 && r + dx[i] < n && c + dy[i] < m
							&& !visited[r + dx[i]][c + dy[i]]) {
						visited[r + dx[i]][c + dy[i]]=true;
						q.add(new Point(r + dx[i], c + dy[i]));
					}
				}
			}
		}
		if (found) {
			return count;
		} else {
			return -1;
		}

	}

	static class Point {
		int x, y;
        
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
