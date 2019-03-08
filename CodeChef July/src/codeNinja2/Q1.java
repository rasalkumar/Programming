package codeNinja2;
import java.util.*;
public class Q1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s ="abba";
		System.out.println(maxLCS(s));
	}

    
    public static ArrayList<Integer> maxLCS(String A)
    {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int j = 1; j < A.length() ; j++ )
        {
            String x = A.substring(0,j);
            String y = A.substring(j);
            StringBuilder sb = new StringBuilder(y);
            sb = sb.reverse();
            System.out.println(x + " " + sb.toString());
            int[][] dp = new int[x.length() + 1][y.length()+1];
            for(int i = 0 ; i  <= x.length() ; i++ )
            {
                for(int k = 0 ; k <= y.length() ; k++ )
                {
                    dp[i][k] = -1;
                }
            }
            int ans = lcs( x , sb.toString() , x.length() , y.length(),dp);
            System.out.println(ans);
            if(ans > max)
            {
                max = ans;
                maxIndex = j ;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if(A.length() == 1)
        {
        	result.add(0);
        	result.add(1);
        }
        result.add(maxIndex);
        result.add(max);
        
        return result;
    }
    public static int lcs(String x ,String y,int m , int n,int[][] dp)
    {
        if(m == 0 || n == 0)
            return 0;
        if(dp[m][n] >= 0)
            return dp[m][n];
        if(x.charAt(m-1) == y.charAt(n-1))
            dp[m][n] =  1 + lcs(x,y,m-1,n-1,dp);
        else 
            dp[m][n] = Math.max( lcs(x,y,m-1,n,dp) , lcs(x,y,m,n-1,dp));
        return dp[m][n];
    }


}
