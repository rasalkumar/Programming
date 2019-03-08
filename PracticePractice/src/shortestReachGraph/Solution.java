package shortestReachGraph;
import java.util.*;
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		while(q-- > 0)
		{
			int n = in.nextInt();
			int m = in.nextInt();
			Graph g= new Graph(n);
			for(int i = 0  ; i < m ; i++ )
			{
				int u = in.nextInt();
				int v = in.nextInt();
				g.addEdge(u-1, v-1);
			}
			int s = in.nextInt();
			int[] ans = g.shortestReach(s-1);
			for(int i = 0 ; i < ans.length ;i++)
			{
				if(ans[i] == 0)
					continue;
				System.out.print(ans[i] + " ");
			}
			System.out.println();
			
		}
	}
	public static class Graph {
        List<List<Integer>> adjLst; 
        int size;
        public Graph(int size) {
            adjLst = new ArrayList<>();
            this.size = size;
            while(size-- > 0)//Initialize the adjancency list.
                adjLst.add(new ArrayList<Integer>());
        }

        public void addEdge(int first, int second) {
            adjLst.get(first).add(second);
            adjLst.get(second).add(first); 
// For undirected graph, you gotta add edges from both sides.
        }
        
        public int[] shortestReach(int startId) { // 0 indexed
            int[] distances = new int[size];
            Arrays.fill(distances, -1); // O(n) space.
            Queue<Integer> que = new LinkedList<>();
            
            que.add(startId); // Initialize queue.
            distances[startId] = 0;
            HashSet<Integer> seen = new HashSet<>(); //O(n) space. Could be further optimized. I leave it to you to optimize it.
            
            seen.add(startId);
            while(!que.isEmpty()) { // Standard BFS loop.
                Integer curr = que.poll();
                for(int node : adjLst.get(curr)) {
                    if(!seen.contains(node)) {
                        que.offer(node);
            // Right place to add the visited set.
                        seen.add(node); 
            // keep on increasing distance level by level.
                        distances[node] = distances[curr] + 6; 
                    }
                }
            }   
            return distances;
        }
    }

}
