package sortList;


public class Solution {
	 
	 static class ListNode {

			public int val;
			public ListNode next;

			ListNode(int x) {
				val = x;
				next = null;
			}
			
		}	
	 void printList(ListNode node) {
	        while (node != null) {
	            System.out.print(node.val + " ");
	            node = node.next;
	        }
	    }
	public ListNode sortList(ListNode head){
	if(head == null || head.next == null)
	{
		return head;
	}
	int count=0;
	ListNode p=head;
	while(p!=null)
	{
		p=p.next;
		count++;
	}
	int middle=count/2;
	ListNode l=head,r=null;
	ListNode p2=head;
	int countHalf=0;
	while (p2 != null) {
		countHalf++;
		ListNode next = p2.next;

		if (countHalf == middle) {
			p2.next = null;
			r = next;
		}
		p2 = next;
	}
	ListNode h1 = sortList(l);
	ListNode h2 = sortList(r);

	// merge together
	ListNode merged = merge(h1, h2);
	return merged;
	}
	private ListNode merge(ListNode l, ListNode r) {
		// TODO Auto-generated method stub
		ListNode p1 = l;
		ListNode p2 = r;
 
		ListNode fakeHead = new ListNode(100);
		ListNode pNew = fakeHead;
 
		while (p1 != null || p2 != null) {
 
			if (p1 == null) {
				pNew.next = new ListNode(p2.val);
				p2 = p2.next;
				pNew = pNew.next;
			} else if (p2 == null) {
				pNew.next = new ListNode(p1.val);
				p1 = p1.next;
				pNew = pNew.next;
			} else {
				if (p1.val < p2.val) {
					// if(fakeHead)
					pNew.next = new ListNode(p1.val);
					p1 = p1.next;
					pNew = pNew.next;
				} else if (p1.val == p2.val) {
					pNew.next = new ListNode(p1.val);
					pNew.next.next = new ListNode(p1.val);
					pNew = pNew.next.next;
					p1 = p1.next;
					p2 = p2.next;
 
				} else {
					pNew.next = new ListNode(p2.val);
					p2 = p2.next;
					pNew = pNew.next;
				}
			}
		}
 
		// printList(fakeHead.next);
		return fakeHead.next;
	}
	public static void main(String[] args) {
        Solution list = new Solution();
         ListNode head = new ListNode(85);
        head.next = new ListNode(15);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(20);
         
        System.out.println("Given Linked list");
        list.printList(head);
        head = list.sortList(head);
        System.out.println("");
        System.out.println("Sorted linked list ");
        list.printList(head);
    }
}
