package intersectionOfLinkedList;


import java.io.*;
//import java.util.Arrays;
//import java.util.LinkedList;

public class Driver {

	public static void main(String[] args)throws IOException
	{
		int n,m,x,y;
		ListNode headA = null,headB = null;
		InputStreamReader xyz = new InputStreamReader(System.in);
		BufferedReader in= new BufferedReader(xyz);
		System.out.println("Enter the value of number of elements in List A");
		n=Integer.parseInt(in.readLine());
		System.out.println("Enter the value of number of elements in List B");
		m=Integer.parseInt(in.readLine());
		// TODO Auto-generated method stub
		Solution obj=new Solution();
	//	LinkedList<Integer> headA = new LinkedList<Integer>();
	//	LinkedList<Integer> headB = new LinkedList<Integer>();
		System.out.println("Enter the " + n + " elements for list A");
		for (int i=0;i<n;i++)
		{
			 x=Integer.parseInt(in.readLine());
			  headA = new ListNode(x);
			
		}
		System.out.println("Enter the " + m + " elements for list B");
		for (int i=0;i<m;i++)
		{
			y=Integer.parseInt(in.readLine());
		    headB=new ListNode(y);
		}
		
		
		ListNode c=new ListNode(obj.getIntersectionNode(headA,headB).val);
		
		System.out.println("The intersection node is " + c.val);
	}

}
