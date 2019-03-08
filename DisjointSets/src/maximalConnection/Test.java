package maximalConnection;

import java.util.*;

public class Test {
 
	static int MAX = 200005;
	static int arr[];
	static long size[];
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		arr = new int[MAX];
		size = new long[MAX];
		int n = in.nextInt();
		int m = in.nextInt();
		int x = in.nextInt();
		
		for (int i = 1; i <= n; i++) {
			size[i] = 0;
			arr[i] = i;
		}
		for (int i = 0; i < m; i++) {
			int city = in.nextInt();
			size[city] = 1;
		}
		while (x-- > 0) {
			int a, b;
			a = in.nextInt();
			b = in.nextInt();
 
			union1(a, b);
		}
 
		long tot = 0;
		for (int i = 1 ; i <= n ; i++) {
			tot += size[root(i)];
		}
		System.out.println(tot);
 
	}
	static int root(int i) {
		while (arr[i] != i) {
			i = arr[arr[i]];
		}
		return i;
	}
	static void union1(int a, int b) {
		int root_a = root(a);
		int root_b = root(b);
 
		if (root_a == root_b)
			return;
 
		if (size[root_a] < size[root_b]) {
			arr[root_a] = arr[root_b];
			size[root_b] += size[root_a];
			size[root_a] = 0;
		} else {
			arr[root_b] = arr[root_a];
			size[root_a] += size[root_b];
			size[root_b] = 0;
		}
	}
}
