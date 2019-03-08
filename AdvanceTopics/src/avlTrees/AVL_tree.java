package avlTrees;


import java.util.*;

class Node
{
    int data, height;
    Node left, right;
    Node(int key)
    {
        data = key;
        height = 1;
    }
}
class AVL_tree
{
    static ArrayList<Integer> list = new ArrayList<Integer>(); 
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            ArrayList<Integer> al = new ArrayList<Integer>();
            Node root = null;
            
            for(int i = 0; i < n; i++)
            {
                int a = sc.nextInt();
                al.add(a);
                root = insert(root, a);
            }
            int k = sc.nextInt();
            GfG gfg = new GfG();
            root = gfg.deleteNode(root, k);
            boolean f = true;
            if(isBalanced(root) != true)
            {
                f = false;
            }
            list = new ArrayList<>();
            list.clear();
            inOrder(root);
            Set<Integer> set = new HashSet<Integer>();
            set.addAll(al);
            ArrayList<Integer> al1 = new ArrayList<Integer>();
            al1.addAll(set);
            if(list.size()!=al1.size()-1)
            {
                f = false;
            }
            if(f == true)
              System.out.println(1);
            else
               System.out.println(0);
        }
    }
    
    public static void inOrder(Node root)
    {
        if(root != null)
        {
            inOrder(root.left);
            list.add(root.data);
            inOrder(root.right);
        }
    }
    
    public static Node insert(Node node, int key)
    {
		if (node == null)
		    return (new Node(key));
		    
		if (key < node.data)
		    node.left = insert(node.left, key);
		else if (key > node.data)
		    node.right = insert(node.right, key);
		else 
		    return node;
            
	    node.height = 1 + max(height(node.left),
	                          height(node.right));
	                          
	    int balance = getBalance(node);
	    
    	if (balance > 1 && key < node.left.data)
    		return rightRotate(node);
        
 
		if (balance > 1 && key > node.left.data)
		{
		     node.left = leftRotate(node.left);
		     return rightRotate(node);
		}
 
        if (balance < -1 && key > node.right.data)
            return leftRotate(node);
            
        if (balance < -1 && key < node.right.data)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
 
       
        return node;
 
    }
    
    public static int max(int a, int b)
    {
        return (a > b) ? a : b;
    }
    
    public static boolean isBalanced(Node node)
    {
        int lh = 0;
        int rh = 0;
        
        if(node == null)
           return true;
        
        lh = heigh(node.left);
        rh = heigh(node.right);
        
        if(Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right))
           return true;
           
        return false;
    }
    
     public static int heigh(Node node)
     {
          if(node == null)
            return 0;
 
   
         return 1 + max(heigh(node.left), heigh(node.right));
     }
    
     public static int getBalance(Node node)
     {
         if(node == null)
           return 0;
           
        return heigh(node.left)-heigh(node.right);
     }
     
     public static int height(Node node)
     {
         if(node == null)
           return 0;
           
         return node.height;
     }
     
    public static Node rightRotate(Node y)
    {
        Node x = y.left;
        Node T2 = x.right;
 
        
        x.right = y;
        y.left = T2;
 
       
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
 
        
        return x;
    }
    
    public static Node leftRotate(Node x)
    {
        Node y = x.right;
        Node T2 = y.left;
 
       
        y.left = x;
        x.right = T2;
 
       
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
 
       
        return y;
    }
    
    public static Node minValueNode(Node node)
    {
        Node current = node;
 
        
        while (current.left != null)
           current = current.left;
 
        return current;
    }
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/


class GfG
{
    public static Node deleteNode(Node root, int key)
    {
        AVL_tree obj = new AVL_tree();
         if (root == null)
            return root;
 
        
        if (key < root.data)
            root.left = deleteNode(root.left, key);
 
       
        else if (key > root.data)
            root.right = deleteNode(root.right, key);
 
       
        else
        {
 
           
            if ((root.left == null) || (root.right == null))
            {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
 
              
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else  
                    root = temp; 
            }
            else
            {
 
               
                Node temp = obj.minValueNode(root.right);
 
                
                root.data = temp.data;
 
                
                root.right = deleteNode(root.right, temp.data);
            }
        }
 
        
        if (root == null)
            return root;
 
        
        root.height = obj.max(obj.height(root.left), obj.height(root.right)) + 1;
 
        
        int balance = obj.getBalance(root);
 
       
        if (balance > 1 && obj.getBalance(root.left) >= 0)
            return obj.rightRotate(root);
 
       
        if (balance > 1 && obj.getBalance(root.left) < 0)
        {
            root.left = obj.leftRotate(root.left);
            return obj.rightRotate(root);
        }
 
        
        if (balance < -1 && obj.getBalance(root.right) <= 0)
            return obj.leftRotate(root);
 
      
        if (balance < -1 && obj.getBalance(root.right) > 0)
        {
            root.right = obj.rightRotate(root.right);
            return obj.leftRotate(root);
        }
 
        return root;
 
    }
}