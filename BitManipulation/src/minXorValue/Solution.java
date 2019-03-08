package minXorValue;

import java.util.ArrayList;
import java.util.*;


public class Solution {
	public int minXorValue(ArrayList<Integer> numbers)
	{
		int a[]=new int[numbers.size()];
		for(int i=0;i<numbers.size();i++)
		{
			a[i]=numbers.get(i);
		}
		Arrays.sort(a);
		int smallestXor = a[0] ^ a[1];
		for (int i = 2; i <= numbers.size(); i ++) {
			smallestXor = Math.min(smallestXor, a[i - 1] ^ a[i]);
		}
		return smallestXor;
	
		
		     
	}
}
 