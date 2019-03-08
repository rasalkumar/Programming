package nearestClone;
import java.util.*;
public class Solution2 {
	static LinkedList<Integer> adj[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] from = new int[m];
		int[] to = new int[m];
		adj = new LinkedList[n];
		for(int i = 0 ; i < n ; i++ )
		{
			adj[i] = new LinkedList<>();
		}
		for(int i = 0 ; i < m ; i++ )
		{
			from[i] = in.nextInt();
			to[i] = in.nextInt();
			adj[from[i]-1].add(to[i]-1);
			adj[to[i]-1].add(from[i]-1);
		}
		int[] colors = new int[n];
		for(int i = 0 ; i < n ; i++ )
		{
			colors[i] = in.nextInt()-1;
		}
		int valid = in.nextInt()-1;
		//for(int i = 0 ; i < n; i++ ){
		boolean[] visited = new boolean[n];
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode src = new TreeNode(valid,colors[valid],0);
		q.add(src);
		visited[valid] = true;
		int min =Integer.MAX_VALUE;
		while(!q.isEmpty())
		{
			TreeNode curr = q.poll();
			visited[curr.index] =true;
			if(curr.color == src.color && curr.distance != 0 && curr.distance < min )
			{
				min =curr.distance ;
			}
			Iterator<Integer> itr = adj[curr.index].listIterator();
			while(itr.hasNext())
			{
				int v = itr.next();
				if(visited[v]== false)
				{
					q.add(new TreeNode(v,colors[v],curr.distance+1));
				}
				
			}
		}
		if(min == Integer.MAX_VALUE)
		{
			System.out.println(-1);
		}
		else
		{
			System.out.println(min);
		}
	}//}
	static class TreeNode
	{
		int index;
		int color;
		int distance;
		TreeNode(int index,int color,int distance)
		{
			this.index = index;
			this.color = color;
			this.distance = distance;
		}
	}
}
