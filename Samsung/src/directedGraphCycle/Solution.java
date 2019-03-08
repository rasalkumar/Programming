package directedGraphCycle;

import java.util.Scanner;

public class Solution {
	static int v;
	static ArrayList adj[];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			v = in.nextInt();
			adj = new ArrayList[v];
			for (int i = 0; i < v; i++) {
				adj[i] = new ArrayList();
			}
			int m = in.nextInt();
			for (int i = 0; i < m; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				adj[x - 1].add(y - 1);
			}
			dfs();
			// System.out.println(x);
		}

	}

	public static void dfs() {
		boolean[] reStack = new boolean[v];
		boolean[] visited = new boolean[v];
		int flag= 0;
		for (int i = 0; i < v; i++) 
		{
			ArrayList res = new ArrayList();
			if ( !visited[i] && checkCycle(i, reStack, visited, res) )
			{
				int cy = res.get(res.size()-1);
				flag = 1 ;
				int[] ans1 =new int[ v + 1];
				ans1[cy] = cy;
				for( int p = res.size() - 2 ; p >= 0 ; p-- )
				{
					if(res.get(p) != cy)
						ans1[res.get(p)] = res.get(p);
					else
						break;
				}
				for(int p = 1 ; p < v + 1 ;p++ )
				{
					if(ans1[p] != 0 )
						System.out.print(ans1[p] +" ");
				}
				flag = 1;
				break;
			}
		}
		if(flag == 0)
			System.out.println("No Cycle");
		
	}

	// return false;
	

	

	public static boolean checkCycle(int i, boolean[] reStack, boolean[] visited, ArrayList res) {

		if (reStack[i]) {
			res.add(i + 1);
			return true;
		}
		if (visited[i])
			return false;
		visited[i] = true;
		reStack[i] = true;
		for (int j = 0; j < adj[i].size(); j++) {
			int k = adj[i].get(j);
			res.add( i + 1 );
			if (checkCycle(k, reStack, visited, res)) {
				return true;
			}
		}
		res.remove(res.size()-1);
		reStack[i] = false;
		return false;

	}

	static class ArrayList {
		int a[];
		int actSize;

		ArrayList() {
			a = new int[10000];
			actSize = 0;
		}

		public void add(int p) {
			a[actSize++] = p;
		}

		public int get(int index) {
			if (index < actSize)
				return a[index];
			else {
				throw new ArrayIndexOutOfBoundsException();
			}
		}
		public void remove(int index)
		{
			//int temp = a[index];
			while(index < actSize - 1)
			{
				a[index] = a[index + 1];
				index++;
			}
			a[actSize - 1] = 0 ;
			actSize--;
		}

		public int size() {
			return actSize;
		}
	}

}
