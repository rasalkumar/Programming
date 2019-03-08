package smallestSequenceWithGivenPrimes;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int k = in.nextInt();
		Solution obj = new Solution();
		ArrayList<Integer> ans = obj.solve(a, b, c, k);
		System.out.println(ans);
	}

	public ArrayList<Integer> solve(int a, int b, int c, int k) {
        ArrayList<Integer> ans= new ArrayList<Integer>();
        if(k==0||a==0||b==0||c==0)
        {
            return ans;
        }
        int dp[] = new int[k+1];
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int next_number = 1;
        int next_multiple_of_a = a;
        int next_multiple_of_b = b;
        int next_multiple_of_c = c;
        dp[0]=1;
        for (int i = 1; i <= k; i++) {
            next_number = Math.min(next_multiple_of_a, Math.min(next_multiple_of_b, next_multiple_of_c));
            dp[i] = next_number;
            if (next_number == next_multiple_of_a) {
                i1 += 1;
                next_multiple_of_a = dp[i1] * a;
            }
            if (next_number == next_multiple_of_b) {
                i2 += 1;
                next_multiple_of_b = dp[i2] * b;
            }
            if (next_number == next_multiple_of_c) {
                i3 += 1;
                next_multiple_of_c = dp[i3] * c;
            }
        }
        
        for(int  i = 1 ; i < dp.length ; i++)
        {
            ans.add(dp[i]);
        }
        return ans;
    }

}
