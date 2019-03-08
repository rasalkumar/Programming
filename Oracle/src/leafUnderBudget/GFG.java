package leafUnderBudget;

import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;
class BinaryTree
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
           // int n = sc.nextInt();
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root = null;
            while (n > 0)
            {	
			
		int n1 = sc.nextInt();
                int n2 = sc.nextInt();
		char lr= sc.next().charAt(0);
				
               
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
			
            int budget = sc.nextInt();
            GfG gfg = new GfG();
            System.out.println(gfg.getCount(root, budget));
            
        }
        
    }
   static class GfG
    {
        
        public int getCount(Node node, int bud)
        {
            ArrayList<Integer> leaves = new ArrayList<>();
            if (node == null)
                return 0;
            helper(node, 1 , leaves);
            Collections.sort(leaves);
            int sum = 0; int count =0;
            for(int i = 0 ; i < leaves.size() ; i++ )
            {
            	if(sum + leaves.get(i) <= bud)
            	{
            		count++;
            		sum = sum + leaves.get(i);
            	}
            	else
            		break ; 
            }
            return count;
        }
        public void helper(Node root,int level,ArrayList<Integer> leaves)
        {
        	if(root.left == null && root.right == null)
        	{
        		leaves.add(level);
        	}
        	if(root.left != null )
        	{
        		helper(root.left, level + 1 , leaves);
        	}
        	if(root.right != null )
        	{
        		helper(root.right, level + 1 , leaves);
        	}
        }
        
    }
   static class Node
   {
       int data;
       Node left, right;
       
       Node(int key)
       {
           data = key;
           left = right = null;
       }
   }

}



/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/


