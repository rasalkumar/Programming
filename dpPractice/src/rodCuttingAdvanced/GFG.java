package rodCuttingAdvanced;
import java.util.*;
class GFG {
    
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int cas1=in.nextInt();
        while(cas1-->0)
        {
            int totalLen=in.nextInt();
            int[] rods=new int[3];
            for(int i = 0 ;i < 3 ; i++ )
                rods[i] = in.nextInt();
            int ans = 0;
            int[] dp = new int[totalLen+1];
            Arrays.fill(dp,0);
            for(int i = 0 ; i < 3 ; i++ )
            {
                int rod = rods[i];
                if(rod <= totalLen)
                {
                    dp[rod] = Math.max(dp[rod], 1);
                    for (int j = rods[i] + 1; j < totalLen + 1; j++)
                    {
                        if (dp[j - rod] != 0)
                        {
                            dp[j] = Math.max(dp[j], (1 + dp[j - rod]));
                        }
                    }
                }
            }

            ans=dp[totalLen];
            System.out.println(ans);
        }
	}
}