package insertionSortList;
import java.util.*;
public class Solution {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Solution obj = new Solution();
		ListNode a =new ListNode(5);
		ListNode ans = obj.insertionSortList(a);
	}
	public ListNode insertionSortList(ListNode A) {
        ListNode head = new ListNode(0);
        ListNode it = A;
        while (it != null) {
            ListNode next = it.next;
            ListNode in = head;
            while (in.next != null && in.next.val < it.val) {
                in = in.next;
            }
            it.next = in.next;
            in.next = it;
            it = next;
        }
        return head.next;
    }
	static class ListNode
	{
		int val;
		ListNode next;
		ListNode(int x)
		{
			val = x;
			next= null;
		}
	}
}
