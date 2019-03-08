package amazon;

import java.util.*;

public class TrappedRainWater {
	static int[] arr;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(findWater(n));
	}

	static int findWater(int n) {
		int right[] = new int[n];
		int water = 0;
		int leftMax = arr[0];
		right[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], arr[i]);
		}
		for (int i = 0; i < n; i++) {
			int temp = Math.min(leftMax, right[i]) - arr[i];
			if (temp >= 0) {
				water += temp;
			}
			if (leftMax < arr[i]) {
				leftMax = arr[i];
			}
		}
		return water;
	}
}
