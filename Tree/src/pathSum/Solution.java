package pathSum;



import java.util.ArrayList;



public class Solution {
	
	
	public int hasPathSum(TreeNode root,int sum) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<Integer> temp2 = new ArrayList<Integer>();
        
        if(root == null)
            return 0;
        pathSum(root, sum, result, temp);
        if(temp2.size()==0)
        {
        	return 0;
        }
        return 1;
	}
	public void pathSum(TreeNode node, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {
        if(node == null)
            return;
        int currentVal = node.val;
        temp.add(currentVal);
        if(node.left == null && node.right == null){
            if(sum - currentVal == 0){
                result.add(new ArrayList<Integer>(temp));
                return;
            }
        }
        pathSum(node.left, sum - node.val, result, temp);
        pathSum(node.right, sum - node.val, result, temp);
        temp.remove(temp.size() - 1);
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		
		n4.right= n5;
		n4.left = n2;
		n2.left = n1;
		n2.right = n3;
		
		Solution obj = new Solution();
		
		
		int ans;
		ans=obj.hasPathSum(n4,9);
		
		
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