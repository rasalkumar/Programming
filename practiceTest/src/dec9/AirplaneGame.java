package dec9;
import java.util.*;
public class AirplaneGame {
	static int[][] b;
	static int[][] a;
	static int n;
	static int maxCoins;
	static int coins;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0)
		{
			a = new int[12][5];
			b = new int[5][5];
			n = in.nextInt();
			for( int i = 0 ; i < n ; i++ )
			{
				for( int j = 0 ; j < 5 ; j++ )
				{
					a[i][j] = in.nextInt();
				}
			}
			for(int i = 0 ; i < 5 ; i++ )
			{
				a[n][i] = 0 ;
			}
			a[n][2] = 3;
			for( int i = n - 1 ; i >= 0 ; i-- )
			{
				coins = -1;
				detonate(i);
				getMaxCoins(2,0,n);
				undetonate(i);
				if(coins > maxCoins)
					maxCoins = coins;
			}
			if(maxCoins < 0)
				System.out.println(-1);
			else
				System.out.println(maxCoins);
		}
		
	}
	public static void getMaxCoins(int pos,int coinsx,int n)
	{
		if(pos < 0 || pos > 4 || coins < 0)
			return;
		if(a[n-1][pos] == 2)
			coinsx -= 1 ;
		else if(a[n-1][pos] == 1)
			coinsx += 1 ;
		if( n == 1)
		{
			if(coinsx > coins)
				coins = coinsx;
			return;
		}
		else
		{
			getMaxCoins(pos + 1, coinsx , n - 1 );
			getMaxCoins(pos - 1, coinsx , n - 1 );
			getMaxCoins(pos , coinsx , n - 1 );
		}
		
	}
	public static void detonate(int row)
	{
		for(int i = row ; i > row - 5 ; i-- )
		{
			for(int j = 0 ; j < 5 ; j++ )
			{
				b[row - i][j] = 0;
				if( i >= 0 && a[i][j] == 2 )
				{
					b[row - i][j] = 2;
					a[i][j] = 0 ;
				}
			}
		}
	}
	public static void undetonate(int row)
	{
		for( int i = row ; i > row - 5 ; i++ )
		{
			for( int j =0 ; j < 5 ; j++ )
			{
				if( i >= 0 && b[row - i][j] == 2)
					a[i][j] = 2;
			}
		}
	}

}
