package removeDuplicatesFromSortedList;

public class Solution {
	public class ListNode {

		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode duplicates(ListNode A) {
		if (A == null || A.next == null) {
			return A;
		}
		while (A.next != null) {
			if (A.val == A.next.val) {
				A.next = A.next.next;
			} else {
				A = A.next;
			}
		}
		return A;
	}
}
