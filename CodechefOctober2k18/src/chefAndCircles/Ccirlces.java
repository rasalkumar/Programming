package chefAndCircles;
import java.util.*;
public class Ccirlces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		int[] r = new int[n];
		for( int i = 0 ; i < n ; i++ )
		{
			x[i] = in.nextInt();
			y[i] = in.nextInt();
			r[i] = in.nextInt();
		}
		int[] k = new int[q];
		for(int i = 0 ;i < q;i++)
		{
			k[i] = in.nextInt();
		}
		double[][] minDist = new double[x.length][x.length];
		double[][] maxDist = new double[x.length][x.length];
		for( int i = 0 ; i < x.length ; i++ )
		{
			for(int j = i + 1 ; j < x.length ; j++)
			{
				
				if( centreDist(x[i], x[j], y[i], y[j]) > r[i] + r[j] )
				{
					minDist[i][j] = centreDist(x[i], x[j], y[i], y[j]) - (r[i] + r[j]);
					maxDist[i][j] = centreDist(x[i], x[j], y[i], y[j]) + (r[i] + r[j]);
				}
				else if( centreDist(x[i], x[j], y[i], y[j]) > Math.max(r[i], r[j]) && centreDist(x[i], x[j], y[i], y[j]) < ( r[i] + r[j]))
				{
					minDist[i][j] = 0;
					maxDist[i][j] = centreDist(x[i], x[j], y[i], y[j]) + ( r[i] + r[j] );
				}
				else if( centreDist(x[i], x[j], y[i], y[j]) >Math.min(r[i], r[j]) && centreDist(x[i], x[j], y[i], y[j]) < Math.max(r[i], r[j]))
				{
					minDist[i][j] = 0 ;
					maxDist[i][j] = centreDist(x[i], x[j], y[i], y[j]) + ( r[i] + r[j] ); 
				}
				else if( centreDist(x[i], x[j], y[i], y[j]) == r[i] + r[j] )
				{
					minDist[i][j] = 0 ;
					maxDist[i][j] =  2 * (r[i] + r[j]) ; 
				}
				else if( centreDist(x[i], x[j], y[i], y[j]) == 0 && (r[i] - r[j]) == 0 )
				{
					minDist[i][j] = 0 ;
					maxDist[i][j] =  0 ; 
				}
				else if( centreDist(x[i], x[j], y[i], y[j]) == Math.abs(r[i] - r[j]) )
				{
					minDist[i][j] = Math.abs(r[i] - r[j]) ;
					maxDist[i][j] =  centreDist(x[i], x[j], y[i], y[j]) + ( r[i] + r[j] ); 
				}
				else if( centreDist(x[i], x[j], y[i], y[j]) < Math.abs(r[i] - r[j]) && centreDist(x[i], x[j], y[i], y[j]) >= Math.min(r[i], r[j])  )
				{
					minDist[i][j] = Math.max(r[i], r[j]) - (centreDist(x[i], x[j], y[i], y[j]) + Math.min(r[i], r[j]) ) ;
					maxDist[i][j] =  centreDist(x[i], x[j], y[i], y[j]) + ( r[i] + r[j] ); 
				}
				else if( centreDist(x[i], x[j], y[i], y[j]) > 0 && centreDist(x[i], x[j], y[i], y[j]) < Math.min(r[i], r[j]) )
				{
					minDist[i][j] = Math.max(r[i], r[j]) - (centreDist(x[i], x[j], y[i], y[j]) + Math.min(r[i], r[j]));
					maxDist[i][j] = centreDist(x[i], x[j], y[i], y[j]) + (r[i] + r[j]);
				}
				else if( centreDist(x[i], x[j], y[i], y[j]) == 0 && r[i] != r[j] )
				{
					minDist[i][j] = Math.abs(r[i] - r[j]);
					maxDist[i][j] = r[i] + r[j];
				}
			}
		}
		long count[] = new long[q];
		for( int p = 0 ; p < q ; p++ )
		{
			for( int i = 0 ; i < x.length ; i++ )
			{
				for(int j = i + 1 ; j < x.length ; j++)
				{
					if( centreDist(x[i], x[j], y[i], y[j]) == 0 && r[i] == r[j])
					{
						continue;
					}
					else if( k[p] >= minDist[i][j] && k[p] <= maxDist[i][j] )
					{
						count[p]++;
					}
				}
			}
		}
		for(int i = 0 ; i < q ; i++ )
		{
			System.out.println(count[i]);
		}
	}
	public static double centreDist(int x1,int x2,int y1,int y2)
	{
		return Math.sqrt(Math.pow((x1 - x2) , 2) + Math.pow((y1 - y2) , 2)) ;
	}

}
