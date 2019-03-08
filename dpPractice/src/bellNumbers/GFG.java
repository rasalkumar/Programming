package bellNumbers;
import java.util.*;
public class GFG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			GFG obj = new GFG();
			System.out.println(obj.bellNumber(n));
		}
	}
	int bellNumber(int n)
	    {
	        int[][] bell = new int[n+1][n+1];
	        bell[0][0] = 1;
	         
	        for (int i=1; i<=n; i++)
	        {
	            // Explicitly fill for j = 0
	            bell[i][0] = bell[i-1][i-1];
	  
	            // Fill for remaining values of j
	            for (int j=1; j<=i; j++)
	                bell[i][j] = bell[i-1][j-1] + bell[i][j-1];
	        }
	         
	        return bell[n][0];
	    }
	}


