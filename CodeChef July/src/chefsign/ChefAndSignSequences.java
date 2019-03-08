package chefsign;

import java.io.*;
import java.util.*;

class ChefAndSignSequences {
	public ArrayList<Integer> signs(ArrayList<String> str)
	{
		if(str==null || str.size()==0)
		{
			return null;
		}
		ArrayList<Integer> result=new ArrayList<Integer>();
		for(int p=0;p<str.size();p++)
		{
			String s=str.get(p);
			int arr[]=new int[s.length()+1];
			//arr[0]=1;
			int max=Integer.MIN_VALUE;
			int c1=0;
			int c2=0;
			int c3=0;
			int currMax=0;
			int diff=0;
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i)=='<')
				{
					c1=c1+1;
				}
				else if(s.charAt(i)=='>')
				{
					c2=c2+1;
				}
				else if(s.charAt(i)=='=')
				{
					c3=c3+1;
				}
			}
			if (c2>c1)
			{
				
			}
		}
		
		return result;
	}
	public static void main(String args[])throws IOException {
		InputStreamReader xyz = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(xyz);
		int T;
		ChefAndSignSequences obj=new ChefAndSignSequences();
		ArrayList<String> str = new ArrayList<String>();
		System.out.println("Input Starts");
		T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			String p = in.readLine();
			str.add(p);
		}
		ArrayList<Integer> result = obj.signs(str);
		System.out.println("Output Starts");
		for (int s : result) {
			System.out.println(s);
		}
	}
}
