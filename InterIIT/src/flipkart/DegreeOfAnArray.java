package flipkart;
/*
 * Given an array of  integers, we define its degree as the maximum frequency of any element
 *  in the array. For example, the array  has a degree of  because the number  occurs three 
 *  times (which is more than any other number in the array). We want to know the size of 
 *  the smallest subarray of our array such that the subarray's degree is equal to the array's 
 *  degree. For example, the array  has a degree of  because  and  occur a maximal two times. 
 *  There are two possible subarrays with this degree:  and . Our answer is the length of the 
 *  smallest subarray, which is .

Complete the function in the editor below. It has one parameter: an array of  integers, . 
The function must return an integer denoting the minimum size of the subarray such that the
 degree of the subarray is equal to the degree of the array.

Input Format

The first line contains an integer, , denoting the number of elements in .
 Each line  of the  subsequent lines (where ) contains an integer describing .

Constraints

Output Format

Return an integer denoting the minimum size of the subarray such that the degree of 
the subarray is equal to the degree of the array.

Sample Input 0

5
1
2
2
3
1
Sample Output 0

2
Explanation 0

The array  has a degree of  because  and  both occur two times. Our subarrays with a degree of  are:

, which has a length of .
, which has a length of .
We then return the minimum length of any subarray with a degree of , which is .

Sample Input 1

6
1
1
2
1
2
2
Sample Output 1

4
Explanation 1

The array  has a degree of  because  and  both occur three times. Our subarrays with a degree of  are:

, which has a length of .
, which has a length of .
We then return the minimum length of any subarray with a degree of , which is .
 */

import java.util.*;

public class DegreeOfAnArray {

	static int degreeOfArray(int[] arr) {
		// HashMap<Integer,Integer> map = new HashMap<>();
		HashMap<Integer, ArrayList<Integer>> map2 = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!map2.containsKey(arr[i])) {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(i);
				map2.put(arr[i], temp);
			} else {
				map2.get(arr[i]).add(i);
			}
		}
		int ans = Integer.MIN_VALUE;
		int result = Integer.MAX_VALUE;
		for (Map.Entry<Integer, ArrayList<Integer>> entry : map2.entrySet()) {
			if (entry.getValue().size() > ans) {
				ans = entry.getValue().size();
			}
		}
		for (Map.Entry<Integer, ArrayList<Integer>> entry2 : map2.entrySet()) {
			if (entry2.getValue().size() == ans) {
				ArrayList<Integer> temp = entry2.getValue();
				// System.out.println(temp);
				result = Math.min(result, temp.get(temp.size() - 1) - temp.get(0) + 1);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] arr = new int[size];
		for (int arr_i = 0; arr_i < size; arr_i++) {
			arr[arr_i] = in.nextInt();
		}
		int res = degreeOfArray(arr);
		System.out.println(res);
		in.close();
	}

}
