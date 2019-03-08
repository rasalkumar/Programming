package removeDuplicatesFromSortedList2;


public class Solution {
	public class ListNode {

		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode duplicates(ListNode head) {
		ListNode t = new ListNode(0);
		t.next = head;
		ListNode p = t;
		
		while (p.next != null && p.next.next!=null) {
			if (p.next.val == p.next.next.val) {
				int dup=p.next.val;
				while(p.next!=null && p.next.val==dup)
				{
					p.next=p.next.next;
				}
				
			} else {
				p = p.next;
			}
		}
		return t.next;
	}
}

