package tobi;

class UF{
    private int[] id;
    private int[] sz;
    private int[] height; // this is for union-by-height
    private int count; // the number of connected components
    private int[] maximum; // keep track of the maximum object in each connected component
    
    public UF(int N){
      id = new int[N];
      sz = new int[N];
      height = new int[N];
      maximum = new int[N];
      count = N;
      for (int i = 0; i < N; i++){
        id[i] = i;
        sz[i] = 1;
        height[i] = 1;
        maximum[i] = i;
      }
    }
    
    public boolean isConnected(int p, int q){
      return root(p) == root(q);
    }
    
    private int root(int p){
      while(p != id[p]){
        // id[p] = id[id[p]]; // this line is for path compression
        p = id[p];
      }
      return p;
    }
    
    public boolean isAllConnected(){
      return count == 1;
    }
    
    public int maximumInSameComponent(int p){
        return maximum[root(p)];
    }
    
    public void union(int p, int q){
      int rootP = root(p);
      int rootQ = root(q);
      
      if (rootP == rootQ) return;
      
      if (sz[rootP] >= sz[rootQ]){
          // we link the smaller tree to the bigger tree
          sz[rootP] += sz[rootQ];
          id[rootQ] = rootP;
          // update if the new comers have a bigger maximum
          if (maximum[rootQ] > maximum[rootP]){
              maximum[rootP] = maximum[rootQ];
          }
      }else{
          sz[rootQ] += sz[rootP];
          id[rootP] = rootQ;
          // update if the new comers have a bigger maximum
          if (maximum[rootP] > maximum[rootQ]){
              maximum[rootQ] = maximum[rootP];
          }
      }
      count--; // do not forget decreasing the number of roots
    }
    
    public void unionByHeight(int p, int q){
      int rootP = root(p);
      int rootQ = root(q);
      
      if (rootP == rootQ) return;
      
      if (height[rootP] > height[rootQ]){
          // we link the shorter tree to the bigger tree
          id[rootQ] = rootP;
      }else if(height[rootP] < height[rootQ]){
          // we link the shorter tree to the bigger tree
          id[rootP] = rootQ;
      }else{
          // we link the tree of q to the tree of p
          id[rootQ] = rootP;
          // and do not forget the height increase
          height[rootP]++;
      }
    }
}
