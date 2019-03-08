package applyLoves1;

import java.util.*;

public class ChefMhappy1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		int k = in.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			a.add(in.nextInt());
		}
		

		String s;
		s = in.next();
		
		int dp[] = new int[n];
		dp[0] = a.get(0);
		for (int p = 1; p < n; p++) {
			if (a.get(p) == 1) {
				dp[p] = dp[p - 1] + 1;
			} else if(a.get(p) == 0){
				dp[p] = 0;
			}
		}
		int max = Integer.MIN_VALUE;
		for(int p = 0 ; p < n ; p++ )
		{
			max = Math.max(max,dp[p]);
		}
		if(max > k)
		{
			System.out.println(k);
		}
		else
		{
			System.out.println(max);
		}
		for (int i = 0; i < q; i++) {
			if (s.charAt(i) == '!') {
				Collections.rotate(a, 1);
				//Collections.rotate(Arrays.asList(dp), 1);
				//System.out.println(a);
			}
			if (s.charAt(i) == '?') {
				
			}
		}
	}
//	public static int helper

}
