package sqrtDecomposition;

import java.util.*;

public class SqrtDecomp {
	static int n;
	static int[] a;
	static int len;
	static int[] b;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		a = new int[n];
		for(int i = 0 ; i < n ; i++)
			a[i] = in.nextInt();
		len = (int)Math.sqrt(n) + 1 ; 
		b = new int[len + 1];
		preCompute();
		int q  = in.nextInt();
		for( int i = 0 ; i < q ; i++ ) // Please give range query Zero-Indexed
		{
			int l = in.nextInt();
			int r = in.nextInt();
			System.out.println(helper(l,r));
		}
			
	}
	public static void preCompute() {
		for (int i = 0; i < n; i++) {
			b[i / len] += a[i];
		}
	}
	static int helper(int l, int r) {
		int sum = 0;
		int c_l = l / len;
		int c_r = r / len;
		int end;
		if (c_l == c_r) {
			for (int i = l; i <= r; i++)
				sum += a[i];
		} else {
			end = (c_l + 1) * len - 1;
			for (int i = l; i <= end; i++) {
				sum += a[i];
			}
			for (int i = c_l + 1; i <= c_r - 1; i++) {
				sum += b[i];
			}
			for (int i = c_r * len; i <= r; i++) {
				sum += a[i];
			}
		}
		return sum;
	}
	public static void update_single_element(int index ,int newVal)
	{
		int k = index / len ;
		b[k] += newVal - a[index];
	}
}
