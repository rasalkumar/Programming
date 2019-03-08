package maxRectangleInABinaryMatrix;

import java.util.*;

public class Solution {
	public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
		int m = a.size();
		int n = a.get(0).size();
		int area = 0;
		int i, j;
		int s[][] = new int[m][n];
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				if (a.get(i).get(j) == 1) {
					s[i][j] = (i == 0) ? 1 : s[i - 1][j] + 1;
				} else {
					s[i][j] = 0;
				}
			}
		}
		for (i = 0; i < m; i++) {
			area = Math.max(area, largestRectangle(s[i]));
		}
		return area;
	}

	private int largestRectangle(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int i = 0;
		while (i < heights.length) {
			if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
				stack.push(i);
				i++;
			} else {
				int height = heights[stack.pop()];
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(max, height * width);
			}
		}

		while (!stack.isEmpty()) {
			int height = heights[stack.pop()];
			int width = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(max, height * width);
		}
		return max;

	}

	public static void main(String args[]) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		Solution obj = new Solution();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(1);
		temp.add(1);
		temp.add(1);
		a.add(new ArrayList<Integer>(temp));
		temp.clear();

		temp.add(0);
		temp.add(1);
		temp.add(1);
		a.add(new ArrayList<Integer>(temp));
		temp.clear();

		temp.add(1);
		temp.add(0);
		temp.add(0);
		a.add(new ArrayList<Integer>(temp));
		temp.clear();
		int ans = obj.maximalRectangle(a);
		System.out.println(ans);
	}

}
