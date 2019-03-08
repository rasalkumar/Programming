package primeNumberOfSetBits;

import java.util.*;

public class GFG {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while( t-- > 0 )
        {
        	int l = in.nextInt();
        	int r = in.nextInt();
        	int count = 0;
        	for(int i = l;i<=r;i++)
        	{
        		if(checkSetBitsPrime(i))
        		{
        			count++;
        		}
        	}
        	System.out.println(count);
        	
        }

	}

	public static boolean checkSetBitsPrime(int x) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<>();
		while(x!=0)
		{
			a.add(x&1);
			x>>=1;
		}
		int counter=0;
		for(int i = 0;i<a.size();i++)
		{
			if(a.get(i)==1)
			{
				counter++;
			}
		}
		int p=0;
		for(int i=1;i<=(counter);i++)
		{
			if(counter%i == 0)
			{
				p++;
			}
		}
		if(p==2)
		{
			return true;
		}
		else{
		return false;}
	}

}
