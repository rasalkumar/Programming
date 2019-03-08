package jumpGameArray;

import java.util.ArrayList;

public class Solution {
	public int canJump(ArrayList<Integer> a) {
//		if (a == null || a.size() == 0) {
//			return 1;
//		}
//		int i = 0;
//		while (i < a.size()-1) {
//			i = i + a.get(i);
//		}
//		if (i == a.size() - 1) {
//			return 1;
//		}
//		return 0;
		 if(a.size() <= 1)
		        return 1;
		 
		    int max = a.get(0); //max stands for the largest index that can be reached.
		 
		    for(int i=0; i<a.size(); i++){
		        //if not enough to go to next
		        if(max <= i && a.get(i) == 0) 
		            return 0;
		 
		        //update max    
		        if(i + a.get(i) > max){
		            max = i + a.get(i);
		        }
		 
		        //max is enough to reach the end
		        if(max >= a.size()-1) 
		            return 1;
		    }
		 
		    return 0;    
	}

	public static void main(String args[]) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(2);
		a.add(3);
		a.add(1);
		a.add(1);
		a.add(4);
		Solution obj = new Solution();
		System.out.println(obj.canJump(a));
	}

}
