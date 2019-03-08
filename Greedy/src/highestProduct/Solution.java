package highestProduct;
 
import java.util.*;

public class Solution {
	public int maxp3(ArrayList<Integer> a) {
		Collections.sort(a);
		int n = a.size();
		return Math.max((a.get(n - 1) * a.get(n - 2) * a.get(n - 3)),
				(a.get(n - 1) * a.get(0) * a.get(1)));
	}

	public static void main(String args[]) {
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(-45);
		a.add(-90);
		a.add(2);
		a.add(3);
		a.add(4);
		Solution obj=new Solution();
		System.out.println(obj.maxp3(a));

	}

}
