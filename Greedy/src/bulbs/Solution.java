package bulbs;

import java.util.*;

public class Solution {

	public int bulbs(ArrayList<Integer> a) {

		int state = 0, ans = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) == state) {
				ans++;
				state = 1 - state;
			}
		}
		return ans;

	}

	public static void main(String args[]) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);
		a.add(1);
		a.add(0);
		a.add(1);
		Solution obj = new Solution();
		int ans = obj.bulbs(a);
		System.out.println(ans);

	}
}
