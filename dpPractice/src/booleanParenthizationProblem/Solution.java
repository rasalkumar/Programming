package booleanParenthizationProblem;
import java.util.*;
public class Solution {
	static int dp[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		char[] symbol = new char[n];
		char[] operator = new char[n-1];
		String s = in.next();
		String t = in.next();
		symbol = s.toCharArray();
		operator = t.toCharArray();
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0 ; j < n ; j++)
			{
				dp[i][j] = -1;
			}
		}
//		int ans = countParenthization(symbol,operator,n)
//		{
//			if(n==1)
//			{
//				
//			}
//			
//		}
	}

}
