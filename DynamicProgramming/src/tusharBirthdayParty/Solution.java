package tusharBirthdayParty;
import java.util.*;


public class Solution {
	 public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
		 int dp[][]=new int[1010][1010];
		    int N = -1;
		    int i,j;
		    int n1=A.size();
		    int n2=B.size();
		 //   int n3=C.size();
		    for(i = 0;i < n1;i++)
		    {
		        if(A.get(i)>N)
		            N = A.get(i);
		    }
		    for(j=0;j<=N;j++)
		    {
		        for(i=0;i<=n2;i++)
		        {
		            if(j==0)
		                dp[i][j] = 0;
		            else if(i==0)
		                dp[i][j]=100000000;
		            else
		            {
		                if((j-B.get(i-1))>=0)
		                {
		                    if(dp[i][j-B.get(i-1)] + C.get(i-1) < dp[i-1][j])
		                        dp[i][j] = dp[i][j-B.get(i-1)] + C.get(i-1);
		                    else
		                        dp[i][j] = dp[i-1][j];
		                }
		                else
		                    dp[i][j] = dp[i-1][j];
		            }
		        }
		    }
		    int ans = 0;
		    for(i=0;i<n1;i++)
		        ans += dp[n2][A.get(i)];
		    return ans;
		 
	    }
	 public static void main(String args[]) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			ArrayList<Integer> b = new ArrayList<Integer>();
			ArrayList<Integer> c = new ArrayList<Integer>();
			a.add(2);
			a.add(4);
			a.add(6);
			b.add(2);
			b.add(1);
			b.add(3);
			c.add(2);
			c.add(5);
			c.add(3);
			Solution obj = new Solution();
			System.out.println(obj.solve(a,b,c));
		}
}
