package mergeKSortedLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	
	// Definition for singly-linked list.

	public static ListNode mergeKLists(ArrayList<ListNode> a) {
        if(a.size() == 0)
            return null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(a.size(), new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b){
                if(a.val > b.val)
                    return 1;
                else if(a.val < b.val)
                    return -1;
                else
                    return 0;
            }
        });
        //Add first node of each list to the queue
        for(ListNode node : a){
            if(node != null)
            q.add(node);
        }
        
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(q.size() >  0){
            ListNode temp = q.poll(); // removes the first / head from queue
            p.next = temp;
            if(temp.next != null)
                q.add(temp.next);
            p = p.next;
        }
        return head.next;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution obj = new Solution();
		ArrayList<ListNode> a = new ArrayList<ListNode>();
		 ListNode p=new ListNode(5);
		 ListNode q=new ListNode(8);
		 ListNode r=new ListNode(7);
		 ListNode s=new ListNode(6);
		 a.add(p);
		 a.add(q);
		 a.add(r);
		 a.add(s);
		ListNode t = obj.mergeKLists(a);
		for(int i=1;i<=3;i++)
		{
			System.out.println(t.val);
			t=t.next;
		}
		System.out.println(t.val);

	}

}
class ListNode {
	public int val;
	public ListNode next;
    int c=0;
	ListNode(int x) {
		val = x;
		next = null;
	}
	
}
