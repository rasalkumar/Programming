package longestIncreasingSubsequence;

import java.util.*;
public class Solution {
	public int lis(ArrayList<Integer> a)
	{
		if(a == null || a.size() == 0)
            return 0;
        if(a.size() == 1)
            return 1;
        
        int[] lis = new int[a.size()];
        int n = a.size();
        int max = Integer.MIN_VALUE;
        
        for(int i =0; i<n; i++)
            lis[i] = 1;
        
        for(int i = 1; i < n; i++){
            for(int j =0; j < i; j++){
                if(a.get(i) >a.get(j) && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
//           for(int k = 0; k <n; k++)
//            System.out.print(lis[k] + " ");
//                   System.out.println();
        }
        
        for(int i =0; i < n; i++){
            max = Math.max(max, lis[i]);
        }
        
       // System.out.println();
        return max;
	}
	public static void main(String args[])
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
      
        a.add(2);
      
        a.add(6);
        a.add(14);
        a.add(1);
        a.add(9);
        a.add(5);
        a.add(13);
        a.add(3);
        a.add(11);
        a.add(7);
        a.add(15);
        Solution obj=new Solution();
        System.out.println(obj.lis(a));
  //      System.out.println(lisDynamic(a));
	}

}
