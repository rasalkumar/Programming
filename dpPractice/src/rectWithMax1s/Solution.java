package rectWithMax1s;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int rectangleWithMax1s(int[][] a)
	{
		int dp[][]= new int[a.length][a[0].length];
		for(int i = 0 ; i < a.length; i++ )
		{
			dp[i][0] = a[i][0];
		}
		return 0;
	}

}
