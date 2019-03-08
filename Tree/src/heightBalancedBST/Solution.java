package heightBalancedBST;





public class Solution {
	
	public int isBalanced(TreeNode a) {
		if(a==null)
		{
			return 0;
		}
		if(getHeight(a)==-1)
		{
			return 0;
		}
		return 1;
		
	}
	private int getHeight(TreeNode a) {
		// TODO Auto-generated method stub
		if(a==null)
		{
			return 0;
		}
		int left  = getHeight(a.left);
		int right = getHeight(a.right);
		if(left==-1||right==-1)
		{
			return -1;
		}
		if(Math.abs(left-right)>1)
		{
			return -1;
		}
		return Math.max(left, right)+1 ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);

		n4.right = n5;
		n4.left = n2;
		n2.left = n1;
		n2.right = n3;

		Solution obj = new Solution();

		int ans;
		ans = obj.isBalanced(n4);

		System.out.println(ans);

	}

}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}