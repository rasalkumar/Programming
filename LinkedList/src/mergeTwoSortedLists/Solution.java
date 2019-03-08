package mergeTwoSortedLists;

public class Solution {
	public class ListNode {

		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode mergeTwoLists(ListNode A, ListNode B) {
	    return solve(A, B);
	}
	
	public ListNode solve(ListNode A, ListNode B) {
	    
	    if (A == null)
	        return B;
	        
	    if (B == null)
	        return A;
	        
	    ListNode head;
	    ListNode node = new ListNode(0);
	    head = node;
	        
	    while (A != null && B != null) {
	        
	        if (A.val <= B.val) {
	            node.next = A;
	            A = A.next;
	            node = node.next;
	        } else {
	            node.next = B;
	            B = B.next;
	            node = node.next;
	        }
	    }
	    
	    if (A == null)
	        node.next = B;
	    else
	        node.next = A;
	    
	    head = head.next;
	    
	    return head;
	    
	}
}
