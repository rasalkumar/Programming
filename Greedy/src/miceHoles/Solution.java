package miceHoles;
import java.util.*;
public class Solution {
	 public int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
		 if(a == null || b == null || a.size() != b.size())
	            return -1;
	        int maxTime = Integer.MIN_VALUE;
		 Collections.sort(a);
		 Collections.sort(b);
		 for(int i =0; i < a.size(); i++){
	            maxTime = Math.max(Math.abs(b.get(i) - a.get(i)),maxTime);
	        }
	        return maxTime;
	    }
	public static void main(String args[])
	{
		
	}

}
