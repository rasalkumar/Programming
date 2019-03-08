package maxSumWithoutAdjacentElements;

import java.util.*;

public class Solution {
	public int adjacent(ArrayList<ArrayList<Integer>> a) {
		if(a==null||a.size()==0)
		{
			return 0;
		}
		//int m=a.size();
		int n=a.get(0).size();
		if(n==0)
		{
			return 0;
		}
		
		int dp[]=new int[n];
		
		ArrayList<Integer> first=a.get(0);
		ArrayList<Integer> second=a.get(1);
		
		dp[0]=Math.max(first.get(0), second.get(0));
	
		if(n<2)
		{
			return dp[0];
		}
		dp[1]=Math.max(first.get(1),second.get(1) );
		dp[1]=Math.max(dp[0], dp[1]);
		for(int i=2;i<n;i++)
		{
			dp[i]=Math.max(first.get(i), second.get(i));
			dp[i]+=dp[i-2];
			dp[i]=Math.max(dp[i], dp[i-1]);
		}
		
		return dp[n-1];
	}
	public static void main(String[] args){
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        temp.add(4);
        a.add(new ArrayList<Integer>(temp));
        temp.clear();
        temp.add(2);
        temp.add(3);
        temp.add(4);
        temp.add(5);
        a.add(new ArrayList<Integer>(temp));
        temp.clear();
        Solution obj=new Solution();
        for(ArrayList<Integer> list : a)
            System.out.println(list);
        
        System.out.println(obj.adjacent(a));
        
    }

}
