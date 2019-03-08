package bestTimeToBuyAndSellStocks1;

import java.util.ArrayList;

public class Solution {
	public int maxProfit(ArrayList<Integer> a)
	{
		if(a==null || a.size()==0)
		{
			return 0;
		}
		int minElement=Integer.MAX_VALUE;
		int profit=0;
		for(int i=0;i<a.size();i++)
		{
			profit=Math.max(profit, a.get(i)-minElement);
			minElement=Math.min(minElement, a.get(i));
		}
		return profit;
	}
    public static void main(String args[])
    {
    	ArrayList<Integer> a=new ArrayList<Integer>();
    	Solution obj=new Solution();
    	a.add(1);
    	a.add(2);
    	int ans=obj.maxProfit(a);
    	System.out.println(ans);
    }
}
