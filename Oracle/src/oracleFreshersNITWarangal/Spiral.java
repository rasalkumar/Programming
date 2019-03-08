package oracleFreshersNITWarangal;
import java.util.*;
public class Spiral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			int a[][] = new int[n][n];
			for(int i = 0 ; i < n ; i++ )
			{
				for(int j = 0 ; j < n ; j++)
				{
					a[i][j] = in.nextInt();
				}
			}
			spiral(a);
		}		
	}
	public static void spiral(int[][] a)
	{
		int n = a.length;
		
		int left = 0 ;
		int right = a[0].length-1;
		
		int top = 0;
		int bottom = a.length-1;
		
		int dir = 0 ;
				 
		int b[] = new int[n*n];
		int count = 0 ;
		while( left <= right || top <= bottom )
		{
			if( dir == 0 && left <= right )
			{
				for(int i = left ; i < right ; i++ )
				{
					b[count++] = a[top][i];
				}
				dir = (1 + dir) % 4 ;
			}
			if( dir == 1 && top <= bottom)
			{
				for(int i = top ; i < bottom ; i++ )
				{
					b[count++] = a[i][right];
				}
				dir = (1 + dir) % 4 ;
			}
			if( dir == 2 && left <= right)
			{
				for(int i = right ; i > left  ; i-- )
				{
					b[count++] = a[bottom][i];
				}
				dir = (1 + dir) % 4 ;
			}
			if( dir == 3 && top <= bottom)
			{
				for(int i = bottom ; i > top  ; i-- )
				{
					b[count++] = a[i][left];
				}
				dir = (1 + dir) % 4 ;
			}
			left++;
			top++;
			right--;
			bottom--;
		}
		if(n % 2 != 0)
		{
			b[b.length-1] =a[ (n / 2) ][ ( n / 2 ) ];
		}
		for(int i = 0 ; i < b.length ; i++)
			System.out.println(b[i]+ " ");
	}

}
