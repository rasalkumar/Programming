package testDaily2;

import java.util.*;
//import java.util.Map.Entry;


class TestClass {
    static int v;
    static LinkedList<Integer> adj[];
    static HashSet<Integer> set;
    static int nSpecial,cNodes;
    static int special[];
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        if(in.hasNextInt())
        {
            int n = in.nextInt();
            v = n;
            int m = in.nextInt();
            int x = in.nextInt();
            special = new int[m];
            
            set = new HashSet<>();
            for(int i = 0 ; i < m ; i++ )
            {
                special[i] = in.nextInt() - 1 ;
               
                set.add(special[i]);
                
            }
            
            adj = new LinkedList[v];
            for(int i = 0 ; i < v ; i++)
            {
            	adj[i] = new LinkedList<>();
            }
            for(int i = 0 ; i < x ; i++ )
            {
                int p = in.nextInt();
                int q = in.nextInt();
                adj[p-1].add(q-1);
                adj[q-1].add(p-1);
            }
            System.out.println(dfs(m));
        }
    }
    public static int dfs(int m)
    {
        boolean visited[] = new boolean[v];
        Arrays.fill(visited, false);
        int sum = 0;
//        for(int i = 0 ; i < m ;i++)
//        {
//        	System.out.println(special[i]);
//        }
        for(int i = 0 ; i < m ; i++ )
        {
            nSpecial = 0 ;
            cNodes = 0;
            if(!visited[special[i]])
            {
                dfs(special[i],visited);
                //System.out.println(nSpecial +" " + cNodes);
                int ans = nSpecial * cNodes;
                sum += ans; 
            }
            
        }
        return sum;
    }
    public static void dfs(int i ,boolean[] visited)
    {
        visited[i] = true;
        cNodes++;
        if(set.contains(i))
            nSpecial++;
        ListIterator<Integer> itr = adj[i].listIterator();
        while(itr.hasNext())
        {
            int c = itr.next();
            if(!visited[c])
            {
                dfs(c,visited);
            }
        }
    }
}
