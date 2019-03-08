package largestTreeNodeDistance;

//import java.util.*;
//import java.util.Scanner;
//public class Solution {
//	static int n;
//	static ArrayList<Integer> p;
//	static int ans;
//	static int node = 0 ;
//	static ArrayList<Integer> G[];
//	static boolean visited[];
//	public static void main(String args[])
//	{
//		Scanner in = new Scanner(System.in);
//		int t = in.nextInt();
//		while( t-- > 0 ){
//			n = in.nextInt();
//			p = new ArrayList<Integer>();
//			for(int i = 0 ; i < n ; i++ )
//			{
//				p.add(in.nextInt());
//			}
//			ans = solve();
//			System.out.println(ans);
//		}
//	}
//	public static int solve()
//	{
//		int n = p.size();
//		visited = new boolean[n];
//		G = new ArrayList[n];
//		for( int i = 0; i < n ; i++ )
//		{
//			G[i] = new ArrayList<Integer>();
//		}
//		for(int i = 0 ; i < n ; i++ )
//		{
//			int par = p.get(i);
//			if(par != -1)
//			{
//				G[i].add(par);
//				G[par].add(i);
//			}
//		}
//		Arrays.fill(visited, false);
//		ans = 0;
//		dfs(0,0);
//		
//		Arrays.fill(visited, false);
//		ans =0;
//		dfs(node,0);
//		return ans;
//	}
//	public static void dfs(int root, int d)
//	{
//		visited[root] = true;
//		if(d > ans )
//		{
//			ans =d;
//			node = root;
//		}
//		for(int i : G[root]){
//			if(visited[i]==false)
//				dfs(i,d+1);
//		}
//	}
//}
















import java.util.Scanner;

import largestTreeNodeDistance.Solution.ArrayList.ArrayListIterator;
public class Solution {
	static int n;
	static ArrayList p;
	static int ans;
	static int node = 0 ;
	static ArrayList G[];
	static boolean visited[];
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 ){
			n = in.nextInt();
			p = new ArrayList();
			for(int i = 0 ; i < n ; i++ )
			{
				p.add(in.nextInt());
			}
			ans = solve();
			System.out.println(ans);
		}
	}
	public static int solve()
	{
		int n = p.size();
		visited = new boolean[n];
		G = new ArrayList[n];
		for( int i = 0; i < n ; i++ )
		{
			G[i] = new ArrayList();
		}
		for(int i = 0 ; i < n ; i++ )
		{
			int par = p.get(i);
			if(par != -1)
			{
				G[i].add(par);
				G[par].add(i);
			}
		}
		for(int i = 0  ; i < n ; i++)
			visited[i] =false;
		ans = 0;
		dfs(0,0);
		
		for(int i = 0  ; i < n ; i++)
			visited[i] =false;
		ans =0;
		dfs(node,0);
		return ans;
	}
	public static void dfs(int root, int d)
	{
		visited[root] = true;
		if(d > ans )
		{
			ans =d;
			node = root;
		}
		ArrayListIterator l = G[root].iterator();
		while(l.hasNext())
		{
			int i = l.next();
			if(visited[i]==false)
				dfs(i,d+1);
		}
	}
	static class ArrayList  
	{
		int a[];
		int actSize;
		ArrayList()
		{
			a = new int[10000];
			actSize = 0;
		}
		
		public ArrayListIterator iterator() {
			// TODO Auto-generated method stub
			return new ArrayListIterator();
		}

		public void add(int x)
		{
			a[actSize++] = x;
		}
		public int size()
		{
			return actSize;
		}
		public int get(int index)
		{
			if(index < actSize)
				return a[index];
			else
				throw new ArrayIndexOutOfBoundsException();
		}
		class ArrayListIterator implements Iterator<Integer>
		{
			int curr = 0; 
			public boolean hasNext()
			{
				if(curr < actSize)
					return true;
				else
					return false;
			}
			public Integer next()
			{
				return a[curr++];
			}
		}
		interface Iterator<Integer>
		{
			public Integer next();
			public boolean hasNext();
		}
	}
	
}
