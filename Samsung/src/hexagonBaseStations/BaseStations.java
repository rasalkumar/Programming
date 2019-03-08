package hexagonBaseStations;

import java.util.*;

public class BaseStations 
{
	static int MAX = 15;
	static int w, h;
	static int[][] a = new int[MAX][MAX];
	static boolean[][] visit = new boolean[MAX][MAX];
	static int ans;
	
	static int mOdd[][] = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 }, { -1, -1 }, { -1, 1 } };
	static int mEven[][] = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 }, { 1, -1 }, { 1, 1 } };
	
	static int oddY[][] = { { -1, -1 }, { -1, 1 }, { 1, 0 } };
	static int evenY[][] = { { 0, -1 }, { 0, 1 }, { 1, 0 } };
	
	static int oddInvY[][] = { { 0, -1 }, { 0, 1 }, { -1, 0 } };
	static int evenInvY[][] = { { -1, 0 }, { -1, -1 }, { -1, 1 } };
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt(); 
		while( t-- > 0 ){
			for ( int i = 0 ; i < MAX ; i++ ){
				for ( int j = 0 ; j < MAX ; j++ ){
					a[i][j] = 0;
					visit[i][j] = false;
				}
			}
			ans = 0; 
			h = 0;
			w = 0 ;
			h = in.nextInt();
			w = in.nextInt();
			for (int i = 0 ; i < h; i++)
				for (int j = 0; j < w; j++)
					a[i][j] = in.nextInt();
		
			for ( int i = 0; i < h; i++ ) {
				for ( int j = 0 ; j < w; j++ ) {
					visit[i][j] = true;
					dfs(i, j, a[i][j], 1);
					visit[i][j] = false;
					calculateY(i, j); 
					calculateInvertedY(i, j);
				}
			}
			System.out.println( ans * ans );
		}
	}
	public static void dfs(int i, int j, int value, int count) {
		if (count >= 4) {
			if (ans < value)
				ans = value;
			return;
		}
		for (int m = 0; m < 6; m++) {
			int x = -1, y = -1;
			if (j % 2 == 1) {
				x = i + mEven[m][0];
				y = j + mEven[m][1];
			}
			else {
				x = i + mOdd[m][0];
				y = j + mOdd[m][1];
			}
			if (x >= 0 && x < h && y >= 0 && y < w && !visit[x][y]) {
				visit[x][y] = true;
				dfs(x, y, value + a[x][y], count + 1);
				visit[x][y] = false;
			}
		}
	}
	public static void calculateY(int i,int j)
	{
		int value = a[i][j];
		int x = -1, y = -1;
		for(int m = 0 ; m < 3 ; m++ )
		{
			if( j % 2 == 1)
			{
				x = i + oddY[m][0];
				y = j + evenY[m][1];
			} else {
				x = i + oddY[m][0];
				y = j + evenY[m][1];
			}
			if(x >= 0 && x < h && y >= 0 && y < w )
			{
				value += a[x][y];
			}
			else
				return;
		}
		if(ans < value)
			ans = value;
	}
	public static void calculateInvertedY(int i,int j)
	{
		int value = a[i][j];
		int x = -1, y = -1;
		for(int m = 0 ; m < 3 ; m++ )
		{
			if( j % 2 == 1)
			{
				x = i + evenInvY[m][0];
				y = j + evenInvY[m][1];
			} else {
				x = i + oddInvY[m][0];
				y = j + oddInvY[m][1];
			}
			if(x >= 0 && x < h && y >= 0 && y < w )
			{
				value += a[x][y];
			}
			else
				return;
		}
		if(ans < value)
			ans = value;
	}
}
