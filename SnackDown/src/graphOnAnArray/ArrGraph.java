package graphOnAnArray;

import java.util.*;

public class ArrGraph {
	static LinkedList<Integer> adj[];
	static boolean visited[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int a[] = new int[n];
			HashSet<Integer> set = new HashSet<>();
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
				set.add(a[i]);
			}
			adj = new LinkedList[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new LinkedList<>();
			}
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (hcf(a[i], a[j]) == 1) {
						addEdge(i, j);
					}
				}
			}
			visited = new boolean[n];
			Arrays.fill(visited, false);
			int b[] = new int[n];
			dfs( 0 , visited);
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					count++;
					b[i] = a[i];
				} else {
					b[i] = -1;
				}

			}
			if (count == n) {
				System.out.println(0);
				for (int i = 0; i < n; i++) {
					System.out.print(a[i] + " ");
				}
			} else {
				int flag1 = 0, flag2 =0;
				int c = 0 ;
				for (int i = 0; i < n; i++) {
					if (b[i] == -1 ) {
						if (a[i] % 2 == 0 && flag1 == 0) {
							b[i] = 47;
							c++;
							flag1 = 1;
						} else if(a[i] % 2 == 1 && flag2 == 0 ) {
							b[i] = 2;
							c++;
							flag2 = 1 ;
						}

					}
					if(flag1==1 && flag2 ==1)
					{
						break;
					}
				}
				for(int i = 0 ; i < n ;i++)
				{
					if(b[i] == -1)
					{
						b[i] = a[i];
					}
				}
				System.out.println(c);
				for(int i = 0 ; i < n ;i++)
				{
					System.out.print(b[i] + " ");
				}
			}
			System.out.println();

		}
		

	}

	public static void dfs(int u, boolean[] visited) {
		visited[u] = true;
		Iterator<Integer> itr = adj[u].listIterator();
		while (itr.hasNext()) {
			int v = itr.next();
			if (v == u)
				continue;
			if (visited[v] == false)
				dfs(v, visited);
		}
	}

	public static void addEdge(int i, int j) {
		adj[i].add(j);
		adj[j].add(i);
	}

	public static int hcf(int a, int b) {
		if (b == 0) {
			return a;
		}
		return hcf(b, a % b);
	}

}
