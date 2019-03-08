package practice;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;





public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	int K=3;
	//	int N=2;
		ArrayList<Integer> B=new ArrayList<>();
		B.add(4);
		B.add(3);
		B.add(7);
		B.add(1);
		B.add(8);
		B.add(5);
		Solution obj=new Solution();
		PriorityQueue<Integer>  d=obj.practice(B);
		Object[] a=d.toArray();
		for(int i=0;i<B.size();i++)
		{
			System.out.println(a[i]);
		}
				

	}

	private PriorityQueue<Integer> practice( ArrayList<Integer> b) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		TreeMap<Integer, Integer> tmap=new TreeMap<>();
		tmap.put(1, 2);
		tmap.put(3, 5);
		tmap.put(2, 8);
		tmap.put(4, 11);
		tmap.put(5, 10);
		tmap.put(6, 3);
		
		for(int i=0;i<b.size();i++)
		{
			
			pq.add(b.get(i));
		}
		for (Map.Entry m:tmap.entrySet()){
	          System.out.println("Frequency of " + m.getKey() + 
	                             " is " + m.getValue());
		}
			
		return pq;
	}
}
