package dpSet13;

import java.util.Arrays;

public class RodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		int p[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		RodCutting obj = new RodCutting();
		System.out.println(obj.memoizedCutRod(p,n));

	}

	public int memoizedCutRod(int[] prices, int n) {
        int[] revs = new int[n + 1];//revs[i] corresponds to the maximum revenues of length i. We define revs[0] = 0.
        for (int i = 0; i < revs.length; i++) {
            revs[i] = -1;//we use -1 here to indicate a state that the revs is not cached yet instead of negative infinity in the book because revenue is always nonnegative.
        }
        return memoizedCutRodAux(prices, n, revs);
    }

    private int memoizedCutRodAux(int[] prices, int n, int[] revs) {
        if (revs[n] >= 0) {
            return revs[n];
        }
        int max = Integer.MIN_VALUE;
        if (n == 0) {
            max = 0;
        } else {
            for (int i = 0; i < n; i++) {
                max = Math.max(max, prices[i] + memoizedCutRodAux(prices, n - i - 1, revs));
            }
        }
        revs[n] = max;
        return max;
    }

}
