package pipes;
import java.io.*;
public class Solution {
	static int m,n;
	public static void main(String args[]) throws IOException 
	{
		InputStreamReader xyz = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(xyz);
		m = Integer.parseInt(in.readLine());
		n = Integer.parseInt(in.readLine());
		int a[][] = new int[m][n];
		
		for(int i = 0 ; i < m ; i++ )
		{
			for(int j = 0 ; j < n ; j++ )
			{
				a[i][j] = Integer.parseInt(in.readLine());
			}
		}
		
//		for(int i = 0 ; i < m ; i++ )
//		{
//			for(int j = 0 ; j < n ; j++ )
//			{
//				System.out.print(a[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int X = Integer.parseInt(in.readLine());
		int Y = Integer.parseInt(in.readLine());
		int L = Integer.parseInt(in.readLine());
		if(a[X][Y] == 0)
		{
			System.out.println(a[X][Y]);
			System.out.println("Not Possible");
		}
		else{
			boolean visited[][] = new boolean[m][n];
			ArrayList q = new ArrayList();
			q.add(new Pipe(a[X][Y],0,X,Y)); // Code according to Zero Indexed
			visited[X][Y] = true;
			while(!q.isEmpty())
			{
				Pipe curr = q.poll();
				//System.out.println(curr.x +" "+curr.y +" " + curr.pipeLen);
				if(isSafe(curr.x-1, curr.y) && !visited[curr.x-1][curr.y] && curr.up == 1 && a[curr.x - 1][curr.y] != 0)
				{
					Pipe next = new Pipe( a[curr.x - 1][curr.y], curr.pipeLen + 1, curr.x-1, curr.y);
					if(next.pipeLen == L+1)
					{
						break;
					}
					if(next.down == 1)
					{
						q.add(next);
						visited[curr.x - 1][curr.y] = true;
					}
				}
				if(isSafe(curr.x+1, curr.y) && !visited[curr.x + 1][curr.y] && curr.down == 1 && curr.x + 1 != 0)
				{
					Pipe next = new Pipe( a[curr.x + 1][curr.y], curr.pipeLen + 1, curr.x + 1, curr.y);
					if(next.pipeLen == L+1)
					{
						break;
					}
					if(next.up == 1)
					{
						q.add(next);
						visited[curr.x + 1][curr.y] = true;
					}
				}
				if(isSafe(curr.x, curr.y - 1) && !visited[curr.x][curr.y - 1] && curr.left == 1 && curr.y - 1 != 0)
				{
					Pipe next = new Pipe( a[curr.x][curr.y - 1], curr.pipeLen + 1, curr.x , curr.y - 1);
					if(next.pipeLen == L+1)
					{
						break;
					}
					if(next.right == 1)
					{
						q.add(next);
						visited[curr.x][curr.y - 1] = true;
					}
				}
				if(isSafe(curr.x, curr.y + 1) && !visited[curr.x][curr.y + 1] && curr.right == 1 && curr.y + 1 != 0)
				{
					Pipe next = new Pipe( a[curr.x][curr.y + 1], curr.pipeLen + 1, curr.x , curr.y + 1);
					if(next.pipeLen == L+1)
					{
						break;
					}
					if(next.left == 1)
					{
						q.add(next);
						visited[curr.x][curr.y + 1] = true;
					}
				}
			}
			int count = 0 ;
			for(int i = 0 ; i < m ; i++ )
			{
				for( int j = 0 ; j < n ;j++ )
				{
					if(visited[i][j] == true)
					{
						//System.out.print(visited[i][j] + " "+i+" " + j);
						count++;
					}
				}
				System.out.println();
			}
			System.out.println(count);
		}
	}
	public static boolean isSafe(int x, int y)
	{
		if(x >= 0 && x < m && y >= 0 && y < n )
			return true;
		return false;
	}
	static class Pipe
	{
		int x,y;
		int pipeNum,pipeLen;
		int left, right,up,down;
		Pipe(int pipeNum,int pipeLen,int x,int y)
		{
			this.x = x ;
			this.y = y ;
			this.pipeNum = pipeNum;
			this.pipeLen = pipeLen;
			if(pipeNum == 1)
			{
				left = 1;
				right = 1 ; 
				up = 1 ;
				down = 1;
			}
			if(pipeNum == 2)
			{
				left = 0;
				right = 0 ; 
				up = 1 ;
				down = 1;
			}
			if(pipeNum == 3)
			{
				left = 1;
				right = 1 ; 
				up = 0 ;
				down = 0;
			}
			if(pipeNum == 4)
			{
				left = 0;
				right = 1 ; 
				up = 1 ;
				down = 0;
			}
			if(pipeNum == 5)
			{
				left = 0 ;
				right = 1 ; 
				up = 0 ;
				down = 1;
			}
			if(pipeNum == 6)
			{
				left = 1 ;
				right = 0 ; 
				up = 0 ;
				down = 1;
			}
			if(pipeNum == 7)
			{
				left = 1;
				right = 0 ; 
				up = 1 ;
				down = 0 ;
			}
		}
	}
	static class ArrayList
	{
		Pipe pipe[];
		int actSize;
		ArrayList()
		{
			pipe = new Pipe[10000];
			for(int i = 0 ; i < pipe.length ; i++ )
				pipe[i] = new Pipe(0,0,-1,-1);
			actSize = 0;
		}
		public void add(Pipe x)
		{
			pipe[actSize++] = x;
		}
		public boolean isEmpty()
		{
			return actSize == 0 ;
		}
		public Pipe poll()
		{
			Pipe temp = pipe[actSize-1];
			actSize--;
			return temp;
		}
	}
}
