package fourSum;

import java.util.*;

public class Solution {
	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> num,int target)
	{
		Collections.sort(num);
		ArrayList<ArrayList<Integer>> result=new ArrayList<>();
		HashSet<ArrayList<Integer>> hashSet = new HashSet<>();
		for(int i=0;i<num.size();i++)
		{
			for(int j=i+1;j<num.size();j++)
			{
				int k=j+1;
				int l= num.size()-1;
				while(k<l)
				{
					int sum=num.get(i)+num.get(j)+num.get(k)+num.get(l);
					if(sum>target)
					{
						l--;
					}
					else if(sum<target)
					{
						k++;
					}
					else if(sum==target)
					{
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num.get(i));
						temp.add(num.get(j));
						temp.add(num.get(k));
						temp.add(num.get(l));
						
						if(!hashSet.contains(temp))
						{
							hashSet.add(temp);
							result.add(temp);
						}
						k++;
						l--;
					}
				}
			}
		}
		return result;
	}
	public static void main(String args[])
	{
		Solution obj=new Solution();
		ArrayList<Integer> a= new ArrayList<>();
		a.add(1);
		a.add(0);
		a.add(-1);
		a.add(0);
		a.add(-2);
		a.add(2);
		int target=0;
		ArrayList<ArrayList<Integer>> result= new ArrayList<>();
		result=obj.fourSum(a, target);
		for(ArrayList<Integer> p : result)
		{
			System.out.println(p);
		}
	}

}
