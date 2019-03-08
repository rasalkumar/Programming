package maxSumRectIn2D;
import java.util.*;
public class DpSet27 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t =in.nextInt();
		while(t-- >0)
		{
			int l = in.nextInt();
			int b = in.nextInt();
			int[][] a = new int[l][b];
			for( int i = 0 ; i < l ; i++ )
			{
				for( int j = 0 ; j < b ; j++ )
				{
					a[i][j] = in.nextInt();
				}
			}
			System.out.println(findMaxSubMatrix(a));
		}
	}
	public static int findMaxSubMatrix(int[][] a)
	{
		int cols = a[0].length;
		int rows = a.length;
		int[] currentResult;
		int maxSum = Integer.MIN_VALUE;
		int left = 0 , right = 0, top = 0 , bottom = 0; 
		for(int leftCols = 0 ; leftCols < cols ; leftCols++ )
		{
			int[] temp = new int[rows];
			for(int rightCols = leftCols ; rightCols < cols ; rightCols++ )
			{
				for(int i = 0 ; i < rows ; i++ )
				{
					temp[i] = a[i][rightCols];
				}
				currentResult = kadane(temp);
				if(currentResult[0] > maxSum )
				{
					maxSum = currentResult[0];
					left = leftCols;
					right = rightCols;
					top = currentResult[1];
					bottom = currentResult[2];
				}
			}
		}
		return maxSum;
	}
	public static int[] kadane(int[] temp)
	{
		int[] result = {Integer.MIN_VALUE, 0 , -1 };
		int localStart = 0;
		int maxEndingHere = 0 ;
		int maxSoFar = Integer.MIN_VALUE;
		for(int i = 0 ; i < temp.length ; i++ )
		{
			maxEndingHere += temp[i];
			if(maxEndingHere < maxSoFar)
			{
				maxSoFar = maxEndingHere;
				result[0] = maxSoFar;
				result[1] = localStart;
				result[2] = i; 
			}
			if( maxEndingHere < 0 )
			{
				localStart = i + 1 ;
				maxEndingHere = 0 ;
			}
		}
		if(result[2] == -1 )
		{
			result[2] = 0 ;
		}
		for(int i = 0 ; i < temp.length ; i++ )
		{
			if(temp[i] > result[0])
			{
				result[0] = temp[i];
				result[1] = i;
				result[2] = i;
			}
		}
		
		return result;
	}

}
