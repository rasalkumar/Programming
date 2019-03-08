package rootToLeafPathsWithSum;

import java.util.ArrayList;


public class Solution {
	

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root,int sum) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
          
        if(root == null)
            return null;
        pathSum(root, sum, result, temp);
        
        return result;
	}
	public void pathSum(TreeNode node, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {
        if(node == null)
            return;
        int currentVal = node.val;
        temp.add(currentVal);
        if(node.left == null && node.right == null){
            if(sum - currentVal == 0){
                result.add(new ArrayList<Integer>(temp));
                
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
		ArrayList<ArrayList<Integer>> m = new ArrayList<ArrayList<Integer>>(); 
		
		
		m = obj.pathSum(n4,9);
		int i,j;
		for( i=0;i<m.size();i++){
			for(j=0;j<m.get(i).size();j++)
			{
				System.out.print(" " + m.get(i).get(j));
			}
		System.out.println();
		}
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


