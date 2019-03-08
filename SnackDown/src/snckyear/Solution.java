package snckyear;
import java.util.*;
public class Solution {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- >0 )
		{
			int n = in.nextInt();
			if(n ==2010 || n == 2015 || n == 2016 || n ==2017 || n==2019)
			{
				System.out.println("HOSTED");
			}
			else
			{
				System.out.println("NOT HOSTED");
			}
		}
	}

}
