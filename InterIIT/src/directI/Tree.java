package directI;
import java.util.*;
public class Tree {
	static int mod = 1000000007;
	static int MAXX = 300007;
	
	static int k;
	static String tree;
	static HashMap<Integer, String > m ;
	static int j;
	static int sizee;
	
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0)
		{
	        m = new HashMap<>();
	        k = in.nextInt();
	        tree = in.next();
	        sizee = tree.length();
	        j=0;
	        dfs(0);
	       // sort(m[k].begin(), m[k].end());
	        //if(m[k].size() == 0){
	          //  cout<<"Hallelujah!\n";
	        }
	        //else
	        //cout<<m[k]<<"\n";
		}
	//}
	static void dfs(int a){
	    if(j >= sizee)
	        return;
	    //cout<<tree[j];
	    if(tree.charAt(j) == '.'){
	        j++;
	        return;
	    }
	  //  m.put(a,tree.charAt(j));
	    j++;
	    if(j < sizee && tree.charAt(j) == '(' ){
	     j++;
	     dfs(a-1); 
	     dfs(a+1);
	     j++;  
	    }
	}

}
