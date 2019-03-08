package roadsAndLibraries;

import java.util.*;

public class Solution {
	static LinkedList<Integer> adj[];
	static int n, m;
	static ArrayList<ArrayList<Integer>> result;
	static int clib, croad;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		while (q-- > 0) {
			n = in.nextInt();
			m = in.nextInt();
			clib = in.nextInt();
			croad = in.nextInt();
			adj = new LinkedList[n];
			for (int i = 0; i < n; i++) {
				adj[i] = new LinkedList<>();
			}
			for (int i = 0; i < m; i++) {
				int u = in.nextInt();
				int v = in.nextInt();
				adj[u - 1].add(v - 1);
				adj[v - 1].add(u - 1);
			}
			long ans = dfs();
			//System.out.println(ans + " " + (n * clib));
			ans = Math.min(n * (long)clib, ans);
			System.out.println(ans);
		}
	}

	public static long dfs() {
		boolean[] visited = new boolean[n];
		result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				ArrayList<Integer> temp = new ArrayList<>();
				dfsUtil(visited, i, temp);
				result.add(temp);
			}
		}
//		for(ArrayList<Integer> l : result)
//		{
//			System.out.println(l);
//		}
		long[] comp = new long[result.size()];
		long sum1 = 0;
		for (int i = 0; i < comp.length; i++) {
			comp[i] = result.get(i).size() - 1;
			comp[i] = comp[i] * (long)croad;
			sum1 += comp[i];
		}
		long costLib = result.size() * (long)clib;
		long sum2 = costLib + sum1;
		return sum2;
	}

	public static void dfsUtil(boolean[] visited, int u, ArrayList<Integer> temp) {
		visited[u] = true;
		temp.add(u);
		Iterator<Integer> itr = adj[u].listIterator();
		while (itr.hasNext()) {
			int v = itr.next();
			if (!visited[v])
				dfsUtil(visited, v, temp);
		}
	}
}
