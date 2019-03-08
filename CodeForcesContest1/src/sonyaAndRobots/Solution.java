package sonyaAndRobots;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int[] a= new int[n];
        for(int i = 0 ; i < n ; i++ )
        {
        	a[i] = in.nextInt();
        }
        HashSet<Integer> set2 = new HashSet<>();
        for(int i = 0 ; i < n ; i++ )
        {
        	if(!set2.contains(a[i]))
        	{
        		set2.add(a[i]);
        	}
        }
        HashSet<Pair> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++)
        {
        	for(int j = 0 ; j < n ; j++)
        	{
        		if(!set.contains(new Pair(a[i],a[j])))
        		{
        			
        		}
        	}
        	
        }
	}
	static class Pair
	{
		int a;
		int b;
		Pair(int a , int b)
		{
			this.a = a;
			this.b = b;
		}
	}

}
