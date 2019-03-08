package maxWeightTransformOfString;
import java.util.*;
public class GFG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
	    int n = in.nextInt();
		String s = in.next();
		int ans = maxWeightTrans(s,n);
		System.out.println(ans);
		}
	}
	public static int maxWeightTrans(String s,int n)
	{
		 if(n == 0 || n == 1) return n;
		    
		    
		    // dp[i] is the maximum possible weight using first i characters
		    int dp[] = new int[n+1];
		    dp[0] = 0;  // empty string 
		    dp[1] = 1;  // Single character string
		    
		    for(int i = 2; i <= n; i++) {

		        dp[i] = 1 + dp[i-1];
		        if(s.charAt(i-1) != s.charAt(i-2))
		        	dp[i] = Math.max(dp[i], 4 + dp[i-2]);
		        else dp[i] = Math.max(dp[i], 3 + dp[i-2]);
		    }
		    
		    return dp[n];
	}

}
