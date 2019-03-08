package p234;
import java.util.*;
public class Permutations {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] =new int[n];
		for(int i = 0 ; i < n ; i++ )
		{
			a[i] = in.nextInt();
		}
		ArrayList<ArrayList<Integer>> res = permute(a);
		for(ArrayList<Integer> b : res)
		{
			System.out.println(b);	
		}
	}
	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		permute(num, 0, result);
		return result;
	}
	 
	static void permute(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
	 
		if (start >= num.length) {
			ArrayList<Integer> item = convertArrayToList(num);
			result.add(item);
		}
	 
		for (int j = start; j <= num.length - 1; j++) {
			swap(num, start, j);
			permute(num, start + 1, result);
			swap(num, start, j);
		}
	}
	 
	private static ArrayList<Integer> convertArrayToList(int[] num) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++) {
			item.add(num[h]);
		}
		return item;
	}
	 
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
