package uniModelArray;

import java.io.*;

public class UnimodelArray {
	public static void main(String args[])throws IOException
	{
		InputStreamReader xyz=new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(xyz);
		//System.out.println("Enter the value of n");
		int n=Integer.parseInt(in.readLine());
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=Integer.parseInt(in.readLine());
		}
		UnimodelArray obj=new UnimodelArray();
		if(obj.isUnimodel(a, n))
		{
			System.out.println("YES");
		}
		else 
		{
			System.out.println("NO");
		}
		//System.out.println(obj.isUnimodel(a,n));
	}

	private boolean isUnimodel(int[] a,int n) {
		// TODO Auto-generated method stub
		if(n==1)
		{
			return true;
		}
		int i=0;
		int j=n-1;
		
		while(i<a.length-1)
		{
			if(a[i+1]!=a[i])
			{
				i++;
				if(a[i]<a[i-1])
				{
					return false;
				}
			}
			else
			{
				break;
			}
			
		}
		while(j>0)
		{
			if(a[j-1]!=a[j])
			{
				j--;
				if(a[j]>a[j-1])
				{
					return false;
				}
			}
			else
			{
				break;
			}
			
		}
		
		if(a[i]==a[j])
		{
			return true;
		}
		
		
		
		
		return false;
	}

}
