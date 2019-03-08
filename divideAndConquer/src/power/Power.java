package power;

import java.util.*;

public class Power {
	static int reverse(int n) {
		int num = 0;
		while (n != 0) {
			num = num * 10 + n % 10;
			n = n / 10;
		}
		return num;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- != 0) {
			int n = sc.nextInt();
			int x = reverse(n);
			long ans = 1;
			for (int i = 0; i < x; i++) {
				ans = (ans * n) % 100000007;
			}
			System.out.println(ans);
		}
	}
}
