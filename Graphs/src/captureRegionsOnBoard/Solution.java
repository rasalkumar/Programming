package captureRegionsOnBoard;
import java.util.*;
public class Solution{
	public void solve(ArrayList<ArrayList<Character>> a) {
	    if(a==null || a.size()==0 || a.get(0).size()==0)
	        return;
	 
	    int m=a.size();
	    int n=a.get(0).size();
	 
	 
	    for(int j=0; j<n; j++){
	        if(a.get(0).get(j)=='O'){
	            bfs(a, 0, j);
	        }
	    }
	 
	    for(int j=0; j<n; j++){
	        if(a.get(m-1).get(j)=='O'){
	            bfs(a, m-1, j);
	        }
	    }
	 
	    for(int i=0; i<m; i++){
	        if(a.get(i).get(0)=='O'){
	            bfs(a, i, 0);
	        }
	    }
	 
	    for(int i=0; i<m; i++){
	        if(a.get(i).get(n-1)=='O'){
	            bfs(a, i, n-1);
	        }
	    }
	 
	    for(int i=0; i<m; i++){
	        for(int j=0; j<n; j++){
	            if(a.get(i).get(j)=='O'){
	                a.get(i).set(j, 'X');
	            }
	            if(a.get(i).get(j)=='1'){
	            	a.get(i).set(j, 'O');;
	            }
	        }
	    }
	}
	 
	public void bfs( ArrayList<ArrayList<Character>> a, int o, int p){
	    int m=a.size();
	    int n=a.get(0).size();
	 
	    int index = o*n+p;
	    LinkedList<Integer> queue = new LinkedList<Integer>();
	    queue.offer(index);
	    a.get(o).set(p,'1');
	 
	    while(!queue.isEmpty()){
	        int top = queue.poll();
	        int i=top/n;
	        int j=top%n;
	 
	        if(i-1>=0 && a.get(i-1).get(j)=='O'){
	        	a.get(i-1).set(j,'1');
	            queue.offer((i-1)*n+j);
	        }
	        if(i+1<m && a.get(i+1).get(j)=='O'){
	        	a.get(i+1).set(j,'1');
	            queue.offer((i+1)*n+j);
	        }
	        if(j-1>=0 && a.get(i).get(j-1)=='O'){
	        	a.get(i).set(j-1,'1');
	            queue.offer(i*n+j-1);
	        }
	        if(j+1<n && a.get(i).get(j+1)=='O'){
	        	a.get(i).set(j+1,'1');
	            queue.offer(i*n+j+1);
	        }
	    }
	}
	
}
//public class Solution {
//	public void solve(char[][] board)
//	{
//		if(board==null || board.length==0)
//		{
//			return;
//		}
//		int m=board.length;
//		int n=board[0].length;
//		for(int i=0;i<m;i++)
//		{
//			if(board[i][0]=='O')
//			{
//				merge(board,i,0);
//			}
//			if(board[i][n-1]=='0')
//			{
//				merge(board,i,n-1);
//			}
//		}
//		for(int j=0;j<n;j++)
//		{
//			if(board[0][j]=='O')
//			{
//				merge(board,0,j);
//			}
//			if(board[m-1][j]=='0')
//			{
//				merge(board,m-1,j);
//			}
//		}
//		for(int i=0;i<m;i++)
//		{
//			for(int j=0;j<n;j++)
//			{
//				if(board[i][j]=='O')
//				{
//					board[i][j]='X';
//				}else if(board[i][j]=='X')
//				{
//					board[i][j]='O';
//				}
//			}
//		}
//	}
//
//	private void merge(char[][] board, int i, int j) {
//		// TODO Auto-generated method stub
//		if(i<0 || i>board.length || j<0 || j>board[0].length)
//		{
//			return;
//		}
//		if(board[i][j]!='0')
//		{
//			return;
//		}
//		board[i][j]='#';
//		
//		merge(board,i-1,j);
//		merge(board,i+1,j);
//		merge(board,i,j-1);
//		merge(board,i,j+1);
//		
//	}
//
//}
