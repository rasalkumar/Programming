package longestContinuousSequenceZeroSum;

import java.util.ArrayList;
import java.util.HashMap;



public class Solution {
	public ArrayList<Integer> lszero(ArrayList<Integer> A) {
		ArrayList<Integer> result=new ArrayList<>();
		HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
		map.put(0, -1);
        int start = -1;
        int end = -1;
        int sum = 0;
        int maxLength  = Integer.MIN_VALUE;
        for(int i = 0; i < A.size(); i++){
            sum += A.get(i);

            if(map.get(sum) != null){
                if(maxLength < (i - map.get(sum))){
                    start = map.get(sum) + 1;
                    end = i;
                    maxLength = i - map.get(sum); 
                                     
                }
               
            }
            
            else
                map.put(sum, i);
        }

        if(start >= 0 && end >= 0){
            for(int i = start; i <= end; i++){
                result.add(A.get(i));
            }
        }
        return result;
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(-8);
        a.add(8);
        a.add(-4);
        a.add(-14);
        a.add(14);
        //a.add(-4);
        Solution obj=new Solution();
        ArrayList<Integer> result = obj.lszero(a);
        for(int i : result)
            System.out.print(i + " ");

	}
}
//-8, 8, -1, -16, -28, -27, 15, -14, 14, -27, -5, -6, -25, -11, 28, 29, -3, -25, 17, -25, 4, -20, 2, 1, -17, -10, -25
