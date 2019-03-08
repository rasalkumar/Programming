package dailyTest4;
import java.util.*;
public class GoodSubset {
	static int[] a;
	static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		a = new int[n];
		for(int i = 0 ;i < n ; i++ )
		{
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		dp = new int[n];
		Arrays.fill(dp, 1); 
		  
        // maintain the index of the last increment 
       // int dp2[] = new int[a.length]; 
        //Arrays.fill(dp2, -1); 
  
        // index at which last increment happened 
        int max_ind = 0; 
  
        for (int i = 1; i < a.length; i++) { 
            for (int j = 0; j < i; j++) { 
  
                // only increment the maximum index if  
                // this iteration will increase it 
                if (a[i] % a[j] == 0 && dp[i] < dp[j] + 1)
                { 
                    //dp2[i] = j; 
                    dp[i] = dp[j] + 1; 
  
                } 
  
            } 
        // Update last index of largest subset if size 
        // of current subset is more. 
            if (dp[i] > dp[max_ind]) 
                max_ind = i; 
        } 
        System.out.println(dp[max_ind]);
  
        // Print result 
//        int k = max_ind; 
//        while (k >= 0) { 
//            System.out.print(dp[k] + " "); 
//            k = dp2[k]; 
//        } 
	  
	     
				
		
		
	}
}
