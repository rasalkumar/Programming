package kthLargestElementInTheArray;
import java.util.*;
public class Solution {
public int findKthLargest(int[] nums,int k)
{
	PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
	for(int i:nums)
	{
		pq.offer(i);
	}
	if(pq.size()>k)
	{
		pq.poll();
	}
	return pq.peek();
	}
}
