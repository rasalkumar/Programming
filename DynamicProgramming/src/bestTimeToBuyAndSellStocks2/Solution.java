package bestTimeToBuyAndSellStocks2;

import java.util.*;



public class Solution {
	public int maxProfit(final List<Integer> a) {
		if(a==null||a.size()==0)
		{
			return 0;
		}
		int profit=0;
		for(int i=1;i<a.size();i++)
		{
			int diff=a.get(i)-a.get(i-1);
			if(diff>0)
			{
				profit+=diff;
			}
		}
		return profit;
	}
public static void main(String args[])
{
	List<Integer> a=new ArrayList<Integer>();
	Solution obj=new Solution();
	a.add(1);
	a.add(2);
	a.add(3);
	int ans=obj.maxProfit(a);
	System.out.println(ans);
}

}
