package rotateArrayInJava;

public class Solution {
	public int[] rotate(int[] arr, int k) {
		if (arr == null || k < 0) {
			return null;
		}
		if (k > arr.length) {
			k = k % arr.length;
		}
		int order = arr.length - k;
		reverse(arr, 0, order - 1);
		reverse(arr, order, arr.length - 1);

		reverse(arr, 0, arr.length - 1);
		return arr;
	}

	public void reverse(int[] arr,int left,int right)
	{
		while(left<=right){
		int temp=arr[left];
		arr[left]=arr[right];
		arr[right]=temp;
		left++;
		right--;
		}
	}

	public static void main(String args[]) {
		Solution obj = new Solution();
		int arr[] = new int[6];
		int c = 0;
		for (int i = 1; i <= 6; i++) {
			arr[c++] = i;
		}
		int k = 2;
		int[] arr2 = new int[6];
		arr2 = obj.rotate(arr, k);
		for (int i = 0; i < 6; i++) {
			System.out.println(arr2[i]);
		}
	}

}
