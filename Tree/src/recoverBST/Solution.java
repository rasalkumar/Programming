package recoverBST;


import java.util.*;

public class Solution {
	TreeNode pre = null;       
    TreeNode first = null;
    TreeNode second = null;

	ArrayList<Integer> result = new ArrayList<Integer>();
    
    public ArrayList<Integer> recoverTree(TreeNode a) {
    	
        recoverTreeHelper(a);
        result.add(first.val);
        result.add(second.val);
        Collections.sort(result);
        return result;
    }
    
    public void recoverTreeHelper(TreeNode node) {
        
    	if(node == null){
            return;
        }
        else{
            recoverTreeHelper(node.left);
            if(pre == null)
                pre = node;
            else{
                if(pre.val > node.val){
                    if(first == null){
                        first = pre;
                    }
                    second = node;
                }
                pre = node;
            }
            
            recoverTreeHelper(node.right);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		
		n4.right= n5;
		n4.left = n2;
		n2.left = n1;
		n2.right = n3;
		
		Solution obj = new Solution();
		
		
		ArrayList<Integer> result= new ArrayList<>();
		result=obj.recoverTree(n4);
		
		
		for(int i=0;i<result.size();i++)
		{
			System.out.println("....."+result.get(i));
		}
	}

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
