package dec11;
import java.util.*;
public class MergeKSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		ArrayList<ListNode> arr =new ArrayList<>(); 
		System.out.println("Enter Number of Lists");
		int n = in.nextInt();
		for(int i = 0 ; i < n ; i++ )
		{
			ListNode head = new ListNode(0);
			System.out.println("Enter the Size of the List : ");
			int k = in.nextInt();
			System.out.println("Enter the Elements in the List : ");
			for(int j = 0 ; j < k ; j++ )
			{
				head = add(head,in.nextInt());
			}
			head = sortList(head.next);
			arr.add(head);
		}
		ListNode ans = helper(arr);
		while( ans != null)
		{
			System.out.print(ans.val + " ");
			ans = ans.next;
		}	
	}
	public static ListNode add(ListNode head, int data)
	{
		ListNode p = new ListNode(data);
		if( head == null )
			head = p ;
		else if( head.next == null )
			head.next = p ;
		else
		{
			ListNode start = head;
			while( start.next != null )
			{
				start = start.next;
			}
			start.next = p;
		}
		return head;
		
	}
	public static ListNode helper( ArrayList<ListNode> a  )
	{
		if( a.size() == 0 )
			return null;
		PriorityQueue<ListNode> pq = new PriorityQueue<>(a.size(), new Comparator<ListNode>(){
			public int compare(ListNode a,ListNode b)
			{
				if(a.val > b.val)
					return 1;
				else if( b.val > a.val)
					return -1;
				else 
					return 0;
			}
		});
		for(ListNode node : a)
		{
			if(node != null)
			pq.add(node);
		}
		ListNode head = new ListNode(0);
		ListNode p = head;
		while( pq.size() > 0 )
		{
			ListNode temp = pq.poll();
			p.next = temp;
			if( temp.next != null )
				pq.add(temp.next);
			p = p.next;
		}
		return head.next;
	}
	public static ListNode sortList(ListNode head)
	{
		if(head == null || head.next == null)
			return head;
		ListNode p = head;
		int count = 0;
		while(p != null)
		{
			count++;
			p = p.next;
		}
		int mid = count / 2;
		ListNode l = head;
		ListNode r = null;
		int countHalf = 0;
		p = head;
		while( p != null)
		{
			countHalf++;
			ListNode next = p.next;
			if(countHalf == mid)
			{
				p.next = null;
				r = next;
			}
			p = p.next;
		}
		ListNode h1 = sortList(l);
		ListNode h2 = sortList(r);
		ListNode merged = merge(h1,h2);
		return merged;
	}
	public static ListNode merge(ListNode l, ListNode r)
	{
		ListNode p1 = l;
		ListNode p2 = r;
		ListNode temp = new ListNode(0);
		ListNode temp2 = temp;
		while(p1 != null || p2 != null )
		{
			if(p1 == null)
			{
				temp.next = new ListNode(p2.val);
				p2 = p2.next;
			}
			if(p2 == null)
			{
				temp.next = new ListNode(p1.val);
				p1 = p1.next;
			}
			else if( p1.val < p2.val)
			{
				temp.next = new ListNode(p1.val);
				p1 = p1.next;
			}
			else
			{
				temp.next = new ListNode(p2.val);
				p2 = p2.next;
			}
			temp = temp.next;
		}
		return temp2.next;
	}
	static class ListNode
	{
		int val; 
		ListNode next ;
		ListNode(int data)
		{
			val = data;
		}
	}

}
