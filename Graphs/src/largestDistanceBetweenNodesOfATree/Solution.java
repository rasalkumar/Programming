package largestDistanceBetweenNodesOfATree;
import java.util.*;
public class Solution {
    static int N = 40005;
    static int ans = 0;
    static int node = 0;
    static boolean[] vis;
    static ArrayList<Integer>[] G;
    
    public int solve(ArrayList<Integer> A) {
        //size of the parent array
        int n = A.size();
    	
    	vis = new boolean[n];
		G = new ArrayList[n];
		
		// making the graph
		for(int i = 0; i < n; i++){
			G[i] = new ArrayList<Integer>();
		}
		
		// adding edges to graph
    	for(int i=0; i<n; i++){
    	    int par = A.get(i);
    		if(par != -1){
    			G[i].add(par);
    			G[par].add(i);
    		}
    	}
    	
    	//filling vis array to 0
    	Arrays.fill(vis, false);
    	
    	//running first dfs to find the farthest node from root.
    	//It will be stored in variable root.
    	ans=0;
    	dfs(0 , 0);
    	
    	//running second dfs to find the farthest node from TreeNode node (as found in last dfs).
    	//This distance will be stored in variable ans.
    	Arrays.fill(vis, false);
    	ans = 0;
    	dfs(node , 0);
    	
    	//ans is the required result
    	return ans;
    }
    
    public static void dfs(int root , int d){
        //standard dfs subroutine
    	vis[root] = true;
    	
    	if(d>ans){ 
    	    ans=d;
    	    node=root;
    	}
    	
    	for(Integer node: G[root]){
    		if(vis[node] == false){
    			dfs(node , d+1);
    		}
    	}
    }
}