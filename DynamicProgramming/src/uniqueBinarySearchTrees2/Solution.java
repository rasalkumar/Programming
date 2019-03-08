package uniqueBinarySearchTrees2;

public class Solution {
	public int numTrees(int n) {
	    int[] count = new int[n + 1];
 
	count[0] = 1;
	count[1] = 1;
 
	for (int i = 2; i <= n; i++) {
		for (int j = 0; j <= i - 1; j++) {
			count[i] = count[i] + count[j] * count[i - j - 1];
		}
	}
 
	return count[n];
	}
	public static void main(String args[])
	{
		int n=3;
		Solution obj=new Solution();
		System.out.println(obj.numTrees(n));
	}

}
