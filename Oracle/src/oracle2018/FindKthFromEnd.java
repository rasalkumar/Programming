package oracle2018;
import java.util.*;
public class FindKthFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			//System.out.println("Enter the values in the Linked List");
			int n = in.nextInt();
			ListNode list[] = new ListNode[n];
			for(int i = 0 ; i < n ; i++ )
			{
				list[i] = new ListNode(in.nextInt());
			}
			for(int i = 0 ; i < n-1 ; i++ )
			{
				list[i].next = list[i+1];
			}
			int k = in.nextInt();
			ListNode ans = KthFromEnd(list[0], k-1);
			System.out.println(ans.val);
		}
		
	}
	public static ListNode KthFromEnd(ListNode head,int k)
	{
		if(head == null)
		{
			System.out.println("****");
			return null;
		}
		ListNode fast = head;
		ListNode slow = head; 
		int i = 0 ;
		while(fast!= null && i < k )
		{
			i++;
			fast = fast.next;
		}
		if(fast == null)
		{
			return null;
		}
		while(fast.next != null)
		{
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
	static class ListNode
	{
		int val;
		ListNode next;
		ListNode(int x)
		{
			val = x ;
			next = null;
		}
	}

}
