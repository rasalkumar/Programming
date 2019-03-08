package zigzagLevelOrderTraversalBST;

import java.util.*;

public class Solution {
	
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode rootNode)
	{
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		
		if(rootNode==null){
			   return result;
			  }
		
		Stack<TreeNode> currentLevelStack = new Stack<TreeNode>();
		Stack<TreeNode> nextLevelStack = new Stack<TreeNode>();
			   
		boolean isLeftRightReading = true;
		currentLevelStack.add(rootNode);
			  
		ArrayList<Integer> list= new ArrayList<Integer>(); 
			  
		while(!currentLevelStack.isEmpty()){
			  TreeNode n = currentLevelStack.pop();
			  list.add(n.val);
			 // System.out.print(n.val + " ");
			 
			   if(isLeftRightReading){
			   
			    if(n.left!=null)
			     nextLevelStack.push(n.left);
			 
			    if(n.right!=null)
			     nextLevelStack.push(n.right);
			 
			   }else{
			    if(n.right!=null)
			     nextLevelStack.push(n.right);
			 
			    if(n.left!=null)
			     nextLevelStack.push(n.left);
			 
			   }
			 
			   if(currentLevelStack.isEmpty()){
				result.add(list); 
				list=new ArrayList<Integer>();
			    isLeftRightReading = !isLeftRightReading;
			    currentLevelStack=nextLevelStack;
			    nextLevelStack = new Stack<TreeNode>();
			   }
			 
		}
	return result;
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
		int i,j;
		Solution obj = new Solution();
		ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
		result=obj.zigzagLevelOrder(n4);
		for(i=0;i<result.size();i++)
		{
			for(j=0;j<result.get(i).size();j++)
			{
				System.out.print(result.get(i).get(j));
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }

