package maxProdu;

import java.util.*;

public class Solution {
	static int mod = 1000000007;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int k = in.nextInt();
			if (n <= (k * (k + 1)) / 2) {
				System.out.println(-1);
			} else {
				ArrayList<Integer> res = new ArrayList<Integer>();
				if(k == 1)
				{
					res.add(n);
				}
				if(k == 2 )
				{
					if(n % k == 1){
						res.add(n/k);
						res.add((n/k) + 1);
					}else
					{
						res.add((n/k) - 1);
						res.add((n/k) + 1);
					}
				}
				else{
					double x = ((double) n / (double) k) - ((double) (k - 1) / 2.0);
					int p = (int) (Math.ceil(x));
					int q = (int) (Math.floor(x));
					if (p != q) {
						//System.out.println("*");
						int sum = 0;
						res.add(q);
						res.add(p);
						sum += p + q;
						int count = 2;
						int i = 1;
						while (count < k - 1) {
							sum += p + i;
							res.add(p+i);
							i++;
							count++;
						}
						if (sum != n) {
							res.add(n - sum);
						}
					} else {
						//System.out.println("**");
						res.add(p);
						int sum = p;
						int count = 1;
						int i = 1;
						while (count < k - 1) {
							sum += p + i;
							res.add(p + i);
							i++;
							count++;
						}
						if (sum != n) {
							res.add(n - sum);
						}
					}
				}
				//System.out.println(res);
				int max = 1;
				for (int i = 0; i < res.size(); i++) {
					max = ((max % mod) * (res.get(i) % mod) % mod);
					max = ((max % mod) * ((res.get(i) - 1) % mod) % mod);
				}
				System.out.println(max);

			}

		}
	}

}
