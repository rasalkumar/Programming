package minJumpArray;

import java.util.ArrayList;


public class Solution {
	public int jump(ArrayList<Integer> a) {
		 if (a == null || a.size() == 0)
				return 0;
			int reach=0;
			int lastReach=0;
			int step=0;
		
			for(int i=0;i<a.size() && i<=reach;i++)
			{
				if (i > lastReach) {
					step++;
					lastReach = reach;
			}
				reach = Math.max(reach, a.get(i) + i);
			}
		 
			if (reach < a.size() - 1)
				return -1;
		 
			return step;	
	
	}
	public static void main(String args[]) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(2);
		a.add(3);
		a.add(1);
		a.add(1);
		a.add(4);
		Solution obj = new Solution();
		System.out.println(obj.jump(a));
	}
}
