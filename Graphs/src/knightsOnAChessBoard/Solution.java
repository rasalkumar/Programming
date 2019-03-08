package knightsOnAChessBoard;
import java.util.*;
public class Solution {
    static int[] DX = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] DY = {-1, 1, -2, 2, -2, 2, -1, 1};
    
	public int knight(int n, int m, int x1, int y1, int x2, int y2) {
	    x1--;
	    y1--;
	    x2--;
	    y2--;
	    
	    int[][] cost = new int[n][m];
	    
	    int[] qx = new int[n * m];
	    int[] qy = new int[n * m];
	    int qn = 0;
	    
	    cost[x1][y1] = 1;
	    qx[qn] = x1;
	    qy[qn] = y1;
	    qn++;
	    
	    for (int i = 0; i < qn; i++) {
	        int x = qx[i];
	        int y = qy[i];
	        if (x == x2 && y == y2) {
	            return cost[x][y]-1 ;
	        }
	        for (int j = 0; j < DX.length; j++) {
	            int nx = x + DX[j];
	            int ny = y + DY[j];
	            if (nx >= 0 && nx < n && ny >= 0 && ny < m && cost[nx][ny] == 0) {
	                cost[nx][ny] = cost[x][y] + 1;
	                qx[qn] = nx;
	                qy[qn] = ny;
	                qn++;
	            }
	        }
	    }

	    return -1;
	}
	public static void main(String args[])
	{
		int N = 10;
		int M = 10;
		int knightPos[]={4,5};
		int targetPos[]={1,1};
		Solution obj=new Solution();
		System.out.println(obj.knight(N,M,knightPos[0],knightPos[1],targetPos[0],targetPos[1]));
	}
}
//public class Solution {
//	class Cell
//	{
//		int x;
//		int y;
//		int dis;
//		Cell()
//		{
//			
//		}
//		Cell(int x,int y,int dis)
//		{
//			this.x=x;
//			this.y=y;
//			this.dis=dis;
//		}
//		
//		}
//
//	public int knight(int N,int M,int x1, int y1, int x2, int y2)
//	{
//		int knightPos[]=new int[2];
//		knightPos[0]=x1;
//		knightPos[1]=y1;
//		int targetPos[]=new int[2];
//		targetPos[0]=x2;
//		targetPos[1]=y2;
//		//x and y directions where the knight can move
//		int dx[]={-2,-1,1,2,2,1,-1,-2};
//		int dy[]={-1,-2,-2,-1,1,2,2,1};
//		int x=-1,y=-1;
//		Queue<Cell> q=new LinkedList<Cell>();
//		
//		q.offer(new Cell(knightPos[0],knightPos[1],0));
//		Cell t;
//		boolean visit[][]=new boolean[N+1][M+1];
//		for(int i=1;i<=N;i++)
//		{
//			for(int j=1;j<=M;j++)
//			{
//				visit[i][j]=false;
//			}
//		}
//		visit[knightPos[0]][knightPos[1]]=true;
//		while(!q.isEmpty())
//		{
//			t=q.peek();
//			q.poll();
//			visit[t.x][t.y]=true;
//			//if current cell is equal to target Cell
//			//return its distance
//			if(t.x==targetPos[0] && t.y==targetPos[1])
//			{
//				if(t.x==targetPos[0] && t.y==targetPos[1])
//				{
//					
//					return t.dis;
//				}
//			}
//			//loop for all its rechable states
//			for(int i=0;i<8;i++)
//			{
//				x=t.x+dx[i];
//				y=t.y+dy[i];
//				
//			
//			//if reachable state is not visited and
//			//inside board push that state into queue
//			if(isInside(x,y,N,M) && !visit[x][y])
//			{
//				
//			     q.offer(new Cell(x,y,t.dis+1));	
//			}
//			}
//		}
//		{
//			
//		}
//		return -1;
//	}
//
//	private boolean isInside(int x, int y, int n, int m) {
//		// TODO Auto-generated method stub
//		if(x >= 1 && x <= n && y >= 1 && y <= m  )
//		{
//			return true;
//		}
//		return false;
//	}
//	public static void main(String args[])
//	{
//		int N = 10;
//		int M = 10;
//		int knightPos[]={4,5};
//		int targetPos[]={1,1};
//		Solution obj=new Solution();
//		System.out.println(obj.knight(N,M,knightPos[0],knightPos[1],targetPos[0],targetPos[1]));
//	}
//
//}
