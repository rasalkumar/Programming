package test3;

import java.util.*;

public class Monk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0)
		{
			int n = in.nextInt();
			int k = in.nextInt();
			long[] a= new long[n];
			
			for(int i = 0 ; i < n ;i++)
			{
				a[i] = in.nextLong();
			}
			int i = 0 ;int j = a.length-1;
			
			while(k-- > 0 )
			{
				if(a[i] < a[j])
					i++;
				else
					j--;
			}
			if(i == j)
				System.out.println(a[i]);
			else
				System.out.println(a[i] * a[j]);
		}
	}

}
