package pallindromePartitioning;
import java.util.*;

public class Solution2 {

	// We can also recursively solve this problem. Swap each element with each
		// element after it.

		public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		 permute(num, 0, result);
		 return result;
		 }
		
		 void permute(ArrayList<Integer> num, int start, ArrayList<ArrayList<Integer>> result)
		 {
		
		 if (start >= num.size()) {
		 ArrayList<Integer> item = convertArrayToList(num);
		 result.add(item);
		 }
		
		 for (int j = start; j <= num.size() - 1; j++) {
		 swap(num, start, j);
		 permute(num, start + 1, result);
		 swap(num, start, j);
		 }
		 }
		
		 private ArrayList<Integer> convertArrayToList(ArrayList<Integer> num) {
		 ArrayList<Integer> item = new ArrayList<Integer>();
		 for (int h = 0; h < num.size(); h++) {
		 item.add(num.get(h));
		 }
		 return item;
		 }
		
		 private void swap(ArrayList<Integer> a, int i, int j) {
		 int temp = a.get(i);
		 a.set(i,a.get(j));
		 a.set(j, temp);
		 }
		 public static void main(String[] args) {
				Solution2 obj2 = new Solution2();
				ArrayList<Integer> a = new ArrayList<Integer>();
				a.add(3);
				a.add(2);
				a.add(1);
				// a.add(4);
				ArrayList<ArrayList<Integer>> result = obj2.permute(a);
				for (int i = 0; i < result.size(); i++) {

					System.out.println(result.get(i));

				}
		 }
}
